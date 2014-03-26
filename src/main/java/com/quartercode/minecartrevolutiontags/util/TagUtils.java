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

package com.quartercode.minecartrevolutiontags.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.entity.Vehicle;
import com.quartercode.minecartrevolution.core.util.VehicleMetdataStorage;

public class TagUtils {

    private static VehicleMetdataStorage metadataStorage;

    public static void setMetadataStorage(VehicleMetdataStorage metadataStorage) {

        TagUtils.metadataStorage = metadataStorage;
    }

    public static Set<String> getTags(Vehicle vehicle) {

        if (metadataStorage.get(vehicle, "mrtags") != null) {
            return new HashSet<String>(Arrays.asList(metadataStorage.get(vehicle, "mrtags").split(",")));
        } else {
            return new HashSet<String>();
        }
    }

    public static void setTags(Vehicle vehicle, Set<String> tags) {

        if (tags.isEmpty()) {
            clearTags(vehicle);
        } else {
            StringBuilder tagString = new StringBuilder();
            for (String tag : tags) {
                tagString.append(",").append(tag);
            }
            metadataStorage.set(vehicle, "mrtags", tagString.substring(1));
        }
    }

    public static void addTag(Vehicle vehicle, String tag) {

        Set<String> tags = getTags(vehicle);
        tags.add(tag);
        setTags(vehicle, tags);
    }

    public static void removeTag(Vehicle vehicle, String tag) {

        Set<String> tags = getTags(vehicle);
        tags.remove(tag);
        setTags(vehicle, tags);
    }

    public static void clearTags(Vehicle vehicle) {

        metadataStorage.set(vehicle, "mrtags", null);
    }

    private TagUtils() {

    }

}
