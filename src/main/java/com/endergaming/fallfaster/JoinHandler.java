package com.endergaming.fallfaster;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinHandler implements Listener {
    DataHandler dataHandler;
    JoinHandler() {
        dataHandler = new DataHandler();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        dataHandler.init(e.getPlayer());
    }
}
