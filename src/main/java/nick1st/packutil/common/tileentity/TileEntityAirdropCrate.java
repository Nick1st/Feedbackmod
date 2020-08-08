package nick1st.packutil.common.tileentity;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import com.feed_the_beast.ftblib.lib.data.Universe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nick1st.packutil.PackUtil;
import nick1st.packutil.common.block.airdrop_crate.AirdropCrateAdvanced;
import nick1st.packutil.common.block.airdrop_crate.ContainerAirdropCrate;
import nick1st.packutil.common.core.PackUtilBlocks;

public class TileEntityAirdropCrate extends TileEntityLockableLoot implements ITickable {
	private NonNullList<ItemStack> cratecontent = NonNullList.<ItemStack>withSize(18, ItemStack.EMPTY);
	private short teamUID;
	public int red, green, blue;
	public int numPlayersUsing, ticksSinceSync;
	public float lidAngle, prevLidAngle;
	private EnumFacing facing;
	public boolean inventoryTouched;
	private String customName;
	private final String CustomNameStr = "CustomName";

	//
	private List<TileEntityAirdropCrate.BeamSegment> beamSegments = Lists.newArrayList();
	private List<TileEntityAirdropCrate.BeamSegment> segmentSize = Lists.newArrayList();
	private int levels = 0;
	private int beamHeight = -1;
	public float[] afloat;
	public IBlockState blockstate;
	public BlockPos blockpos;
	public Block block;

	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		super.onDataPacket(net, pkt);
		handleUpdateTag(pkt.getNbtCompound());
	}

	public void sendUpdates() {
		System.out.println("Called sendUpdates()");
		world.markBlockRangeForRenderUpdate(pos, pos);
		world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 3);
		world.scheduleBlockUpdate(pos, this.getBlockType(), 0, 0);
		markDirty();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared() {
		return 65536.0D;
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return INFINITE_EXTENT_AABB;
	}
	//

	public int getRed() {
		return this.red;
	}

	public int getGreen() {
		return this.green;
	}

	public int getBlue() {
		return this.blue;
	}

	@Override
	public int getSizeInventory() {
		return 18;
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack stack : this.cratecontent) {
			if (!stack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "Airdrop Crate";
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		this.cratecontent = NonNullList.<ItemStack>withSize(getSizeInventory(), ItemStack.EMPTY);
		if (compound.hasKey(CustomNameStr, Constants.NBT.TAG_STRING)) {
			this.customName = compound.getString(CustomNameStr);
		}
		if (!this.checkLootAndRead(compound)) {
			ItemStackHelper.loadAllItems(compound, cratecontent);
		}
		this.teamUID = compound.getShort("Team");
		this.red = compound.getInteger("Red");
		this.green = compound.getInteger("Green");
		this.blue = compound.getInteger("Blue");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.cratecontent);
		}
		if (this.hasCustomName()) {
			compound.setString(CustomNameStr, this.customName);
		}
		compound.setShort("Team", this.teamUID);
		compound.setInteger("Red", this.red);
		compound.setInteger("Green", this.green);
		compound.setInteger("Blue", this.blue);
		return compound;
	}

	public NonNullList<ItemStack> setCratecontent(NonNullList<ItemStack> cratecontentIn) {
		markDirty();
		return this.cratecontent = cratecontentIn;
	}

	public Short setTeamUID(Short teamUID) {
		markDirty();
		return this.teamUID = teamUID;
	}

	public Short getTeamUID(TileEntity te) {
		TileEntityAirdropCrate teac = (TileEntityAirdropCrate) te;
		return teac.teamUID;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		this.fillWithLoot(playerIn);
		return new ContainerAirdropCrate(playerInventory, this);
	}

	@Override
	public String getGuiID() {
		return "packutil" + ":airdrop_crate";
	}

	@Override
	public void update() {
		if (!this.world.isRemote && this.numPlayersUsing == 0 && this.isEmpty() && this.inventoryTouched) {
			this.world.destroyBlock(this.getPos(), false);
			this.world.removeTileEntity(this.getPos());
		}
		if (!this.world.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + pos.getX() + pos.getY()
				+ pos.getZ()) % 200 == 0) {
			this.numPlayersUsing = 0;
			float f = 5.0F;
			for (EntityPlayer entityplayer : this.world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((double) ((float) pos.getX()
					- 5.0F), (double) ((float) pos.getY() - 5.0F), (double) ((float) pos.getZ()
							- 5.0F), (double) ((float) (pos.getX() + 1) + 5.0F), (double) ((float) (pos.getY() + 1)
									+ 5.0F), (double) ((float) (pos.getZ() + 1) + 5.0F)))) {
				if (entityplayer.openContainer instanceof ContainerAirdropCrate) {
					//if (((ContainerAirdropCrate) entityplayer.openContainer).getCrateInventory() == this) {
					++this.numPlayersUsing;
					//}
				}
			}
		}
		this.prevLidAngle = this.lidAngle;
		float f1 = 0.1F;
		if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
			double d1 = (double) pos.getX() + 0.5D;
			double d2 = (double) pos.getZ() + 0.5D;
			this.world.playSound((EntityPlayer) null, d1, (double) pos.getY()
					+ 0.5D, d2, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat()
							* 0.1F + 0.9F);
		}
		if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
			float f2 = this.lidAngle;
			if (this.numPlayersUsing > 0) {
				this.lidAngle += 0.1F;
			} else {
				this.lidAngle -= 0.1F;
			}
			if (this.lidAngle > 1.0F) {
				this.lidAngle = 1.0F;
			}
			float f3 = 0.5F;
			if (this.lidAngle < 0.5F && f2 >= 0.5F) {
				double d3 = (double) pos.getX() + 0.5D;
				double d0 = (double) pos.getZ() + 0.5D;
				this.world.playSound((EntityPlayer) null, d3, (double) pos.getY()
						+ 0.5D, d0, SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat()
								* 0.1F + 0.9F);
			}
			if (this.lidAngle < 0.0F) {
				this.lidAngle = 0.0F;
			}
		}
		//
		int x = this.pos.getX();
		int y = this.pos.getY();
		int z = this.pos.getZ();
		if (this.beamHeight < y) {
			this.blockpos = this.pos;
			this.segmentSize = Lists.newArrayList();
			this.beamHeight = this.blockpos.getY() - 1;
		} else {
			this.blockpos = new BlockPos(x, this.beamHeight + 1, z);
		}
		TileEntityAirdropCrate.BeamSegment beaconBeamSegment = this.segmentSize.isEmpty() ? null : this.segmentSize.get(this.segmentSize.size()
				- 1);
		int l = this.world != null ? this.world.getHeight(x, z) : 0;
		for (int i1 = 0; i1 < 10 && this.blockpos.getY() <= l; ++i1) {
			this.blockstate = this.world.getBlockState(this.blockpos);
			this.block = this.blockstate.getBlock();
			////float[] afloat = blockstate.getBeaconColorMultiplier(this.world, blockpos, getPos());
			//float[] afloat = {1.0F, 0.725F, 0.059F};
			//
			//float[] afloat = {this.red / 255F, this.green / 255F, this.blue / 255F};
			//
			this.afloat = PackUtilBlocks.airdrop_crate_advanced.getBeamColor(this.world, this.blockpos);
			if (this.afloat != null) {
				if (this.segmentSize.size() <= 1) {
					//System.out.println(afloat);
					beaconBeamSegment = new TileEntityAirdropCrate.BeamSegment(this.afloat);
					this.segmentSize.add(beaconBeamSegment);
				} else if (beaconBeamSegment != null) {
					if (Arrays.equals(this.afloat, beaconBeamSegment.colors)) {
						beaconBeamSegment.incrementHeight();
					} else {
						beaconBeamSegment = new TileEntityAirdropCrate.BeamSegment(new float[] {(beaconBeamSegment.colors[0]
								+ this.afloat[0]) / 2.0F, (beaconBeamSegment.colors[1] + this.afloat[1])
										/ 2.0F, (beaconBeamSegment.colors[2] + this.afloat[2]) / 2.0F});
						this.segmentSize.add(beaconBeamSegment);
					}
				}
			} else {
				if (beaconBeamSegment == null || blockstate.getLightOpacity(this.world, this.blockpos) >= 15 && this.block != Blocks.BEDROCK) {
					this.segmentSize.clear();
					this.beamHeight = l;
					break;
				}
				beaconBeamSegment.incrementHeight();
			}
			this.blockpos = this.blockpos.up();
			++this.beamHeight;
		}
		//int j1 = this.levels;
		if (this.world.getWorldTime() % 80L == 0L) {
			if (!this.beamSegments.isEmpty()) {
				this.sendBeam(x, y, z);
			}
			//if (this.levels > 0 && !this.beamSegments.isEmpty()) {
			//this.addEffectsToEntities();
			//this.playSound(SoundEvents.BLOCK_BEACON_AMBIENT);
			//}
		}
		if (this.beamHeight >= l) {
			this.beamHeight = -1;
			//boolean flag = j1 > 0;
			this.beamSegments = this.segmentSize;
			if (!this.world.isRemote) {
				//boolean flag1 = this.levels > 0;
				//if (!flag && flag1) {
				//this.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE);
				//} else if (flag && !flag1) {
				//this.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE);
				//}
			}
		}
		//
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.cratecontent;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		++this.numPlayersUsing;
		this.inventoryTouched = true;
		this.world.addBlockEvent(pos, this.getBlockType(), 1, this.numPlayersUsing);
		this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		--this.numPlayersUsing;
		this.world.addBlockEvent(pos, this.getBlockType(), 1, this.numPlayersUsing);
		this.world.notifyNeighborsOfStateChange(pos, this.getBlockType(), false);
	}

	//
	private void sendBeam(int posX, int posY, int posZ) {
		this.levels = 0;
		for (int i = 1; i <= 4; this.levels = i++) {
			int j = posY - i;
			if (j < 0) {
				break;
			}
			boolean flag = true;
			for (int k = posX - i; k <= posX + i && flag; ++k) {
				for (int l = posZ - i; l <= posZ + i; ++l) {
					if (!(this.world.getBlockState(new BlockPos(k, j, l)).getBlock() == PackUtilBlocks.airdrop_crate.getDefaultState())) {
						flag = false;
						break;
					}
				}
			}
			if (!flag) {
				break;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public List<TileEntityAirdropCrate.BeamSegment> getBeamSegments() {
		return /*this.levels == 0 ? ImmutableList.of() :*/ this.beamSegments;
	}

	public static class BeamSegment {
		private final float[] colors;
		private int height;

		public BeamSegment(float[] colorsIn) {
			this.colors = colorsIn;
			this.height = 1;
		}

		protected void incrementHeight() {
			++this.height;
		}

		/**
		 * Returns RGB (0 to 1.0) colors of this beam segment
		 */
		@SideOnly(Side.CLIENT)
		public float[] getColors() {
			return this.colors;
		}

		@SideOnly(Side.CLIENT)
		public int getHeight() {
			return this.height;
		}
	}
	//
}
