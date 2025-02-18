package net.hecco.desire.compat;

import net.hecco.desire.Desire;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatStairsBlock extends StairsBlock {
    public final String MODID;
    public CompatStairsBlock(BlockState baseBlockState, Settings settings, String modId) {
        super(baseBlockState, settings);
        this.MODID = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return Desire.isModLoaded(MODID) || Desire.isDatagen();
    }
}
