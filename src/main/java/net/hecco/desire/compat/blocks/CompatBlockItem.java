package net.hecco.desire.compat.blocks;

import net.hecco.desire.Desire;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.resource.featuretoggle.FeatureSet;

import java.util.List;

public class CompatBlockItem extends BlockItem {
    public final List<String> MODIDS;
    public CompatBlockItem(Block block, Item.Settings settings, String modId) {
        super(block, settings);
        this.MODIDS = List.of(modId);
    }
    public CompatBlockItem(Block block, Item.Settings settings, List<String> modIds) {
        super(block, settings);
        this.MODIDS = modIds;
    }
    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return MODIDS.stream().allMatch(Desire::isModLoaded) || Desire.isDatagen();
    }
}
