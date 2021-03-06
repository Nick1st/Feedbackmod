package nick1st.packutil.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 3.5.4

public class ModelParachuteEntity extends ModelBase {
	private final ModelRenderer crate;
	private final ModelRenderer hookRight;
	private final ModelRenderer hookLeft;
	private final ModelRenderer hookBack;
	private final ModelRenderer hookFront;
	private final ModelRenderer parachute;
	private final ModelRenderer parachutereal;
	private final ModelRenderer top;
	private final ModelRenderer top1;
	private final ModelRenderer top2;
	private final ModelRenderer top3;
	private final ModelRenderer top4;
	private final ModelRenderer top5;
	private final ModelRenderer top6;
	private final ModelRenderer top7;
	private final ModelRenderer top8;
	private final ModelRenderer side;
	private final ModelRenderer side1;
	private final ModelRenderer side2;
	private final ModelRenderer side3;
	private final ModelRenderer side4;
	private final ModelRenderer side5;
	private final ModelRenderer side6;
	private final ModelRenderer strings;
	private final ModelRenderer string1;
	private final ModelRenderer string2;
	private final ModelRenderer string3;
	private final ModelRenderer string4;
	private final ModelRenderer string5;
	private final ModelRenderer string6;
	private final ModelRenderer string7;
	private final ModelRenderer string8;

