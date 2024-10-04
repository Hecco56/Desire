package net.hecco.desire.registry;

import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.hecco.desire.util.BlockSetMaker;

public class ModRegistries {
    public static void register() {
        registerOxidizables();
    }

    public static void registerOxidizables() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockSetMaker.BLOCK_SET_BLOCKS.get("copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"));
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockSetMaker.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"));
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockSetMaker.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetMaker.BLOCK_SET_BLOCKS.get("copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetMaker.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_exposed_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetMaker.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_weathered_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetMaker.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_oxidized_copper_pillar"));
    }
}
