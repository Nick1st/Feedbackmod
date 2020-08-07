package nick1st.packutil.common.core;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import nick1st.packutil.PackUtilConfig;
import nick1st.packutil.common.block.BlockColoredWood;
import nick1st.packutil.common.block.ColoredWoodType;
import nick1st.packutil.common.block.airdrop_crate.AirdropCrate;
import nick1st.packutil.common.block.airdrop_crate.AirdropCrateAdvanced;
import nick1st.packutil.common.config.Config;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;
import nick1st.packutil.common.tileentity.TileEntityHandler;
import nick1st.packutil.item.ItemColoredWood;

public class PackUtilBlocks {

	//Object variables
	public static final AirdropCrate airdrop_crate = new AirdropCrate();
	public static final AirdropCrateAdvanced airdrop_crate_advanced = new AirdropCrateAdvanced();
	public static final BlockColoredWood colored_wood = new BlockColoredWood();

	@EventBusSubscriber(modid = "packutil")
	public static class Registration {
		@SubscribeEvent
		public static void registerBlocks(Register<Block> event) {
			IForgeRegistry<Block> blockRegistry = event.getRegistry();
			blockRegistry.register(colored_wood);
			if (Config.advancedAirdropCrate == true) {
				blockRegistry.register(airdrop_crate_advanced);
			} else {
				blockRegistry.register(airdrop_crate);
			}
		}

		/*@SubscribeEvent
		public static void register(RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(colored_wood);
		}*/

		@SubscribeEvent
		public static void registerItems(Register<Item> event) {
			IForgeRegistry<Item> itemRegistry = event.getRegistry();
			itemRegistry.register(new ItemColoredWood(colored_wood));
			if (Config.advancedAirdropCrate == true) {
				itemRegistry.register(new ItemBlock(airdrop_crate_advanced).setRegistryName("airdrop_crate"));
				System.out.println("Advanced!!!!");
			} else {
				itemRegistry.register(new ItemBlock(airdrop_crate).setRegistryName("airdrop_crate"));
				System.out.println("Not Advanced!!!!");
			}
		}

		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			Item item = Item.getItemFromBlock(colored_wood);
			for (ColoredWoodType type : ColoredWoodType.values()) {
				ModelLoader.setCustomModelResourceLocation(item, type.ordinal(), new ModelResourceLocation(item.getRegistryName(), "variant="
						+ type.getName()));
			}
		}
	}
}
