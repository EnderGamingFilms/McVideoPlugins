package com.endergaming.fallfaster;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import javax.xml.crypto.Data;

public final class FallFaster extends JavaPlugin {
    private static PluginManager pm = Bukkit.getServer().getPluginManager();
    boolean running = false;
    private static BukkitTask mainTask;
    static String perm = "fallfaster.admin";

    @Override
    public void onEnable() {
        // Plugin startup logic\
        pm.registerEvents(new JoinHandler(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        if (mainTask != null) {
            mainTask.cancel();
        }
        HandlerList.unregisterAll(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "[FallFaster] Only players can run these commands!");
            return false;
        }

        if (args.length < 1) {
            InteractionHandler.getHelp(sender);
            return false;
        } else {
            String input = args[0].toLowerCase();
            switch(input) {
                // Test Command -- Delete later
                case "get":
                    sender.sendMessage("Case get.");
                    sender.sendMessage(ChatColor.GOLD + "Speed (Data): " + DataHandler.getValue((Player) sender));
                    break;
                // Test Command -- Delete later
                case "set":
                    sender.sendMessage("Case set.");
                    int data = Integer.parseInt(args[1]);
                    sender.sendMessage("Input Data: " + args[1]);
                    DataHandler.setValue((Player) sender, data);
                    sender.sendMessage(ChatColor.GOLD + "Success: DATA SET(" + DataHandler.getValue((Player) sender) + ")");
                    break;
                case "reset":
                    if (args.length == 1) {
                        DataHandler.setValue((Player) sender, 0);
                        InteractionHandler.dataReset(sender);
                    } else {
                        if (getServer().getPlayerExact(args[1]) != null) {
                            DataHandler.setValue(getServer().getPlayerExact(args[1].toString()), 0);
                            sender.sendMessage(ChatColor.GOLD + "DATA SET TO: " + DataHandler.getValue(getServer().getPlayerExact(args[1])));
                        } else {
                            InteractionHandler.invalidPlayer(sender);
                        }
                    }
                    ((Player) sender).getPlayer().removePotionEffect(PotionEffectType.SPEED);
                    break;
                case "on":
                    if (!this.running && sender.hasPermission(perm)) {
                        InteractionHandler.pluginOn(sender);
                        this.running = true;
                        // Scheduled task to check if the block under a player is air
                        BukkitTask task = new BukkitRunnable() {

                            @Override
                            public void run() {
                                // Run through this for all online players
                                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                                    // Check if the player is in the air
                                    Material blockTmp = player.getLocation().subtract(0, 1, 0).getBlock().getType();
                                    if (blockTmp == Material.AIR) {
                                        DataHandler.setValue(player, DataHandler.getValue(player) + 1);
                                    }
                                    // Only apply speed if the player has been in the air more than 0 times
                                    if (DataHandler.getValue(player) > 0) {
                                        // Update player speed
                                        PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 999999, DataHandler.getValue(player), true, false);
                                        player.removePotionEffect(PotionEffectType.SPEED);
                                        player.addPotionEffect(speed);
                                    }
                                }
                            }
                        }.runTaskTimer(this, 20 * 5, 20 * 2);
                        // Make a reference to the task so it can be cancelled later
                        mainTask = task;
                    } else
                        InteractionHandler.alreadyOn(sender);

                    break;
                case "off":
                    if (this.running && sender.hasPermission(perm)) {
                        this.running = false;
                        mainTask.cancel();
                        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                            player.removePotionEffect(PotionEffectType.SPEED);
                            DataHandler.setValue(player, 0);
                        }
                        HandlerList.unregisterAll(this);
                        InteractionHandler.pluginOff(sender);
                    } else {
                        InteractionHandler.alreadyOff(sender);
                    }
                    break;
                case "help":
                    InteractionHandler.getHelp(sender);
                    break;
                default:
                    InteractionHandler.getUsage(sender);
            }

            return true;
        }
    }
}
