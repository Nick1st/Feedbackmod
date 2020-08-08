package nick1st.packutil.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nick1st.packutil.PackUtil;
import nick1st.packutil.client.models.ModModels;
import nick1st.packutil.client.renderers.RenderEntityParachute;
import nick1st.packutil.common.CommonProxy;
import nick1st.packutil.common.block.airdrop_crate.ContainerAirdropCrate;
import nick1st.packutil.common.block.airdrop_crate.GUIAirdropCrate;
import nick1st.packutil.common.block.airdrop_crate.RenderAirdropCrate;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;
import nick1st.packutil.entities.EntityParachute;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
	@Override
	public void preInit() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAirdropCrate.class, new RenderAirdropCrate());
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		System.out.println("Gui Handler(Client) got called");
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if (te != null && te instanceof TileEntityAirdropCrate) {
			TileEntityAirdropCrate acte = (TileEntityAirdropCrate) te;
			return new GUIAirdropCrate(player.inventory, acte, player);
		} else {
			return null;
		}
	}

	@Override
	public World getClientWorld() {
		return Minecraft.getMinecraft().world;
	}

	//
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityParachute.class, nick1st.packutil.client.renderers.RenderEntityParachute::new);
	}

	public void registerGui() {
		//NetworkRegistry.INSTANCE.registerGuiHandler(PackUtil.INSTANCE, new GUIHandler());
	}

	public void registerItemModels() {
		//Unused: Moved to ModItems class
	}
	//
}
