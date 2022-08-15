package me.masem.changerwand;

import me.masem.changerwand.Listeners.OnInventoryEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class WeatherChangeCompass extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        NamespacedKey key = new NamespacedKey(this,"weather_change_compass");

        ItemStack WeatherWand = new ItemStack(Material.RECOVERY_COMPASS);
        ItemMeta WeatherWandDetails = WeatherWand.getItemMeta();

        WeatherWandDetails.setDisplayName(ChatColor.AQUA + "Weather Changer Compass");
        WeatherWandDetails.addEnchant(Enchantment.DURABILITY, 1, false);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(0,ChatColor.BLUE + "Changes the weather");
        lore.add(1,ChatColor.BLUE + "of the server");
        lore.add(2, "--------------------");
        lore.add(3,ChatColor.YELLOW + "☀ Clear");
        lore.add(4, ChatColor.GRAY + "☁ Thunder");
        lore.add(5, ChatColor.DARK_GRAY + "☂ Rainy");
        lore.add(6,"---------------------");
        lore.add(7,ChatColor.WHITE + "Right Click on Weather Compass");
        lore.add(8, ChatColor.WHITE + "to change weather");

        WeatherWandDetails.setLore(lore);

        WeatherWand.setItemMeta(WeatherWandDetails);

        ShapedRecipe WeatherCompassRecipe = new ShapedRecipe(key, WeatherWand);

        WeatherCompassRecipe.shape("ABC", "DEF", "GHI");

        WeatherCompassRecipe.setIngredient('A', Material.OAK_LOG);
        WeatherCompassRecipe.setIngredient('B', Material.SPRUCE_LOG);
        WeatherCompassRecipe.setIngredient('C', Material.BIRCH_LOG);

        WeatherCompassRecipe.setIngredient('D', Material.JUNGLE_LOG);

        WeatherCompassRecipe.setIngredient('E', Material.RECOVERY_COMPASS);

        WeatherCompassRecipe.setIngredient('F', Material.ACACIA_LOG);

        WeatherCompassRecipe.setIngredient('G', Material.DARK_OAK_LOG);
        WeatherCompassRecipe.setIngredient('H', Material.MANGROVE_LOG);
        WeatherCompassRecipe.setIngredient('I', Material.MUSHROOM_STEM);

        Bukkit.addRecipe(WeatherCompassRecipe);

        getServer().getPluginManager().registerEvents(new OnInventoryEvent(),this);
    }
}
