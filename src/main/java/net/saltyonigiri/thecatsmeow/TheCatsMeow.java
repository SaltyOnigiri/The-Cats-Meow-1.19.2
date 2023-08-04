package net.saltyonigiri.thecatsmeow;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.saltyonigiri.thecatsmeow.entity.ModEntities;
import net.saltyonigiri.thecatsmeow.entity.custom.CatrickEntity;
import net.saltyonigiri.thecatsmeow.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib3.GeckoLib;

public class TheCatsMeow implements ModInitializer {
	public static final String MOD_ID = "thecatsmeow";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		GeckoLib.initialize();
		FabricDefaultAttributeRegistry.register(ModEntities.CATRICK, CatrickEntity.setAttributes());
	}
}
