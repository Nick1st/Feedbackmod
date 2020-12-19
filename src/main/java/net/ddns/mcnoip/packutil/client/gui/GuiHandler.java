package net.ddns.mcnoip.packutil.client.gui;

import net.ddns.mcnoip.packutil.config.PackUtilConfigClient;
import net.minecraft.client.gui.screen.ConfirmOpenLinkScreen;
import net.minecraft.client.gui.screen.IngameMenuScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Packutil GuiHandler
 */
public class GuiHandler {

    protected static boolean isSave;

    @SubscribeEvent
    public static void onGUI(GuiScreenEvent.InitGuiEvent.Post e) {
	if (e.getGui() instanceof IngameMenuScreen) {

	    Button feedback = (Button) e.getWidgetList().stream().filter(n -> {
		if (n instanceof Button) {
		    if (n.getMessage() instanceof TranslationTextComponent) {
			return ((TranslationTextComponent) n.getMessage()).getKey().equals("menu.sendFeedback");
		    }
		}
		return false;
	    }).findAny().orElseGet(null);

	    Button reportbugs = (Button) e.getWidgetList().stream().filter(n -> {
		if (n instanceof Button) {
		    if (n.getMessage() instanceof TranslationTextComponent) {
			return ((TranslationTextComponent) n.getMessage()).getKey().equals("menu.reportBugs");
		    }
		}
		return false;
	    }).findAny().orElseGet(null);

	    /**
	     * Remove Feedback and default Report Bug button
	     */
	    if (PackUtilConfigClient.enableIngameMenuScreen()) {
		if (feedback != null) {
		    e.removeWidget(feedback);
		}
		if (reportbugs != null) {
		    e.removeWidget(reportbugs);
		}

		/**
		 * Check if Url is save
		 */

		if (PackUtilConfigClient.reportUrl().startsWith("https://github.com/")) {
		    isSave = true;
		}

		/**
		 * Add custom Report Bug button
		 */
		Button reportPackBugs = new ReportButton(e.getGui().width / 2 - 102, e.getGui().height / 4 + 72 + -16,
			e);
		e.addWidget(reportPackBugs);
	    }
	}

	return;
    }

    /**
     * Custom Report Bug button
     */
    private static class ReportButton extends Button {

	public ReportButton(int x, int y, GuiScreenEvent.InitGuiEvent.Post e) {
	    super(x, y, 204, 20, new TranslationTextComponent("menu.reportBugs"), (button2) -> {
		if (button2.active) {
		    e.getGui().getMinecraft().displayGuiScreen(new ConfirmOpenLinkScreen((open) -> {
			if (open) {
			    Util.getOSType().openURI(PackUtilConfigClient.reportUrl());
			}

			e.getGui().getMinecraft().displayGuiScreen(e.getGui());
		    }, PackUtilConfigClient.reportUrl(), isSave));
		}
	    });

	}
    }

}