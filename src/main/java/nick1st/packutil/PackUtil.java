package nick1st.packutil;

import java.io.File;
import java.util.Properties;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import nick1st.packutil.common.CommonProxy;
import nick1st.packutil.common.block.airdrop_crate.GUIHandler;
import nick1st.packutil.common.config.Config;
import nick1st.packutil.common.core.ModBlocks;
import nick1st.packutil.common.core.ModItems;
import nick1st.packutil.common.core.PackUtilBlocks;
import nick1st.packutil.common.integration.ftbquests.PackUtilIntegration;
import nick1st.packutil.common.network.MessageBeamColorSync;
import nick1st.packutil.common.tileentity.TileEntityHandler;
import nick1st.packutil.entities.EntityParachute;

@Mod(modid = PackUtil.MOD_ID, name = "PackUtil",
		dependencies = "required-after:forge@[14.21.0.2359,);after:ftblib@[5.4.7.2,);", version = "0.1.1")
public class PackUtil {
	public static final String MOD_ID = "packutil";
	@Instance
	public static PackUtil INSTANCE;
	@SidedProxy(clientSide = "nick1st.packutil.client.ClientProxy", serverSide = "nick1st.packutil.common.CommonProxy")
	public static CommonProxy PROXY;
	public static final SimpleNetworkWrapper PACKET_HANDLER = NetworkRegistry.INSTANCE.newSimpleChannel(MOD_ID);

	//
	public static final int GUI_AIRDROP_CRATE = 2;
	public static File config;
	//public static GUIHandler guihandler;
	//public static CommonProxy guihandler;

	@Deprecated
	public static PackUtil getInstance() {
		return INSTANCE;
	}

	public static CreativeTabs TAB = new CreativeTabs("packutiltab") {
		public ItemStack getTabIconItem() {
			return new ItemStack(Blocks.TNT);
		}
	};
	//

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Config.load(event);
		PROXY.preInit();
		NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, PROXY);
		//
		//PackUtilConfig.registerConfig(event);
		//NetworkRegistry.INSTANCE.registerGuiHandler(INSTANCE, guihandler);
		//MinecraftForge.EVENT_BUS.register(ModItems.class);
		//MinecraftForge.EVENT_BUS.register(PackUtilBlocks.class);
		//EntityRegistry.registerModEntity(getEntityResource("parachute_drop"), EntityParachute.class, "parachute_drop", 1, PackUtil.INSTANCE, 120, 1, true);
		PROXY.registerRenderers();
		PROXY.registerItemModels();
		PROXY.registerGui();
		PackUtilIntegration.preInit();
		//
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		int messageId = 0;
		PACKET_HANDLER.registerMessage(MessageBeamColorSync.Handler.class, MessageBeamColorSync.class, messageId++, Side.CLIENT);
		MinecraftForge.EVENT_BUS.register(PackUtilBlocks.class);
		MinecraftForge.EVENT_BUS.register(ModItems.class);
		EntityRegistry.registerModEntity(new ResourceLocation(PackUtil.MOD_ID, "parachute_drop"), EntityParachute.class, "parachute_drop", 1, PackUtil.INSTANCE, 120, 1, true);
		TileEntityHandler.registerTileEntities();
		RegisterOreDict.registerOreDict();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	private static ResourceLocation getEntityResource(String entityName) {
		return new ResourceLocation(PackUtil.MOD_ID, entityName);
	}
}
