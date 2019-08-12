package nick1st.feedback_mod.common.items;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Items {
	
	public static final Item_Moon_Mosaic moon_mosaic = new Item_Moon_Mosaic();
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(moon_mosaic);
	}
	
}
