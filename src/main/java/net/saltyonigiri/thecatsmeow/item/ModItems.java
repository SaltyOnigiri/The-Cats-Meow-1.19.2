package net.saltyonigiri.thecatsmeow.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.saltyonigiri.thecatsmeow.TheCatsMeow;
import net.saltyonigiri.thecatsmeow.item.custom.CopperJourneymanCardItem;

public class ModItems {
    // Creative Tab
    public static final Item TAB = registerItem("tab",
            new Item(new FabricItemSettings()));

    // Adventurers Card Set
    public static final Item COPPER_JOURNEYMAN_CARD = registerItem("copper_journeyman_card",
            new CopperJourneymanCardItem(new FabricItemSettings().group(ModItemGroup.CATSMEOW)));
    public static final Item GILDED_EXPLORER_CARD = registerItem("gilded_explorer_card",
            new Item(new FabricItemSettings().group(ModItemGroup.CATSMEOW)));
    public static final Item IRONHEART_WANDERER_CARD = registerItem("ironheart_wanderer_card",
            new Item(new FabricItemSettings().group(ModItemGroup.CATSMEOW)));
    public static final Item JEWELED_PATHFINDER_CARD = registerItem("jeweled_pathfinder_card",
            new Item(new FabricItemSettings().group(ModItemGroup.CATSMEOW)));
    public static final Item NETHERITE_VANGUARD_CARD = registerItem("netherite_vanguard_card",
            new Item(new FabricItemSettings().group(ModItemGroup.CATSMEOW)));

    // Food Set
    // public static final Item(new FabricItemSettings().group())

    // Method to register a custom item in the game's item registry.
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(TheCatsMeow.MOD_ID, name), item);
    }

    // Method to register all custom items of the mod during initialization.
    public static void registerModItems() {
        TheCatsMeow.LOGGER.debug("Registering Mod Items for " + TheCatsMeow.MOD_ID);
    }
}
