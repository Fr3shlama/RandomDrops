package at.fr3shlama.randomdrops;

import org.bukkit.craftbukkit.libs.jline.internal.Log;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
    public void onEnable() {
		getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        Log.info("Enabled RandomDrops");
    }

    @Override
    public void onDisable() {
    	Log.info("Disabled RandomDrops. Goodbye");
    }
    

}
