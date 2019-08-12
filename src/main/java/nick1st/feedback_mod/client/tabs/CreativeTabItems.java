package nick1st.feedback_mod.client.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import nick1st.feedback_mod.common.blocks.Blocks;
import nick1st.feedback_mod.common.items.Items;

public class CreativeTabItems extends CreativeTabs{

	public CreativeTabItems() {
		super("item_tab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.moon_mosaic);
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
	
}
