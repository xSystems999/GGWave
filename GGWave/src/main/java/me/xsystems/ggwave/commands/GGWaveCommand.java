package me.xsystems.ggwave.commands;

import me.logicologist.ggwave.utils.Config;
import me.logicologist.ggwave.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.olzie.olziecommand.framework.CommandExecutor;
import xyz.olzie.olziecommand.framework.FrameworkCommand;

import java.util.Random;

public class GGWaveCommand extends FrameworkCommand {

    private int ggCode = -1;
    public static boolean ggWaveEnabled = false;

    public GGWaveCommand() {
        super("ggwave");
        this.setPermissions("ggwave.use");
    }

    @Override
    public void onExecute(CommandExecutor cmd) {
        String[] args = cmd.getArguments();
        if (args.length == 0) {
            Utils.message(cmd.getSender(), "&c/ggwave <seconds>");
            return;
        }
        int duration;
        try {
            duration = Integer.parseInt(args[0]);
        } catch (NumberFormatException ex) {
            Utils.message(cmd.getSender(), "&cYou did not type in a number.");
            return;
        }
        Utils.message(cmd.getSender(), "&aYou have started a GG Wave for " + duration + " seconds.");
        int generatedGGCode = new Random().nextInt(1000000);
        this.ggCode = generatedGGCode;
        if (!ggWaveEnabled) {
            Bukkit.broadcastMessage(Utils.color(Config.getInstance().getGGWaveStart()));
        }
        ggWaveEnabled = true;
        new BukkitRunnable() {
            @Override
            public void run() {
                if (ggCode == generatedGGCode) {
                    ggWaveEnabled = false;
                    Bukkit.broadcastMessage(Utils.color(Config.getInstance().getGgWaveEnd()));
                }
            }
        }.runTaskLater(Utils.getPlugin(), duration * 20);
    }
}
