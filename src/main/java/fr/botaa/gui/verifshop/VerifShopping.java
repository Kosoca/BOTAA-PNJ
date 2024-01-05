package fr.botaa.gui.verifshop;
/*    */

import fr.botaa.lib.ElementItem;
import fr.botaa.utils.GuiBuilder;
/*    */ import org.bukkit.*;
/*    */
/*    */
/*    */
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */ import org.bukkit.event.inventory.InventoryType;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */
public class VerifShopping implements Listener {
  private static final String nameOfGui = "§eVoulez-vous acheter ?";
  private static int aPrice;
  private static ElementItem aElementItem;
  private static String aPermission;

  public static void openGui(Player owner, int price, ElementItem elementItem, String permission) {
            aPrice = price;
            aElementItem = elementItem;
            aPermission = permission;
            if (owner.getLevel() < 1000) {
                    owner.playSound(owner.getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, SoundCategory.RECORDS, 100.0F, 0.0F);
                    owner.sendMessage("§cVous n'avez pas les éléments requis.");
                    owner.closeInventory();
                    return;
            }
        GuiBuilder gui = new GuiBuilder(owner, InventoryType.HOPPER, nameOfGui);
        owner.playSound(owner.getLocation(), Sound.UI_LOOM_SELECT_PATTERN, 300.0F, -1.0F);

        for (ListOfItems item : ListOfItems.values()) {
            gui.getInventory().setItem(item.getSlot(), item.getItemBuilder().toItemStack());
            }

        owner.openInventory(gui.getInventory());
      }

  @EventHandler
  public void onClickGui(InventoryClickEvent event) {
        /* 46 */     Player player = (Player)event.getWhoClicked();
        /* 47 */     String title = event.getView().getTitle();
        /* 48 */     ItemStack itemClicked = event.getCurrentItem();
        /*    */
        /* 50 */     if (itemClicked == null) {
              return;
            }
        /* 53 */     if (title.equals(nameOfGui)) {
            /* 54 */       event.setCancelled(true);
            /* 55 */       if (itemClicked.isSimilar(ListOfItems.OUI.getItemBuilder().toItemStack())) {
                /* 56 */         checkPlayerHaveEnoughtXp(player, getElementShop(), getPermissionShop());
                /* 57 */         player.getInventory().close();
                  }
            /* 59 */       else if (itemClicked.isSimilar(ListOfItems.NON.getItemBuilder().toItemStack())) {
                /* 60 */         player.getInventory().close();
                  }
            }
      }
    /*    */
    /*    */
  private void checkPlayerHaveEnoughtXp(Player player, ElementItem elementItem, String permission) {
        /* 67 */     if (player.getLevel() >= 1000) {
            /* 68 */       player.setLevel(player.getLevel() - 1000);
            /* 69 */       player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, SoundCategory.RECORDS, 300.0F, -1.0F);
            /* 70 */
                           Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set " + permission);
                           player.sendMessage("§aVous êtes maintenant affilié à l'élément " + elementItem.getTextComponent().content() + ".");
            /* 71 */       player.getInventory().close();
            /* 72 */       createMagicParticles(player.getLocation());
            } else {
            /*    */
            /* 75 */       player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_AMBIENT, SoundCategory.RECORDS, 100.0F, 0.0F);
            /* 76 */       player.sendMessage("§cVous n'avez pas les éléments requis.");
            /* 77 */       player.getInventory().close();
            }
      }
    /*    */
  private void createMagicParticles(Location location) {
        /* 82 */     for (int i = 0; i < 36; i++) {
            /* 83 */       double angle = 6.283185307179586D * i / 36.0D;
            /* 84 */       double x = location.getX() + 1.5D * Math.cos(angle);
            /* 85 */       double y = location.getY() + 0.5D;
            /* 86 */       double z = location.getZ() + 1.5D * Math.sin(angle);
            /*    */
            /* 88 */       Location particleLocation = new Location(location.getWorld(), x, y, z);
            /* 89 */       location.getWorld().spawnParticle(Particle.SPELL_WITCH, particleLocation, 10);
            }
      }
    /*    */
    /*    */
    public static int getPrice() {
        /* 95 */     return aPrice;
      }
      public static ElementItem getElementShop() {
        /* 99 */     return aElementItem;
      }
      public static String getPermissionShop() {
        /* 99 */     return aPermission;
    }

}
