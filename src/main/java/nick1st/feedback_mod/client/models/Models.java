package nick1st.feedback_mod.client.models;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nick1st.feedback_mod.common.blocks.Blocks;
import nick1st.feedback_mod.common.items.Item_Moon_Mosaic;
import nick1st.feedback_mod.common.items.Items;

public class Models {
	
	@SubscribeEvent
	public static void register(ModelRegistryEvent event) {
		register(Items.moon_mosaic);
		register(Item.getItemFromBlock(Blocks.white_colored_wood));
		register(Item.getItemFromBlock(Blocks.orange_colored_wood));
	}
	
	private static void register(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
