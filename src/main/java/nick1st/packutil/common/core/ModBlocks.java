package nick1st.packutil.common.core;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nick1st.packutil.common.tileentity.TileEntityHandler;

@Deprecated
public class ModBlocks {

	//public static final BlockWetGrass wet_grass = new BlockWetGrass();
	////public static final Testblock testblock = new Testblock();
	//public static final AirdropCrate airdrop_crate = new AirdropCrate();
	//***public static final BlockColoredWood colored_wood = new BlockColoredWood();
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Block> event) {
		//event.getRegistry().registerAll(white_colored_wood, orange_colored_wood, magenta_colored_wood, light_blue_colored_wood, yellow_colored_wood, lime_colored_wood, pink_colored_wood, gray_colored_wood, light_gray_colored_wood, cyan_colored_wood, purple_colored_wood, blue_colored_wood, brown_colored_wood, green_colored_wood, red_colored_wood, black_colored_wood);
		//event.getRegistry().registerAll(wet_grass);
		////event.getRegistry().registerAll(testblock);
		////event.getRegistry().register((colored_wood).getDefaultState().withProperty(Block_Colored_Wood.VARIANT, Block_Colored_Wood.EnumType.OAK1));
		//***event.getRegistry().registerAll(colored_wood);
		//event.getRegistry().registerAll(airdrop_crate);
		TileEntityHandler.registerTileEntities();
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAirdropCrate.class, new RenderAirdropCrate());
	}

	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		//event.getRegistry().register(new ItemBlock(wet_grass).setRegistryName("wet_grass"));
		//event.getRegistry().register(new ItemBlock(testblock).setRegistryName("testblock"));
		//event.getRegistry().register(new ItemBlock(airdrop_crate).setRegistryName("airdrop_crate"));
		//event.getRegistry().register(new ItemBlock(coloredWood).setRegistryName("colored_wood"));
		//***event.getRegistry().register(new ItemColoredWood(ModBlocks.colored_wood));
	}
}
