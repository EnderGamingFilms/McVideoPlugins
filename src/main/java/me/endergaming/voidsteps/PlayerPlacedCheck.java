package me.endergaming.voidsteps;

import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class PlayerPlacedCheck{
    //Constructor
    public PlayerPlacedCheck(Plugin plugin) {
    }

    // Checks to see if a block has been placed in a specific spot
    public static boolean wasPlaced(Location blocLoc) {
        CoreProtectAPI api = CoreProtect.getInstance().getAPI();
        List<String[]> result = api.blockLookup(blocLoc.getBlock(), 999999999);
        if (!result.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
