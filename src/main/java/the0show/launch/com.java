package the0show.launch;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class com extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if (cmd.getName().equalsIgnoreCase("launch") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("launch.use")){
                if (args.length == 0) {
                    // /launch
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Zooooooom!");
                    player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));

                    return true;
                }
                // /launch <number>
                if(isNum(args[0])) {
                    if (Integer.parseInt(args[0]) >= 1001) {
                        player.sendMessage(ChatColor.RED + "Sorry, but there is a limit of 1000 to make sure the server doesn't crash.");
                    }
                    else {
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Zooooooom!");
                        player.setVelocity(player.getLocation().getDirection().multiply(Integer.parseInt((args[0]))).setY(2));
                    }

                }
                else {
                    player.sendMessage(ChatColor.RED + "Usage: /launch <number-value>");
                }

                return true;
            }
            else {
                player.sendMessage(ChatColor.RED + "You cannot use this!");
            }

        }

        if (cmd.getName().equalsIgnoreCase("lch") && sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("launch.use")) {
                if (args.length == 0) {
                    // /launch
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Zooooooom!");
                    player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));

                    return true;
                }
                // /launch <number>
                if (isNum(args[0])) {
                    if (Integer.parseInt(args[0]) >= 1001) {
                        player.sendMessage(ChatColor.RED + "Sorry, but there is a limit of 1000 to make sure the server doesn't crash.");
                    } else {
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Zooooooom!");
                        player.setVelocity(player.getLocation().getDirection().multiply(Integer.parseInt((args[0]))).setY(2));
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Usage: /lch <number-value>");
                }
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "You cannot use this!");
            }
        }

        return false;
    }

    public boolean isNum(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
