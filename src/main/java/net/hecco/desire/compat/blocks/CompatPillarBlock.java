package net.hecco.desire.compat.blocks;

import net.hecco.desire.Desire;
import net.minecraft.block.PillarBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatPillarBlock extends PillarBlock {
    public final String MODID;
    public CompatPillarBlock(Settings settings, String modId) {
        super(settings);
        this.MODID = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return Desire.isModLoaded(MODID) || Desire.isDatagen();
    }
}
