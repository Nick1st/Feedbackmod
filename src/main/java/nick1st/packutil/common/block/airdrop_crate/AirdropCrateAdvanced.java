package nick1st.packutil.common.block.airdrop_crate;

import com.feed_the_beast.ftblib.lib.EnumTeamColor;
import com.feed_the_beast.ftblib.lib.command.CommandUtils;
import com.feed_the_beast.ftblib.lib.data.ForgePlayer;
import com.feed_the_beast.ftblib.lib.data.ForgeTeam;
import com.feed_the_beast.ftblib.lib.data.TeamType;
import com.feed_the_beast.ftblib.lib.data.Universe;

import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandException;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import nick1st.packutil.PackUtil;
import nick1st.packutil.common.network.MessageBeamColorSync;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;

public class AirdropCrateAdvanced extends AirdropCrate {
	public float multiplier = 0.0039F;
	public ForgePlayer p;
	public Universe universe;
	public static ForgeTeam t;
	private int update = 0;
	public float[] colors = {1.0F, 1.0F, 1.0F};
	public TileEntityAirdropCrate teac;

	private TileEntityAirdropCrate getTE(World world, BlockPos pos) {
		return (TileEntityAirdropCrate) world.getTileEntity(pos);
	}

	protected void sendColorPacket(TileEntityAirdropCrate tile) {
		PackUtil.PACKET_HANDLER.sendToAllAround(new MessageBeamColorSync(tile, this.colors), new TargetPoint(tile.getWorld().provider.getDimension(), tile.getPos().getX(), tile.getPos().getY(), tile.getPos().getZ(), 128));
	}

	public void receiveMessageFromServer(float[] colors) {
		System.out.println("receiveMessageFromServer() called");
		this.colors = colors;
	}

