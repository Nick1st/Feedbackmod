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
import nick1st.packutil.PackUtil;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;

public class AirdropCrateAdvanced extends AirdropCrate {
	public float multiplier = 0.0039F;
	public ForgePlayer p;
	public Universe universe;
	public static ForgeTeam t;
	private int update = 0;

	private TileEntityAirdropCrate getTE(World world, BlockPos pos) {
		return (TileEntityAirdropCrate) world.getTileEntity(pos);
	}

	public float[] getBeamColor(World worldIn, BlockPos pos) {
		if (worldIn.isRemote) {
			float[] colors = {1.0F, 1.0F, 1.0F};
			return colors;
		}
		TileEntity te = worldIn.getTileEntity(pos);
		universe = Universe.get();
		try {
			//System.out.println(universe.getTeam(((TileEntityAirdropCrate) te).getTeamUID(te)));
			t = universe.getTeam(((TileEntityAirdropCrate) te).getTeamUID(te));
		} catch (Exception ex) {
			t = universe.getTeam("");
		}
		//ForgeTeam t = universe.getTeam(((TileEntityAirdropCrate) te).getTeamUID(te).toString());
		if (te instanceof TileEntityAirdropCrate) {
			TileEntityAirdropCrate teac = ((TileEntityAirdropCrate) te);
			if (t.type == TeamType.NONE && teac.red == 0 && teac.green == 0 && teac.blue == 0) {
				update++;
				if (update <= 40) {
					float[] colors = {0.855F, 0.647F, 0.125F};
					return colors;
				} else {
					float[] colors = {1.0F, 1.0F, 1.0F};
					if (update == 80) {
						update = 0;
					}
					return colors;
				}
			} else if (teac.red != 0 || teac.green != 0 || teac.blue != 0) {
				if (t.type == TeamType.NONE) {
					float[] colors = {teac.red / 255F, teac.green / 255F, teac.blue / 255F};
					return colors;
				}
			}
			if (t.getColor() == EnumTeamColor.BLUE) {
				float[] colors = {0.0F, 0.58F, 1.0F};
				return colors;
			} else if (t.getColor() == EnumTeamColor.CYAN) {
				float[] colors = {0.0F, 0.867F, 1.0F};
				return colors;
			} else if (t.getColor() == EnumTeamColor.GREEN) {
				float[] colors = {0.137F, 0.867F, 0.298F};
				return colors;
			} else if (t.getColor() == EnumTeamColor.YELLOW) {
				float[] colors = {1.0F, 0.816F, 0.0F};
				return colors;
			} else if (t.getColor() == EnumTeamColor.ORANGE) {
				float[] colors = {1.0F, 0.58F, 0.0F};
				return colors;
			} else if (t.getColor() == EnumTeamColor.RED) {
				float[] colors = {0.918F, 0.294F, 0.294F};
				return colors;
			} else if (t.getColor() == EnumTeamColor.PINK) {
				float[] colors = {0.91F, 0.533F, 0.788F};
				return colors;
			} else if (t.getColor() == EnumTeamColor.MAGENTA) {
				float[] colors = {1.0F, 0.0F, 0.498F};
				return colors;
			} else if (t.getColor() == EnumTeamColor.PURPLE) {
				float[] colors = {0.702F, 0.259F, 1.0F};
				return colors;
			} else if (t.getColor() == EnumTeamColor.GRAY) {
				float[] colors = {0.753F, 0.753F, 0.753F};
				return colors;
			} else {
				float[] colors = {teac.red / 255F, teac.green / 255F, teac.blue / 255F};
				return colors;
				//red = t.getColor().getColor().redi();
				//green = t.getColor().getColor().greeni();
				//blue = t.getColor().getColor().bluei();
			}
		}
		float[] colors = {1.0F, 1.0F, 1.0F};
		return colors;
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
