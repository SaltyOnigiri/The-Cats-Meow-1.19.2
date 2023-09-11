package net.saltyonigiri.thecatsmeow.gui;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class QuestGui extends LightweightGuiDescription {
    // Define an array of quest names
    private static final String[] questNames = {
            "Creepurr Control",
            "Meow-sical Marvels",
            "Feathered Friends",
            "Sleeping With The Fishies",
            "Mysterious Yarn Balls",
            "Sweet Treats",
            "Kittens in a Blanket"
            // Add more quest names here
    };

    public QuestGui(CatrickGui parentGui) {
        // Create the GUI elements for the QuestGui here
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        WLabel titleLabel = new WLabel(Text.of("Quest System"));
        root.add(titleLabel, 2, 1, 6, 1);

        // Add quest buttons with different names
        for (int i = 0; i < questNames.length; i++) {
            int questIndex = i;
            String questName = questNames[i];

            WButton questButton = new WButton(Text.of(questName));
            questButton.setOnClick(() -> {
                // Open the QuestDetailsScreen when a quest button is clicked
                MinecraftClient.getInstance().setScreen(new QuestDetailsScreen(parentGui, questName));
            });

            root.add(questButton, 1, 2 + i, 8, 1);
        }

        WButton back_button = new WButton(Text.of("Back"));
        back_button.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new CottonClientScreen(parentGui));
        });
        root.add(back_button, 1, 9, 7, 7);
    }

    // Getter method to access questNames from other classes
    public static String[] getQuestNames() {
        return questNames;
    }
}