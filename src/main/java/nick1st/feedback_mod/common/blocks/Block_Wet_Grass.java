//Idea by Real ZombieManF (Modified)

package nick1st.feedback_mod.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;
import nick1st.feedback_mod.Specification;
import nick1st.feedback_mod.client.tabs.Tabs;

public class Block_Wet_Grass extends Block{

	public Block_Wet_Grass() {
		super(Material.GRASS);
		setHardness(0.6F);
		setResistance(3);
		setSoundType(SoundType.GROUND);
		setUnlocalizedName("wet_grass");
		setCreativeTab(Tabs.blocktab);
		setRegistryName(new ResourceLocation(Specification.MODID, "wet_grass"));
		setHarvestLevel("shovel", 0);
		setDefaultSlipperiness(0.88F);
		
	}
	
}
