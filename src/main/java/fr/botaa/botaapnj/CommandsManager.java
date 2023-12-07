package fr.botaa.botaapnj;

public class CommandsManager {

    private final BotaaPnj plugin;

    public CommandsManager(BotaaPnj plugin) {
        this.plugin = plugin;
        // Objects.requireNonNull(plugin.getCommand("bitem")).setExecutor(new BItem());
    }
    public BotaaPnj getPlugin() {return this.plugin;}
}