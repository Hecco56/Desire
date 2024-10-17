package net.hecco.desire.registry;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.hecco.desire.datagen.ModDatagenUtils;
import net.hecco.desire.util.BlockSetGenerator;
import net.minecraft.block.Block;

public class ModRegistries {
    public static void register() {
        registerOxidizables();
        registerFlammables();
    }

    public static void registerOxidizables() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"));
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"));
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_exposed_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_weathered_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_oxidized_copper_pillar"));
    }

    public static void registerFlammables() {
        for (String name : BlockSetGenerator.WoodVariantsBlockMaker.WOOD_TYPES) {
            FlammableBlockRegistry.getDefaultInstance().add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_mosaic"), 5, 20);
            FlammableBlockRegistry.getDefaultInstance().add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_mosaic_stairs"), 5, 20);
            FlammableBlockRegistry.getDefaultInstance().add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_mosaic_slab"), 5, 20);
        }
    }
}
