package fr.botaa.gui.vortor.slotAffiliationElement;

import fr.botaa.gui.verifshop.VerifShopping;
import fr.botaa.lib.ElementItem;
import fr.botaa.utils.GuiBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class SlotAffiliationElement implements Listener {
    private static final String nameOfGui = "§ePremier ou second ?";
    private static int aPrice;
    private static ElementItem aElementItem;
    private static String aPermission;

    public static void openGui(Player owner, int price, ElementItem elementItem, String permission) {
        aPrice = price;
        aElementItem = elementItem;
        aPermission = permission;
        GuiBuilder gui = new GuiBuilder(owner, InventoryType.HOPPER, nameOfGui);
        owner.playSound(owner.getLocation(), Sound.UI_LOOM_SELECT_PATTERN, 300.0F, -1.0F);

        for (ListOfItems item : ListOfItems.values()) {
            gui.getInventory().setItem(item.getSlot(), item.getItemBuilder().toItemStack());
        }

        owner.openInventory(gui.getInventory());
    }


    @EventHandler
    public void onClickGui(InventoryClickEvent event) {
        Player player = (Player)event.getWhoClicked();
        String title = event.getView().getTitle();
        ItemStack itemClicked = event.getCurrentItem();

        if (itemClicked == null) {
            return;
        }

        if (title.equals(nameOfGui)) {
           event.setCancelled(true);

            String permissionWantedPremier = getPermissionShop()+".premier";
            String permissionWantedSecond = getPermissionShop()+".second";

            if (player.hasPermission(permissionWantedPremier) || player.hasPermission(permissionWantedSecond)) {
                player.getInventory().close();
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, SoundCategory.RECORDS, 100.0F, 0.0F);
                player.sendMessage("§cVous êtes déjà affilié à cet élément.");
                return;
            }

            if (itemClicked.isSimilar(ListOfItems.PREMIER.getItemBuilder().toItemStack())) {
                player.getInventory().close();
                VerifShopping.openGui(player, getPrice(), getElementShop(), permissionWantedPremier);

            } else if (itemClicked.isSimilar(ListOfItems.SECOND.getItemBuilder().toItemStack())) {
                player.getInventory().close();
                VerifShopping.openGui(player, getPrice(), getElementShop(), permissionWantedSecond);


            }
        }
    }


    public static int getPrice() {
        return aPrice;
    }
    public static ElementItem getElementShop() {
       return aElementItem;
    }
    public static String getPermissionShop() {
        return aPermission;
    }

}

