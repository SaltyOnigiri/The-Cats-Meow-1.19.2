package net.saltyonigiri.thecatsmeow.gui;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.text.Text;


public class CardGui extends LightweightGuiDescription {
    public CardGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(300, 200);

        WLabel label = new WLabel(Text.literal("Class: Copper Journeyman     Rank: F"));
        root.add(label, 1,1, 4, 1);
    }
}
