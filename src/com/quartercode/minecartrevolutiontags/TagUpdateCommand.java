
package com.quartercode.minecartrevolutiontags;

import com.quartercode.basiccommands.util.MinecartRevolutionUpdater;
import com.quartercode.minecartrevolution.command.MRCommandHandler;
import com.quartercode.minecartrevolution.get.Lang;
import com.quartercode.quarterbukkit.api.command.Command;
import com.quartercode.quarterbukkit.api.command.CommandInfo;

public class TagUpdateCommand extends MRCommandHandler {

    public TagUpdateCommand() {

    }

    @Override
    public CommandInfo createInfo() {

        return new CommandInfo(true, null, "Updates your MinecartRevolutionTags to the latest version", "minecartrevolutiontags.update", "tagupdate");
    }

    @Override
    public void execute(final Command command) {

        command.getSender().sendMessage(Lang.DEFAULT + "Updating MinecartRevolutionTags ...");
        command.getSender().sendMessage(Lang.DEFAULT + "Downloading ...");
        new MinecartRevolutionUpdater(minecartRevolution).tryInstall(command.getSender());
    }

}
