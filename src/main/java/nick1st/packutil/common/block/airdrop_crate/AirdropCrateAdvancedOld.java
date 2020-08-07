package nick1st.packutil.common.block.airdrop_crate;

import java.util.Random;

import javax.annotation.Nullable;

import com.feed_the_beast.ftblib.lib.command.CommandUtils;
import com.feed_the_beast.ftblib.lib.data.ForgePlayer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandException;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nick1st.packutil.PackUtil;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;

@Deprecated
public class AirdropCrateAdvancedOld extends Block {
	public static final Material FAKEWOOD = new Material(MapColor.WOOD);
	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0625D, 0.0625D, 0.0625D, 0.9375D, 0.9375D, 0.9375D);

	public AirdropCrateAdvancedOld() {
		super(FAKEWOOD);
		this.setRegistryName("airdrop_crate");
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setHardness(50.0F);
		this.setUnlocalizedName("airdrop_crate");
		this.setCreativeTab(PackUtil.TAB);
		this.setResistance(1200);
		this.setSoundType(SoundType.WOOD);
		this.setHarvestLevel("axe", 3);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return AABB;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Nullable
	public ILockableContainer getLockableContainer(World worldIn, BlockPos pos) {
		return this.getContainer(worldIn, pos, false);
	}

	@Nullable
	public ILockableContainer getContainer(World worldIn, BlockPos pos, boolean allowBlocking) {
		return null;
	}

	/*@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) {
		playerIn.openGui(PackUtil.instance, PackUtil.GUI_AIRDROP_CRATE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}*/

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) {
		TileEntity te = worldIn.getTileEntity(pos);
		if (te == null || !(te instanceof TileEntityAirdropCrate)) {
			return true;
		}
		if (worldIn.getBlockState(pos.up()).doesSideBlockChestOpening(worldIn, pos.up(), EnumFacing.DOWN)) {
			return true;
		}
		if (worldIn.isRemote) {
			return true;
		}
		playerIn.openGui(PackUtil.INSTANCE, PackUtil.GUI_AIRDROP_CRATE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		//New
		if (playerIn instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) playerIn;
			try {
				ForgePlayer p = CommandUtils.getForgePlayer(player);
				if (p.hasTeam()) {
					System.out.println("Has Team!!!!!");
				} else if (!p.hasTeam()) {
					System.out.println("Has NO Team!!!!!");
				}
			} catch (CommandException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("NOOOOOOOOOOOOOOOOOOO REEEEEEEEEEEEMOOOOOOOOOOOOOOOOOOOTTTTTTTTTTTTTTTTTTTTTTTTTE!!!!!");
		}
		//Old
		return true;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState state = this.getDefaultState();
		state = state.withProperty(FACING, EnumFacing.getFront(meta));
		return state;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumFacing) state.getValue(FACING)).getIndex();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		super.onBlockAdded(world, pos, state);
		world.notifyBlockUpdate(pos, state, state, 3);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityAirdropCrate) {
				((TileEntityAirdropCrate) tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntityAirdropCrate tileentity = (TileEntityAirdropCrate) worldIn.getTileEntity(pos);
		if (tileentity != null) {
			InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
			worldIn.removeTileEntity(pos);
		}
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}

	private static final EnumFacing[] validRA = new EnumFacing[] {EnumFacing.UP, EnumFacing.DOWN};

	@Override
	public EnumFacing[] getValidRotations(World worldObj, BlockPos pos) {
		return validRA;
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = world instanceof World ? ((World) world).rand : RANDOM;
		TileEntity tileentity = world.getTileEntity(pos);

		int count = quantityDropped(state, fortune, rand);
		for (int i = 0; i < count; i++) {
			Item item = this.getItemDropped(state, rand, fortune);
			if (item != Items.AIR) {
				ItemStack stack = new ItemStack(item, 1, this.damageDropped(state));
				if (tileentity instanceof IWorldNameable && ((IWorldNameable) tileentity).hasCustomName()) {
					stack.setStackDisplayName(((IWorldNameable) tileentity).getName());
				}
				drops.add(stack);
			}
		}
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable
	TileEntity te, ItemStack stack) {
		if (te instanceof IWorldNameable && ((IWorldNameable) te).hasCustomName()) {
			player.addStat(StatList.getBlockStats(this));
			player.addExhaustion(0.005F);
			if (worldIn.isRemote) {
				return;
			}
			int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
			Item item = this.getItemDropped(state, worldIn.rand, i);
			if (item == Items.AIR) {
				return;
			}
			ItemStack itemstack = new ItemStack(item, 1, this.damageDropped(state));

			itemstack.setStackDisplayName(((IWorldNameable) te).getName());

			spawnAsEntity(worldIn, pos, itemstack);
		} else {
			super.harvestBlock(worldIn, player, pos, state, (TileEntity) null, stack);
		}
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityAirdropCrate();
	}
}
