package net.hecco.desire.compat.blocks;

import net.hecco.desire.Desire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

import java.util.function.Supplier;

public class CompatStairsBlock extends StairsBlock {
    public final String MODID;

    public CompatStairsBlock(Block base, Settings settings, String modId) {
        super(base.getDefaultState(), settings);
        this.MODID = modId;
    }


    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return Desire.isModLoaded(MODID) || Desire.isDatagen();
    }
}
