package me.endergamingfilms.blockbreakdamage;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockBreakDamage extends JavaPlugin {
    private static PluginManager pm = Bukkit.getServer().getPluginManager();
    boolean running = false;
    static String perm = "BlockBreakDamage.admin";

    @Override
    public void onEnable() {
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            InteractionHandler.getHelp(sender);
            return false;
        } else {
            String input = args[0].toLowerCase();
            switch (input) {
                case "on":
                    if (args.length <= 1) {
                        InteractionHandler.getUsage(sender);
                    } else {
                        if (args[1].matches("[A-z]")) {
                            InteractionHandler.getOnUsage(sender);
                            return false;
                        }
                        if (!running && sender.hasPermission(perm)) {
                            DamageHandler listener = new DamageHandler(Double.parseDouble(args[1]));
                            pm.registerEvents(listener, this);
                            InteractionHandler.pluginOn(sender);
                            this.running = true;
                        } else {
                            InteractionHandler.alreadyOn(sender);
                        }
                    }
                    break;
                case "off":
                    if (this.running && sender.hasPermission(perm)) {
                        this.running = false;
                        HandlerList.unregisterAll(this);
                        InteractionHandler.pluginOff(sender);
                    } else {
                        InteractionHandler.alreadyOff(sender);
                    }
                    break;
                default:
                    InteractionHandler.getHelp(sender);
            }
            return true;
        }
    }
}
