package nick1st.packutil.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import nick1st.packutil.client.renderers.RenderEntityParachute;
import nick1st.packutil.common.block.airdrop_crate.ContainerAirdropCrate;
import nick1st.packutil.common.core.ModBlocks;
import nick1st.packutil.common.core.ModItems;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;
import nick1st.packutil.item.ItemMoonMosaic;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CommonProxy implements IGuiHandler {
	public void preInit() {
		//Required for ClientProx to override
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		System.out.println("Gui Handler(Server) got called");
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if (te != null && te instanceof TileEntityAirdropCrate) {
			TileEntityAirdropCrate acte = (TileEntityAirdropCrate) te;
			return new ContainerAirdropCrate(player.inventory, acte);
		} else {
			return null;
		}
	}

	public World getClientWorld() {
		return null;
	}

	//
	public void registerRenderers() {
		//Required for ClientProx to override
	}

	public void registerGui() {
		//Required for ClientProx to override
	}

	public void registerItemModels() {
		//Unused: Moved to ModItems/PackUtilBlocks class
	}
	//
}
