package net.saltyonigiri.thecatsmeow.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.saltyonigiri.thecatsmeow.TheCatsMeow;
import net.saltyonigiri.thecatsmeow.entity.custom.CatrickEntity;

public class ModEntities {
    public static final EntityType<CatrickEntity> CATRICK = Registry.register(
            Registry. ENTITY_TYPE, new Identifier(TheCatsMeow.MOD_ID,"catrick"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CatrickEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f,1.3f)).build());
}
