package net.ddns.mcnoip.packutil.event;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class AnvilEvent {

    @SubscribeEvent
    public void onUpdateEvent(AnvilUpdateEvent e) {
	ItemStack left = e.getLeft();
	ItemStack right = e.getRight();
	ItemStack output = e.getOutput();

	if (!right.getItem().equals(Items.ENCHANTED_BOOK) && !left.getItem().equals(right.getItem())
		&& output.isEmpty()) {
	    Item leftitem = left.getItem();
	    if (!leftitem.getIsRepairable(left, right)) {
		return;
	    }
	    int levelcost = 1;
	    int materialcost = 1;
	    if (levelcost >= 0 || materialcost >= 0) {
		if (levelcost >= 0) {
		    e.setCost(levelcost);
		}
		if (materialcost >= 0) {
		    e.setMaterialCost(materialcost);
		}
		int currentdamage = left.getDamage();
		int maxdamage = left.getMaxDamage();
		int repairamount = ((int) (maxdamage * 0.3333D));
		currentdamage -= repairamount;
		if (currentdamage < 0) {
		    currentdamage = 0;
		}
		ItemStack newoutput = left.copy();
		newoutput.setDamage(currentdamage);
		e.setOutput(newoutput);
	    }
	}
    }
}
