package at.fr3shlama.randomdrops;

import java.util.Arrays;
import java.util.Random;
import java.util.List;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {

	@EventHandler 
	public void onBlockBreak(BlockBreakEvent event) {
		
		//removes the drop
		event.setCancelled(true);
		event.getPlayer()
			 .getWorld()
			 .getBlockAt(event.getBlock()
			 .getLocation())
			 .setType(Material.AIR);
		
		Player p = event.getPlayer();
		World  w = p.getWorld();
		Location l = event.getBlock().getState().getLocation();
		
		//spawns in random item
		Random random = new Random();
		List<Material> materials = Arrays.asList(Material.values());
		Material randomMat = materials.get(random.nextInt(materials.size()));
		
		w.dropItemNaturally(l, new ItemStack(randomMat));
	}
	
}

