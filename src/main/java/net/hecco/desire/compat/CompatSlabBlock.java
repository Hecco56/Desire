package net.hecco.desire.compat;

import net.hecco.desire.Desire;
import net.minecraft.block.SlabBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatSlabBlock extends SlabBlock {
    public final String MODID;
    public CompatSlabBlock(Settings settings, String modId) {
        super(settings);
        this.MODID = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return Desire.isModLoaded(MODID) || Desire.isDatagen();
    }
}
