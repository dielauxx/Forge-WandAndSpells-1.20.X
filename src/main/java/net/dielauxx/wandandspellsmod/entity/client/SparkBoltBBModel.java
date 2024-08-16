package net.dielauxx.wandandspellsmod.entity.client;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class SparkBoltBBModel<T extends Entity> extends EntityModel<T> {

	private final ModelPart external_particles;
	private final ModelPart top;
	private final ModelPart bone;
	private final ModelPart layer_out;
	private final ModelPart bottom;
	private final ModelPart bb_main;

	public SparkBoltBBModel(ModelPart root) {
		this.external_particles = root.getChild("external_particles");
		this.top = root.getChild("top");
		this.bone = root.getChild("bone");
		this.layer_out = root.getChild("layer_out");
		this.bottom = root.getChild("bottom");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition external_particles = partdefinition.addOrReplaceChild("external_particles", CubeListBuilder.create().texOffs(15, 20).addBox(1.0F, -6.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 11).addBox(1.0F, -6.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 20).addBox(-2.0F, -6.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 5).addBox(-2.0F, -6.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 0).addBox(-3.0F, -5.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 19).addBox(-3.0F, -4.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 17).addBox(-3.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 13).addBox(2.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 9).addBox(3.0F, -3.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 19).addBox(0.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 19).addBox(-4.0F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 3).addBox(-1.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 19).addBox(-3.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(15, 18).addBox(2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 18).addBox(1.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 17).addBox(2.0F, -4.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition top = partdefinition.addOrReplaceChild("top", CubeListBuilder.create().texOffs(11, 7).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(17, 7).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 10.0F, -1.0F));

		PartDefinition bone = top.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition layer_out = partdefinition.addOrReplaceChild("layer_out", CubeListBuilder.create().texOffs(8, 0).addBox(-4.0F, -2.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 0).addBox(-2.0F, -2.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 9).addBox(-3.0F, -2.0F, 2.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 14).addBox(-3.0F, -1.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 10).addBox(-4.0F, -1.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 0).addBox(-2.0F, -1.0F, 2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 14).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 13.0F, -1.0F));

		PartDefinition bottom = partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(12, 10).addBox(-1.0F, -1.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 4).addBox(-2.0F, -1.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 17).addBox(-2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 12).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 21.0F, -1.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		external_particles.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		top.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		layer_out.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}