package me.xsystems.ggwave.events;

import me.logicologist.ggwave.commands.GGWaveCommand;
import me.logicologist.ggwave.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        if (!GGWaveCommand.ggWaveEnabled) return;
        if (!event.getMessage().equalsIgnoreCase("gg")) return;
        event.setMessage(Utils.color("&" + Utils.getRandomCode() + "&lG&" + Utils.getRandomCode() + "&lG"));
    }
}
