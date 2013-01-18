
package com.quartercode.minecartrevolutiontags;

import org.bukkit.entity.Minecart;
import com.quartercode.basicexpression.util.Direction;
import com.quartercode.basicexpression.util.MinecartTerm;

public class TagMinecartTerm implements MinecartTerm {

    private final MinecartRevolutionTags minecartRevolutionTags;

    public TagMinecartTerm(final MinecartRevolutionTags minecartRevolutionTags) {

        this.minecartRevolutionTags = minecartRevolutionTags;
    }

    @Override
    public String[] getLabels() {

        return new String[] { "t-.*", "tag-.*" };
    }

    @Override
    public boolean getResult(final Minecart minecart, final Direction direction, final String term) {

        final TagManager tagManager = minecartRevolutionTags.getTagManager();

        String tagTerm = term.split("-")[1];
        tagTerm = tagTerm.replaceAll("\\*", ".*");
        final boolean negate = tagTerm.startsWith("!");
        if (negate) {
            tagTerm = tagTerm.replace("!", "");
        }

        for (final String tag : tagManager.getTags(minecart)) {
            if (tag.matches(tagTerm)) {
                return negate ? false : true;
            }
        }

        return negate ? true : false;
    }

}
