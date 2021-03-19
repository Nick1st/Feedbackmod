package net.ddns.mcnoip.packutil.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Slice;

import net.ddns.mcnoip.packutil.config.PackUtilConfigCommon;
import net.minecraft.inventory.container.RepairContainer;

@Mixin(RepairContainer.class)
public class RepairContainerMixin {

    // change hardcoded level 40 cap
    @ModifyConstant(method = "updateRepairOutput", constant = @Constant(intValue = 40), slice = @Slice(from = @At(value = "INVOKE", target = "Lnet/minecraft/util/IntReferenceHolder;get()I", ordinal = 1)))
    private int setCap(int input) {
	return PackUtilConfigCommon.levelCap();
    }

    /*
     * @ModifyConstant(method = "getMaximumCost", constant = @Constant(intValue =
     * 40), slice = @Slice(from = @At(value = "INVOKE", target =
     * "Lnet/minecraft/util/IntReferenceHolder;get()I", ordinal = 1))) private int
     * setVisibleCap(int input) { return PackUtilConfigCommon.levelCap(); }
     */
}
