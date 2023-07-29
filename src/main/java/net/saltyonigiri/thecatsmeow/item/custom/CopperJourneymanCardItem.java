package net.saltyonigiri.thecatsmeow.item.custom;


import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.saltyonigiri.thecatsmeow.gui.CardGui;
import net.saltyonigiri.thecatsmeow.gui.CardScreen;

public class CopperJourneymanCardItem extends Item  {
    public CopperJourneymanCardItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        MinecraftClient.getInstance().setScreen(new CardScreen(new CardGui()));
        return super.use(world, user, hand);
    }
}
