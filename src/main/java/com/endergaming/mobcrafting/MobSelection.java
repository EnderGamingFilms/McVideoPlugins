package com.endergaming.mobcrafting;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;

public class MobSelection {
    // Constructor
    public MobSelection() {

    }

    public static EntityType generator() {
        int randNum = (int) (Math.random() * 32) + 1;

        switch(randNum) {
            case 1:
                return EntityType.BEE;
            case 2:
                return EntityType.CHICKEN;
            case 3:
                return EntityType.CAVE_SPIDER;
            case 4:
                return EntityType.SKELETON;
            case 5:
                return EntityType.ZOMBIE;
            case 6:
                return EntityType.HUSK;
            case 7:
                return EntityType.CREEPER;
            case 8:
                return EntityType.PILLAGER;
            case 9:
                return EntityType.ENDERMITE;
            case 10:
                return EntityType.GHAST;
            case 11:
                return EntityType.BLAZE;
            case 12:
                return EntityType.COW;
            case 13:
                return EntityType.DOLPHIN;
            case 14:
                return EntityType.WITCH;
            case 15:
                return EntityType.ENDERMAN;
            case 16:
                return EntityType.TRADER_LLAMA;
            case 17:
                return EntityType.PUFFERFISH;
            case 18:
                return EntityType.SLIME;
            case 19:
                return EntityType.DROWNED;
            case 20:
                return EntityType.ZOMBIE_VILLAGER;
            case 21:
                return EntityType.PIG_ZOMBIE;
            case 22:
                return EntityType.WANDERING_TRADER;
            case 23:
                return EntityType.SALMON;
            case 24:
                return EntityType.BOAT;
            case 25:
                return EntityType.HORSE;
            case 26:
                return EntityType.MAGMA_CUBE;
            case 27:
                return EntityType.PANDA;
            case 28:
                return EntityType.FOX;
            case 29:
                return EntityType.RABBIT;
            case 30:
                return EntityType.SNOWMAN;
            case 31:
                return EntityType.TURTLE;
            case 32:
                return EntityType.SPIDER;
            case 33:
                return EntityType.SQUID;
            default:
                Bukkit.getServer().broadcastMessage(ChatColor.YELLOW+">> Mob selector defaulted");
                return EntityType.COD;
        }
    }
}
