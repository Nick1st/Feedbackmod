package nick1st.packutil.client.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nick1st.packutil.client.models.ModelParachuteEntity;
import nick1st.packutil.client.models.ModelParachuteEntity;
import nick1st.packutil.entities.EntityParachute;

@SideOnly(Side.CLIENT)
public class RenderEntityParachute extends Render<EntityParachute> {
	private final ModelParachuteEntity PARACHUTE = new ModelParachuteEntity();
	private final ResourceLocation TEXTURE = new ResourceLocation("packutil:textures/entity/parachute.png");

	public RenderEntityParachute(RenderManager rendermanagerIn) {
		super(rendermanagerIn);
	}

	public void doRender(EntityParachute entity, double x, double y, double z, float yaw, float tick) {
		renderParachute(entity, x, y, z, yaw, tick);
	}

	public void renderParachute(EntityParachute entity, double x, double y, double z, float yaw, float tick) {
		FMLClientHandler.instance().getClient().getTextureManager().bindTexture(this.TEXTURE);
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x, (float) y + 2.3D, (float) z);
		GlStateManager.scale(-1.0D, -1.0D, 1.0D);
		GlStateManager.rotate(entity.rotationYaw, 0.0F, 1.0F, 0.0F);
		GlStateManager.pushMatrix();
		GlStateManager.disableCull();
		this.PARACHUTE.render();
		GlStateManager.enableCull();
		GlStateManager.popMatrix();
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		GlStateManager.translate(x - 0.5D, y, z + 0.5D);
		GlStateManager.scale(1.0D, 1.0D, 1.0D);
		bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		GlStateManager.popMatrix();
	}

	protected ResourceLocation getEntityTexture(EntityParachute entity) {
		return null;
	}
}
