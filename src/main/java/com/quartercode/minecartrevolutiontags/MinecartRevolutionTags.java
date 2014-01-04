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

import java.io.File;
import com.quartercode.minecartrevolution.core.plugin.BukkitMinecartRevolutionPlugin;
import com.quartercode.minecartrevolution.core.plugin.PluginInfo;
import com.quartercode.minecartrevolutiontags.util.MinecartRevolutionTagsUpdater;
import com.quartercode.minecartrevolutiontags.util.TagManager;
import com.quartercode.quarterbukkit.api.scheduler.ScheduleTask;

public class MinecartRevolutionTags extends BukkitMinecartRevolutionPlugin {

    private File       tagFile;
    private TagManager tagManager;

    public MinecartRevolutionTags() {

        super();
    }

    @Override
    public PluginInfo getInfo() {

        return new PluginInfo("MinecartRevolutionTags");
    }

    public File getTagFile() {

        return tagFile;
    }

    public TagManager getTagManager() {

        return tagManager;
    }

    @Override
    public void enable() {

        // Don't worry about QuarterBukkit; it's loaded by MinecartRevolution

        new MinecartListener(this);

        tagFile = new File(getPluginFolder(), "tags.properties");
        tagManager = new TagManager(this);

        addExpressionCommand(new TagCommand(this));
        addControlSign(new TagSign());

        addMinecartTerm(new TagMinecartTerm(this));

        addUpdater(new MinecartRevolutionTagsUpdater(this));

        // Schedule task for saving tags every 10 minutes
        new ScheduleTask(this) {

            @Override
            public void run() {

                tagManager.save();
            }
        }.run(true, 10 * 60 * 1000, 10 * 60 * 1000);
    }

    @Override
    public void onDisable() {

        tagManager.save();
    }

}
