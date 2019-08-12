package nick1st.feedback_mod.client.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import nick1st.feedback_mod.common.blocks.Blocks;

public class CreativeTabBlocks extends CreativeTabs {

	public CreativeTabBlocks() {
		super("block_tab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Blocks.white_colored_wood);
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
	
}
