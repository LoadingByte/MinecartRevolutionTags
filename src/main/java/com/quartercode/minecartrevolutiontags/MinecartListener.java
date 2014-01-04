/*
 * This file is part of MinecartRevolutionTags.
 * Copyright (c) 2013 QuarterCode <http://www.quartercode.com/>
 *
 * MinecartRevolutionTags is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MinecartRevolutionTags is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MinecartRevolutionTags. If not, see <http://www.gnu.org/licenses/>.
 */

package com.quartercode.minecartrevolutiontags;

import org.bukkit.Bukkit;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;

public class MinecartListener implements Listener {

    private final MinecartRevolutionTags minecartRevolutionTags;

    public MinecartListener(MinecartRevolutionTags minecartRevolutionTags) {

        this.minecartRevolutionTags = minecartRevolutionTags;
        Bukkit.getPluginManager().registerEvents(this, minecartRevolutionTags.getMinecartRevolution().getPlugin());
    }

    @EventHandler
    public void onVehicleDestroy(VehicleDestroyEvent event) {

        if (event.getVehicle() instanceof Minecart) {
            minecartRevolutionTags.getTagManager().removeTags((Minecart) event.getVehicle());
        }
    }

}
