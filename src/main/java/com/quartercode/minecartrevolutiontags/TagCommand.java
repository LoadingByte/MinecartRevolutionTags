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

import org.bukkit.entity.Minecart;
import com.quartercode.minecartrevolution.core.expression.ExpressionCommand;
import com.quartercode.minecartrevolution.core.expression.ExpressionCommandInfo;
import com.quartercode.minecartrevolution.core.expression.TypeArray;
import com.quartercode.minecartrevolution.core.expression.TypeArray.Type;

public class TagCommand extends ExpressionCommand {

    private final MinecartRevolutionTags minecartRevolutionTags;

    public TagCommand(MinecartRevolutionTags minecartRevolutionTags) {

        this.minecartRevolutionTags = minecartRevolutionTags;
    }

    @Override
    protected ExpressionCommandInfo createInfo() {

        return new ExpressionCommandInfo(new TypeArray(Type.STRING), "ta", "tag");
    }

    @Override
    public boolean canExecute(Minecart minecart) {

        return true;
    }

    @Override
    public void execute(Minecart minecart, Object parameter) {

        String data = String.valueOf(parameter);

        if (String.valueOf(parameter).startsWith("+")) {
            minecartRevolutionTags.getTagManager().addTag(minecart, data.replaceAll("\\+", "").trim());
        } else if (String.valueOf(parameter).startsWith("-")) {
            if (data.replaceAll("-", "").trim().isEmpty()) {
                minecartRevolutionTags.getTagManager().removeTags(minecart);
            } else {
                minecartRevolutionTags.getTagManager().removeTag(minecart, data.replaceAll("-", "").trim());
            }
        } else {
            minecartRevolutionTags.getTagManager().addTag(minecart, data.trim());
        }
    }

}
