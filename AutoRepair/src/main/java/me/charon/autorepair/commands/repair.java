package me.charon.autorepair.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class repair implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("repair")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("ar.Repair")){
                    ItemStack item = player.getItemInHand();
                    item.setDurability((short) 0);
                    player.setItemInHand(item);
                }
            } else {
                System.out.println("[AutoRepair] You have to run this command as player!");
            }
        }
        return false;
    }
}
