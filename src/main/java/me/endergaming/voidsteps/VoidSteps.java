package me.endergaming.voidsteps;

import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class VoidSteps extends JavaPlugin {
    private static PluginManager pm = Bukkit.getServer().getPluginManager();
    private boolean running = false;
    public static Plugin plugin;
    //public static CoreProtectAPI api;

    @Override
    public void onEnable() {
        // Check for CoreProtect
        if(!Bukkit.getPluginManager().isPluginEnabled("CoreProtect")) {
            Bukkit.getLogger().severe("[VoidSteps] Please make sure CoreProtect is installed!");
            Bukkit.getPluginManager().disablePlugin(plugin);
        } else {

            Bukkit.getLogger().info("[VoidSteps] Everything is installed and ready to go! Use: /voidsteps help");
        }
    }

    @Override
    public void onDisable() {
        running = false;
        HandlerList.unregisterAll(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if command has arguments
        if (args.length < 1) {
            senderInteractions(sender);
            return false;
        }

        // Start & Stop Commands
        String input = args[0].toLowerCase();
        switch(input) {
            case "on":
                // If you try to turn it on without the seconds argument it breaks
                if (args.length <= 1) {
                    sender.sendMessage(ChatColor.GREEN + "/voidsteps [help/off/on] [under/behind]");
                    break;
                }
                if (args[1].equalsIgnoreCase("under")) {
                    if (!running && sender.hasPermission("voidsteps.admin")) {
                        running = true;
                        MovementListener listener = new MovementListener(this, true);
                        pm.registerEvents(listener, this);
                        sender.sendMessage(ChatColor.GREEN + "[VoidSteps] Void will now spawn under players.");
                    } else {
                        sender.sendMessage(ChatColor.GREEN + "[VoidSteps] The void is already spawning under players.");
                    }
                } else if (args[1].equalsIgnoreCase("behind")) {
                    if (!running && sender.hasPermission("voidsteps.admin")) {
                        running = true;
                        MovementListener listener = new MovementListener(this, false);
                        pm.registerEvents(listener, this);
                        sender.sendMessage(ChatColor.GREEN + "[VoidSteps] Void will now spawn behind players.");
                    } else {
                        sender.sendMessage(ChatColor.GREEN + "[VoidSteps] The void is already spawning under players.");
                    }
                } else {
                    sender.sendMessage(ChatColor.GREEN + "/voidsteps on [under/behind]");
                }
                break;
            case "off":
                if (running && sender.hasPermission("voidsteps.admin")) {
                    running = false;
                    HandlerList.unregisterAll(this);
                    sender.sendMessage(ChatColor.GREEN + "[VoidSteps] Void will now stop spawning under/behind players.");
                } else {
                    sender.sendMessage(ChatColor.GREEN + "[VoidSteps] The void is not currently spawning.");
                }
                break;
            default:
                senderInteractions(sender);
        }
        return true;
    }

    public static void senderInteractions(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "# Warning: Please run /voidsteps off before starting it again");
        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Author: EnderGamingFilms");
        sender.sendMessage(ChatColor.GRAY + "Aliases: voidstep, vstep, vs  |  Permission: voidsteps.admin");
        sender.sendMessage(ChatColor.GREEN + "/voidsteps help" + ChatColor.YELLOW + " - Shows this menu");
        sender.sendMessage(ChatColor.GREEN + "/voidsteps off" + ChatColor.YELLOW + " - Stops deleting blocks");
        sender.sendMessage(ChatColor.GREEN + "/voidsteps on [under/behind]" + ChatColor.YELLOW + " - Starts deleting blocks");
    }
}
