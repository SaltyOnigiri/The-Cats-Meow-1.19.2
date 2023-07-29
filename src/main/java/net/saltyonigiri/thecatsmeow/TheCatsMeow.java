package net.saltyonigiri.thecatsmeow;

import net.fabricmc.api.ModInitializer;

import net.saltyonigiri.thecatsmeow.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheCatsMeow implements ModInitializer {
	public static final String MOD_ID = "thecatsmeow";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}