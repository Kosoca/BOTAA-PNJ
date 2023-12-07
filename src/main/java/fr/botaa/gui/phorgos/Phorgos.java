package fr.botaa.gui.phorgos;

import fr.botaa.utils.GuiBuilder;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Phorgos implements Listener {
    private static final String nameOfGui = "<shift:-8><glyph:phorgos_page_principale><shift:-190>";
    private static final String nameOfPnj = "§e§lPhorgos";


    public static void openGui(Player owner) {
        GuiBuilder gui = new GuiBuilder(owner, 54, nameOfGui);
        owner.playSound(owner.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 100, 1);

        for (ListOfItems item : ListOfItems.values()) {
            gui.getInventory().setItem(item.getSlot(), item.getItemBuilder().toItemStack());
        }

        owner.openInventory(gui.getInventory());
    }



    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();

        if (entity.getName().equals(nameOfPnj)) {
            openGui(player);
        }
    }

    @EventHandler
    public void onClickGuiVortor(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String title = event.getView().getTitle();
        ItemStack itemClicked = event.getCurrentItem();

        if (itemClicked == null) return;

        if (title.equals(nameOfGui)) {
            event.setCancelled(true);

        }
    }
}
