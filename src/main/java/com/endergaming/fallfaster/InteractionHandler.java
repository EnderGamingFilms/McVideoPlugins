package com.endergaming.fallfaster;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class InteractionHandler {
    // Constructor
    public InteractionHandler () {

    }

    public static void getHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + "Author: EnderGamingFilms");
        sender.sendMessage(ChatColor.GRAY + "Aliases: fallfaster, fallfast, ff  |  Permission: fallfaster.admin");
        sender.sendMessage(ChatColor.GREEN + "/fallfaster help" + ChatColor.YELLOW + " - Shows this menu");
        sender.sendMessage(ChatColor.GREEN + "/fallfaster off" + ChatColor.YELLOW + " - Stops increasing player speed");
        sender.sendMessage(ChatColor.GREEN + "/fallfaster on" + ChatColor.YELLOW + " - Starts increasing player speed");
    }

    public static void getUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "/fallfaster [help/on/off]");
    }

    public static void getResetUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "/fallfaster reset [PlayerName]");
    }

    public static void pluginOn(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[FallFaster] Will begin increasing player speed.");
    }

    public static void pluginOff(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[FallFaster] Is no longer increasing speed.");
    }

    public static void alreadyOn(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[FallFaster] Is already running. Please run /fallfaster off and start it again.");
    }

    public static void alreadyOff(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[FallFaster] Is not currently running.");
    }

    public static void dataReset(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[FallFaster] Your data has been reset.");
    }

    public static void invalidPlayer(CommandSender sender) {
        sender.sendMessage(ChatColor.GREEN + "[FallFaster] That is not a valid player!");
    }
}
