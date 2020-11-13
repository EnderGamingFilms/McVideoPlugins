package me.endergamingfilms.blockbreakdamage;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class InteractionHandler {
    // Constructor
    public InteractionHandler () {

    }

    public static void getHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Author: EnderGamingYT");
        sender.sendMessage(ChatColor.GRAY + "Aliases: bbd  |  Permission: BlockBreakDamage.admin");
        sender.sendMessage(ChatColor.GREEN + "/bbd help" + ChatColor.YELLOW + " - Shows this menu");
        sender.sendMessage(ChatColor.GREEN + "/bbd off" + ChatColor.YELLOW + " - Stops players being damaged");
        sender.sendMessage(ChatColor.GREEN + "/bbd on [number]" + ChatColor.YELLOW + " - Broken blocks will do damage");
    }

    public static void getUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "/bbd [help/on/off]");
    }

    public static void getOnUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "/bbd on [number]");
    }

    public static void pluginOn(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[BBD] Breaking blocks damages you.");
    }

    public static void pluginOff(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[BBD] Blocks aren't evil anymore.");
    }

    public static void alreadyOn(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[BBD] Is already running. Please run /bbd off to start it again.");
    }

    public static void alreadyOff(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[BBD] Is not currently running.");
    }
}
