package net.saltyonigiri.thecatsmeow.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static io.github.cottonmc.cotton.gui.client.CottonHud.add;


public class CardGui extends LightweightGuiDescription {
    public CardGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        WLabel label = new WLabel(Text.literal("Class: Copper Journeyman     Rank: F"));
        root.add(label, 5,2, 4, 1);

        WSprite icon = new WSprite(new Identifier("thecatsmeow:textures/item/copper_journeyman_card.png"));
        root.add(icon, 0, 1, 5, 5);

    }
}
