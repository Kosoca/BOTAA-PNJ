package fr.botaa.botaapnj;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BotaaPnj extends JavaPlugin {

    private static BotaaPnj BOTAA_PNJ;
    private CommandsManager commandsManager;
    private PluginManager pluginManager;
    private final String prefix = "[BOTAA-PNJ] ";
    private final Logger logger = Logger.getLogger("Minecraft");
    RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
    private static LuckPerms luckPerms;
    private static Economy economy = null;

    @Override
    public void onEnable() {
        BOTAA_PNJ = this;
        this.commandsManager = new CommandsManager(BOTAA_PNJ);
        this.pluginManager = new PluginManager(BOTAA_PNJ);
        if (provider != null) {
            luckPerms = provider.getProvider();
        }
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        logger.info(prefix + "ENABLE");
    }

    @Override
    public void onDisable() {
        logger.info(prefix + "DISABLE");
    }


    public static BotaaPnj getBOTAA_PNJ() {
        return BOTAA_PNJ;
    }
    public CommandsManager getCommandsManager() {return commandsManager;}
    public PluginManager getPluginManager() {return pluginManager;}

    public static LuckPerms getLuckPerms() {
        return luckPerms;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    public static Economy getEconomy() {
        return economy;
    }
}
