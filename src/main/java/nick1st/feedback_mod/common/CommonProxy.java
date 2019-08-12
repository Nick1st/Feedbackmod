package nick1st.feedback_mod.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nick1st.feedback_mod.common.blocks.Blocks;
import nick1st.feedback_mod.common.items.Item_Moon_Mosaic;
import nick1st.feedback_mod.common.items.Items;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(Items.class);
		MinecraftForge.EVENT_BUS.register(Blocks.class);
	}

	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		
	}

}
