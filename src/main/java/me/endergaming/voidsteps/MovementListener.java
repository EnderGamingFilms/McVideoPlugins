package me.endergaming.voidsteps;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementListener implements Listener {
    public static boolean killOption;
    private static boolean isUnder;
    //Constructor
    public MovementListener(VoidSteps plugin, boolean input) {
        this.isUnder = input;
        this.killOption = false;
    }

    //EventListener
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        // Check if a player is in survival before continuing
        if (event.getPlayer().getGameMode() != GameMode.SURVIVAL) {
            return;
        }
        // Getting Block Locations
        Location from = event.getFrom();
        Location to = event.getTo();
        Location blocLoc = from.subtract(0, 1, 0);
        // Translate bool to int
        int switchNum = 0;
        if (isUnder) {
            switchNum = 1;
        }
        switch (switchNum) {
            case 1:
                // Replace blocks directly under players
                if (from.getBlockX() == to.getBlockX()) {
                    if (!airCheck(blocLoc) && !liquidCheck(blocLoc) && !plankCheck(blocLoc)) {
                        if (!PlayerPlacedCheck.wasPlaced(blocLoc)) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "fill " + blocLoc.getBlockX() + " " + blocLoc.getBlockY() + " " + blocLoc.getBlockZ() + " " + blocLoc.getBlockX() + " 0 " + blocLoc.getBlockZ() + " minecraft:air");
                        }
                    }
                }
                break;
            case 0:
                // Replace blocks as players move off them
                if (from.getBlockX() != to.getBlockX()) { // X Axis Movement
                    if (!airCheck(blocLoc) && !liquidCheck(blocLoc) && !plankCheck(blocLoc)) {
                        if (!PlayerPlacedCheck.wasPlaced(blocLoc)) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "fill " + blocLoc.getBlockX() + " " + blocLoc.getBlockY() + " " + blocLoc.getBlockZ() + " " + blocLoc.getBlockX() + " 0 " + blocLoc.getBlockZ() + " minecraft:air");
                        }
                    }
                } else if (from.getBlockZ() != to.getBlockZ()) { // Z Axis Movement
                    if (!airCheck(blocLoc) && !liquidCheck(blocLoc) && !plankCheck(blocLoc)) {
                        if (!PlayerPlacedCheck.wasPlaced(blocLoc)) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "fill " + blocLoc.getBlockX() + " " + blocLoc.getBlockY() + " " + blocLoc.getBlockZ() + " " + blocLoc.getBlockX() + " 0 " + blocLoc.getBlockZ() + " minecraft:air");
                        }
                    }
                }
                break;
        }
    }

    // Check if the block is a plank
    public static boolean plankCheck(Location blockLoc) {
        switch (blockLoc.getBlock().getType().toString()) {
            case "OAK_PLANKS":
            case "BIRCH_PLANKS":
            case "SPRUCE_PLANKS":
            case "DARK_OAK_PLANKS":
            case "ACACIA_PLANKS":
            case "JUNGLE_PLANKS":
                return true;
            default:
                return  false;
        }
    }
    // Check if the block is liquid
    public static boolean liquidCheck(Location blockLoc) {
        switch (blockLoc.getBlock().getType().toString()) {
            case "WATER":
            case "LAVA":
                return true;
            default:
                return  false;
        }
    }
    // Check if the block is air
    public static boolean airCheck(Location blockLoc) {
        switch (blockLoc.getBlock().getType().toString()) {
            case "AIR":
            case "CAVE_AIR":
            case "VOID_AIR":
                return true;
            default:
                return  false;
        }
    }
}
