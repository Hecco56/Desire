package net.hecco.desire.compat.netherexp;

import net.hecco.desire.Desire;
import net.minecraft.block.*;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class CompatNetherBrickFenceGateBlock extends FenceGateBlock {
    public final String MODID;

    public static final WoodType NETHER_BRICK = new WoodType("nether_brick", new BlockSetType("nether_brick"), BlockSoundGroup.NETHER_BRICKS, BlockSoundGroup.NETHER_BRICKS, SoundEvents.BLOCK_NETHER_BRICKS_PLACE, SoundEvents.BLOCK_NETHER_BRICKS_PLACE);

    public CompatNetherBrickFenceGateBlock(Settings settings, String modId) {
        super(NETHER_BRICK, settings);
        this.MODID = modId;
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return Desire.isModLoaded(MODID) || Desire.isDatagen();
    }
}
