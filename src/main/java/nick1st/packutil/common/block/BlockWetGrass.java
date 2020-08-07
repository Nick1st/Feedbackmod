// Idea by Real ZombieManF (Modified)
package nick1st.packutil.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

@Deprecated
public class BlockWetGrass extends Block {
	public BlockWetGrass() {
		super(Material.GRASS);
		setHardness(0.6F);
		setResistance(3);
		setSoundType(SoundType.GROUND);
		setUnlocalizedName("wet_grass");
		setRegistryName(new ResourceLocation("packutil", "wet_grass"));
		setHarvestLevel("shovel", 0);
		setDefaultSlipperiness(0.88F);
	}
}
