package nick1st.packutil.common.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

public enum ColoredWoodType implements IStringSerializable {
	WHITE("white_colored_wood.png"),
	ORANGE("orange_colored_wood.png"),
	MAGENTA("magenta_colored_wood.png"),
	LIGHT_BLUE("light_blue_colored_wood.png"),
	YELLOW("yellow_colored_wood.png"),
	LIME("lime_colored_wood.png"),
	PINK("pink_colored_wood.png"),
	GREY("grey_colored_wood.png"),
	LIGHT_GREY("light_grey_colored_wood.png"),
	CYAN("cyan_colored_wood.png"),
	PURPLE("purple_colored_wood.png"),
	BLUE("blue_colored_wood.png"),
	BROWN("brown_colored_wood.png"),
	GREEN("green_colored_wood.png"),
	RED("red_colored_wood.png"),
	BLACK("black_colored_wood.png");

	public static final ColoredWoodType VALUES[] = values();
	public final ResourceLocation texture;
	public final String name;
	private String breakTexture;

	ColoredWoodType(String texture) {
		this.name = this.name().toLowerCase();
		this.texture = new ResourceLocation("packutil", "textures/blocks/" + texture);
	}

	public String getBreakTexture() {
		if (this.breakTexture == null) {
			this.breakTexture = "packutil:textures/blocks/" + this.getName();
		}
		return this.breakTexture;
	}

	@Override
	public String getName() {
		return this.name;
	}

	MapColor getMapColor() {
		return MapColor.DIRT;
	}
}
