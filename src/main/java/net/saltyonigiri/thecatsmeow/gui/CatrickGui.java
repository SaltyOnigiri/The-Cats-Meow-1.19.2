package net.saltyonigiri.thecatsmeow.gui;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
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

        // TextBox Option
        // WSprite textbox = new WSprite(new Identifier("thecatsmeow:textures/gui/1.png"));
        // root.add(textbox, 3, 0, 11, 8);

        // Catrick Icon
        WSprite icon = new WSprite(new Identifier("thecatsmeow:textures/gui/catrick.png"));
        root.add(icon, 9, 5, 7, 7);

        // Label with card information
        WLabel label = new WLabel(Text.literal("Meow there, adventurer! Welcome to The Cat's "));
        root.add(label, 2, 2, 4, 1);
        WLabel label1 = new WLabel(Text.literal("Meow Guild Hall, the purr-fect hub for all your "));
        root.add(label1, 2, 3, 4, 1);
        WLabel label2 = new WLabel(Text.literal("feline-fueled adventures. I'm Catrick, the "));
        root.add(label2, 2, 4, 4, 1);
        WLabel label3 = new WLabel(Text.literal( "receptionist here. How can I help you today?"));
        root.add(label3, 2, 5, 4, 1);

        WButton quest_button = new WButton(Text.literal("Browse Quests"));
        quest_button.setOnClick(() -> {
            // This code runs on the client when you click the button.
            System.out.println("Quest Button Works!");
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