package net.hecco.desire.compat.blocks;

import net.hecco.desire.Desire;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.resource.featuretoggle.FeatureSet;

import java.util.List;

public class CompatFenceBlock extends FenceBlock {
    public final List<String> MODIDS;
    public CompatFenceBlock(Settings settings, String modId) {
        super(settings);
        this.MODIDS = List.of(modId);
    }
    public CompatFenceBlock(AbstractBlock.Settings settings, List<String> modIds) {
        super(settings);
        this.MODIDS = modIds;
    }
    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return MODIDS.stream().allMatch(Desire::isModLoaded) || Desire.isDatagen();
    }
}
