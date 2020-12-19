package net.ddns.mcnoip.packutil.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class PackUtilConfigClient {

    private final ForgeConfigSpec spec;

    // IngameMenuScreen
    private static ForgeConfigSpec.BooleanValue ingameMenuScreen;
    private static ForgeConfigSpec.ConfigValue<String> reportUrl;

    public PackUtilConfigClient() {
	final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

	// IngameMenuScreen
	builder.comment("Configure IngameMenuScreen (Escape Menu)").push("IngameMenuScreen");
	ingameMenuScreen = builder.comment("If false, module won't be loaded.").define("isAktiv", false);
	reportUrl = builder.comment("URL that should be opened by clicking the \"Report Bug\" button")
		.define("reportURL", "");

	builder.pop();
	this.spec = builder.build();
    }

    // IngameMenuScreen
    public static boolean enableIngameMenuScreen() {
	return ingameMenuScreen.get();
    }

    public static String reportUrl() {
	return reportUrl.get();
    }

    public ForgeConfigSpec getSpec() {
	return this.spec;
    }
}
