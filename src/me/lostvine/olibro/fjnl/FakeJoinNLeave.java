package me.lostvine.olibro.fjnl;

import java.io.File;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FakeJoinNleave extends JavaPlugin
{
  public Logger logger = Logger.getLogger("Minecraft");
  public FakeJoinNleave plugin = this;

  public void onEnable() {
    saveConfig();
    setupConfig();
    this.logger.info(ChatColor.GREEN + "[FakeJoin'nLeave] v1.2 Has Been Enabled!");
  }

  public void onDisable() {
    this.logger.info(ChatColor.RED + "[FakeJoin'nLeave] v1.2 Has Been Disabled!");
  }

  private void setupConfig() {
    FileConfiguration config = getConfig();
    try {
      this.logger.info("[FakeJoin'nLeave] Setting Up Configuration File (config.yml)...");
      if (!new File(getDataFolder(), "RESET.FILE").exists());
      this.logger.info("[FakeJoin'nLeave] Reset File Not Found! Resetting Default Config Values!");
      config.set(Paths.PLUGIN_DIS.getPath(), Integer.valueOf(1));
      config.set("FakeJoinNleave.Plugin Disabled", "false");

      config.set(Paths.PERM_JOIN.getPath(), Integer.valueOf(1));

      config.set("fakejoinnleave.join Permission", "fakejoinnleave.fakejoin");

      config.set(Paths.PERM_LEAVE.getPath(), Integer.valueOf(1));
      config.set("fakejoinnleave.leave Permission", "fakejoinnleave.fakeleave");

      new File(getDataFolder(), "RESET.FILE").createNewFile();

      this.logger.info("[FakeJoin'nLeave] Configuration Loaded!");
      saveConfig();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    Player player = (Player)sender;
    if (player.hasPermission("fakejoinnleave.join"); 
      if(cmd.getName().equalsIgnoreCase("fakejoin"))) {
      Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + " has joined the game.");
    }

    if (cmd.getName().equalsIgnoreCase("fakeleave")) {
      if (player.hasPermission("fakejoinnleave.leave"));
      Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + " has left the game.");
    }
    return false;
  }
}