package nick1st.feedback_mod.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import nick1st.feedback_mod.Specification;
import nick1st.feedback_mod.client.tabs.Tabs;

public class Block_Colored_Wood extends Block {

	public Block_Colored_Wood() {
		super(Material.WOOD);
		setHardness(2);
		setResistance(15);
		setSoundType(SoundType.WOOD);
		setCreativeTab(Tabs.blocktab);
		setHarvestLevel("axe", 0);
		setLightOpacity(2);
	}
	
}
