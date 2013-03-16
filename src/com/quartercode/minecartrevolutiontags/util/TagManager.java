
package com.quartercode.minecartrevolutiontags.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.entity.Minecart;
import com.quartercode.minecartrevolution.exception.MinecartRevolutionException;
import com.quartercode.minecartrevolution.exception.MinecartRevolutionSilenceException;
import com.quartercode.minecartrevolutiontags.MinecartRevolutionTags;
import com.quartercode.qcutil.io.Properties;
import com.quartercode.quarterbukkit.api.exception.ExceptionHandler;

public class TagManager {

    private final MinecartRevolutionTags minecartRevolutionTags;
    private final Properties             tags;

    public TagManager(final MinecartRevolutionTags minecartRevolutionTags) {

        this.minecartRevolutionTags = minecartRevolutionTags;

        tags = new Properties();

        if (minecartRevolutionTags.getTagFile().exists()) {
            try {
                tags.load(minecartRevolutionTags.getTagFile());
            }
            catch (final IOException e) {
                ExceptionHandler.exception(new MinecartRevolutionSilenceException(minecartRevolutionTags.getMinecartRevolution(), e, "Can't load tag file!"));
                save();
            }
        } else {
            save();
        }
    }

    private String getKey(final Minecart minecart) {

        return String.valueOf(minecart.getEntityId());
    }

    public List<String> getTags(final Minecart minecart) {

        if (tags.keySet().contains(getKey(minecart))) {
            final String data = tags.getProperty(getKey(minecart));
            if (data.contains(",")) {
                return new ArrayList<String>(Arrays.asList(data.split(",")));
            } else {
                return new ArrayList<String>(Arrays.asList(data));
            }
        } else {
            return new ArrayList<String>();
        }
    }

    public void setTags(final Minecart minecart, final List<String> tags) {

        removeTags(minecart);

        String tagString = "";
        for (final String tag : tags) {
            tagString += tag + ",";
        }
        tagString = tagString.substring(0, tagString.length() - 1);
        this.tags.setProperty(getKey(minecart), tagString);

        save();
    }

    public void addTag(final Minecart minecart, final String tag) {

        final List<String> tags = getTags(minecart);
        tags.add(tag);
        setTags(minecart, tags);
    }

    public void removeTag(final Minecart minecart, final String tag) {

        final List<String> tags = getTags(minecart);
        tags.remove(tag);
        setTags(minecart, tags);
    }

    public void removeTags(final Minecart minecart) {

        tags.remove(getKey(minecart));

        save();
    }

    private void save() {

        try {
            tags.store(minecartRevolutionTags.getTagFile(), "Tag Store File", "Do not edit!");
        }
        catch (final IOException e) {
            ExceptionHandler.exception(new MinecartRevolutionException(minecartRevolutionTags.getMinecartRevolution(), e, "Can't save tag file!"));
        }
    }

}
