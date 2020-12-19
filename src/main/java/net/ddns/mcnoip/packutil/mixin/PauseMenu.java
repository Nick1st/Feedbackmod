package net.ddns.mcnoip.packutil.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.ConfirmOpenLinkScreen;
import net.minecraft.client.gui.screen.IngameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

@Mixin(IngameMenuScreen.class)
public abstract class PauseMenu extends Screen {

    protected PauseMenu(ITextComponent titleIn) {
	super(titleIn);
    }

    @Inject(at = @At("HEAD"), method = "addButtons()V")
    public void addCustomButtons(CallbackInfo ci) {
	this.addButton(new Button(this.width / 2 + 4, this.height / 4 + 72 + -16, 98, 20,
		new TranslationTextComponent("menu.reportPackBugs"), (button2) -> {
		    this.minecraft.displayGuiScreen(new ConfirmOpenLinkScreen((open) -> {
			if (open) {
			    Util.getOSType().openURI("https://www.curseforge.com/minecraft/mc-mods/packutil");
			}

			this.minecraft.displayGuiScreen(this);
		    }, "https://www.curseforge.com/minecraft/mc-mods/packutil", true));
		}));
    }

}
