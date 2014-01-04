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
import com.quartercode.minecartrevolution.core.util.Direction;
import com.quartercode.minecartrevolution.core.util.cart.MinecartTerm;
import com.quartercode.minecartrevolutiontags.util.TagUtils;

public class TagMinecartTerm implements MinecartTerm {

    public TagMinecartTerm() {

    }

    @Override
    public String[] getLabels() {

        return new String[] { "t-.*", "tag-.*" };
    }

    @Override
    public boolean getResult(Minecart minecart, Direction direction, String term) {

        String tagTerm = term.split("-")[1];
        tagTerm = tagTerm.replaceAll("\\*", ".*");

        for (String tag : TagUtils.getTags(minecart)) {
            if (tag.matches(tagTerm)) {
                return true;
            }
        }

        return false;
    }

}
