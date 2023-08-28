package net.saltyonigiri.thecatsmeow.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;



public class CatrickGui extends LightweightGuiDescription {
    public CatrickGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        // Load the background image
        Identifier backgroundImageIdentifier = new Identifier("thecatsmeow:textures/gui/copper_bck.png");
        WSprite backgroundImage = new WSprite(backgroundImageIdentifier);
        root.add(backgroundImage, 0, 0, 17, 12); // Adjust the grid position and span as needed

        // Label with card information
        WLabel label = new WLabel(Text.literal("Class: Copper Journeyman     Rank: F"));
        root.add(label, 5, 2, 4, 1);

        // Card icon
        WSprite icon = new WSprite(new Identifier("thecatsmeow:textures/item/copper_journeyman_card.png"));
        root.add(icon, 1, 1, 4, 4);
    }
}