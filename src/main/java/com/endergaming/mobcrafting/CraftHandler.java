package com.endergaming.mobcrafting;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;

enum identifier {
    CRAFTING, INVENTORY, BOTH
}

public class CraftHandler implements Listener {
    private static identifier mode;
    // Constructor
    public CraftHandler(identifier ident) {
        mode = ident;
    }

    @EventHandler
    public void onPlayerCraft (CraftItemEvent craftEvent) {
        if (mode == identifier.CRAFTING || mode == identifier.BOTH) {
            Player p = (Player) craftEvent.getWhoClicked();
            Location loc = p.getLocation();

            if (!craftEvent.isCancelled()) {
                EntityType selectedMob = MobSelection.generator();
                spawnCreature(loc, selectedMob);
            }
        }
    }

    @EventHandler
    public void onPlayerOInv (InventoryOpenEvent openEvent) {
        if (mode == identifier.INVENTORY || mode == identifier.BOTH) {
            Player p = (Player) openEvent.getPlayer();
            Location loc = p.getLocation();

            if (!openEvent.isCancelled()) {
                EntityType selectedMob = MobSelection.generator();
                spawnCreature(loc, selectedMob);
            }
        }
    }

    @EventHandler
    public void onPlayerCInv(InventoryCloseEvent closeEvent) {
        if (mode == identifier.INVENTORY || mode == identifier.BOTH) {
            Player p = (Player) closeEvent.getPlayer();
            Location loc = p.getLocation();
            
            if (closeEvent.getInventory().getType().getDefaultSize() == 5) {
                EntityType selectedMob = MobSelection.generator();
                spawnCreature(loc, selectedMob);
            }
        }
    }

    private void spawnCreature(Location loc, EntityType mob) {
        loc.getWorld().spawnEntity(loc,mob);
    }
}
