package nick1st.packutil.common.block.airdrop_crate;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelAirdropCrate extends ModelBase {
	private final ModelRenderer crate;
	private final ModelRenderer hookRight;
	private final ModelRenderer hookLeft;
	private final ModelRenderer hookBack;
	private final ModelRenderer hookFront;

	public ModelAirdropCrate() {
		textureWidth = 64;
		textureHeight = 64;

		crate = new ModelRenderer(this);
		crate.setRotationPoint(1.0F, 1.0F, 1.0F);
		crate.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 14, 14, 14, false);
		crate.setTextureOffset(12, 34).addBox(-1.0F, -1.0F, -1.0F, 3, 3, 3, false);
		crate.setTextureOffset(0, 34).addBox(12.0F, -1.0F, 12.0F, 3, 3, 3, false);
		crate.setTextureOffset(33, 33).addBox(-1.0F, -1.0F, 12.0F, 3, 3, 3, false);
		crate.setTextureOffset(24, 28).addBox(12.0F, -1.0F, -1.0F, 3, 3, 3, false);
		crate.setTextureOffset(12, 28).addBox(-1.0F, 12.0F, -1.0F, 3, 3, 3, false);
		crate.setTextureOffset(0, 28).addBox(12.0F, 12.0F, 12.0F, 3, 3, 3, false);
		crate.setTextureOffset(0, 6).addBox(-1.0F, 12.0F, 12.0F, 3, 3, 3, false);
		crate.setTextureOffset(0, 0).addBox(12.0F, 12.0F, -1.0F, 3, 3, 3, false);
		crate.setTextureOffset(24, 34).addBox(6.0F, 1.0F, 13.0F, 2, 4, 2, false);

		hookRight = new ModelRenderer(this);
		hookRight.setRotationPoint(3.0F, -1.0F, 4.0F);
		crate.addChild(hookRight);
		hookRight.setTextureOffset(24, 40).addBox(-2.0F, 0.0F, 0.0F, 2, 1, 2, false);
		hookRight.setTextureOffset(16, 40).addBox(-2.0F, 0.0F, 4.0F, 2, 1, 2, false);
		hookRight.setTextureOffset(21, 28).addBox(-1.0F, 0.0F, 2.0F, 1, 1, 2, false);

		hookLeft = new ModelRenderer(this);
		hookLeft.setRotationPoint(10.0F, -1.0F, 4.0F);
		crate.addChild(hookLeft);
		hookLeft.setTextureOffset(8, 40).addBox(1.0F, 0.0F, 0.0F, 2, 1, 2, false);
		hookLeft.setTextureOffset(0, 40).addBox(1.0F, 0.0F, 4.0F, 2, 1, 2, false);
		hookLeft.setTextureOffset(9, 28).addBox(1.0F, 0.0F, 2.0F, 1, 1, 2, false);

		hookBack = new ModelRenderer(this);
		hookBack.setRotationPoint(7.0F, -1.0F, 3.0F);
		crate.addChild(hookBack);
		hookBack.setTextureOffset(39, 29).addBox(1.0F, 0.0F, -2.0F, 2, 1, 2, false);
		hookBack.setTextureOffset(38, 39).addBox(-3.0F, 0.0F, -2.0F, 2, 1, 2, false);
		hookBack.setTextureOffset(6, 12).addBox(-1.0F, 0.0F, -1.0F, 2, 1, 1, false);

		hookFront = new ModelRenderer(this);
		hookFront.setRotationPoint(7.0F, -1.0F, 12.0F);
		crate.addChild(hookFront);
		hookFront.setTextureOffset(30, 39).addBox(1.0F, 0.0F, -1.0F, 2, 1, 2, false);
		hookFront.setTextureOffset(33, 28).addBox(-3.0F, 0.0F, -1.0F, 2, 1, 2, false);
		hookFront.setTextureOffset(0, 12).addBox(-1.0F, 0.0F, -1.0F, 2, 1, 1, false);
	}

	public void renderAll() {
		this.crate.render(0.0625F);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
