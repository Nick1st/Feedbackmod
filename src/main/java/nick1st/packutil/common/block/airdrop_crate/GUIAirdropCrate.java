package nick1st.packutil.common.block.airdrop_crate;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;

public class GUIAirdropCrate extends GuiContainer {
	private static final ResourceLocation GUI_AIRDROP_CRATE = new ResourceLocation("packutil"
			+ ":textures/gui/airdrop_crate.png");
	private final InventoryPlayer playerInv;
	private final TileEntityAirdropCrate te;

	public GUIAirdropCrate(InventoryPlayer playerInv, TileEntityAirdropCrate crateInv, EntityPlayer player) {
		super(new ContainerAirdropCrate(playerInv, crateInv));
		this.playerInv = playerInv;
		this.te = crateInv;
		this.xSize = 176;
		this.ySize = 156;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_AIRDROP_CRATE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		this.fontRenderer.drawString("Crate", 5, 6, 212121);
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 5, this.ySize - 92, 212121);
	}
}
