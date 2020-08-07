package nick1st.packutil.common.tileentity;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Deprecated
public class TileEntityHandler {
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityAirdropCrate.class, new ResourceLocation("packutil"
				+ ":airdrop_crate"));
	}
}
