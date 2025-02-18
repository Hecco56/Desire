package net.hecco.desire.compat;

import net.hecco.desire.Desire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatBlock extends Block {
    public final String MODID;
    public CompatBlock(Settings settings, String modId) {
        super(settings);
        this.MODID = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return Desire.isModLoaded(MODID) || Desire.isDatagen();
    }
}
