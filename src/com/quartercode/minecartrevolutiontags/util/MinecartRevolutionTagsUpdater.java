
package com.quartercode.minecartrevolutiontags.util;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import com.quartercode.minecartrevolution.get.Lang;
import com.quartercode.minecartrevolutiontags.MinecartRevolutionTags;
import com.quartercode.quarterbukkit.QuarterBukkit;
import com.quartercode.quarterbukkit.api.Updater;
import com.quartercode.quarterbukkit.api.exception.InstallException;

public class MinecartRevolutionTagsUpdater extends Updater {

    public MinecartRevolutionTagsUpdater(final MinecartRevolutionTags minecartRevolutionTags) {

        super(minecartRevolutionTags, minecartRevolutionTags, "minecartrevolutiontags");
    }

    @Override
    protected String parseVersion(final String title) {

        return title.replaceAll("MinecartRevolutionTags ", "");
    }

    @Override
    protected void doInstall(final File downloadedFile, final CommandSender causer) throws IOException {

        if (causer != null) {
            causer.sendMessage(Lang.DEFAULT + "Successfully downloaded " + downloadedFile.getName() + "!");
            causer.sendMessage(Lang.getValue("Reloading " + updatePlugin.getName() + " ..."));
        } else {
            plugin.getLogger().info(Lang.DEFAULT + "Successfully downloaded " + downloadedFile.getName() + "!");
            plugin.getLogger().info(Lang.getValue("Reloading " + updatePlugin.getName() + " ..."));
        }

        try {
            Bukkit.getPluginManager().disablePlugin(plugin);
            Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().loadPlugin(new File("plugins", "MinecartRevolutionTags.jar")));
        }
        catch (final Exception e) {
            QuarterBukkit.exception(new InstallException(plugin, e, Lang.getValue("Error while reloading " + updatePlugin.getName() + ": " + e.getLocalizedMessage())));
            return;
        }

        if (causer != null) {
            causer.sendMessage(Lang.DEFAULT + "Successfully reloaded " + updatePlugin.getName() + "!");
            causer.sendMessage(Lang.DEFAULT + "Successfully updated " + updatePlugin.getName() + "!");
        } else {
            plugin.getLogger().info(Lang.DEFAULT + "Successfully reloaded " + updatePlugin.getName() + "!");
            plugin.getLogger().info(Lang.DEFAULT + "Successfully updated " + updatePlugin.getName() + "!");
        }
    }

}
