package com.endergaming.mobcrafting;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class InteractionHandler {
    // Constructor
    public InteractionHandler () {

    }

    public static void getHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Author: EnderGamingFilms");
        sender.sendMessage(ChatColor.GRAY + "Aliases: mobcrafting, mcraft, mcr  |  Permission: mobcrafting.admin");
        sender.sendMessage(ChatColor.GREEN + "/mobcrafting help" + ChatColor.YELLOW + " - Shows this menu");
        sender.sendMessage(ChatColor.GREEN + "/mobcrafting off" + ChatColor.YELLOW + " - Stops the spawning of mobs");
        sender.sendMessage(ChatColor.GREEN + "/mobcrafting on [craft/inv/both]" + ChatColor.YELLOW + " - Starts the spawning of mobs");
    }

    public static void getUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "/mobcrafting [help/on/off]");
    }

    public static void getOnUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "/mobcrafting on [craft/inv/both]");
    }

    public static void pluginOn(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[MobCrafting] Will begin summoning mobs.");
    }

    public static void pluginOff(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[MobCrafting] Is no longer spawning mobs.");
    }

    public static void alreadyOn(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[MobCrafting] Is already running. Please run /mobcrafting off to start it again.");
    }

    public static void alreadyOff(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[MobCrafting] Is not currently running.");
    }
}
