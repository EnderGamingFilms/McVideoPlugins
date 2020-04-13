package com.endergaming.mobcrafting;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static com.endergaming.mobcrafting.identifier.*;

public final class MobCrafting extends JavaPlugin {
    private static PluginManager pm = Bukkit.getServer().getPluginManager();
    boolean running = false;
    static String perm = "mobcrafting.admin";

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
            switch(input) {
                case "on":
                    if (args.length <= 1) {
                        InteractionHandler.getUsage(sender);
                    } else {
                        CraftHandler listener;
                        if (args[1].equalsIgnoreCase("craft") || args[1].equalsIgnoreCase("crafting")) {
                            if (!this.running && sender.hasPermission(perm)) {
                                this.running = true;
                                listener = new CraftHandler(CRAFTING);
                                pm.registerEvents(listener, this);
                                InteractionHandler.pluginOn(sender);
                            } else {
                                InteractionHandler.alreadyOn(sender);
                            }
                        } else if (args[1].equalsIgnoreCase("inv") || args[1].equalsIgnoreCase("inventory")) {
                            if (!this.running && sender.hasPermission(perm)) {
                                this.running = true;
                                listener = new CraftHandler(INVENTORY);
                                pm.registerEvents(listener, this);
                                InteractionHandler.pluginOn(sender);
                            } else {
                                InteractionHandler.alreadyOn(sender);
                            }
                        } else if (args[1].equalsIgnoreCase("both")) {
                            if (!this.running && sender.hasPermission(perm)) {
                                this.running = true;
                                listener = new CraftHandler(BOTH);
                                pm.registerEvents(listener, this);
                                InteractionHandler.pluginOn(sender);
                            } else {
                                InteractionHandler.alreadyOn(sender);
                            }
                        } else {
                            InteractionHandler.getOnUsage(sender);
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
