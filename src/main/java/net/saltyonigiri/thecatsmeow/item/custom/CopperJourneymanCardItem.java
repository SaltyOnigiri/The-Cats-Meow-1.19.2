package net.saltyonigiri.thecatsmeow.item.custom;


import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.saltyonigiri.thecatsmeow.gui.CopperCardGui;
import net.saltyonigiri.thecatsmeow.gui.CopperCardScreen;

public class CopperJourneymanCardItem extends Item {
    public CopperJourneymanCardItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) { // Ensure this code runs only on the client side
            MinecraftClient.getInstance().execute(() -> MinecraftClient.getInstance().setScreen(new CopperCardScreen(new CopperCardGui())));
        }

        return super.use(world, user, hand);
    }
}
