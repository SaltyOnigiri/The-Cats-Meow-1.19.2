package net.saltyonigiri.thecatsmeow.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.saltyonigiri.thecatsmeow.TheCatsMeow;
import net.saltyonigiri.thecatsmeow.entity.custom.CatrickEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CatrickRenderer extends GeoEntityRenderer<CatrickEntity> {
    public CatrickRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CatrickModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(CatrickEntity instance) {
        return new Identifier(TheCatsMeow.MOD_ID,"textures/entity/catrick.png");
    }

    @Override
    public RenderLayer getRenderType(CatrickEntity animatable, float partialTick, MatrixStack poseStack,
                                     VertexConsumerProvider bufferSource, VertexConsumer buffer,
                                     int packedLight, Identifier texture) {
        poseStack.scale(0.8f,0.8f,0.8f);

        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
