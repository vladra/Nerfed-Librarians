package com.vladra.nerfedLibrarians;


import com.vladra.nerfedLibrarians.util.VillagerTradeUtils;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



public class NerfedLibrarians extends JavaPlugin {


    /**
     * Called when the plugin is being enabled.
     * Used to initialise everything.
     */
    @Override
    public void onEnable() {

        /* Initialise listener */
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new com.vladra.nerfedLibrarians.listener.ChunkLoadListener(), this);
        pluginManager.registerEvents(new com.vladra.nerfedLibrarians.listener.VillagerAcquireTradeListener(), this);
        this.getLogger().info("[Nerfed Librarians] Plugin enabled");

        //in case a chunk happens to already be loaded? full coverage

        for (World world : Bukkit.getWorlds()) {
            for (Chunk chunk : world.getLoadedChunks()) {
                for (Entity entity : chunk.getEntities()) {
                    if (entity instanceof Villager villager) {
                        VillagerTradeUtils.removeEnchantedBookTrades(villager);
                    }
                }
            }

        }
    }

    /**
     * Called when the plugin is being disabled.
     */
    @Override
    public void onDisable() {
        this.getLogger().info("[Nerfed Librarians] Plugin disabled");

    }


}
