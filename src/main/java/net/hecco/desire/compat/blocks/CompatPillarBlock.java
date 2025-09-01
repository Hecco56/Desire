package net.hecco.desire.compat.blocks;

import net.hecco.desire.Desire;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.PillarBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

import java.util.List;

public class CompatPillarBlock extends PillarBlock {
    public final List<String> MODIDS;
    public CompatPillarBlock(Settings settings, String modId) {
        super(settings);
        this.MODIDS = List.of(modId);
    }
    public CompatPillarBlock(AbstractBlock.Settings settings, List<String> modIds) {
        super(settings);
        this.MODIDS = modIds;
    }
    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return MODIDS.stream().allMatch(Desire::isModLoaded) || Desire.isDatagen();
    }
}
