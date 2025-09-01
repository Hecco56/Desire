package net.hecco.desire.compat.netherexp;

import net.hecco.desire.Desire;
import net.hecco.desire.compat.blocks.CompatFenceBlock;
import net.minecraft.block.*;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

import java.util.List;

public class CompatNetherBrickFenceGateBlock extends FenceGateBlock {

    public static final WoodType NETHER_BRICK = new WoodType("nether_brick", new BlockSetType("nether_brick"), BlockSoundGroup.NETHER_BRICKS, BlockSoundGroup.NETHER_BRICKS, SoundEvents.BLOCK_NETHER_BRICKS_PLACE, SoundEvents.BLOCK_NETHER_BRICKS_PLACE);

    public final List<String> MODIDS;

    public CompatNetherBrickFenceGateBlock(Settings settings, String modId) {
        super(NETHER_BRICK, settings);
        this.MODIDS = List.of(modId);
    }
    public CompatNetherBrickFenceGateBlock(AbstractBlock.Settings settings, List<String> modIds) {
        super(NETHER_BRICK, settings);
        this.MODIDS = modIds;
    }
    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return MODIDS.stream().allMatch(Desire::isModLoaded) || Desire.isDatagen();
    }
}
