package at.fr3shlama.randomdrops;

import java.util.Arrays;
import java.util.Random;
import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;


public class MobKillListener implements Listener {
	
	Random random = new Random();
	
	@EventHandler 
	public void onMobKill(EntityDeathEvent event) {
		
	    Location l = event.getEntity().getLocation();
	    World w = l.getWorld();
	    
	    //removes item drop
		event.getDrops().clear();
	    
		//generates random item and drops it
		List<Material> materials = Arrays.asList(Material.values());
		Material randomMat = materials.get(random.nextInt(materials.size()));
		
		while (randomMat.isBlock() || randomMat.equals(Material.AIR)){
			randomMat = materials.get(random.nextInt(materials.size()));
		}
		
		w.dropItemNaturally(l, new ItemStack(randomMat));
	}
	
}
