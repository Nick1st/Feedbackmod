package nick1st.packutil.common.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
	public static Config CONFIG = new Config();
	static Configuration CONFIG_FILE;

	//Configuration Options
	public static boolean advancedAirdropCrate = false;

	//Category
	private static final String ENABLE_DISABLE = "ENABLE OR DISABLE";

	private Config() {
	}

	public static void load(FMLPreInitializationEvent event) {
		CONFIG_FILE = new Configuration(event.getSuggestedConfigurationFile(), "0.1", false);
		CONFIG_FILE.load();

		syncConfig();
	}

	public static boolean syncConfig() {
		advancedAirdropCrate = CONFIG_FILE.get(ENABLE_DISABLE, "Enable the Advanced Airdrop Crate (Requires FTBLib@5.7.4.2 or higher)", advancedAirdropCrate).getBoolean(advancedAirdropCrate);

		boolean changed = false;
		if (CONFIG_FILE.hasChanged()) {
			CONFIG_FILE.save();
			changed = true;
		}
		return changed;
	}
}
