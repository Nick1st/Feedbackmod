package net.ddns.mcnoip.packutil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("packutil")
public class PackUtil {
    // static log4j logger.
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger("PackUtil");

    public PackUtil() {
	// Register setup method for modloading
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	// Register enqueueIMC method for modloading
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
	// Register processIMC method for modloading
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
	// Register doClientStuff method for modloading
	FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

	// Register ourselves for server and other game events we are interested in
	MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
	// preinit code

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
	// client stuff

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
