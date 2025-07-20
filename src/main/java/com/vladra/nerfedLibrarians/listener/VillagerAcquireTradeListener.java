package com.vladra.nerfedLibrarians.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public record VillagerAcquireTradeListener() implements Listener {

    @EventHandler
    public void onTradeAcquire(VillagerAcquireTradeEvent event) {
        MerchantRecipe recipe = event.getRecipe();
        ItemStack result = recipe.getResult();

        if (result.getType() == Material.ENCHANTED_BOOK) {
            event.setCancelled(true);
        }
    }
}
