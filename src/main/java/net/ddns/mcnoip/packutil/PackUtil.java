package net.ddns.mcnoip.packutil;

import net.ddns.mcnoip.packutil.client.gui.GuiHandler;
import net.ddns.mcnoip.packutil.config.PackUtilConfigClient;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Main class for Packutil
 */
@Mod("packutil")
public class PackUtil {

    public static final PackUtilConfigClient CLIENT_CONFIG = new PackUtilConfigClient();

    public PackUtil() {
	// Register setup method for modloading
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	// Register enqueueIMC method for modloading
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
	// Register processIMC method for modloading
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
	ModLoadingContext.get().registerConfig(Type.CLIENT, CLIENT_CONFIG.getSpec());
	MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
	// preinit code

    }

    /**
     * Register GuiHandler
     */
    private void doClientStuff(final FMLClientSetupEvent event) {
	PackUtilLogger.info("Registering GuiHandler");
	PackUtilLogger.info("Registering GuiHandler");
	PackUtilLogger.info("Registering GuiHandler");
	PackUtilLogger.info("Registering GuiHandler");
	MinecraftForge.EVENT_BUS.register(GuiHandler.class);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
	// code to dispatch IMC to another mod

    }

    private void processIMC(final InterModProcessEvent event) {
	// code to receive and process InterModComms from other mods

    }

    // SubscribeEvent and Event Bus
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
	// register blocks
	@SubscribeEvent
	public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

	}
    }
}
