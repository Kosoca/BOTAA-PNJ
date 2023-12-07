package fr.botaa.gui.dryel;

import fr.botaa.utils.ItemBuilder;

public enum ListOfItems {


    ;


    private final int slot;
    private final ItemBuilder itemBuilder;

    private ListOfItems(int slot, ItemBuilder item) {
        this.slot = slot;
        this.itemBuilder = item;
    }

    public int getSlot() {
        return slot;
    }

    public ItemBuilder getItemBuilder() {
        return itemBuilder;
    }

}


