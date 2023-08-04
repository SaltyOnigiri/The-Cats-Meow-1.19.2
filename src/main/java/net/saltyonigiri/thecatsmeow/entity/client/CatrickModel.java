package net.saltyonigiri.thecatsmeow.entity.client;

import net.minecraft.util.Identifier;
import net.saltyonigiri.thecatsmeow.TheCatsMeow;
import net.saltyonigiri.thecatsmeow.entity.custom.CatrickEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CatrickModel extends AnimatedGeoModel<CatrickEntity> {
    @Override
    public Identifier getModelResource(CatrickEntity object) {
        return new Identifier(TheCatsMeow.MOD_ID,"geo/kittycat.geo.json");
    }

    @Override
    public Identifier getTextureResource(CatrickEntity object) {
        return new Identifier(TheCatsMeow.MOD_ID,"textures/entity/kittycat.png");
    }

    @Override
    public Identifier getAnimationResource(CatrickEntity animatable) {
        return new Identifier(TheCatsMeow.MOD_ID,"animations/kittycat.animation.json");
    }
}
