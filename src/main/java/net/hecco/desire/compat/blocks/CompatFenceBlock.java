package net.hecco.desire.compat.blocks;

import net.hecco.desire.Desire;
import net.minecraft.block.FenceBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatFenceBlock extends FenceBlock {
    public final String MODID;
    public CompatFenceBlock(Settings settings, String modId) {
        super(settings);
        this.MODID = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return Desire.isModLoaded(MODID) || Desire.isDatagen();
    }
}
