package com.quochungcyou.blockmmocore;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;



import net.Indyuce.mmocore.api.player.PlayerData;
import io.lumine.mythic.bukkit.BukkitAPIHelper;
import io.lumine.mythic.core.mobs.ActiveMob;

public class Main extends JavaPlugin implements Listener {
	
	
	    @Override
	    public void onEnable() {
	        System.out.println("[MMOCoreBlock] Loaded!");
	        getServer().getPluginManager().registerEvents(this, this);
	    }
	
	    @Override
	    public void onDisable() {
	    	System.out.println("[MMOCoreBlock] Disable!");
	    }
	
		 BukkitAPIHelper b = new BukkitAPIHelper();
	
	     @EventHandler
	     public void MMOCoreBlockHandler(EntityDamageByEntityEvent event) {
	    	 Entity target = event.getEntity();
	    	 Entity damager = event.getDamager();
	    	 ActiveMob damagermm = b.getMythicMobInstance(target);
	    	 int level = (int) damagermm.getLevel();
	    	 PlayerData player = PlayerData.get(damager.getUniqueId());
	    	 int levelpl = player.getLevel();
	    	 if (!b.isMythicMob(target)) return; //check mythicmob
	    	 if (damager.getType() != EntityType.PLAYER) return; //check damager is player
	    	 if (level - levelpl > 10) {
	    		 event.setDamage(0);
	    		 event.setCancelled(true);
	    	 }
	    	
	     }
	
}
