package nick1st.packutil.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import nick1st.packutil.PackUtil;
import nick1st.packutil.common.block.airdrop_crate.AirdropCrateAdvanced;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;

public class MessageBeamColorSync implements IMessage {
	int dimension;
	BlockPos pos;
	float[] colors = {0.0F, 0.0F, 0.0F};

	public MessageBeamColorSync(TileEntityAirdropCrate tile, float[] colors) {
		this.dimension = tile.getWorld().provider.getDimension();
		this.pos = tile.getPos();
		this.colors = colors;
	}

	public MessageBeamColorSync() {
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.dimension = buf.readInt();
		this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
		this.colors[0] = buf.readFloat();
		this.colors[1] = buf.readFloat();
		this.colors[2] = buf.readFloat();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.dimension);
		buf.writeInt(this.pos.getX());
		buf.writeInt(this.pos.getY());
		buf.writeInt(this.pos.getZ());
		buf.writeFloat(this.colors[0]);
		buf.writeFloat(this.colors[1]);
		buf.writeFloat(this.colors[2]);
	}

	public static class Handler implements IMessageHandler<MessageBeamColorSync, IMessage> {
		@Override
		public IMessage onMessage(MessageBeamColorSync message, MessageContext ctx) {
			World world = PackUtil.PROXY.getClientWorld();
			if (world != null) {
				TileEntity tile = world.getTileEntity(message.pos);
				Block block = world.getBlockState(message.pos).getBlock();
				if (block instanceof AirdropCrateAdvanced) {
					((AirdropCrateAdvanced) block).receiveMessageFromServer(message.colors);
				}
			}
			return null;
		}
	}
}
