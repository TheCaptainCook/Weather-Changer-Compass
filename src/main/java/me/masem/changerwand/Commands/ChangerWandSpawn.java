package me.masem.changerwand.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ChangerWandSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Inventory inventory = player.getInventory();

        if (sender instanceof Player){

            ItemStack WeatherWand = new ItemStack(Material.RECOVERY_COMPASS);
            ItemMeta WeatherWandDetails = WeatherWand.getItemMeta();

            WeatherWandDetails.setDisplayName(ChatColor.AQUA + "Weather Changer Stick");
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
            inventory.addItem(WeatherWand);
        }
        return true;
    }
}
