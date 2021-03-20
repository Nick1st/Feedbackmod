package net.ddns.mcnoip.packutil.event;

import net.ddns.mcnoip.packutil.PackUtilLogger;
import net.ddns.mcnoip.packutil.config.PackUtilConfigClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class SpawnEvent {

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void onSpawn(PlayerEvent.PlayerLoggedInEvent e) {
	CompoundNBT NBT = e.getPlayer().getPersistentData().getCompound(PlayerEntity.PERSISTED_NBT_TAG);
	for (String tagname : NBT.keySet()) {
	    if (tagname.matches("PULoggedIn")) {
		PackUtilLogger.debug("Player already logged in before!");
		return;
	    }
	}
	if (PackUtilConfigClient.welcomeMessage().isEmpty()) {
	    return;
	}
	IFormattableTextComponent message = ITextComponent.Serializer
		.getComponentFromJson(PackUtilConfigClient.welcomeMessage());
	e.getPlayer().sendMessage(message, e.getPlayer().getUniqueID());
	PackUtilLogger.debug("Player hasn't logged in yet!");
	NBT.putBoolean("PULoggedIn", true);
	e.getPlayer().getPersistentData().put(PlayerEntity.PERSISTED_NBT_TAG, NBT);
    }
}
