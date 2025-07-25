package net.hecco.desire.compat.natures_spirit;

import net.hecco.desire.Desire;
import net.hecco.desire.compat.blocks.*;
import net.hecco.desire.datagen.desire.ModBlockTagProvider;
import net.hecco.desire.datagen.desire.ModDatagenUtils;
import net.hecco.desire.oldutil.ModCompat;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NSModBlocks {
    public static final String MOD_ID = Desire.NATURES_SPIRIT;

    public static final List<String> WOOD_TYPES = List.of("aspen", "cedar", "cypress", "fir", "ghaf", "larch", "maple", "olive", "palo_verde", "redwood", "saxaul", "willow");
    public static final List<MapColor> WOOD_MAP_COLORS = List.of(MapColor.PALE_YELLOW, MapColor.GRAY, MapColor.OAK_TAN, MapColor.DIRT_BROWN, MapColor.BROWN, MapColor.LIGHT_GRAY, MapColor.ORANGE, MapColor.PALE_GREEN, MapColor.LICHEN_GREEN, MapColor.RED, MapColor.LIGHT_GRAY, MapColor.TERRACOTTA_BROWN);
    public static final List<String> PREV_ITEM = List.of("yellow_aspen_leaves", "cedar_sapling", "cypress_sapling", "fir_sapling", "ghaf_sapling", "larch_sapling", "yellow_maple_sapling", "olive_sapling", "palo_verde_sapling", "redwood_sapling", "saxaul_sapling", "willow_sapling");

    public static final Block KAOLIN_BRICK_WALL = registerBlock("kaolin_brick_wall", new CompatWallBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).instrument(Instrument.BASEDRUM).requiresTool().strength(1.25F, 4.2F), MOD_ID));
    public static final Map<DyeColor, Block> DYED_KAOLIN_BRICK_WALLS = new HashMap<>();

    public static final Block TRAVERTINE_WALL = registerBlock("travertine_wall", new CompatWallBlock(AbstractBlock.Settings.copy(Blocks.ANDESITE).mapColor(MapColor.LIGHT_GRAY).strength(1.5f), MOD_ID));
    public static final Block SMOOTH_PINK_SANDSTONE_WALL = registerBlock("smooth_pink_sandstone_wall", new CompatWallBlock(AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASEDRUM).requiresTool().strength(2.0F, 6.0F), MOD_ID));
    public static final Block CUT_PINK_SANDSTONE_STAIRS = registerBlock("cut_pink_sandstone_stairs", new CompatStairsBlock(Blocks.CUT_SANDSTONE.getDefaultState(), AbstractBlock.Settings.create().mapColor(MapColor.PALE_YELLOW).instrument(Instrument.BASEDRUM).requiresTool().strength(2.0F, 6.0F), MOD_ID));
    public static final Block CHISELED_TRAVERTINE_BRICKS = registerBlock("chiseled_travertine_bricks", new CompatBlock(AbstractBlock.Settings.copy(TRAVERTINE_WALL), MOD_ID));
    public static final Block CHISELED_CHERT_BRICKS = registerBlock("chiseled_chert_bricks", new CompatBlock(AbstractBlock.Settings.copy(Blocks.ANDESITE).mapColor(MapColor.OAK_TAN).strength(0.9f), MOD_ID));
    public static final Map<String, Block> WOOD_MOSAICS = new HashMap<>();
    public static final Map<String, Block> WOOD_MOSAIC_SLABS = new HashMap<>();
    public static final Map<String, Block> WOOD_MOSAIC_STAIRS = new HashMap<>();

    private static Block registerBlock(String name, Block block) {
        Block newBlock = Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, name), block);
        ModCompat.COMPAT_BLOCKS.put(Identifier.of(MOD_ID, name), newBlock);
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), new CompatBlockItem(block, new Item.Settings(), MOD_ID));
        return newBlock;
    }

    public static void register() {
        for (DyeColor color : ModDatagenUtils.VANILLA_COLORS.stream().map((color) -> DyeColor.byName(color, DyeColor.WHITE)).toList()) {
            DYED_KAOLIN_BRICK_WALLS.put(color, registerBlock(color.getName() + "_kaolin_brick_wall", new CompatWallBlock(AbstractBlock.Settings.copy(KAOLIN_BRICK_WALL).mapColor(color), MOD_ID)));
            BlockFamilyGenerator.PICKAXE_MINEABLE.add(DYED_KAOLIN_BRICK_WALLS.get(color));
            BlockFamilyGenerator.WALLS.add(DYED_KAOLIN_BRICK_WALLS.get(color));
            BlockFamilyGenerator.CUSTOM_WALL_MODEL.add(DYED_KAOLIN_BRICK_WALLS.get(color));
        }
        for (String wood : WOOD_TYPES) {
            WOOD_MOSAICS.put(wood, registerBlock(wood + "_mosaic", new CompatBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(WOOD_MAP_COLORS.get(WOOD_TYPES.indexOf(wood))), MOD_ID)));
            WOOD_MOSAIC_STAIRS.put(wood, registerBlock(wood + "_mosaic_stairs", new CompatStairsBlock(WOOD_MOSAICS.get(wood).getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(WOOD_MAP_COLORS.get(WOOD_TYPES.indexOf(wood))), MOD_ID)));
            WOOD_MOSAIC_SLABS.put(wood, registerBlock(wood + "_mosaic_slab", new CompatSlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(WOOD_MAP_COLORS.get(WOOD_TYPES.indexOf(wood))), MOD_ID)));
            BlockFamilyGenerator.AXE_MINEABLE.add(WOOD_MOSAICS.get(wood));
            BlockFamilyGenerator.AXE_MINEABLE.add(WOOD_MOSAIC_STAIRS.get(wood));
            BlockFamilyGenerator.AXE_MINEABLE.add(WOOD_MOSAIC_SLABS.get(wood));
            BlockFamilyGenerator.STAIRS.add(WOOD_MOSAIC_STAIRS.get(wood));
            BlockFamilyGenerator.SLABS.add(WOOD_MOSAIC_STAIRS.get(wood));
            BlockFamilyGenerator.CUSTOM_STAIRS_MODEL.add(WOOD_MOSAIC_STAIRS.get(wood));
            BlockFamilyGenerator.CUSTOM_SLAB_MODEL.add(WOOD_MOSAIC_STAIRS.get(wood));
        }
        BlockFamilyGenerator.PICKAXE_MINEABLE.add(KAOLIN_BRICK_WALL);
        BlockFamilyGenerator.WALLS.add(KAOLIN_BRICK_WALL);
        BlockFamilyGenerator.CUSTOM_WALL_MODEL.add(KAOLIN_BRICK_WALL);
        BlockFamilyGenerator.PICKAXE_MINEABLE.add(TRAVERTINE_WALL);
        BlockFamilyGenerator.WALLS.add(TRAVERTINE_WALL);
        BlockFamilyGenerator.CUSTOM_WALL_MODEL.add(TRAVERTINE_WALL);
        BlockFamilyGenerator.PICKAXE_MINEABLE.add(SMOOTH_PINK_SANDSTONE_WALL);
        BlockFamilyGenerator.WALLS.add(SMOOTH_PINK_SANDSTONE_WALL);
        BlockFamilyGenerator.CUSTOM_WALL_MODEL.add(SMOOTH_PINK_SANDSTONE_WALL);
        BlockFamilyGenerator.PICKAXE_MINEABLE.add(CUT_PINK_SANDSTONE_STAIRS);
        BlockFamilyGenerator.STAIRS.add(CUT_PINK_SANDSTONE_STAIRS);
        BlockFamilyGenerator.CUSTOM_STAIRS_MODEL.add(CUT_PINK_SANDSTONE_STAIRS);
        BlockFamilyGenerator.PICKAXE_MINEABLE.add(CHISELED_CHERT_BRICKS);
        BlockFamilyGenerator.PICKAXE_MINEABLE.add(CHISELED_TRAVERTINE_BRICKS);
    }
}
