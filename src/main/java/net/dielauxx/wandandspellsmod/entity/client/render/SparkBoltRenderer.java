package net.dielauxx.wandandspellsmod.entity.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.dielauxx.wandandspellsmod.WandAndSpellsMod;
import net.dielauxx.wandandspellsmod.entity.client.ModModelLayers;
import net.dielauxx.wandandspellsmod.entity.client.SparkBoltBBModel;
import net.dielauxx.wandandspellsmod.entity.custom.SparkBoltEntity;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.ThrownTrident;

public class SparkBoltRenderer extends EntityRenderer<SparkBoltEntity> {

    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(WandAndSpellsMod.MOD_ID, "textures/entity/spark_bolt_texture.png");
    private final TridentModel model;
    /* public SparkBoltRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }*/
    public SparkBoltRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new TridentModel(pContext.bakeLayer(ModModelLayers.SPARK_BOLT_LAYER));
    }

    @Override
    public ResourceLocation getTextureLocation(SparkBoltEntity sparkBoltEntity) {
        return TEXTURE_LOCATION;
    }

    public void render(SparkBoltEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        VertexConsumer $$6 = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, false);
        this.model.renderToBuffer(pPoseStack, $$6, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
