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

import org.bukkit.block.Sign;
import org.bukkit.entity.Minecart;
import com.quartercode.minecartrevolution.core.control.sign.ControlSign;
import com.quartercode.minecartrevolution.core.control.sign.ControlSignInfo;

public class TagSign extends ControlSign {

    public TagSign() {

    }

    @Override
    protected ControlSignInfo createInfo() {

        return new ControlSignInfo("Tag", "Adds or removes minecart tags", "tag.place", "tag.destroy", "tag");
    }

    @Override
    public void execute(Minecart minecart, String label, Sign sign) {

        executeExpression(minecart, "tag " + sign.getLine(1));
    }

}
