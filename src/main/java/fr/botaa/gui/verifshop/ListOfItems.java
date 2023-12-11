 package fr.botaa.gui.verifshop;

 import fr.botaa.utils.ItemBuilder;
 import org.bukkit.Material;


 public enum ListOfItems
         {
    /*  9 */   OUI(0, (new ItemBuilder(Material.GREEN_WOOL, 1)).setName("§a§lOui")),
    
    /* 11 */   NON(4, (new ItemBuilder(Material.RED_WOOL, 1)).setName("§c§lNon"));
    
       private final int slot;
    
       private final ItemBuilder itemBuilder;
    
       ListOfItems(int slot, ItemBuilder item) {
        /* 18 */     this.slot = slot;
        /* 19 */     this.itemBuilder = item;
           }
    
       public int getSlot() {
        /* 23 */     return this.slot;
           }
    
       public ItemBuilder getItemBuilder() {
        /* 27 */     return this.itemBuilder;
           }
     }
