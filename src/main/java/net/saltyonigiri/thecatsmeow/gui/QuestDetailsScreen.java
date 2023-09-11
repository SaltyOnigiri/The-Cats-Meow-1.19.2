package net.saltyonigiri.thecatsmeow.gui;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WText;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class QuestDetailsScreen extends CottonClientScreen {

    public QuestDetailsScreen(CatrickGui parentGui, String questName) {
        super(new QuestDetailsGui(parentGui, questName));
    }

    private static class QuestDetailsGui extends LightweightGuiDescription {
        public QuestDetailsGui(CatrickGui parentGui, String questName) {
            WGridPanel root = new WGridPanel();
            setRootPanel(root);
            root.setSize(300, 200);

            WLabel titleLabel = new WLabel(Text.of("Quest Details: " + questName));
            root.add(titleLabel, 2, 1, 6, 1);

            // Define quest descriptions for each quest name
            String[] questDescriptions = {
                    "The Pawthfinders have spotted an unusually high number of creepers in a nearby forest. Catrick asks the player to hunt down and eliminate a set number of creepers to make the area safe for feline exploration.",
                    "The Pawthfinders are fond of music. Find and retrieve 5 note blocks, which they believe will make their village sound more melodious.",
                    "Cats are known for their fascination with birds. Collect 20 feathers to satisfy the cat Pawthfinders' curiosity about the feathered creatures of the world.",
                    "Cats love fish! Gather 15 fish from the nearby rivers and ponds to treat the cat adventurers to a delicious meal.",
                    "The Pawthfinders have heard rumors of special yarn balls hidden in caves. Retrieve 8 strings from spider drops to craft yarn balls for their amusement.",
                    "The Pawthfinders are craving sweet treats! Gather 20 bottles of honey and 5 buckets of milk to make delicious honey and milk desserts for them.",
                    "Collect wool from different colored sheep to create cozy blankets for the adorable kittens. To make the blankets even more delightful, you may need to dye the wool in a variety of vibrant colors. These blankets will not only keep the kittens warm but also fill their nights with dreams of colorful adventures."
            };

            // Access questNames using the getter method
            String[] questNames = QuestGui.getQuestNames();

            // Find the index of the quest name in the array
            int questIndex = -1;
            for (int i = 0; i < questNames.length; i++) {
                if (questNames[i].equals(questName)) {
                    questIndex = i;
                    break;
                }
            }

            if (questIndex >= 0 && questIndex < questDescriptions.length) {
                // Create a label to display quest details
                WLabel detailsLabel = new WLabel(Text.of("Quest Details: " + questName));
                root.add(detailsLabel, 2, 1, 6, 1);

                // Create a WText widget to display the quest description with text wrapping
                WText descriptionText = new WText(Text.of(questDescriptions[questIndex]));
                root.add(descriptionText, 1, 2, 8, 1);
            }

            // Add a "Back" button to return to the QuestGui
            WButton backButton = new WButton(Text.of("Back"));
            backButton.setOnClick(() -> MinecraftClient.getInstance().setScreen(new CottonClientScreen(parentGui)));
            root.add(backButton, 1, 8, 7, 1);
        }
    }
}