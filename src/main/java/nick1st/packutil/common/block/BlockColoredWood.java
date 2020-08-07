package nick1st.packutil.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nick1st.packutil.PackUtil;

public class BlockColoredWood extends Block {
	public static final PropertyEnum<ColoredWoodType> VARIANT = PropertyEnum.create("variant", ColoredWoodType.class);

	public BlockColoredWood() {
		super(Material.WOOD);
		this.setRegistryName(new ResourceLocation("packutil", "colored_wood"));
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, ColoredWoodType.BLACK));
		this.setCreativeTab(PackUtil.TAB);
		this.setHardness(2.0F);
		this.setResistance(15);
		this.setSoundType(SoundType.WOOD);
		this.setHarvestLevel("axe", 0);
		this.setUnlocalizedName("colored_wood");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> list) {
		for (ColoredWoodType type : ColoredWoodType.values()) {
			list.add(new ItemStack(this, 1, type.ordinal()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, ColoredWoodType.VALUES[meta]);
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return ((ColoredWoodType) state.getValue(VARIANT)).getMapColor();
	}

	public int getMetaFromState(IBlockState state) {
		return state.getValue(VARIANT).ordinal();
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, VARIANT);
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(VARIANT).ordinal();
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
				drops.add(stack);
			}
		}
	}
}
