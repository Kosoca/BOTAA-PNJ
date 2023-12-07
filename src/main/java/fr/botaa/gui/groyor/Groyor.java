package fr.botaa.gui.groyor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class Groyor implements Listener {
    private static final String nameOfPnj = "§e§lGroyor";

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();

        if (entity.getName().equals(nameOfPnj)) {
            Bukkit.dispatchCommand(player, "bank");
        }
    }
}
