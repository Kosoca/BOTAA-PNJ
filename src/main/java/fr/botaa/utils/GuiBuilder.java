package fr.botaa.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.Objects;

public class GuiBuilder {

    private final Inventory inventory;
    private final String title;
    private final Player owner;
    private final Integer size;

    public GuiBuilder(Player owner, int size) {
        this.owner = owner;
        this.size = size;
        this.title = null;
        this.inventory = Bukkit.createInventory(owner, size);
    }
    public GuiBuilder(Player owner, int size, String title) {
        this.owner = owner;
        this.size = size;
        this.title = title;
        this.inventory = Bukkit.createInventory(owner, size, title);
    }
    public GuiBuilder(Player owner, InventoryType inventoryType, String title) {
        this.owner = owner;
        this.size = null;
        this.title = title;
        this.inventory = Bukkit.createInventory(owner, inventoryType, title);
    }

    public Integer getSize() {
        return Objects.requireNonNullElse(this.size, 0);
    }

    public Player getOwner() {
        return this.owner;
    }

    public String getTitle() {
        return Objects.requireNonNullElse(this.title, "");
    }

    public Inventory getInventory() {
        return inventory;
    }


}
