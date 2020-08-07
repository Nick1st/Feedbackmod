package nick1st.packutil.common.integration.ftbquests;

import com.feed_the_beast.ftblib.lib.gui.GuiIcons;
import com.feed_the_beast.ftbquests.integration.customnpcs.CustomNPCsIntegration;
import com.feed_the_beast.ftbquests.integration.customnpcs.NPCFactionReward;
import com.feed_the_beast.ftbquests.integration.customnpcs.NPCMailReward;
import com.feed_the_beast.ftbquests.integration.customnpcs.NPCQuestReward;
import com.feed_the_beast.ftbquests.quest.reward.RewardType;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PackUtilIntegration {
	public static RewardType PARACHUTE;

	public static void preInit() {
		MinecraftForge.EVENT_BUS.register(PackUtilIntegration.class);
	}

	@SubscribeEvent
	public static void registerRewards(RegistryEvent.Register<RewardType> event) {
		event.getRegistry().register(PARACHUTE = new RewardType(ParachuteReward::new).setRegistryName("parachute_quest").setIcon(GuiIcons.BEACON));
	}
}
