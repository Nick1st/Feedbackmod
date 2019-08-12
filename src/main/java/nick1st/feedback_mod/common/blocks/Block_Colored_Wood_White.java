package nick1st.feedback_mod.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.functions.SetMetadata;
import nick1st.feedback_mod.Specification;
import nick1st.feedback_mod.client.tabs.Tabs;

public class Block_Colored_Wood_White extends Block_Colored_Wood {
	
	public Block_Colored_Wood_White() {
		setUnlocalizedName("white_colored_wood");
		setRegistryName(new ResourceLocation(Specification.MODID, "white_colored_wood"));
	}
	
}
