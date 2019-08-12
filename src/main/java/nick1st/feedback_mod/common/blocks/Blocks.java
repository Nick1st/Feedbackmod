package nick1st.feedback_mod.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nick1st.feedback_mod.common.items.Item_Moon_Mosaic;

public class Blocks {
	
	public static final Block_Wet_Grass wet_grass = new Block_Wet_Grass();
	public static final Block_Colored_Wood_White white_colored_wood = new Block_Colored_Wood_White();
	public static final Block_Colored_Wood_Orange orange_colored_wood = new Block_Colored_Wood_Orange();
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(white_colored_wood, orange_colored_wood);
		event.getRegistry().registerAll(wet_grass);
	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new ItemBlock(wet_grass).setRegistryName("wet_grass"));
		event.getRegistry().register(new ItemBlock(white_colored_wood).setRegistryName("white_colored_wood"));
		event.getRegistry().register(new ItemBlock(orange_colored_wood).setRegistryName("orange_colored_wood"));
	}
}
