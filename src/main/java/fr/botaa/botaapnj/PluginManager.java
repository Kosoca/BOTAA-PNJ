package fr.botaa.botaapnj;

import fr.botaa.gui.blazeman.Blazeman;
import fr.botaa.gui.dryel.Dryel;
import fr.botaa.gui.groyor.Groyor;
import fr.botaa.gui.iago.Iago;
import fr.botaa.gui.kiki.Kiki;
import fr.botaa.gui.momo.Momo;
import fr.botaa.gui.phorgos.Phorgos;
import fr.botaa.gui.verifshop.VerifShopping;
import fr.botaa.gui.volette.Volette;
import fr.botaa.gui.vortor.Vortor;
import fr.botaa.gui.vortor.slotAffiliationElement.SlotAffiliationElement;
import fr.botaa.gui.zazou.Zazou;

public class PluginManager {

    private final BotaaPnj plugin;

    public PluginManager(BotaaPnj plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(new VerifShopping(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new SlotAffiliationElement(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Vortor(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Kiki(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Momo(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Blazeman(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Phorgos(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Dryel(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Volette(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Iago(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Zazou(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new Groyor(), plugin);


    }

    public BotaaPnj getPlugin() {return this.plugin;}
}