package nick1st.packutil.common.block.airdrop_crate;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nick1st.packutil.PackUtil;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;

@Deprecated
public class GUIHandler implements IGuiHandler {
	/*@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == PackUtil.GUI_AIRDROP_CRATE) {
			return new ContainerAirdropCrate(player.inventory, (TileEntityAirdropCrate) world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		return null;
	}*/
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		System.out.println("Gui Handler(Server) got called");
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if (te != null && te instanceof TileEntityAirdropCrate) {
			return new ContainerAirdropCrate(player.inventory, (TileEntityAirdropCrate) world.getTileEntity(new BlockPos(x, y, z)));
		} else {
			return null;
		}
	}

	@SideOnly(Side.CLIENT)
	public World getClientWorld() {
		return Minecraft.getMinecraft().world;
	}

	/*@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == PackUtil.GUI_AIRDROP_CRATE) {
			return new GUIAirdropCrate(player.inventory, (TileEntityAirdropCrate) world.getTileEntity(new BlockPos(x, y, z)), player);
		}
		return null;
	}*/

	@SideOnly(Side.CLIENT)
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		System.out.println("Gui Handler(Client) got called");
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		if (te != null && te instanceof TileEntityAirdropCrate) {
			return new GUIAirdropCrate(player.inventory, (TileEntityAirdropCrate) world.getTileEntity(new BlockPos(x, y, z)), player);
		} else {
			return null;
		}
	}

	public static void registerGuis() {
	}
}
