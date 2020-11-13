package me.endergamingfilms.blockbreakdamage;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class DamageHandler implements Listener {
    public final double damage;
    DamageHandler(double damage) {
        this.damage = Math.max(1.0f, damage);
    }

    @EventHandler
    void OnBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        double NewHealth = player.getHealth() - damage;
        if (NewHealth <= 0) {
            player.setHealth(0.0f);
        } else {
            player.damage(damage);
        }
    }
}
