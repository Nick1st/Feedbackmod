package nick1st.packutil;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class PackUtilConfig {
	public static Configuration config;
	public static String PACKNAME;

	public static void init(File file) {
		config = new Configuration(file);
		config.load();

		PACKNAME = config.get("Do not change!!! Otherwise it can break your game!", "modpack", "").getString();
		System.out.println("|" + PACKNAME + "|");
		config.save();
	}

	public static void registerConfig(FMLPreInitializationEvent event) {
		PackUtil.config = new File(event.getModConfigurationDirectory() + "/PackUtil.cfg");
		//PackUtil.config.mkdirs();
		init(PackUtil.config);
	}
}
