package fr.botaa.gui.vortor.slotAffiliationElement;

import fr.botaa.utils.ItemBuilder;
import org.bukkit.Material;

public enum ListOfItems
{
    PREMIER(0, (new ItemBuilder(Material.GLOWSTONE, 1)).setName("§e§lPremière emplacement")),

    SECOND(4, (new ItemBuilder(Material.SHROOMLIGHT, 1)).setName("§6§lDeuxième emplacement"));

    private final int slot;

    private final ItemBuilder itemBuilder;

    ListOfItems(int slot, ItemBuilder item) {
        this.slot = slot;
        this.itemBuilder = item;
    }

    public int getSlot() {
        /* 23 */     return this.slot;
    }

    public ItemBuilder getItemBuilder() {
        /* 27 */     return this.itemBuilder;
    }
}