	public ModelParachuteEntity() {
		textureWidth = 128;
		textureHeight = 128;

		crate = new ModelRenderer(this);
		//crate.setRotationPoint(-8.0F, 16.0F, 8.0F);
		crate.setRotationPoint(-8.0F, 29.0F, 8.0F);
		setRotationAngle(crate, 3.1416F, 3.1416F, 0.0F);
		crate.setTextureOffset(0, 0).addBox(-15.0F, -7.0F, -15.0F, 14, 14, 14, false);
		crate.setTextureOffset(12, 65).addBox(-16.0F, -8.0F, -16.0F, 3, 3, 3, false);
		crate.setTextureOffset(12, 77).addBox(-3.0F, -8.0F, -16.0F, 3, 3, 3, false);
		crate.setTextureOffset(12, 71).addBox(-3.0F, -8.0F, -3.0F, 3, 3, 3, false);
		crate.setTextureOffset(0, 53).addBox(-16.0F, -8.0F, -3.0F, 3, 3, 3, false);
		crate.setTextureOffset(26, 47).addBox(-3.0F, 5.0F, -16.0F, 3, 3, 3, false);
		crate.setTextureOffset(0, 47).addBox(-16.0F, 5.0F, -16.0F, 3, 3, 3, false);
		crate.setTextureOffset(44, 35).addBox(-16.0F, 5.0F, -3.0F, 3, 3, 3, false);
		crate.setTextureOffset(44, 29).addBox(-3.0F, 5.0F, -3.0F, 3, 3, 3, false);
		crate.setTextureOffset(0, 28).addBox(-9.0F, 2.0F, -16.0F, 2, 4, 2, false);

		hookRight = new ModelRenderer(this);
		hookRight.setRotationPoint(0.0F, 0.0F, 0.0F);
		crate.addChild(hookRight);
		hookRight.setTextureOffset(8, 0).addBox(-3.0F, 7.0F, -11.0F, 1, 2, 2, false);
		hookRight.setTextureOffset(8, 8).addBox(-3.0F, 7.0F, -7.0F, 1, 2, 2, false);
		hookRight.setTextureOffset(82, 27).addBox(-3.0F, 8.0F, -10.0F, 1, 1, 4, false);

		hookLeft = new ModelRenderer(this);
		hookLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		crate.addChild(hookLeft);
		hookLeft.setTextureOffset(0, 7).addBox(-14.0F, 7.0F, -11.0F, 1, 2, 2, false);
		hookLeft.setTextureOffset(0, 0).addBox(-14.0F, 7.0F, -7.0F, 1, 2, 2, false);
		hookLeft.setTextureOffset(82, 18).addBox(-14.0F, 8.0F, -10.0F, 1, 1, 4, false);

		hookBack = new ModelRenderer(this);
		hookBack.setRotationPoint(0.0F, 0.0F, 0.0F);
		crate.addChild(hookBack);
		hookBack.setTextureOffset(21, 94).addBox(-7.0F, 7.0F, -3.0F, 2, 2, 1, false);
		hookBack.setTextureOffset(0, 94).addBox(-11.0F, 7.0F, -3.0F, 2, 2, 1, false);
		hookBack.setTextureOffset(84, 51).addBox(-10.0F, 8.0F, -3.0F, 4, 1, 1, false);

		hookFront = new ModelRenderer(this);
		hookFront.setRotationPoint(0.0F, 0.0F, 0.0F);
		crate.addChild(hookFront);
		hookFront.setTextureOffset(90, 93).addBox(-7.0F, 7.0F, -14.0F, 2, 2, 1, false);
		hookFront.setTextureOffset(44, 93).addBox(-11.0F, 7.0F, -14.0F, 2, 2, 1, false);
		hookFront.setTextureOffset(76, 84).addBox(-10.0F, 8.0F, -14.0F, 4, 1, 1, false);

		parachute = new ModelRenderer(this);
		//parachute.setRotationPoint(0.0F, 24.0F, 0.0F);
		parachute.setRotationPoint(0.0F, 37.0F, 0.0F);

		parachutereal = new ModelRenderer(this);
		parachutereal.setRotationPoint(0.0F, 0.0F, 0.0F);
		parachute.addChild(parachutereal);
		setRotationAngle(parachutereal, 0.0F, -0.7854F, 0.0F);

		top = new ModelRenderer(this);
		top.setRotationPoint(0.0F, 0.0F, 0.0F);
		parachutereal.addChild(top);

		top1 = new ModelRenderer(this);
		top1.setRotationPoint(0.0F, 0.0F, 0.0F);
		top.addChild(top1);
		top1.setTextureOffset(0, 60).addBox(-4.0F, -49.0F, -2.0F, 8, 1, 4, false);
		top1.setTextureOffset(14, 56).addBox(-3.0F, -49.0F, 2.0F, 6, 1, 1, false);
		top1.setTextureOffset(26, 53).addBox(-3.0F, -49.0F, -3.0F, 6, 1, 1, false);
		top1.setTextureOffset(66, 84).addBox(-2.0F, -49.0F, -4.0F, 4, 1, 1, false);
		top1.setTextureOffset(12, 84).addBox(-2.0F, -49.0F, 3.0F, 4, 1, 1, false);

		top2 = new ModelRenderer(this);
		top2.setRotationPoint(0.0F, 0.0F, 0.0F);
		top.addChild(top2);
		top2.setTextureOffset(42, 0).addBox(-7.0F, -48.0F, -2.0F, 14, 1, 4, false);
		top2.setTextureOffset(42, 8).addBox(-6.0F, -48.0F, -4.0F, 12, 1, 2, false);
		top2.setTextureOffset(42, 5).addBox(-6.0F, -48.0F, 2.0F, 12, 1, 2, false);
		top2.setTextureOffset(62, 38).addBox(-5.0F, -48.0F, 4.0F, 10, 1, 1, false);
		top2.setTextureOffset(42, 11).addBox(-5.0F, -48.0F, -5.0F, 10, 1, 1, false);
		top2.setTextureOffset(66, 77).addBox(-4.0F, -48.0F, -6.0F, 8, 1, 1, false);
		top2.setTextureOffset(76, 71).addBox(-4.0F, -48.0F, 5.0F, 8, 1, 1, false);
		top2.setTextureOffset(83, 76).addBox(-2.0F, -48.0F, 6.0F, 4, 1, 1, false);
		top2.setTextureOffset(83, 74).addBox(-2.0F, -48.0F, -7.0F, 4, 1, 1, false);

		top3 = new ModelRenderer(this);
		top3.setRotationPoint(0.0F, 0.0F, 0.0F);
		top.addChild(top3);
		top3.setTextureOffset(0, 28).addBox(-1.0F, -47.0F, -9.0F, 2, 1, 18, false);
		top3.setTextureOffset(44, 44).addBox(-4.0F, -47.0F, -8.0F, 3, 1, 16, false);
		top3.setTextureOffset(22, 28).addBox(1.0F, -47.0F, -8.0F, 3, 1, 16, false);
		top3.setTextureOffset(44, 29).addBox(-6.0F, -47.0F, -7.0F, 2, 1, 14, false);
		top3.setTextureOffset(44, 14).addBox(4.0F, -47.0F, -7.0F, 2, 1, 14, false);
		top3.setTextureOffset(0, 47).addBox(-7.0F, -47.0F, -6.0F, 1, 1, 12, false);
		top3.setTextureOffset(28, 45).addBox(6.0F, -47.0F, -6.0F, 1, 1, 12, false);
		top3.setTextureOffset(74, 53).addBox(-8.0F, -47.0F, -4.0F, 1, 1, 8, false);
		top3.setTextureOffset(72, 27).addBox(7.0F, -47.0F, -4.0F, 1, 1, 8, false);
		top3.setTextureOffset(92, 85).addBox(-9.0F, -47.0F, -1.0F, 1, 1, 2, false);
		top3.setTextureOffset(92, 71).addBox(8.0F, -47.0F, -1.0F, 1, 1, 2, false);

		top4 = new ModelRenderer(this);
		top4.setRotationPoint(0.0F, 0.0F, 0.0F);
		top.addChild(top4);
		top4.setTextureOffset(66, 56).addBox(-3.0F, -46.0F, -10.0F, 6, 1, 2, false);
		top4.setTextureOffset(66, 53).addBox(-3.0F, -46.0F, 8.0F, 6, 1, 2, false);
		top4.setTextureOffset(22, 35).addBox(-10.0F, -46.0F, -3.0F, 2, 1, 6, false);
		top4.setTextureOffset(22, 28).addBox(8.0F, -46.0F, -3.0F, 2, 1, 6, false);
		top4.setTextureOffset(40, 88).addBox(-9.0F, -46.0F, -5.0F, 2, 1, 2, false);
		top4.setTextureOffset(32, 88).addBox(-9.0F, -46.0F, 3.0F, 2, 1, 2, false);
		top4.setTextureOffset(24, 88).addBox(7.0F, -46.0F, 3.0F, 2, 1, 2, false);
		top4.setTextureOffset(86, 87).addBox(3.0F, -46.0F, -9.0F, 2, 1, 2, false);
		top4.setTextureOffset(78, 87).addBox(3.0F, -46.0F, 7.0F, 2, 1, 2, false);
		top4.setTextureOffset(18, 87).addBox(-5.0F, -46.0F, 7.0F, 2, 1, 2, false);
		top4.setTextureOffset(86, 62).addBox(-5.0F, -46.0F, -9.0F, 2, 1, 2, false);
		top4.setTextureOffset(86, 36).addBox(-7.0F, -46.0F, -8.0F, 2, 1, 2, false);
		top4.setTextureOffset(72, 86).addBox(-7.0F, -46.0F, 6.0F, 2, 1, 2, false);
		top4.setTextureOffset(64, 86).addBox(5.0F, -46.0F, 6.0F, 2, 1, 2, false);
		top4.setTextureOffset(56, 86).addBox(5.0F, -46.0F, -8.0F, 2, 1, 2, false);
		top4.setTextureOffset(12, 86).addBox(7.0F, -46.0F, -5.0F, 2, 1, 2, false);
		top4.setTextureOffset(50, 85).addBox(6.0F, -46.0F, -7.0F, 2, 1, 2, false);
		top4.setTextureOffset(42, 85).addBox(6.0F, -46.0F, 5.0F, 2, 1, 2, false);
		top4.setTextureOffset(34, 85).addBox(-8.0F, -46.0F, 5.0F, 2, 1, 2, false);
		top4.setTextureOffset(26, 85).addBox(-8.0F, -46.0F, -7.0F, 2, 1, 2, false);

		top5 = new ModelRenderer(this);
		top5.setRotationPoint(0.0F, 0.0F, 0.0F);
		top.addChild(top5);
		top5.setTextureOffset(66, 62).addBox(-4.0F, -45.0F, 9.0F, 8, 1, 2, false);
		top5.setTextureOffset(62, 40).addBox(-4.0F, -45.0F, -11.0F, 8, 1, 2, false);
		top5.setTextureOffset(30, 58).addBox(-11.0F, -45.0F, -4.0F, 2, 1, 8, false);
		top5.setTextureOffset(14, 47).addBox(9.0F, -45.0F, -4.0F, 2, 1, 8, false);
		top5.setTextureOffset(84, 56).addBox(-6.0F, -45.0F, 8.0F, 2, 1, 2, false);
		top5.setTextureOffset(84, 53).addBox(4.0F, -45.0F, 8.0F, 2, 1, 2, false);
		top5.setTextureOffset(20, 84).addBox(4.0F, -45.0F, -10.0F, 2, 1, 2, false);
		top5.setTextureOffset(72, 79).addBox(-6.0F, -45.0F, -10.0F, 2, 1, 2, false);
		top5.setTextureOffset(36, 78).addBox(-10.0F, -45.0F, -6.0F, 2, 1, 2, false);
		top5.setTextureOffset(72, 32).addBox(-10.0F, -45.0F, 4.0F, 2, 1, 2, false);
		top5.setTextureOffset(72, 29).addBox(8.0F, -45.0F, 4.0F, 2, 1, 2, false);
		top5.setTextureOffset(72, 18).addBox(8.0F, -45.0F, -6.0F, 2, 1, 2, false);
		top5.setTextureOffset(98, 75).addBox(8.0F, -45.0F, -7.0F, 1, 1, 1, false);
		top5.setTextureOffset(98, 72).addBox(7.0F, -45.0F, -8.0F, 1, 1, 1, false);
		top5.setTextureOffset(98, 67).addBox(6.0F, -45.0F, -9.0F, 1, 1, 1, false);
		top5.setTextureOffset(98, 65).addBox(-7.0F, -45.0F, -9.0F, 1, 1, 1, false);
		top5.setTextureOffset(98, 52).addBox(-8.0F, -45.0F, -8.0F, 1, 1, 1, false);
		top5.setTextureOffset(98, 47).addBox(-9.0F, -45.0F, -7.0F, 1, 1, 1, false);
		top5.setTextureOffset(98, 45).addBox(-9.0F, -45.0F, 6.0F, 1, 1, 1, false);
		top5.setTextureOffset(98, 43).addBox(-8.0F, -45.0F, 7.0F, 1, 1, 1, false);
		top5.setTextureOffset(89, 98).addBox(-7.0F, -45.0F, 8.0F, 1, 1, 1, false);
		top5.setTextureOffset(60, 98).addBox(6.0F, -45.0F, 8.0F, 1, 1, 1, false);
		top5.setTextureOffset(56, 98).addBox(7.0F, -45.0F, 7.0F, 1, 1, 1, false);
		top5.setTextureOffset(52, 98).addBox(8.0F, -45.0F, 6.0F, 1, 1, 1, false);

		top6 = new ModelRenderer(this);
		top6.setRotationPoint(0.0F, 0.0F, 0.0F);
		top.addChild(top6);
		top6.setTextureOffset(76, 69).addBox(-4.0F, -44.0F, 11.0F, 8, 1, 1, false);
		top6.setTextureOffset(76, 67).addBox(-4.0F, -44.0F, -12.0F, 8, 1, 1, false);
		top6.setTextureOffset(72, 18).addBox(-12.0F, -44.0F, -4.0F, 1, 1, 8, false);
		top6.setTextureOffset(72, 9).addBox(11.0F, -44.0F, -4.0F, 1, 1, 8, false);
		top6.setTextureOffset(95, 56).addBox(-6.0F, -44.0F, -11.0F, 2, 1, 1, false);
		top6.setTextureOffset(95, 38).addBox(4.0F, -44.0F, -11.0F, 2, 1, 1, false);
		top6.setTextureOffset(95, 28).addBox(4.0F, -44.0F, 10.0F, 2, 1, 1, false);
		top6.setTextureOffset(95, 19).addBox(-6.0F, -44.0F, 10.0F, 2, 1, 1, false);
		top6.setTextureOffset(92, 60).addBox(-11.0F, -44.0F, 4.0F, 1, 1, 2, false);
		top6.setTextureOffset(92, 51).addBox(-11.0F, -44.0F, -6.0F, 1, 1, 2, false);
		top6.setTextureOffset(92, 35).addBox(10.0F, -44.0F, -6.0F, 1, 1, 2, false);
		top6.setTextureOffset(92, 22).addBox(10.0F, -44.0F, 4.0F, 1, 1, 2, false);
		top6.setTextureOffset(72, 14).addBox(7.0F, -44.0F, 7.0F, 2, 1, 2, false);
		top6.setTextureOffset(72, 9).addBox(-9.0F, -44.0F, 7.0F, 2, 1, 2, false);
		top6.setTextureOffset(72, 5).addBox(-9.0F, -44.0F, -9.0F, 2, 1, 2, false);
		top6.setTextureOffset(30, 71).addBox(7.0F, -44.0F, -9.0F, 2, 1, 2, false);
		top6.setTextureOffset(48, 98).addBox(6.0F, -44.0F, -10.0F, 1, 1, 1, false);
		top6.setTextureOffset(44, 98).addBox(9.0F, -44.0F, -7.0F, 1, 1, 1, false);
		top6.setTextureOffset(40, 98).addBox(9.0F, -44.0F, 6.0F, 1, 1, 1, false);
		top6.setTextureOffset(31, 98).addBox(6.0F, -44.0F, 9.0F, 1, 1, 1, false);
		top6.setTextureOffset(27, 98).addBox(-7.0F, -44.0F, 9.0F, 1, 1, 1, false);
		top6.setTextureOffset(23, 98).addBox(-10.0F, -44.0F, 6.0F, 1, 1, 1, false);
		top6.setTextureOffset(15, 98).addBox(-10.0F, -44.0F, -7.0F, 1, 1, 1, false);
		top6.setTextureOffset(97, 80).addBox(-7.0F, -44.0F, -10.0F, 1, 1, 1, false);

		top7 = new ModelRenderer(this);
		top7.setRotationPoint(0.0F, 0.0F, 0.0F);
		top.addChild(top7);
		top7.setTextureOffset(44, 41).addBox(-3.0F, -43.0F, -13.0F, 6, 1, 1, false);
		top7.setTextureOffset(22, 42).addBox(-3.0F, -43.0F, 12.0F, 6, 1, 1, false);
		top7.setTextureOffset(0, 7).addBox(-13.0F, -43.0F, -3.0F, 1, 1, 6, false);
		top7.setTextureOffset(0, 0).addBox(12.0F, -43.0F, -3.0F, 1, 1, 6, false);
		top7.setTextureOffset(66, 70).addBox(11.0F, -43.0F, -6.0F, 1, 1, 3, false);
		top7.setTextureOffset(66, 44).addBox(11.0F, -43.0F, 3.0F, 1, 1, 3, false);
		top7.setTextureOffset(30, 67).addBox(-12.0F, -43.0F, 3.0F, 1, 1, 3, false);
		top7.setTextureOffset(66, 48).addBox(-12.0F, -43.0F, -6.0F, 1, 1, 3, false);
		top7.setTextureOffset(90, 25).addBox(-6.0F, -43.0F, -12.0F, 3, 1, 1, false);
		top7.setTextureOffset(90, 16).addBox(3.0F, -43.0F, -12.0F, 3, 1, 1, false);
		top7.setTextureOffset(90, 7).addBox(3.0F, -43.0F, 11.0F, 3, 1, 1, false);
		top7.setTextureOffset(84, 90).addBox(-6.0F, -43.0F, 11.0F, 3, 1, 1, false);
		top7.setTextureOffset(97, 78).addBox(-7.0F, -43.0F, 10.0F, 1, 1, 1, false);
		top7.setTextureOffset(97, 62).addBox(-11.0F, -43.0F, 6.0F, 1, 1, 1, false);
		top7.setTextureOffset(97, 40).addBox(-11.0F, -43.0F, -7.0F, 1, 1, 1, false);
		top7.setTextureOffset(97, 26).addBox(-7.0F, -43.0F, -11.0F, 1, 1, 1, false);
		top7.setTextureOffset(97, 24).addBox(6.0F, -43.0F, -11.0F, 1, 1, 1, false);
		top7.setTextureOffset(97, 17).addBox(10.0F, -43.0F, -7.0F, 1, 1, 1, false);
		top7.setTextureOffset(97, 15).addBox(10.0F, -43.0F, 6.0F, 1, 1, 1, false);
		top7.setTextureOffset(97, 8).addBox(6.0F, -43.0F, 10.0F, 1, 1, 1, false);
		top7.setTextureOffset(95, 10).addBox(7.0F, -43.0F, 9.0F, 2, 1, 1, false);
		top7.setTextureOffset(95, 1).addBox(-9.0F, -43.0F, 9.0F, 2, 1, 1, false);
		top7.setTextureOffset(95, 95).addBox(-9.0F, -43.0F, -10.0F, 2, 1, 1, false);
		top7.setTextureOffset(85, 95).addBox(7.0F, -43.0F, -10.0F, 2, 1, 1, false);
		top7.setTextureOffset(92, 13).addBox(9.0F, -43.0F, -9.0F, 1, 1, 2, false);
		top7.setTextureOffset(92, 4).addBox(9.0F, -43.0F, 7.0F, 1, 1, 2, false);
		top7.setTextureOffset(84, 92).addBox(-10.0F, -43.0F, 7.0F, 1, 1, 2, false);
		top7.setTextureOffset(78, 92).addBox(-10.0F, -43.0F, -9.0F, 1, 1, 2, false);

		top8 = new ModelRenderer(this);
		top8.setRotationPoint(0.0F, 0.0F, 0.0F);
		top.addChild(top8);
		top8.setTextureOffset(79, 95).addBox(-1.0F, -42.0F, -14.0F, 2, 1, 1, false);
		top8.setTextureOffset(73, 95).addBox(-1.0F, -42.0F, 13.0F, 2, 1, 1, false);
		top8.setTextureOffset(72, 92).addBox(-14.0F, -42.0F, -1.0F, 1, 1, 2, false);
		top8.setTextureOffset(16, 92).addBox(13.0F, -42.0F, -1.0F, 1, 1, 2, false);
		top8.setTextureOffset(82, 9).addBox(12.0F, -42.0F, -5.0F, 1, 1, 4, false);
		top8.setTextureOffset(82, 0).addBox(12.0F, -42.0F, 1.0F, 1, 1, 4, false);
		top8.setTextureOffset(82, 82).addBox(-13.0F, -42.0F, 1.0F, 1, 1, 4, false);
		top8.setTextureOffset(80, 36).addBox(-13.0F, -42.0F, -5.0F, 1, 1, 4, false);
		top8.setTextureOffset(39, 83).addBox(-5.0F, -42.0F, -13.0F, 4, 1, 1, false);
		top8.setTextureOffset(29, 83).addBox(1.0F, -42.0F, -13.0F, 4, 1, 1, false);
		top8.setTextureOffset(82, 79).addBox(1.0F, -42.0F, 12.0F, 4, 1, 1, false);
		top8.setTextureOffset(82, 41).addBox(-5.0F, -42.0F, 12.0F, 4, 1, 1, false);
		top8.setTextureOffset(67, 95).addBox(-7.0F, -42.0F, 11.0F, 2, 1, 1, false);
		top8.setTextureOffset(38, 95).addBox(5.0F, -42.0F, 11.0F, 2, 1, 1, false);
		top8.setTextureOffset(12, 95).addBox(5.0F, -42.0F, -12.0F, 2, 1, 1, false);
		top8.setTextureOffset(6, 95).addBox(-7.0F, -42.0F, -12.0F, 2, 1, 1, false);
		top8.setTextureOffset(10, 92).addBox(-12.0F, -42.0F, -7.0F, 1, 1, 2, false);
		top8.setTextureOffset(91, 76).addBox(-12.0F, -42.0F, 5.0F, 1, 1, 2, false);
		top8.setTextureOffset(91, 57).addBox(11.0F, -42.0F, 5.0F, 1, 1, 2, false);
		top8.setTextureOffset(91, 39).addBox(11.0F, -42.0F, -7.0F, 1, 1, 2, false);
		top8.setTextureOffset(68, 91).addBox(10.0F, -42.0F, -9.0F, 1, 1, 2, false);
		top8.setTextureOffset(62, 91).addBox(10.0F, -42.0F, 7.0F, 1, 1, 2, false);
		top8.setTextureOffset(56, 91).addBox(-11.0F, -42.0F, 7.0F, 1, 1, 2, false);
		top8.setTextureOffset(50, 91).addBox(-11.0F, -42.0F, -9.0F, 1, 1, 2, false);
		top8.setTextureOffset(94, 90).addBox(-9.0F, -42.0F, -11.0F, 2, 1, 1, false);
		top8.setTextureOffset(94, 88).addBox(7.0F, -42.0F, -11.0F, 2, 1, 1, false);
		top8.setTextureOffset(94, 54).addBox(7.0F, -42.0F, 10.0F, 2, 1, 1, false);
		top8.setTextureOffset(94, 31).addBox(-9.0F, -42.0F, 10.0F, 2, 1, 1, false);
		top8.setTextureOffset(97, 6).addBox(-10.0F, -42.0F, 9.0F, 1, 1, 1, false);
		top8.setTextureOffset(97, 97).addBox(-10.0F, -42.0F, -10.0F, 1, 1, 1, false);
		top8.setTextureOffset(93, 97).addBox(9.0F, -42.0F, -10.0F, 1, 1, 1, false);
		top8.setTextureOffset(86, 97).addBox(9.0F, -42.0F, 9.0F, 1, 1, 1, false);

		side = new ModelRenderer(this);
		side.setRotationPoint(0.0F, 0.0F, 0.0F);
		parachutereal.addChild(side);

		side1 = new ModelRenderer(this);
		side1.setRotationPoint(0.0F, 0.0F, 0.0F);
		side.addChild(side1);
		side1.setTextureOffset(76, 65).addBox(-4.0F, -41.0F, -14.0F, 8, 1, 1, false);
		side1.setTextureOffset(76, 49).addBox(-4.0F, -41.0F, 13.0F, 8, 1, 1, false);
		side1.setTextureOffset(72, 0).addBox(13.0F, -41.0F, -4.0F, 1, 1, 8, false);
		side1.setTextureOffset(30, 67).addBox(-14.0F, -41.0F, -4.0F, 1, 1, 8, false);
		side1.setTextureOffset(66, 66).addBox(-13.0F, -41.0F, 4.0F, 1, 1, 3, false);
		side1.setTextureOffset(62, 33).addBox(-13.0F, -41.0F, -7.0F, 1, 1, 3, false);
		side1.setTextureOffset(62, 29).addBox(12.0F, -41.0F, -7.0F, 1, 1, 3, false);
		side1.setTextureOffset(62, 18).addBox(12.0F, -41.0F, 4.0F, 1, 1, 3, false);
		side1.setTextureOffset(76, 90).addBox(4.0F, -41.0F, 12.0F, 3, 1, 1, false);
		side1.setTextureOffset(15, 90).addBox(-7.0F, -41.0F, 12.0F, 3, 1, 1, false);
		side1.setTextureOffset(69, 89).addBox(-7.0F, -41.0F, -13.0F, 3, 1, 1, false);
		side1.setTextureOffset(61, 89).addBox(4.0F, -41.0F, -13.0F, 3, 1, 1, false);
		side1.setTextureOffset(82, 97).addBox(7.0F, -41.0F, -12.0F, 1, 1, 1, false);
		side1.setTextureOffset(78, 97).addBox(8.0F, -41.0F, -11.0F, 1, 1, 1, false);
		side1.setTextureOffset(74, 97).addBox(9.0F, -41.0F, -10.0F, 1, 1, 1, false);
		side1.setTextureOffset(70, 97).addBox(10.0F, -41.0F, -9.0F, 1, 1, 1, false);
		side1.setTextureOffset(66, 97).addBox(11.0F, -41.0F, -8.0F, 1, 1, 1, false);
		side1.setTextureOffset(37, 97).addBox(11.0F, -41.0F, 7.0F, 1, 1, 1, false);
		side1.setTextureOffset(20, 97).addBox(10.0F, -41.0F, 8.0F, 1, 1, 1, false);
		side1.setTextureOffset(12, 97).addBox(9.0F, -41.0F, 9.0F, 1, 1, 1, false);
		side1.setTextureOffset(8, 97).addBox(8.0F, -41.0F, 10.0F, 1, 1, 1, false);
		side1.setTextureOffset(4, 97).addBox(7.0F, -41.0F, 11.0F, 1, 1, 1, false);
		side1.setTextureOffset(0, 97).addBox(-8.0F, -41.0F, 11.0F, 1, 1, 1, false);
		side1.setTextureOffset(96, 84).addBox(-9.0F, -41.0F, 10.0F, 1, 1, 1, false);
		side1.setTextureOffset(96, 70).addBox(-10.0F, -41.0F, 9.0F, 1, 1, 1, false);
		side1.setTextureOffset(96, 59).addBox(-11.0F, -41.0F, 8.0F, 1, 1, 1, false);
		side1.setTextureOffset(96, 50).addBox(-12.0F, -41.0F, 7.0F, 1, 1, 1, false);
		side1.setTextureOffset(96, 35).addBox(-12.0F, -41.0F, -8.0F, 1, 1, 1, false);
		side1.setTextureOffset(96, 33).addBox(-11.0F, -41.0F, -9.0F, 1, 1, 1, false);
		side1.setTextureOffset(96, 21).addBox(-10.0F, -41.0F, -10.0F, 1, 1, 1, false);
		side1.setTextureOffset(96, 12).addBox(-9.0F, -41.0F, -11.0F, 1, 1, 1, false);
		side1.setTextureOffset(96, 3).addBox(-8.0F, -41.0F, -12.0F, 1, 1, 1, false);

		side2 = new ModelRenderer(this);
		side2.setRotationPoint(0.0F, 0.0F, 0.0F);
		side.addChild(side2);
		side2.setTextureOffset(76, 79).addBox(-15.0F, -40.0F, -2.0F, 1, 1, 4, false);
		side2.setTextureOffset(66, 79).addBox(14.0F, -40.0F, -2.0F, 1, 1, 4, false);
		side2.setTextureOffset(82, 32).addBox(-2.0F, -40.0F, -15.0F, 4, 1, 1, false);
		side2.setTextureOffset(82, 23).addBox(-2.0F, -40.0F, 14.0F, 4, 1, 1, false);
		side2.setTextureOffset(82, 14).addBox(-6.0F, -40.0F, 13.0F, 4, 1, 1, false);
		side2.setTextureOffset(82, 5).addBox(2.0F, -40.0F, 13.0F, 4, 1, 1, false);
		side2.setTextureOffset(40, 72).addBox(2.0F, -40.0F, -14.0F, 4, 1, 1, false);
		side2.setTextureOffset(62, 25).addBox(-6.0F, -40.0F, -14.0F, 4, 1, 1, false);
		side2.setTextureOffset(20, 79).addBox(-14.0F, -40.0F, -6.0F, 1, 1, 4, false);
		side2.setTextureOffset(40, 78).addBox(-14.0F, -40.0F, 2.0F, 1, 1, 4, false);
		side2.setTextureOffset(30, 78).addBox(13.0F, -40.0F, 2.0F, 1, 1, 4, false);
		side2.setTextureOffset(40, 67).addBox(13.0F, -40.0F, -6.0F, 1, 1, 4, false);
		side2.setTextureOffset(39, 91).addBox(12.0F, -40.0F, -8.0F, 1, 1, 2, false);
		side2.setTextureOffset(33, 91).addBox(12.0F, -40.0F, 6.0F, 1, 1, 2, false);
		side2.setTextureOffset(27, 91).addBox(-13.0F, -40.0F, 6.0F, 1, 1, 2, false);
		side2.setTextureOffset(21, 91).addBox(-13.0F, -40.0F, -8.0F, 1, 1, 2, false);
		side2.setTextureOffset(62, 94).addBox(6.0F, -40.0F, -13.0F, 2, 1, 1, false);
		side2.setTextureOffset(56, 94).addBox(-8.0F, -40.0F, -13.0F, 2, 1, 1, false);
		side2.setTextureOffset(50, 94).addBox(-8.0F, -40.0F, 12.0F, 2, 1, 1, false);
		side2.setTextureOffset(33, 94).addBox(6.0F, -40.0F, 12.0F, 2, 1, 1, false);
		side2.setTextureOffset(90, 96).addBox(8.0F, -40.0F, 11.0F, 1, 1, 1, false);
		side2.setTextureOffset(63, 96).addBox(9.0F, -40.0F, 10.0F, 1, 1, 1, false);
		side2.setTextureOffset(59, 96).addBox(10.0F, -40.0F, 9.0F, 1, 1, 1, false);
		side2.setTextureOffset(55, 96).addBox(11.0F, -40.0F, 8.0F, 1, 1, 1, false);
		side2.setTextureOffset(51, 96).addBox(11.0F, -40.0F, -9.0F, 1, 1, 1, false);
		side2.setTextureOffset(47, 96).addBox(10.0F, -40.0F, -10.0F, 1, 1, 1, false);
		side2.setTextureOffset(43, 96).addBox(9.0F, -40.0F, -11.0F, 1, 1, 1, false);
		side2.setTextureOffset(34, 96).addBox(8.0F, -40.0F, -12.0F, 1, 1, 1, false);
		side2.setTextureOffset(30, 96).addBox(-9.0F, -40.0F, -12.0F, 1, 1, 1, false);
		side2.setTextureOffset(26, 96).addBox(-10.0F, -40.0F, -11.0F, 1, 1, 1, false);
		side2.setTextureOffset(17, 96).addBox(-11.0F, -40.0F, -10.0F, 1, 1, 1, false);
		side2.setTextureOffset(95, 92).addBox(-12.0F, -40.0F, -9.0F, 1, 1, 1, false);
		side2.setTextureOffset(95, 82).addBox(-12.0F, -40.0F, 8.0F, 1, 1, 1, false);
		side2.setTextureOffset(95, 76).addBox(-11.0F, -40.0F, 9.0F, 1, 1, 1, false);
		side2.setTextureOffset(82, 92).addBox(-10.0F, -40.0F, 10.0F, 1, 1, 1, false);
		side2.setTextureOffset(76, 92).addBox(-9.0F, -40.0F, 11.0F, 1, 1, 1, false);

		side3 = new ModelRenderer(this);
		side3.setRotationPoint(0.0F, 0.0F, 0.0F);
		side.addChild(side3);
		side3.setTextureOffset(76, 47).addBox(-4.0F, -39.0F, -15.0F, 8, 1, 1, false);
		side3.setTextureOffset(76, 45).addBox(-4.0F, -39.0F, 14.0F, 8, 1, 1, false);
		side3.setTextureOffset(66, 44).addBox(14.0F, -39.0F, -4.0F, 1, 1, 8, false);
		side3.setTextureOffset(66, 66).addBox(-15.0F, -39.0F, -4.0F, 1, 1, 8, false);
		side3.setTextureOffset(62, 14).addBox(-14.0F, -39.0F, 4.0F, 1, 1, 3, false);
		side3.setTextureOffset(30, 62).addBox(-14.0F, -39.0F, -7.0F, 1, 1, 3, false);
		side3.setTextureOffset(42, 61).addBox(13.0F, -39.0F, -7.0F, 1, 1, 3, false);
		side3.setTextureOffset(30, 58).addBox(13.0F, -39.0F, 4.0F, 1, 1, 3, false);
		side3.setTextureOffset(53, 89).addBox(4.0F, -39.0F, 13.0F, 3, 1, 1, false);
		side3.setTextureOffset(8, 89).addBox(-7.0F, -39.0F, 13.0F, 3, 1, 1, false);
		side3.setTextureOffset(0, 89).addBox(-7.0F, -39.0F, -14.0F, 3, 1, 1, false);
		side3.setTextureOffset(88, 83).addBox(4.0F, -39.0F, -14.0F, 3, 1, 1, false);
		side3.setTextureOffset(14, 92).addBox(7.0F, -39.0F, -13.0F, 1, 1, 1, false);
		side3.setTextureOffset(66, 91).addBox(-8.0F, -39.0F, -13.0F, 1, 1, 1, false);
		side3.setTextureOffset(60, 91).addBox(-13.0F, -39.0F, -8.0F, 1, 1, 1, false);
		side3.setTextureOffset(54, 91).addBox(-13.0F, -39.0F, 7.0F, 1, 1, 1, false);
		side3.setTextureOffset(37, 91).addBox(-8.0F, -39.0F, 12.0F, 1, 1, 1, false);
		side3.setTextureOffset(31, 91).addBox(7.0F, -39.0F, 12.0F, 1, 1, 1, false);
		side3.setTextureOffset(25, 91).addBox(12.0F, -39.0F, 7.0F, 1, 1, 1, false);
		side3.setTextureOffset(4, 91).addBox(12.0F, -39.0F, -8.0F, 1, 1, 1, false);
		side3.setTextureOffset(6, 91).addBox(11.0F, -39.0F, -10.0F, 1, 1, 2, false);
		side3.setTextureOffset(0, 91).addBox(-12.0F, -39.0F, -10.0F, 1, 1, 2, false);
		side3.setTextureOffset(90, 54).addBox(-12.0F, -39.0F, 8.0F, 1, 1, 2, false);
		side3.setTextureOffset(27, 94).addBox(-10.0F, -39.0F, 11.0F, 2, 1, 1, false);
		side3.setTextureOffset(93, 74).addBox(8.0F, -39.0F, 11.0F, 2, 1, 1, false);
		side3.setTextureOffset(90, 32).addBox(11.0F, -39.0F, 8.0F, 1, 1, 2, false);
		side3.setTextureOffset(93, 68).addBox(8.0F, -39.0F, -12.0F, 2, 1, 1, false);
		side3.setTextureOffset(93, 66).addBox(-10.0F, -39.0F, -12.0F, 2, 1, 1, false);
		side3.setTextureOffset(38, 88).addBox(-11.0F, -39.0F, -11.0F, 1, 1, 1, false);
		side3.setTextureOffset(30, 88).addBox(-11.0F, -39.0F, 10.0F, 1, 1, 1, false);
		side3.setTextureOffset(84, 87).addBox(10.0F, -39.0F, 10.0F, 1, 1, 1, false);
		side3.setTextureOffset(70, 86).addBox(10.0F, -39.0F, -11.0F, 1, 1, 1, false);

		side4 = new ModelRenderer(this);
		side4.setRotationPoint(0.0F, 0.0F, 0.0F);
		side.addChild(side4);
		side4.setTextureOffset(76, 43).addBox(-4.0F, -38.0F, -15.0F, 8, 1, 1, false);
		side4.setTextureOffset(30, 76).addBox(-4.0F, -38.0F, 14.0F, 8, 1, 1, false);
		side4.setTextureOffset(62, 29).addBox(14.0F, -38.0F, -4.0F, 1, 1, 8, false);
		side4.setTextureOffset(62, 14).addBox(-15.0F, -38.0F, -4.0F, 1, 1, 8, false);
		side4.setTextureOffset(52, 49).addBox(-14.0F, -38.0F, 4.0F, 1, 1, 3, false);
		side4.setTextureOffset(52, 45).addBox(-14.0F, -38.0F, -7.0F, 1, 1, 3, false);
		side4.setTextureOffset(14, 51).addBox(13.0F, -38.0F, -7.0F, 1, 1, 3, false);
		side4.setTextureOffset(42, 49).addBox(13.0F, -38.0F, 4.0F, 1, 1, 3, false);
		side4.setTextureOffset(88, 81).addBox(4.0F, -38.0F, 13.0F, 3, 1, 1, false);
		side4.setTextureOffset(88, 29).addBox(-7.0F, -38.0F, 13.0F, 3, 1, 1, false);
		side4.setTextureOffset(88, 27).addBox(-7.0F, -38.0F, -14.0F, 3, 1, 1, false);
		side4.setTextureOffset(88, 20).addBox(4.0F, -38.0F, -14.0F, 3, 1, 1, false);
		side4.setTextureOffset(62, 86).addBox(7.0F, -38.0F, -13.0F, 1, 1, 1, false);
		side4.setTextureOffset(48, 85).addBox(-8.0F, -38.0F, -13.0F, 1, 1, 1, false);
		side4.setTextureOffset(40, 85).addBox(-13.0F, -38.0F, -8.0F, 1, 1, 1, false);
		side4.setTextureOffset(32, 85).addBox(-13.0F, -38.0F, 7.0F, 1, 1, 1, false);
		side4.setTextureOffset(84, 62).addBox(-8.0F, -38.0F, 12.0F, 1, 1, 1, false);
		side4.setTextureOffset(82, 81).addBox(7.0F, -38.0F, 12.0F, 1, 1, 1, false);
		side4.setTextureOffset(82, 29).addBox(12.0F, -38.0F, 7.0F, 1, 1, 1, false);
		side4.setTextureOffset(82, 27).addBox(12.0F, -38.0F, -8.0F, 1, 1, 1, false);
		side4.setTextureOffset(90, 90).addBox(11.0F, -38.0F, -10.0F, 1, 1, 2, false);
		side4.setTextureOffset(46, 90).addBox(-12.0F, -38.0F, -10.0F, 1, 1, 2, false);
		side4.setTextureOffset(74, 0).addBox(-12.0F, -38.0F, 8.0F, 1, 1, 2, false);
		side4.setTextureOffset(93, 64).addBox(-10.0F, -38.0F, 11.0F, 2, 1, 1, false);
		side4.setTextureOffset(93, 48).addBox(8.0F, -38.0F, 11.0F, 2, 1, 1, false);
		side4.setTextureOffset(20, 60).addBox(11.0F, -38.0F, 8.0F, 1, 1, 2, false);
		side4.setTextureOffset(93, 46).addBox(8.0F, -38.0F, -12.0F, 2, 1, 1, false);
		side4.setTextureOffset(93, 44).addBox(-10.0F, -38.0F, -12.0F, 2, 1, 1, false);
		side4.setTextureOffset(82, 20).addBox(-11.0F, -38.0F, -11.0F, 1, 1, 1, false);
		side4.setTextureOffset(82, 18).addBox(-11.0F, -38.0F, 10.0F, 1, 1, 1, false);
		side4.setTextureOffset(82, 11).addBox(10.0F, -38.0F, 10.0F, 1, 1, 1, false);
		side4.setTextureOffset(82, 9).addBox(10.0F, -38.0F, -11.0F, 1, 1, 1, false);

		side5 = new ModelRenderer(this);
		side5.setRotationPoint(0.0F, 0.0F, 0.0F);
		side.addChild(side5);
		side5.setTextureOffset(66, 75).addBox(-4.0F, -37.0F, -15.0F, 8, 1, 1, false);
		side5.setTextureOffset(62, 23).addBox(-4.0F, -37.0F, 14.0F, 8, 1, 1, false);
		side5.setTextureOffset(62, 5).addBox(14.0F, -37.0F, -4.0F, 1, 1, 8, false);
		side5.setTextureOffset(42, 45).addBox(-15.0F, -37.0F, -4.0F, 1, 1, 8, false);
		side5.setTextureOffset(14, 47).addBox(-14.0F, -37.0F, 4.0F, 1, 1, 3, false);
		side5.setTextureOffset(42, 45).addBox(-14.0F, -37.0F, -7.0F, 1, 1, 3, false);
		side5.setTextureOffset(10, 41).addBox(13.0F, -37.0F, -7.0F, 1, 1, 3, false);
		side5.setTextureOffset(0, 41).addBox(13.0F, -37.0F, 4.0F, 1, 1, 3, false);
		side5.setTextureOffset(88, 18).addBox(4.0F, -37.0F, 13.0F, 3, 1, 1, false);
		side5.setTextureOffset(88, 11).addBox(-7.0F, -37.0F, 13.0F, 3, 1, 1, false);
		side5.setTextureOffset(88, 9).addBox(-7.0F, -37.0F, -14.0F, 3, 1, 1, false);
		side5.setTextureOffset(88, 2).addBox(4.0F, -37.0F, -14.0F, 3, 1, 1, false);
		side5.setTextureOffset(82, 2).addBox(7.0F, -37.0F, -13.0F, 1, 1, 1, false);
		side5.setTextureOffset(82, 0).addBox(-8.0F, -37.0F, -13.0F, 1, 1, 1, false);
		side5.setTextureOffset(66, 81).addBox(-13.0F, -37.0F, -8.0F, 1, 1, 1, false);
		side5.setTextureOffset(80, 36).addBox(-13.0F, -37.0F, 7.0F, 1, 1, 1, false);
		side5.setTextureOffset(46, 80).addBox(-8.0F, -37.0F, 12.0F, 1, 1, 1, false);
		side5.setTextureOffset(30, 80).addBox(7.0F, -37.0F, 12.0F, 1, 1, 1, false);
		side5.setTextureOffset(66, 79).addBox(12.0F, -37.0F, 7.0F, 1, 1, 1, false);
		side5.setTextureOffset(46, 78).addBox(12.0F, -37.0F, -8.0F, 1, 1, 1, false);
		side5.setTextureOffset(32, 38).addBox(11.0F, -37.0F, -10.0F, 1, 1, 2, false);
		side5.setTextureOffset(22, 38).addBox(-12.0F, -37.0F, -10.0F, 1, 1, 2, false);
		side5.setTextureOffset(32, 35).addBox(-12.0F, -37.0F, 8.0F, 1, 1, 2, false);
		side5.setTextureOffset(93, 42).addBox(-10.0F, -37.0F, 11.0F, 2, 1, 1, false);
		side5.setTextureOffset(92, 79).addBox(8.0F, -37.0F, 11.0F, 2, 1, 1, false);
		side5.setTextureOffset(22, 35).addBox(11.0F, -37.0F, 8.0F, 1, 1, 2, false);
		side5.setTextureOffset(64, 11).addBox(8.0F, -37.0F, -12.0F, 2, 1, 1, false);
		side5.setTextureOffset(54, 56).addBox(-10.0F, -37.0F, -12.0F, 2, 1, 1, false);
		side5.setTextureOffset(30, 78).addBox(-11.0F, -37.0F, -11.0F, 1, 1, 1, false);
		side5.setTextureOffset(21, 77).addBox(-11.0F, -37.0F, 10.0F, 1, 1, 1, false);
		side5.setTextureOffset(76, 27).addBox(10.0F, -37.0F, 10.0F, 1, 1, 1, false);
		side5.setTextureOffset(21, 71).addBox(10.0F, -37.0F, -11.0F, 1, 1, 1, false);

		side6 = new ModelRenderer(this);
		side6.setRotationPoint(0.0F, 0.0F, 0.0F);
		side.addChild(side6);
		side6.setTextureOffset(42, 58).addBox(-4.0F, -36.0F, -15.0F, 8, 1, 1, false);
		side6.setTextureOffset(42, 54).addBox(-4.0F, -36.0F, 14.0F, 8, 1, 1, false);
		side6.setTextureOffset(0, 37).addBox(14.0F, -36.0F, -4.0F, 1, 1, 8, false);
		side6.setTextureOffset(0, 28).addBox(-15.0F, -36.0F, -4.0F, 1, 1, 8, false);
		side6.setTextureOffset(10, 37).addBox(-14.0F, -36.0F, 4.0F, 1, 1, 3, false);
		side6.setTextureOffset(0, 37).addBox(-14.0F, -36.0F, -7.0F, 1, 1, 3, false);
		side6.setTextureOffset(10, 32).addBox(13.0F, -36.0F, -7.0F, 1, 1, 3, false);
		side6.setTextureOffset(10, 28).addBox(13.0F, -36.0F, 4.0F, 1, 1, 3, false);
		side6.setTextureOffset(88, 0).addBox(4.0F, -36.0F, 13.0F, 3, 1, 1, false);
		side6.setTextureOffset(46, 88).addBox(-7.0F, -36.0F, 13.0F, 3, 1, 1, false);
		side6.setTextureOffset(84, 59).addBox(-7.0F, -36.0F, -14.0F, 3, 1, 1, false);
		side6.setTextureOffset(0, 34).addBox(4.0F, -36.0F, -14.0F, 3, 1, 1, false);
		side6.setTextureOffset(46, 69).addBox(7.0F, -36.0F, -13.0F, 1, 1, 1, false);
		side6.setTextureOffset(40, 69).addBox(-8.0F, -36.0F, -13.0F, 1, 1, 1, false);
		side6.setTextureOffset(46, 67).addBox(-13.0F, -36.0F, -8.0F, 1, 1, 1, false);
		side6.setTextureOffset(40, 67).addBox(-13.0F, -36.0F, 7.0F, 1, 1, 1, false);
		side6.setTextureOffset(21, 65).addBox(-8.0F, -36.0F, 12.0F, 1, 1, 1, false);
		side6.setTextureOffset(0, 62).addBox(7.0F, -36.0F, 12.0F, 1, 1, 1, false);
		side6.setTextureOffset(0, 60).addBox(12.0F, -36.0F, 7.0F, 1, 1, 1, false);
		side6.setTextureOffset(53, 35).addBox(12.0F, -36.0F, -8.0F, 1, 1, 1, false);
		side6.setTextureOffset(32, 31).addBox(11.0F, -36.0F, -10.0F, 1, 1, 2, false);
		side6.setTextureOffset(32, 28).addBox(-12.0F, -36.0F, -10.0F, 1, 1, 2, false);
		side6.setTextureOffset(22, 31).addBox(-12.0F, -36.0F, 8.0F, 1, 1, 2, false);
		side6.setTextureOffset(33, 55).addBox(-10.0F, -36.0F, 11.0F, 2, 1, 1, false);
		side6.setTextureOffset(0, 11).addBox(8.0F, -36.0F, 11.0F, 2, 1, 1, false);
		side6.setTextureOffset(22, 28).addBox(11.0F, -36.0F, 8.0F, 1, 1, 2, false);
		side6.setTextureOffset(8, 4).addBox(8.0F, -36.0F, -12.0F, 2, 1, 1, false);
		side6.setTextureOffset(0, 4).addBox(-10.0F, -36.0F, -12.0F, 2, 1, 1, false);
		side6.setTextureOffset(53, 29).addBox(-11.0F, -36.0F, -11.0F, 1, 1, 1, false);
		side6.setTextureOffset(35, 47).addBox(-11.0F, -36.0F, 10.0F, 1, 1, 1, false);
		side6.setTextureOffset(42, 2).addBox(10.0F, -36.0F, 10.0F, 1, 1, 1, false);
		side6.setTextureOffset(42, 0).addBox(10.0F, -36.0F, -11.0F, 1, 1, 1, false);

		strings = new ModelRenderer(this);
		strings.setRotationPoint(0.0F, 0.0F, 0.0F);
		parachute.addChild(strings);

		string1 = new ModelRenderer(this);
		string1.setRotationPoint(-5.0F, -17.0F, 1.0F);
		strings.addChild(string1);
		setRotationAngle(string1, -0.4363F, -0.4363F, 0.0F);
		string1.setTextureOffset(8, 65).addBox(-1.0F, -23.0F, 0.0F, 1, 23, 0, false);

		string2 = new ModelRenderer(this);
		string2.setRotationPoint(-5.0F, -17.0F, -2.0F);
		strings.addChild(string2);
		setRotationAngle(string2, 0.4363F, 0.5236F, 0.0F);
		string2.setTextureOffset(4, 65).addBox(-1.0F, -23.0F, 0.0F, 1, 23, 0, false);

		string3 = new ModelRenderer(this);
		string3.setRotationPoint(-1.0F, -17.0F, -6.0F);
		strings.addChild(string3);
		setRotationAngle(string3, 0.4363F, 0.9599F, 0.0F);
		string3.setTextureOffset(0, 65).addBox(-1.0F, -23.0F, 0.0F, 1, 23, 0, false);

		string4 = new ModelRenderer(this);
		string4.setRotationPoint(2.0F, -17.0F, -6.0F);
		strings.addChild(string4);
		setRotationAngle(string4, 0.4363F, -1.2217F, 0.0F);
		string4.setTextureOffset(62, 62).addBox(-1.0F, -23.0F, 0.0F, 1, 23, 0, false);

		string5 = new ModelRenderer(this);
		string5.setRotationPoint(6.0F, -17.0F, -2.0F);
		strings.addChild(string5);
		setRotationAngle(string5, 0.4363F, -0.5236F, 0.0F);
		string5.setTextureOffset(58, 61).addBox(-1.0F, -22.0F, 0.0F, 1, 22, 0, false);

		string6 = new ModelRenderer(this);
		string6.setRotationPoint(6.0F, -17.0F, 1.0F);
		strings.addChild(string6);
		setRotationAngle(string6, -0.4363F, 0.4363F, 0.0F);
		string6.setTextureOffset(54, 61).addBox(-1.0F, -23.0F, 0.0F, 1, 23, 0, false);

		string7 = new ModelRenderer(this);
		string7.setRotationPoint(2.0F, -17.0F, 5.0F);
		strings.addChild(string7);
		setRotationAngle(string7, -0.4363F, 1.0472F, -0.0873F);
		string7.setTextureOffset(26, 58).addBox(-1.0F, -24.0F, 0.0F, 1, 24, 0, false);

		string8 = new ModelRenderer(this);
		string8.setRotationPoint(-1.0F, -17.0F, 5.0F);
		strings.addChild(string8);
		setRotationAngle(string8, -0.4363F, -1.0472F, 0.0F);
		string8.setTextureOffset(50, 61).addBox(-1.0F, -23.0F, 0.0F, 1, 23, 0, false);
	}

	//public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	//}

	public void render() {
		crate.render(0.0625F);
		parachute.render(0.0625F);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
