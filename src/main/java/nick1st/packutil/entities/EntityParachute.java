package nick1st.packutil.entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.registries.GameData;
import nick1st.packutil.PackUtilConfig;
import nick1st.packutil.common.config.Config;
import nick1st.packutil.common.core.ModBlocks;
import nick1st.packutil.common.core.PackUtilBlocks;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;

public class EntityParachute extends EntityThrowable implements IEntityAdditionalSpawnData {
	private NonNullList<ItemStack> cratecontent = NonNullList.<ItemStack>withSize(18, ItemStack.EMPTY);
	public short teamUID;

	public EntityParachute(World worldIn) {
		super(worldIn);
		setSize(1.0F, 1.0F);
		setEntityInvulnerable(true);
	}

	public void setCratecontent(NonNullList<ItemStack> cratecontentIn) {
		this.cratecontent = cratecontentIn;
	}

	private TileEntityAirdropCrate getTE(World world, BlockPos pos) {
		return (TileEntityAirdropCrate) world.getTileEntity(pos);
	}

	public EntityParachute(World worldIn, double x, double y, double z) {
		super(worldIn);
		setSize(1.0F, 1.0F);
		setPosition(x, y, z);
		setEntityInvulnerable(true);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		ItemStackHelper.saveAllItems(compound, this.cratecontent);
		compound.setShort("Team", this.teamUID);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		ItemStackHelper.loadAllItems(compound, cratecontent);
		this.teamUID = compound.getShort("Team");
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		//Forced by extending the EntityThrowable class
	}

	@Override
	public void readSpawnData(ByteBuf buffer) {
		//Forced by extending the EntityThrowable class
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (this.posY < 200 && this.motionY < -0.2D) {
			this.motionY += 0.05D;
			getEntityWorld().playSound((EntityPlayer) null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_HORSE_BREATHE, SoundCategory.NEUTRAL, 0.08F, 0.7F);
		}
		//System.out.println(this.motionY + " " + this.posY);
	}

	public static NonNullList<ItemStack> getItems(NBTTagCompound tag, NonNullList<ItemStack> list) {
		NBTTagList nbttaglist = tag.getTagList("Items", 10);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("Slot") & 255;
			if (j >= 0 && j < list.size()) {
				list.set(j, new ItemStack(nbttagcompound));
			}
		}
		return list;
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	protected boolean canBeRidden(Entity entityIn) {
		return true;
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.typeOfHit != null && result.typeOfHit == RayTraceResult.Type.BLOCK && !(getEntityWorld()).isRemote) {
			setDead();
			BlockPos pos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.posY), MathHelper.floor(this.posZ));
			if (Config.advancedAirdropCrate == true) {
				getEntityWorld().setBlockState(pos, PackUtilBlocks.airdrop_crate_advanced.getDefaultState());
			} else {
				getEntityWorld().setBlockState(pos, PackUtilBlocks.airdrop_crate.getDefaultState());
			}
			getTE(getEntityWorld(), pos).setCratecontent(this.cratecontent);
			getTE(getEntityWorld(), pos).setTeamUID(this.teamUID);
			/*if (getEntityWorld().getTileEntity(pos) instanceof TileEntityAirdropCrate) {
			}
			getEntityWorld().getTileEntity(pos).writeToNBT(this.getEntityData().getTagList("Items", 10).getCompoundTagAt(0));
			getEntityWorld().getTileEntity(pos).writeToNBT(this.getEntityData().getTagList("Items", 10).getCompoundTagAt(1));
			getEntityWorld().getTileEntity(pos).writeToNBT(this.getEntityData().getTagList("Items", 10).getCompoundTagAt(2));
			getEntityWorld().getTileEntity(pos).writeToNBT(this.getEntityData().getTagList("Items", 10).getCompoundTagAt(3));
			getEntityWorld().getTileEntity(pos).writeToNBT(this.getEntityData().getTagList("Items", 10).getCompoundTagAt(4));
			getEntityWorld().getTileEntity(pos).writeToNBT(this.getEntityData().getTagList("Items", 10).getCompoundTagAt(5));*/
			//getEntityWorld().getTileEntity(pos).writeToNBT(this.getEntityData());
			getEntityWorld().playSound((EntityPlayer) null, this.posX, this.posY, this.posZ, SoundEvents.BLOCK_CLOTH_FALL, SoundCategory.BLOCKS, 2.0F, 0.5F);
			getEntityWorld().playSound((EntityPlayer) null, this.posX, this.posY, this.posZ, SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 3.0F, 0.5F);
		}
	}
}
