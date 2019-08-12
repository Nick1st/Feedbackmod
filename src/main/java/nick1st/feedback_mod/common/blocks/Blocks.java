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
	public static final Block_Colored_Wood_Magenta magenta_colored_wood = new Block_Colored_Wood_Magenta();
	public static final Block_Colored_Wood_LightBlue light_blue_colored_wood = new Block_Colored_Wood_LightBlue();
	public static final Block_Colored_Wood_Yellow yellow_colored_wood = new Block_Colored_Wood_Yellow();
	public static final Block_Colored_Wood_Lime lime_colored_wood = new Block_Colored_Wood_Lime();
	public static final Block_Colored_Wood_Pink pink_colored_wood = new Block_Colored_Wood_Pink();
	public static final Block_Colored_Wood_Gray gray_colored_wood = new Block_Colored_Wood_Gray();
	public static final Block_Colored_Wood_LightGray light_gray_colored_wood = new Block_Colored_Wood_LightGray();
	public static final Block_Colored_Wood_Cyan cyan_colored_wood = new Block_Colored_Wood_Cyan();
	public static final Block_Colored_Wood_Purple purple_colored_wood = new Block_Colored_Wood_Purple();
	public static final Block_Colored_Wood_Blue blue_colored_wood = new Block_Colored_Wood_Blue();
	public static final Block_Colored_Wood_Brown brown_colored_wood = new Block_Colored_Wood_Brown();
	public static final Block_Colored_Wood_Green green_colored_wood = new Block_Colored_Wood_Green();
	public static final Block_Colored_Wood_Red red_colored_wood = new Block_Colored_Wood_Red();
	public static final Block_Colored_Wood_Black black_colored_wood = new Block_Colored_Wood_Black();
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(white_colored_wood, orange_colored_wood, magenta_colored_wood, light_blue_colored_wood, yellow_colored_wood, lime_colored_wood, pink_colored_wood, gray_colored_wood, light_gray_colored_wood, cyan_colored_wood, purple_colored_wood, blue_colored_wood, brown_colored_wood, green_colored_wood, red_colored_wood, black_colored_wood);
		event.getRegistry().registerAll(wet_grass);
	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new ItemBlock(wet_grass).setRegistryName("wet_grass"));
		event.getRegistry().register(new ItemBlock(white_colored_wood).setRegistryName("white_colored_wood"));
		event.getRegistry().register(new ItemBlock(orange_colored_wood).setRegistryName("orange_colored_wood"));
		event.getRegistry().register(new ItemBlock(magenta_colored_wood).setRegistryName("magenta_colored_wood"));
		event.getRegistry().register(new ItemBlock(light_blue_colored_wood).setRegistryName("light_blue_colored_wood"));
		event.getRegistry().register(new ItemBlock(yellow_colored_wood).setRegistryName("yellow_colored_wood"));
		event.getRegistry().register(new ItemBlock(lime_colored_wood).setRegistryName("lime_colored_wood"));
		event.getRegistry().register(new ItemBlock(pink_colored_wood).setRegistryName("pink_colored_wood"));
		event.getRegistry().register(new ItemBlock(gray_colored_wood).setRegistryName("gray_colored_wood"));
		event.getRegistry().register(new ItemBlock(light_gray_colored_wood).setRegistryName("light_gray_colored_wood"));
		event.getRegistry().register(new ItemBlock(cyan_colored_wood).setRegistryName("cyan_colored_wood"));
		event.getRegistry().register(new ItemBlock(purple_colored_wood).setRegistryName("purple_colored_wood"));
		event.getRegistry().register(new ItemBlock(blue_colored_wood).setRegistryName("blue_colored_wood"));
		event.getRegistry().register(new ItemBlock(brown_colored_wood).setRegistryName("brown_colored_wood"));
		event.getRegistry().register(new ItemBlock(green_colored_wood).setRegistryName("green_colored_wood"));
		event.getRegistry().register(new ItemBlock(red_colored_wood).setRegistryName("red_colored_wood"));
		event.getRegistry().register(new ItemBlock(black_colored_wood).setRegistryName("black_colored_wood"));
	}
}
