package nick1st.feedback_mod.client;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nick1st.feedback_mod.client.models.Models;
import nick1st.feedback_mod.common.CommonProxy;

public class ClientProxy extends CommonProxy{
	
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		MinecraftForge.EVENT_BUS.register(Models.class);
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
	
}
