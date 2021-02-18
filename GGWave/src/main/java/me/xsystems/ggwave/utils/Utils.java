package me.xsystems.ggwave.utils;

import me.logicologist.ggwave.GGWave;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.Random;

public class Utils {

    public static String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void log(String s) {
        Bukkit.getConsoleSender().sendMessage("[" + getPlugin().getName() + "] " + s);
    }

    public static void message(CommandSender sender, String message) {
        if (message == null) return;
        if (message.isEmpty()) return;

        sender.sendMessage(color(message));
    }

    public static GGWave getPlugin() {
        return GGWave.getPlugin(GGWave.class);
    }

    public static String getRandomCode() {
        return "abcde".split("")[new Random().nextInt(5)];
    }

}
