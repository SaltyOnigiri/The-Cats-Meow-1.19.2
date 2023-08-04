package net.saltyonigiri.thecatsmeow;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.saltyonigiri.thecatsmeow.entity.ModEntities;
import net.saltyonigiri.thecatsmeow.entity.client.CatrickRenderer;

public class TheCatsMeowClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.CATRICK, CatrickRenderer::new);
    }
}
