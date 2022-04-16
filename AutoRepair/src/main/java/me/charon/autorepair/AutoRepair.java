package me.charon.autorepair;

import me.charon.autorepair.commands.repair;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoRepair extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("[Auto Repair] Starting plugin ...");
        System.out.println("[Auto Repair] Plugin started!");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("repair").setExecutor(new repair());
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        Action action = e.getAction();
        if (player.hasPermission("ar.useAnvilRepair"))
            if ((block != null) && (action == Action.RIGHT_CLICK_BLOCK) && (block.getType() == Material.ANVIL)) {
                ItemStack item = player.getItemInHand();
                item.setDurability((short) 0);
                player.setItemInHand(item);
            }
        }
    @Override
    public void onDisable() {
        System.out.println("[Auto Repair] Stopping plugin ...");
        System.out.println("[Auto Repair] Plugin stopped!");
    }
}
