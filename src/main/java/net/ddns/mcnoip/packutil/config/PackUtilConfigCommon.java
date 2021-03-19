package net.ddns.mcnoip.packutil.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class PackUtilConfigCommon {

    private final ForgeConfigSpec spec;

    // Anvil Tweaks
    private static ForgeConfigSpec.IntValue levelCap;

    public PackUtilConfigCommon() {
	final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

	// Anvil Tweaks
	builder.comment("Tweaks for the anvil.").push("Anvil Tweaks");
	levelCap = builder.comment("Set the level cap of the anvil. Default: 40; 0 to remove cap.")
		.defineInRange("levelCap", 40, 0, Integer.MAX_VALUE);

	builder.pop();
	this.spec = builder.build();
    }

    // Anvil Tweaks
    public static int levelCap() {
	return levelCap.get();
    }

    public ForgeConfigSpec getSpec() {
	return this.spec;
    }

}
