package com.endergaming.fallfaster;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DataHandler {
    public static HashMap<Player, Integer> playerHashMap = new HashMap<>();
    public DataHandler () {
    }

    // Initializer -- Is ran on every player join.
    public static void init(Player p) {
        playerHashMap.put(p, 0);
    }

    public static void setValue(Player p, int input) {
        playerHashMap.put(p, input);

        // Warns the player that they can reset their speed -- when up at speed 180 the server starts to freak out
        if (playerHashMap.get(p) == 180 || playerHashMap.get(p) == 200) {
            p.sendMessage(ChatColor.RED + " If you want, run " + ChatColor.GOLD + "/ff reset" + ChatColor.RED + " to reset your speed.");
        }
    }

    public static int getValue(Player p) {
        // If for some reason the HashMap is empty
        if (playerHashMap.isEmpty()) {
            p.sendMessage("HashMap was empty so you were added..." + "\n");
            playerHashMap.put(p, 0);

            return playerHashMap.get(p);
        }
        return playerHashMap.get(p);
    }
}
