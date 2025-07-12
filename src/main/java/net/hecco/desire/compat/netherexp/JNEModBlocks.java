package net.hecco.desire.compat.netherexp;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.CompatBlock;
import net.hecco.desire.compat.CompatBlockItem;
import net.hecco.desire.compat.CompatSlabBlock;
import net.hecco.desire.compat.CompatStairsBlock;
import net.hecco.desire.datagen.desire.ModBlockTagProvider;
import net.hecco.desire.datagen.desire.ModDatagenUtils;
import net.hecco.desire.oldutil.ModCompat;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JNEModBlocks {
    public static final String MOD_ID = Desire.JADENS_NETHER_EXPANSION;

    public static final Block CLARET_MOSAIC = registerBlock("claret_mosaic", new CompatBlock(FabricBlockSettings.copy(Blocks.WARPED_PLANKS).mapColor(MapColor.DARK_RED), MOD_ID));
    public static final Block CLARET_MOSAIC_STAIRS = registerBlock("claret_mosaic_stairs", new CompatStairsBlock(CLARET_MOSAIC.getDefaultState(), FabricBlockSettings.copy(Blocks.WARPED_PLANKS).mapColor(MapColor.DARK_RED), MOD_ID));
    public static final Block CLARET_MOSAIC_SLAB = registerBlock("claret_mosaic_slab", new CompatSlabBlock(FabricBlockSettings.copy(Blocks.WARPED_PLANKS).mapColor(MapColor.DARK_RED), MOD_ID));
    public static final Block POLISHED_NETHER_BRICKS = registerBlock("polished_nether_bricks", new CompatBlock(FabricBlockSettings.copy(Blocks.NETHER_BRICKS), MOD_ID));
    public static final Block POLISHED_RED_NETHER_BRICKS = registerBlock("polished_red_nether_bricks", new CompatBlock(FabricBlockSettings.copy(Blocks.RED_NETHER_BRICKS), MOD_ID));
    public static final Block POLISHED_BLUE_NETHER_BRICKS = registerBlock("polished_blue_nether_bricks", new CompatBlock(FabricBlockSettings.copy(Blocks.RED_NETHER_BRICKS).mapColor(MapColor.BRIGHT_TEAL), MOD_ID));
    public static final Block CRACKED_RED_NETHER_BRICKS = registerBlock("cracked_red_nether_bricks", new CompatBlock(FabricBlockSettings.copy(Blocks.RED_NETHER_BRICKS), MOD_ID));
    public static final Block CRACKED_BLUE_NETHER_BRICKS = registerBlock("cracked_blue_nether_bricks", new CompatBlock(FabricBlockSettings.copy(Blocks.RED_NETHER_BRICKS).mapColor(MapColor.BRIGHT_TEAL), MOD_ID));
    public static final Block CHISELED_RED_NETHER_BRICKS = registerBlock("chiseled_red_nether_bricks", new CompatBlock(FabricBlockSettings.copy(Blocks.RED_NETHER_BRICKS), MOD_ID));
    public static final Block CHISELED_BLUE_NETHER_BRICKS = registerBlock("chiseled_blue_nether_bricks", new CompatBlock(FabricBlockSettings.copy(Blocks.RED_NETHER_BRICKS).mapColor(MapColor.BRIGHT_TEAL), MOD_ID));

    private static Block registerBlock(String name, Block block) {
        Block newBlock = Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
        ModCompat.COMPAT_BLOCKS.put(Identifier.of(MOD_ID, name), newBlock);
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), new CompatBlockItem(block, new Item.Settings(), MOD_ID));
        return newBlock;
    }

    public static void register() {
        ModBlockTagProvider.AXE_MINEABLE.add(CLARET_MOSAIC);
        ModBlockTagProvider.AXE_MINEABLE.add(CLARET_MOSAIC_STAIRS);
        ModBlockTagProvider.AXE_MINEABLE.add(CLARET_MOSAIC_SLAB);
        ModBlockTagProvider.STAIRS.add(CLARET_MOSAIC_STAIRS);
        ModBlockTagProvider.SLABS.add(CLARET_MOSAIC_SLAB);
        ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(CLARET_MOSAIC_STAIRS, CLARET_MOSAIC);
        ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(CLARET_MOSAIC_SLAB, CLARET_MOSAIC);
    }
}
