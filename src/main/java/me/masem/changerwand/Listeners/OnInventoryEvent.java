package me.masem.changerwand.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.Material.*;

public class OnInventoryEvent implements Listener {

    private Inventory ChangeWeatherDisplay;
    private ItemStack item1, item2, item3, item4;
    private ItemMeta meta1, meta2, meta3;

    @EventHandler
    public void OnPlayerInteractEvent(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack HoldingItemMeta = player.getInventory().getItemInMainHand();
        Action action = event.getAction();

        if (action == Action.RIGHT_CLICK_AIR) {
            if (HoldingItemMeta.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Weather Changer Stick")) {

                ChangeWeatherDisplay = Bukkit.createInventory(null, 9, "Weather Changer Menu");

                item1 = new ItemStack(YELLOW_STAINED_GLASS);
                meta1 = item1.getItemMeta();

                meta1.setDisplayName(ChatColor.YELLOW + "Sunny Weather");
                ArrayList<String> lore1 = new ArrayList<>();
                lore1.add("Set the weather to sunny weather");
                item1.setItemMeta(meta1);

                item2 = new ItemStack(GRAY_STAINED_GLASS);
                meta2 = item2.getItemMeta();
                meta2.setDisplayName(ChatColor.GRAY + "Rain Weather");
                ArrayList<String> lore2 = new ArrayList<>();
                lore2.add("Set the weather to cloudy weather");
                item2.setItemMeta(meta2);


                item3 = new ItemStack(BLACK_STAINED_GLASS);
                meta3 = item3.getItemMeta();
                meta3.setDisplayName(ChatColor.BLACK + "Thunder Weather");
                ArrayList<String> lore3 = new ArrayList<>();
                lore3.add("Set the weather to Rainy weather");
                item3.setItemMeta(meta3);


                item4 = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

                ChangeWeatherDisplay.setItem(0, item4);
                ChangeWeatherDisplay.setItem(1, item4);
                ChangeWeatherDisplay.setItem(2, item1);
                ChangeWeatherDisplay.setItem(3, item4);
                ChangeWeatherDisplay.setItem(4, item2);
                ChangeWeatherDisplay.setItem(5, item4);
                ChangeWeatherDisplay.setItem(6, item3);
                ChangeWeatherDisplay.setItem(7, item4);
                ChangeWeatherDisplay.setItem(8, item4);

                player.openInventory(ChangeWeatherDisplay);
            }else {
                event.setCancelled(true);
            }
        }
    }
        @EventHandler
        private void OnPlayerClickInventory (InventoryClickEvent events){

            Player players = (Player) events.getWhoClicked();
            Inventory ClickedInventory = events.getClickedInventory();

            if(ClickedInventory.equals(ChangeWeatherDisplay)){
                if (events.getCurrentItem().getType() == YELLOW_STAINED_GLASS) {
                    players.closeInventory();
                    players.getWorld().setClearWeatherDuration(1200);
                    players.sendMessage("Clear Weather set");
                } else if (events.getCurrentItem().getType() == GRAY_STAINED_GLASS) {
                    players.closeInventory();
                    players.getWorld().setStorm(true);
                    players.sendMessage("Rain Weather Set");
                } else if (events.getCurrentItem().getType() == BLACK_STAINED_GLASS) {
                    players.closeInventory();
                    players.getWorld().setStorm(true);
                    players.getWorld().setThunderDuration(1200);
                    players.sendMessage("Thunder Weather Set");

                } else {
                    players.closeInventory();
                    players.sendMessage("Nothing Selected");
                    events.setCancelled(true);
                }
            }

        }
    }


