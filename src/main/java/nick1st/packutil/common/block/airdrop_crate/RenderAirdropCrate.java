package nick1st.packutil.common.block.airdrop_crate;

import java.util.List;
import java.util.Objects;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityBeaconRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import nick1st.packutil.common.tileentity.TileEntityAirdropCrate;
import nick1st.packutil.entities.EntityParachute;

public class RenderAirdropCrate extends TileEntitySpecialRenderer<TileEntityAirdropCrate> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("packutil"
			+ ":textures/blocks/airdrop_crate.png");
	private static final ResourceLocation BEAM_TEXTURE = new ResourceLocation("textures/entity/beacon_beam.png");
	private final ModelAirdropCrate MODEL = new ModelAirdropCrate();

	@Override
	public void render(TileEntityAirdropCrate te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		GlStateManager.enableDepth();
		GlStateManager.depthFunc(515);
		GlStateManager.depthMask(true);

		ModelAirdropCrate model = MODEL;
		if (destroyStage >= 0) {
			this.bindTexture(DESTROY_STAGES[destroyStage]);
			GlStateManager.matrixMode(5890);
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
			GlStateManager.matrixMode(5888);
		} else {
			this.bindTexture(TEXTURE);
		}
		GlStateManager.pushMatrix();
		GlStateManager.enableRescaleNormal();
		GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
		GlStateManager.scale(1.0F, -1.0F, -1.0F);
		GlStateManager.translate(0.5F, 0.5F, 0.5F);
		GlStateManager.translate(-0.5F, -0.5F, -0.5F);

		float f = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * partialTicks;
		f = 1.0F - f;
		f = 1.0F - f * f * f;
		model.renderAll();
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		if (destroyStage >= 0) {
			GlStateManager.matrixMode(5890);
			GlStateManager.popMatrix();
			GlStateManager.matrixMode(5888);
		}
		//
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240f, 240f);
		this.renderBeam(x, y, z, (double) partialTicks, te.getBeamSegments(), Objects.requireNonNull(te.getWorld()).getWorldTime());
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glPopMatrix();
		//System.out.println("renderBeam() was called!");
		//
	}

	//
	private void renderBeam(double x, double y, double z, double partialTicks, List<TileEntityAirdropCrate.BeamSegment> segments, long time) {
		GlStateManager.alphaFunc(516, 0.1F);
		this.bindTexture(BEAM_TEXTURE);
		GlStateManager.disableFog();
		int i = 0;
		//System.out.println(segments.size());
		for (int j = 0; j < segments.size(); ++j) {
			TileEntityAirdropCrate.BeamSegment beacontileentity$beamsegment = segments.get(j);
			renderSegments(x, y, z, partialTicks, time, i, j == segments.size()
					- 1 ? 1024 : beacontileentity$beamsegment.getHeight(), beacontileentity$beamsegment.getColors());
			//System.out.println(red + "|" + green + "|" + blue);
			i += beacontileentity$beamsegment.getHeight();
		}
		GlStateManager.enableFog();
	}

	private static void renderSegments(double x, double y, double z, double partialTicks, long time, int segment, int height, float[] colours) {
		//TileEntityBeaconRenderer.renderBeamSegment(x, y, z, partialTicks, 1.0D, time, segment, height, colours, 0.2D, 0.25D);
		TileEntityBeaconRenderer.renderBeamSegment(x, y, z, partialTicks, 1.0D, time, segment, height, colours, 0.1D, 0.2D);
	}

	@Override
	public boolean isGlobalRenderer(TileEntityAirdropCrate te) {
		return true;
	}
	//
}
