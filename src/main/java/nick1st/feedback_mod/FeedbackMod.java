package nick1st.feedback_mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nick1st.feedback_mod.client.ClientProxy;
import nick1st.feedback_mod.client.tabs.CreativeTabBlocks;
import nick1st.feedback_mod.common.CommonProxy;
import scala.annotation.meta.getter;

import org.apache.logging.log4j.Logger;

import static nick1st.feedback_mod.Specification.*;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class FeedbackMod
{

	@Instance 
	private static FeedbackMod instance;
	
	public static FeedbackMod getInstance() {
		return instance;
	}
	
    @SidedProxy(serverSide = "nick1st.feedback_mod.common.CommonProxy", clientSide = "nick1st.feedback_mod.client.ClientProxy")
    private static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);   
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	proxy.postInit(event);
    }
    
}
