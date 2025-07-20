package com.vladra.nerfedLibrarians.listener;

import com.vladra.nerfedLibrarians.util.VillagerTradeUtils;
import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;



// this function checks for existing villagers and disables book trades

public class ChunkLoadListener implements Listener {

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {
        Chunk chunk = event.getChunk();

        for (Entity entity : chunk.getEntities()) {
            if (entity instanceof Villager villager) {
                VillagerTradeUtils.removeEnchantedBookTrades(villager);
            }
        }
    }

}
