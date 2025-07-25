package net.hecco.desire.compat.blocks;

import net.hecco.desire.Desire;
import net.minecraft.block.WallBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatWallBlock extends WallBlock {
    public final String MODID;
    public CompatWallBlock(Settings settings, String modId) {
        super(settings);
        this.MODID = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return Desire.isModLoaded(MODID) || Desire.isDatagen();
    }
}
