package nick1st.packutil.item;

import net.minecraft.block.Block;
import net.minecraft.client.resources.Locale;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import nick1st.packutil.common.block.ColoredWoodType;

public class ItemColoredWood extends ItemBlock {
	public ItemColoredWood(Block block) {
		super(block);

		this.setRegistryName(block.getRegistryName());
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		int meta = itemstack.getMetadata();
		if (meta < ColoredWoodType.BLOCK_VALUES.length) {
			return ColoredWoodType.BLOCK_VALUES[itemstack.getMetadata()].name().toLowerCase() + "_colored_wood";
		} else {
			return super.getUnlocalizedName(itemstack);
		}
	}
}
