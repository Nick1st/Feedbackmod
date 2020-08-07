package nick1st.packutil.client.models;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import nick1st.packutil.PackUtilConfig;
import nick1st.packutil.common.block.ColoredWoodType;
import nick1st.packutil.common.config.Config;
import nick1st.packutil.common.core.ModBlocks;
import nick1st.packutil.common.core.ModItems;
import nick1st.packutil.common.core.PackUtilBlocks;

@EventBusSubscriber(modid = "air_support", value = {Side.CLIENT})
@SideOnly(Side.CLIENT)
public class ModModels {
	@SubscribeEvent
	public static void register(ModelRegistryEvent event) {
		//register(ModItems.moon_mosaic);
		//register(Item.getItemFromBlock(ModBlocks.white_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.orange_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.magenta_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.light_blue_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.yellow_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.lime_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.pink_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.gray_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.light_gray_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.cyan_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.purple_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.blue_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.brown_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.green_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.red_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.black_colored_wood));
		//register(Item.getItemFromBlock(ModBlocks.colored_wood));
		////register(Item.getItemFromBlock(ModBlocks.airdrop_crate));
		if (Config.advancedAirdropCrate == true) {
			register(Item.getItemFromBlock(PackUtilBlocks.airdrop_crate_advanced));
		} else {
			register(Item.getItemFromBlock(PackUtilBlocks.airdrop_crate));
		}
		Item coloredWoodItem = Item.getItemFromBlock(PackUtilBlocks.colored_wood);
		for (ColoredWoodType type : ColoredWoodType.values()) {
			ModelLoader.setCustomModelResourceLocation(coloredWoodItem, type.ordinal(), new ModelResourceLocation(coloredWoodItem.getRegistryName(), "variant="
					+ type.getName()));
		}
	}

	private static void register(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
