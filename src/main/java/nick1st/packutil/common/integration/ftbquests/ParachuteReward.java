package nick1st.packutil.common.integration.ftbquests;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.feed_the_beast.ftblib.lib.command.CommandUtils;
import com.feed_the_beast.ftblib.lib.config.ConfigGroup;
import com.feed_the_beast.ftblib.lib.config.ConfigItemStack;
import com.feed_the_beast.ftblib.lib.config.ConfigList;
import com.feed_the_beast.ftblib.lib.config.ConfigValue;
import com.feed_the_beast.ftblib.lib.config.ConfigValueInstance;
import com.feed_the_beast.ftblib.lib.data.ForgePlayer;
import com.feed_the_beast.ftblib.lib.gui.GuiHelper;
import com.feed_the_beast.ftblib.lib.io.DataIn;
import com.feed_the_beast.ftblib.lib.io.DataOut;
import com.feed_the_beast.ftbquests.gui.tree.GuiValidItems;
import com.feed_the_beast.ftbquests.net.MessageClaimReward;
import com.feed_the_beast.ftbquests.net.MessageSubmitTask;
import com.feed_the_beast.ftbquests.quest.Quest;
import com.feed_the_beast.ftbquests.quest.reward.Reward;
import com.feed_the_beast.ftbquests.quest.reward.RewardType;
import com.latmod.mods.itemfilters.item.ItemMissing;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.CommandException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nick1st.packutil.entities.EntityParachute;

// For Information look at ItemTask.class

public class ParachuteReward extends Reward {
	public ItemStack item0;
	public int count0;
	public NonNullList<ItemStack> cratecontent = NonNullList.<ItemStack>withSize(18, new ItemStack(Items.AIR));
	private int rx, rz;

	//public List<ItemStack> cratecontent;

	/*
	public ParachuteReward(Quest quest, ItemStack is) {
		super(quest);
		item0 = is;
		count0 = 1;
	}
	
	public ParachuteReward(Quest quest) {
		this(quest, new ItemStack(Items.APPLE));
	}*/

	public ParachuteReward(Quest quest) {
		super(quest);
	}

	@Override
	public RewardType getType() {
		return PackUtilIntegration.PARACHUTE;
	}
	/*
	@Override
	public void writeData(NBTTagCompound nbt) {
		super.writeData(nbt);
		nbt.setTag("item0", ItemMissing.write(item0, false));
		if (count0 > 1) {
			nbt.setInteger("count0", count0);
		}
	}
	
	@Override
	public void readData(NBTTagCompound nbt) {
		super.readData(nbt);
		item0 = ItemMissing.read(nbt.getTag("item0"));
		count0 = nbt.getInteger("count0");
		if (count0 == 0) {
			count0 = item0.getCount();
			item0.setCount(1);
		}
	}
	*/

	@Override
	public void writeData(NBTTagCompound nbt) {
		super.writeData(nbt);
		ItemStackHelper.saveAllItems(nbt, this.cratecontent);
	}

	@Override
	public void readData(NBTTagCompound nbt) {
		super.readData(nbt);
		ItemStackHelper.loadAllItems(nbt, this.cratecontent);
	}

	/*
	@Override
	public void writeNetData(DataOut data) {
		super.writeNetData(data);
		data.writeItemStack(item0);
		data.writeVarInt(count0);
	}
	
	@Override
	public void readNetData(DataIn data) {
		super.readNetData(data);
		item0 = data.readItemStack();
		count0 = data.readVarInt();
	}
	*/

	@Override
	public void writeNetData(DataOut data) {
		super.writeNetData(data);
		for (int i = 0; i < cratecontent.size(); i++) {
			data.writeItemStack(cratecontent.get(i));
		}
	}

	@Override
	public void readNetData(DataIn data) {
		super.readNetData(data);
		for (int i = 0; i < cratecontent.size(); i++) {
			cratecontent.set(i, data.readItemStack());
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getConfig(ConfigGroup config) {
		super.getConfig(config);
		////config.add("item0", new ConfigItemStack.SimpleStack(true, () -> item0, v -> item0 = v), new ConfigItemStack(ItemStack.EMPTY)).setDisplayName(new TextComponentTranslation("ftbquests.reward.packutil.parachute"));
		////config.addInt("count0", () -> count0, v -> count0 = v, 1, 1, 8192);
		config.addList("items", cratecontent, new ConfigItemStack(ItemStack.EMPTY, false), v -> new ConfigItemStack(v, false), ConfigItemStack::getStack);
	}

	public ForgePlayer p;

	@Override
	public void claim(EntityPlayerMP player, boolean notify) {
		try {
			p = CommandUtils.getForgePlayer(player);
		} catch (CommandException e) {
			e.printStackTrace();
		}
		Random ran = new Random();
		rx = ran.nextInt(51);
		rz = ran.nextInt(51);
		if (ran.nextBoolean()) {
			rx *= -1;
		}
		if (ran.nextBoolean()) {
			rz *= -1;
		}
		MutableBlockPos pos = new MutableBlockPos(player.getPosition());
		EntityParachute ep = new EntityParachute(player.getEntityWorld(), pos.getX() + rx, 300, pos.getZ() + rz);
		ep.setCratecontent(cratecontent);
		ep.teamUID = p.team.getUID();
		player.getEntityWorld().spawnEntity(ep);
		System.out.println("Claimend!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onButtonClicked(boolean canClick) {
		GuiHelper.playClickSound();
		/*
				List<ItemStack> validItems = cratecontent;
				if (GuiScreen.isShiftKeyDown()) {
					int r = GuiScreen.isCtrlKeyDown() ? 16 : 1;
					for (int i = 0; i < r; i++) {
						new MessageSubmitTask(id).sendToServer();
						for (Reward reward : quest.rewards) {
							new MessageClaimReward(reward.id, false).sendToServer();
						}
					}
				} else {
					new GuiValidItems(null, validItems, canClick).openGui();
				}*/
	}
}
