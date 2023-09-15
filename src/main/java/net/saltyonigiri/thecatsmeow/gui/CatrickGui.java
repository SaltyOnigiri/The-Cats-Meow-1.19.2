package net.saltyonigiri.thecatsmeow.gui;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CatrickGui extends LightweightGuiDescription {
    public CatrickGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        // Load the background image
        Identifier backgroundImageIdentifier = new Identifier("thecatsmeow:textures/gui/catrick_bck.png");
        WSprite backgroundImage = new WSprite(backgroundImageIdentifier);
        root.add(backgroundImage, 0, 0, 17, 12); // Adjust the grid position and span as needed

        // Catrick Icon
        WSprite icon = new WSprite(new Identifier("thecatsmeow:textures/gui/catrick.png"));
        root.add(icon, 9, 5, 7, 7);

        // Label with card information
        // Create a WText widget to display the quest description with text wrapping
        WText descriptionText = new WText(Text.of("Meow there, adventurer! Welcome to The Cat's Meow Guild Hall, the purr-fect hub for all your feline-fueled adventures. I'm Catrick, the receptionist here. How can I help you today?"));
        root.add(descriptionText, 3, 2, 12, 1);

        WButton quest_button = new WButton(Text.literal("Browse Quests"));
        quest_button.setOnClick(() -> {
            // Create an instance of the QuestGui
            QuestGui questGui = new QuestGui(this); // Pass the reference to CatrickGui

            // Set the current screen to the QuestGui
            MinecraftClient.getInstance().setScreen(new CottonClientScreen(questGui));
        });

        // Widget, X, Y, Width, Height
        root.add(quest_button, 3, 6, 7, 7);

        WButton guide_button = new WButton(Text.literal("I Have Questions"));
        guide_button.setOnClick(() -> {
            // This code runs on the client when you click the button.
            System.out.println("Guide Button Works!");
        });

        // Widget, X, Y, Width, Height
        root.add(guide_button, 3, 8, 7, 7);

        root.validate(this);
    }
}