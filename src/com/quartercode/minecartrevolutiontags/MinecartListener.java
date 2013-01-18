
package com.quartercode.minecartrevolutiontags;

import org.bukkit.Bukkit;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

public class MinecartListener implements Listener {

    private final MinecartRevolutionTags minecartRevolutionTags;

    public MinecartListener(final MinecartRevolutionTags minecartRevolutionTags) {

        this.minecartRevolutionTags = minecartRevolutionTags;
        Bukkit.getPluginManager().registerEvents(this, minecartRevolutionTags.getMinecartRevolution().getPlugin());
    }

    @EventHandler
    public void onVehicleDestroy(final VehicleDestroyEvent event) {

        if (event.getVehicle() instanceof Minecart) {
            minecartRevolutionTags.getTagManager().removeTags((Minecart) event.getVehicle());
        }
    }

}
