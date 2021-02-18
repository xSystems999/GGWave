package me.xsystems.ggwave;

import me.logicologist.ggwave.events.ChatEvent;
import me.logicologist.ggwave.utils.Config;
import me.logicologist.ggwave.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.olzie.olziecommand.OlzieCommand;
import xyz.olzie.olziecommand.framework.action.ActionType;

public class GGWave extends JavaPlugin {

    public void onEnable() {
        Utils.log("Registering Command Framework...");
        new OlzieCommand(this, GGWave.class)
                .getActionRegister()
                .registerAction(ActionType.PERMISSION, cmd -> {
                    Utils.message(cmd.getSender(), "&cThis command is only allowed to event administrators.");
                    return true;
                })
                .registerAction(ActionType.PLAYER, cmd -> {
                    Utils.message(cmd.getSender(), "&cThis command cannot be executed from console.");
                    return true;
                })
                .buildActions()
                .registerCommands();
        Utils.log("Registering Config File");
        new Config(this)
                .setup()
                .load();
        Utils.log("Registering Events");
        Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
    }
}
