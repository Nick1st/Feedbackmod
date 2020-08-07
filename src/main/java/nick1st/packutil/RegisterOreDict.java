package nick1st.packutil;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import nick1st.packutil.common.core.PackUtilBlocks;

public class RegisterOreDict {
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;

	public static void registerOreDict() {
		OreDictionary.registerOre("plankColoredWood", new ItemStack(PackUtilBlocks.colored_wood, 1, WILDCARD_VALUE));
	}
}
