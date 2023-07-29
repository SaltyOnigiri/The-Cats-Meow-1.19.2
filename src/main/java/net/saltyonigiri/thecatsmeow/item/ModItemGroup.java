package net.saltyonigiri.thecatsmeow.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.saltyonigiri.thecatsmeow.TheCatsMeow;

public class ModItemGroup {
    public static final ItemGroup CATSMEOW = FabricItemGroupBuilder.build(
            new Identifier(TheCatsMeow.MOD_ID, "catsmeow"), () -> new ItemStack(ModItems.TAB)
    );
}
