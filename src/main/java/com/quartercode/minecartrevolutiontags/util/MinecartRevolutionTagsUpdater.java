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

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import com.quartercode.minecartrevolution.core.MinecartRevolution;
import com.quartercode.minecartrevolutiontags.MinecartRevolutionTags;
import com.quartercode.quarterbukkit.api.Updater;
import com.quartercode.quarterbukkit.api.exception.ExceptionHandler;
import com.quartercode.quarterbukkit.api.exception.InstallException;

public class MinecartRevolutionTagsUpdater extends Updater {

    public MinecartRevolutionTagsUpdater(MinecartRevolutionTags minecartRevolutionTags) {

        super(minecartRevolutionTags, minecartRevolutionTags, "minecartrevolutiontags");
    }

    @Override
    protected String parseVersion(String title) {

        return title.replaceAll("MinecartRevolutionTags ", "");
    }

    @Override
    protected boolean doInstall(File downloadedFile, CommandSender causer) throws IOException {

        try {
            Bukkit.getPluginManager().disablePlugin(plugin);
            Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().loadPlugin(new File("plugins", "MinecartRevolutionTags.jar")));
            return true;
        }
        catch (Exception e) {
            ExceptionHandler.exception(new InstallException(plugin, this, e, MinecartRevolution.getLang().get("basiccommands.update.error", "plugin", updatePlugin.getName(), "error", "Error while reloading: " + e.getLocalizedMessage())));
        }

        return false;
    }

}
