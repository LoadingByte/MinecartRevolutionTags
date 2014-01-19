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

import com.quartercode.minecartrevolution.core.plugin.BukkitMinecartRevolutionPlugin;
import com.quartercode.minecartrevolution.core.plugin.PluginInfo;
import com.quartercode.minecartrevolutiontags.util.MinecartRevolutionTagsUpdater;
import com.quartercode.minecartrevolutiontags.util.TagUtils;

public class MinecartRevolutionTags extends BukkitMinecartRevolutionPlugin {

    public MinecartRevolutionTags() {

        super();
    }

    @Override
    public PluginInfo getInfo() {

        return new PluginInfo("MinecartRevolutionTags");
    }

    @Override
    public void enable() {

        // QuarterBukkit is loaded by MinecartRevolution

        TagUtils.setMetadataStorage(getMetdataStorage());

        addExpressionCommand(new TagCommand());
        addControlSign(new TagSign());

        addMinecartTerm(new TagMinecartTerm());

        addUpdater(new MinecartRevolutionTagsUpdater(this));
    }

}
