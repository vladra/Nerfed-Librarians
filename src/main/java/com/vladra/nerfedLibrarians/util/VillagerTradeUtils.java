package com.vladra.nerfedLibrarians.util;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class VillagerTradeUtils {
    public static void removeEnchantedBookTrades(Villager villager) {
        if (villager.getProfession() == Villager.Profession.LIBRARIAN) {
            List<MerchantRecipe> newRecipes = new ArrayList<>();
            for (MerchantRecipe recipe : villager.getRecipes()) {
                if (!(recipe.getResult().getType() == Material.ENCHANTED_BOOK)) {
                    newRecipes.add(recipe);
                } //for now just remove enchanted books, don't change to a new trade
            }
            villager.setRecipes(newRecipes);

        }
    }
}