	public float[] getBeamColor(World worldIn, BlockPos pos) {
		//System.out.println(pos.getX() + "|" + pos.getY() + "|" + pos.getZ());
		if (worldIn.isRemote) {
			//System.out.println(pos.getX() + "; " + this.colors[0] + "|" + pos.getY() + "; " + this.colors[1] + "|"
			//		+ pos.getZ() + "; " + this.colors[2]);
			//float[] colors = {1.0F, 1.0F, 1.0F};
			return this.colors;
		}
		universe = Universe.get();
		TileEntity te = worldIn.getTileEntity(pos);
		try {
			//System.out.println(universe.getTeam(((TileEntityAirdropCrate) te).getTeamUID(te)));
			t = universe.getTeam(((TileEntityAirdropCrate) te).getTeamUID(te));
		} catch (Exception ex) {
			t = universe.getTeam("");
		}
		//ForgeTeam t = universe.getTeam(((TileEntityAirdropCrate) te).getTeamUID(te).toString());
		if (te instanceof TileEntityAirdropCrate) {
			teac = ((TileEntityAirdropCrate) te);
			if (t.type == TeamType.NONE && this.teac.red == 0 && this.teac.green == 0 && this.teac.blue == 0) {
				update++;
				if (update <= 40) {
					this.colors[0] = 0.855F;
					this.colors[1] = 0.647F;
					this.colors[2] = 0.125F;
				} else {
					this.colors[0] = 1.0F;
					this.colors[1] = 1.0F;
					this.colors[2] = 1.0F;
					if (update == 80) {
						update = 0;
					}
				}
				sendColorPacket(this.teac);
				return this.colors;
			} else if (this.teac.red != 0 || this.teac.green != 0 || this.teac.blue != 0) {
				if (t.type == TeamType.NONE) {
					this.colors[0] = this.teac.red / 255F;
					this.colors[1] = this.teac.green / 255F;
					this.colors[2] = this.teac.blue / 255F;
					sendColorPacket(this.teac);
					return this.colors;
				}
			}
			if (t.getColor() == EnumTeamColor.BLUE) {
				this.colors[0] = 0.0F;
				this.colors[1] = 0.58F;
				this.colors[2] = 1.0F;
			} else if (t.getColor() == EnumTeamColor.CYAN) {
				this.colors[0] = 0.0F;
				this.colors[1] = 0.867F;
				this.colors[2] = 1.0F;
			} else if (t.getColor() == EnumTeamColor.GREEN) {
				this.colors[0] = 0.137F;
				this.colors[1] = 0.867F;
				this.colors[2] = 0.298F;
			} else if (t.getColor() == EnumTeamColor.YELLOW) {
				this.colors[0] = 1.0F;
				this.colors[1] = 0.816F;
				this.colors[2] = 0.0F;
			} else if (t.getColor() == EnumTeamColor.ORANGE) {
				this.colors[0] = 1.0F;
				this.colors[1] = 0.58F;
				this.colors[2] = 0.0F;
			} else if (t.getColor() == EnumTeamColor.RED) {
				this.colors[0] = 0.918F;
				this.colors[1] = 0.294F;
				this.colors[2] = 0.294F;
			} else if (t.getColor() == EnumTeamColor.PINK) {
				this.colors[0] = 0.91F;
				this.colors[1] = 0.533F;
				this.colors[2] = 0.788F;
			} else if (t.getColor() == EnumTeamColor.MAGENTA) {
				this.colors[0] = 1.0F;
				this.colors[1] = 0.0F;
				this.colors[2] = 0.498F;
			} else if (t.getColor() == EnumTeamColor.PURPLE) {
				this.colors[0] = 0.702F;
				this.colors[1] = 0.259F;
				this.colors[2] = 1.0F;
			} else if (t.getColor() == EnumTeamColor.GRAY) {
				this.colors[0] = 0.753F;
				this.colors[1] = 0.753F;
				this.colors[2] = 0.753F;
			} else {
				this.colors[0] = this.teac.red / 255F;
				this.colors[1] = this.teac.green / 255F;
				this.colors[2] = this.teac.blue / 255F;
			}
			sendColorPacket(this.teac);
			return this.colors;
		}
		return this.colors;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (stack.hasDisplayName()) {
			if (tileentity instanceof TileEntityAirdropCrate) {
				((TileEntityAirdropCrate) tileentity).setCustomName(stack.getDisplayName());
			}
		}
		if (placer instanceof EntityPlayerMP) {
			if (tileentity instanceof TileEntityAirdropCrate) {
				try {
					p = CommandUtils.getForgePlayer((EntityPlayerMP) placer);
				} catch (CommandException e) {
					e.printStackTrace();
				}
				getTE(worldIn, pos).setTeamUID(p.team.getUID());
			}
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) {
		TileEntity te = worldIn.getTileEntity(pos);
		//((TileEntityAirdropCrate) te).sendUpdates();
		System.out.println(((TileEntityAirdropCrate) te).getRed() + "|" + ((TileEntityAirdropCrate) te).getGreen() + "|"
				+ ((TileEntityAirdropCrate) te).getBlue());
		if (playerIn instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) playerIn;
			try {
				p = CommandUtils.getForgePlayer(player);
				/*if (p.hasTeam()) {
					System.out.println("Has Team!!!!!");
					System.out.println(p.team.getUID());
				} else if (!p.hasTeam()) {
					System.out.println("Has NO Team!!!!!");
				}*/
			} catch (CommandException e) {
				e.printStackTrace();
			}
		}
		if (te == null || !(te instanceof TileEntityAirdropCrate)) {
			return true;
		}
		if (!worldIn.isRemote) {
			if (te instanceof TileEntityAirdropCrate) {
				System.out.println(p.team.getUID());
				if (((TileEntityAirdropCrate) te).getTeamUID(te) == p.team.getUID()) {
					playerIn.openGui(PackUtil.INSTANCE, PackUtil.GUI_AIRDROP_CRATE, worldIn, pos.getX(), pos.getY(), pos.getZ());
				} else if (((TileEntityAirdropCrate) te).getTeamUID(te) == 0) {
					playerIn.openGui(PackUtil.INSTANCE, PackUtil.GUI_AIRDROP_CRATE, worldIn, pos.getX(), pos.getY(), pos.getZ());
					playerIn.sendMessage(new TextComponentString("You found an unclaimed Loot Crate !"));
				} else {
					universe = Universe.get();
					playerIn.sendMessage(new TextComponentString("This Crate is owned by "
							+ universe.getTeam(((TileEntityAirdropCrate) te).getTeamUID(te)).getTitle().getUnformattedText()));
					System.out.println(p.team.getUID());
					System.out.println(p.team.getColor().getColor().redi() * multiplier);
					System.out.println(p.team.getColor().getColor().greeni() * multiplier);
					System.out.println(p.team.getColor().getColor().bluei() * multiplier);
					//System.out.println(p.team.getTitle().getUnformattedText());
				}
			}
		}
		if (worldIn.getBlockState(pos.up()).doesSideBlockChestOpening(worldIn, pos.up(), EnumFacing.DOWN)) {
			return true;
		}
		if (worldIn.isRemote) {
			return true;
		}
		//New
		/*
		if (playerIn instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) playerIn;
			try {
				ForgePlayer p = CommandUtils.getForgePlayer(player);
				if (p.hasTeam()) {
					System.out.println("Has Team!!!!!");
					System.out.println(p.team.getUID());
				} else if (!p.hasTeam()) {
					System.out.println("Has NO Team!!!!!");
				}
			} catch (CommandException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("NOOOOOOOOOOOOOOOOOOO REEEEEEEEEEEEMOOOOOOOOOOOOOOOOOOOTTTTTTTTTTTTTTTTTTTTTTTTTE!!!!!");
		}
		*/
		//Old
		return true;
	}
}
