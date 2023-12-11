package fr.botaa.gui.vortor;

import fr.botaa.gui.verifshop.VerifShopping;
import fr.botaa.lib.ElementItem;
import fr.botaa.utils.GuiBuilder;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Vortor implements Listener {
  private static final String nameOfGui = "<shift:-8><glyph:vortor_page_principale><shift:-190>";
  
  private static final String nameOfPnj = ";
  
  public static void openGui(Player owner) {
    GuiBuilder gui = new GuiBuilder(owner, 54, "<shift:-8><glyph:vortor_page_principale><shift:-190>");
    owner.playSound(owner.getLocation(), Sound.ENTITY_WARDEN_HURT, SoundCategory.RECORDS, 100.0F, 1.0F);
    for (ListOfItems item : ListOfItems.values())
      gui.getInventory().setItem(item.getSlot(), item.getItemBuilder().toItemStack()); 
    owner.openInventory(gui.getInventory());
  }
  
  @EventHandler
  public void onInteract(PlayerInteractEntityEvent event) {
    Entity entity = event.getRightClicked();
    Player player = event.getPlayer();
    if (entity.getName().equals("))
      openGui(player); 
  }
  
  @EventHandler
  public void onClickGuiVortor(InventoryClickEvent event) {
    Player player = (Player)event.getWhoClicked();
    String title = event.getView().getTitle();
    ItemStack itemClicked = event.getCurrentItem();
    if (itemClicked == null)
      return; 
    if (title.equals("<shift:-8><glyph:vortor_page_principale><shift:-190>")) {
      event.setCancelled(true);
      switch (event.getClick()) {
        case RIGHT:
          if (itemClicked.isSimilar(ListOfItems.SLOT_0.getItemBuilder().toItemStack())) {
            player.closeInventory();
            VerifShopping.openGui(player, 1000, ElementItem.VENT);
          } 
          break;
        case LEFT:
          if (itemClicked.isSimilar(ListOfItems.SLOT_0.getItemBuilder().toItemStack()))
            player.closeInventory(); 
          break;
      } 
    } 
  }
}
