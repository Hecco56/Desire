package net.hecco.desire.compat.blocks;

import net.hecco.desire.Desire;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class CompatBlockItem extends BlockItem {
    public final String MODID;
    public CompatBlockItem(Block block, Settings settings, String modId) {
        super(block, settings);
        this.MODID = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return Desire.isModLoaded(MODID) || Desire.isDatagen();
    }
}
