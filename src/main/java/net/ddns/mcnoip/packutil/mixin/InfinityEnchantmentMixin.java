package net.ddns.mcnoip.packutil.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.inventory.EquipmentSlotType;

@Mixin(InfinityEnchantment.class)
public abstract class InfinityEnchantmentMixin extends Enchantment {

    public InfinityEnchantmentMixin(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
	super(rarityIn, EnchantmentType.BOW, slots);
    }

    @Overwrite
    public boolean canApplyTogether(Enchantment ench) {
	return super.canApplyTogether(ench);
    }

}
