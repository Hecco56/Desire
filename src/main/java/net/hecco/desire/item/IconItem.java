package net.hecco.desire.item;

import net.minecraft.item.Item;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class IconItem extends Item {
    public IconItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return false;
    }
}
