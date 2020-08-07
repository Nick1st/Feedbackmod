package nick1st.packutil.common.core;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModItems {

	//public static final ItemMoonMosaic moon_mosaic = new ItemMoonMosaic();
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		//event.getRegistry().registerAll(moon_mosaic);
	}
}
