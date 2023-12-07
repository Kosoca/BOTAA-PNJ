package fr.botaa.botaapnj;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class BotaaPnj extends JavaPlugin {

    private static BotaaPnj BOTAA_PNJ;
    private CommandsManager commandsManager;
    private PluginManager pluginManager;
    private final String prefix = "[BOTAA-PNJ] ";
    private final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        BOTAA_PNJ = this;
        this.commandsManager = new CommandsManager(BOTAA_PNJ);
        this.pluginManager = new PluginManager(BOTAA_PNJ);
        logger.info(prefix + "ENABLE");
    }

    @Override
    public void onDisable() {
        logger.info(prefix + "DISABLE");
    }


    public static BotaaPnj getBOTAA_ITEM() {
        return BOTAA_PNJ;
    }
    public CommandsManager getCommandsManager() {return commandsManager;}
    public PluginManager getPluginManager() {return pluginManager;}
}
