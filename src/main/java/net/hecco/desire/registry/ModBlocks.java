package net.hecco.desire.registry;

import net.hecco.desire.Desire;
import net.hecco.desire.block.OxidizablePillarBlock;
import net.hecco.desire.block.PlaceableRockBlock;
import net.hecco.desire.datagen.ModDatagenUtils;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block STONE_BOULDER = register("stone_boulder", new PlaceableRockBlock(AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.STONE_GRAY).requiresTool().strength(1.0F, 2.0F)));
    public static final Block DEEPSLATE_SHEET = register("deepslate_sheet", new PlaceableRockBlock(AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.DEEPSLATE_GRAY).sounds(BlockSoundGroup.DEEPSLATE).requiresTool().strength(1.5F, 2.0F)));
    public static final Block BLACKSTONE_CHUNK = register("blackstone_chunk", new PlaceableRockBlock(AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.BLACK).requiresTool().strength(1.0F, 2.0F)));

    private static Block register(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Desire.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, Identifier.of(Desire.MOD_ID, name), block);
    }
    public static void register() {
        BlockSetMaker.BlockSetExtension STONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.STONE, AbstractBlock.Settings.copy(Blocks.STONE), "stone", false, false, true, false, false, true, false);
        BlockSetMaker.BlockSetExtension POLISHED_ANDESITE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.POLISHED_ANDESITE, AbstractBlock.Settings.copy(Blocks.POLISHED_ANDESITE), "polished_andesite", false, false, true, true, false,false, false);
        BlockSetMaker.BlockSetExtension POLISHED_GRANITE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.POLISHED_GRANITE, AbstractBlock.Settings.copy(Blocks.POLISHED_GRANITE), "polished_granite", false, false, true, true, false,false, false);
        BlockSetMaker.BlockSetExtension POLISHED_DIORITE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.POLISHED_DIORITE, AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE), "polished_diorite", false, false, true, true, false,false, false);

        BlockSetMaker.BlockSetExtension SMOOTH_SANDSTONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.SMOOTH_SANDSTONE, AbstractBlock.Settings.copy(Blocks.SMOOTH_SANDSTONE), "smooth_sandstone", false, false, true, false, false,false, false);
        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_sandstone_wall"));

        BlockSetMaker.BlockSetExtension SMOOTH_RED_SANDSTONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.SMOOTH_RED_SANDSTONE, AbstractBlock.Settings.copy(Blocks.SMOOTH_RED_SANDSTONE), "smooth_red_sandstone", false, false, true, false, false,false, false);
        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_red_sandstone_wall"));

        BlockSetMaker.BlockSetExtension SMOOTH_QUARTZ_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.SMOOTH_QUARTZ, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ), "smooth_quartz", false, false, true, false, false,false, false);
        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_quartz_wall"));

        BlockSetMaker.BlockSetExtension DARK_PRISMARINE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.DARK_PRISMARINE, AbstractBlock.Settings.copy(Blocks.DARK_PRISMARINE), "dark_prismarine", false, false, true, false, false,false, false);
        BlockSetMaker.BlockSetExtension PRISMARINE_BRICK_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.PRISMARINE_BRICKS, AbstractBlock.Settings.copy(Blocks.PRISMARINE_BRICKS), "prismarine_brick", false, false, true, false, false,false, false);

        BlockSetMaker.BlockSetExtension SMOOTH_STONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.SMOOTH_STONE, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE), "smooth_stone", true, false, false, false, false,false, false);
        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_stairs"));

        BlockSetMaker.BlockSetExtension CUT_SANDSTONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.CUT_SANDSTONE, AbstractBlock.Settings.copy(Blocks.CUT_SANDSTONE), "cut_sandstone", true, false, false, false, false,false, false);
        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cut_sandstone_stairs"));

        BlockSetMaker.BlockSetExtension CUT_RED_SANDSTONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.CUT_RED_SANDSTONE, AbstractBlock.Settings.copy(Blocks.CUT_RED_SANDSTONE), "cut_red_sandstone", true, false, false, false, false,false, false);
        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cut_red_sandstone_stairs"));

        BlockSetMaker.BlockSetExtension SMOOTH_BASALT_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.SMOOTH_BASALT, AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT), "smooth_basalt", true, true, true,false, false, false, false);
        BlockSetMaker.BlockSetExtension QUARTZ_BRICK_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.QUARTZ_BRICKS, AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS), "quartz_brick", true, true, true, false, false,false, false);
        BlockSetMaker.BlockSetExtension CALCITE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.CALCITE, AbstractBlock.Settings.copy(Blocks.CALCITE), "calcite", true, true, true, false, false,false, false);



        BlockSetMaker.StoneBlockSetMaker COBBLESTONE_BRICKS = new BlockSetMaker.StoneBlockSetMaker("", "cobblestone", AbstractBlock.Settings.copy(Blocks.COBBLESTONE),
                false, false, false, false, false, false, false, false, false,
                true,
                true,
                true,
                true,
                false, false, false, false, false, false, false, false
        );
        BlockSetMaker.StoneBlockSetMaker MOSSY_COBBLESTONE_BRICKS = new BlockSetMaker.StoneBlockSetMaker("", "mossy_cobblestone", AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE),
                false, false, false, false, false, false, false, false, false,
                true,
                true,
                true,
                true,
                false, false, false, false, false, false, false, false
        );
        BlockSetMaker.StoneBlockSetMaker SMOOTH_STONE_BRICKS = new BlockSetMaker.StoneBlockSetMaker("", "smooth_stone", AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE),
                false, false, false, false, false, false, false, false, false,
                true,
                true,
                true,
                true,
                false, false, false, false, false, false, false, false
        );
        BlockSetMaker.StoneBlockSetMaker STONE_VARIANTS = new BlockSetMaker.StoneBlockSetMaker("", "stone", AbstractBlock.Settings.copy(Blocks.STONE_BRICKS),
                false, false, false, false,
                true,
                true,
                true,
                true,
                false, false, false, false, false, false, false,
                true,
                true,
                true,
                true,
                true,
                false
        );
        BlockSetMaker.StoneBlockSetMaker POLISHED_GRANITE_BRICKS = new BlockSetMaker.StoneBlockSetMaker("", "polished_granite", AbstractBlock.Settings.copy(Blocks.POLISHED_GRANITE),
                false, false, false, false, false, false, false, false, false,
                true,
                true,
                true,
                true,
                true,
                false, false, false, false, false, false, false
        );
        BlockSetMaker.StoneBlockSetMaker POLISHED_ANDESITE_BRICKS = new BlockSetMaker.StoneBlockSetMaker("", "polished_andesite", AbstractBlock.Settings.copy(Blocks.POLISHED_ANDESITE),
                false, false, false, false, false, false, false, false, false,
                true,
                true,
                true,
                true,
                true,
                false, false, false, false, false, false, false
        );
        BlockSetMaker.StoneBlockSetMaker POLISHED_DIORITE_BRICKS = new BlockSetMaker.StoneBlockSetMaker("", "polished_diorite", AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE),
                false, false, false, false, false, false, false, false, false,
                true,
                true,
                true,
                true,
                true,
                false, false, false, false, false, false, false
        );
        BlockSetMaker.StoneBlockSetMaker MUD_VARIANTS = new BlockSetMaker.StoneBlockSetMaker("", "mud", AbstractBlock.Settings.copy(Blocks.MUD_BRICKS),
                false, false, false, false,
                true,
                true,
                true,
                true,
                false, false, false, false, false,
                true,
                true,
                false, false, false, false, false, false
        );
        BlockSetMaker.StoneBlockSetMaker SMOOTH_BASALT_BRICKS = new BlockSetMaker.StoneBlockSetMaker("", "smooth_basalt", AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT),
                false, false, false, false, false, false, false, false, false,
                true,
                true,
                true,
                true,
                false, false, false, false, false, false, false, false
        );
        BlockSetMaker.StoneBlockSetMaker BASALT_TILES = new BlockSetMaker.StoneBlockSetMaker("", "basalt", AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT),
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                true,
                true,
                true,
                true,
                false,
                false
        );
        BlockSetMaker.StoneBlockSetMaker BLACKSTONE_TILES = new BlockSetMaker.StoneBlockSetMaker("", "polished_blackstone", AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS),
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
                true,
                true,
                true,
                true,
                true,
                false
        );
        BlockSetMaker.WoodVariantsBlockMaker MOSAIC = new BlockSetMaker.WoodVariantsBlockMaker("mosaic", "mosaic", true).stairsAndSlab();
        BlockSetMaker.StoneBlockSetMaker FLINTSTONE = new BlockSetMaker.StoneBlockSetMaker("", "flintstone", AbstractBlock.Settings.copy(Blocks.SANDSTONE).mapColor(MapColor.STONE_GRAY),
                true,
                true,
                true,
                true,
                false, false, false, false, false,
                true,
                true,
                true,
                true,
                false, false, false, false, false, false, false, false
        );
        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_stairs"));
        ModDatagenUtils.CUSTOM_SLAB_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_slab"));
        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_wall"));
        BlockSetMaker.StoneBlockSetMaker SMOOTH_FLINTSTONE = new BlockSetMaker.StoneBlockSetMaker("", "smooth_flintstone", AbstractBlock.Settings.copy(Blocks.SANDSTONE).mapColor(MapColor.STONE_GRAY),
                true,
                true,
                true,
                true,
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
        );
        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone_stairs"));
        ModDatagenUtils.CUSTOM_SLAB_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone_slab"));
        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone_wall"));

        BlockSetMaker.registerSingleBlock("rough_concrete", new PillarBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE).strength(2.2f).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)), true, false);
        BlockSetMaker.registerSingleBlock("rough_concrete_block", new PillarBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE).strength(2.2f).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)), true, false);
        BlockSetMaker.BlockSetExtension ROUGH_CONCRETE_EXTENSION = new BlockSetMaker.BlockSetExtension(BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_block"), AbstractBlock.Settings.copy(BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_block")), "rough_concrete", true, true, true, false, false,false, false);

        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_stairs"));
        ModDatagenUtils.CUSTOM_SLAB_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_slab"));
        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_wall"));

        BlockSetMaker.StoneBlockSetMaker CALCITE = new BlockSetMaker.StoneBlockSetMaker("", "calcite", AbstractBlock.Settings.copy(Blocks.CALCITE),
                false, false, false, false,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                false,
                true,
                false, false, false, false, false, false
        );

        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            BlockSetMaker.StoneBlockSetMaker CONCRETE_BRICKS = new BlockSetMaker.StoneBlockSetMaker(color, "concrete", AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("minecraft", color + "_concrete"))),
                    false, false, false, false, false, false, false, false, false,
                    true,
                    true,
                    true,
                    true,
                    false, false, false, false, false, false, false, false
            );
            BlockSetMaker.registerSingleBlock(color + "_terracotta_mosaic", new Block(AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("minecraft", color + "_glazed_terracotta")))), true, false);
            BlockSetMaker.BlockSetExtension TERRACOTTA_MOSAIC_EXTENSION = new BlockSetMaker.BlockSetExtension(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"), AbstractBlock.Settings.copy(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic")), color + "_terracotta_mosaic", true, true, true, false, false,false, false);
        }

        BlockSetMaker.registerSingleBlock("chiseled_deepslate_bricks", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICKS)), true, false);
        BlockSetMaker.registerSingleBlock("cracked_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)), true, false);
        BlockSetMaker.registerSingleBlock("mossy_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)), true, false);
        BlockSetMaker.registerSingleBlock("chiseled_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)), true, false);
        BlockSetMaker.registerSingleBlock("brick_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.BRICKS)), true, false);
        BlockSetMaker.registerSingleBlock("smooth_packed_mud", new PillarBlock(AbstractBlock.Settings.copy(Blocks.PACKED_MUD)), true, false);
        BlockSetMaker.registerSingleBlock("polished_basalt_bricks", new PillarBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BASALT)), true, false);
        BlockSetMaker.registerSingleBlock("cracked_polished_basalt_bricks", new PillarBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BASALT)), true, false);
        BlockSetMaker.registerSingleBlock("chiseled_polished_basalt_bricks", new PillarBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BASALT)), true, false);
        BlockSetMaker.registerSingleBlock("chiseled_blackstone",new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)), true, false);
        BlockSetMaker.registerSingleBlock("copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(Blocks.CUT_COPPER)), true, false);
        BlockSetMaker.registerSingleBlock("exposed_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(Blocks.EXPOSED_CUT_COPPER)), true, false);
        BlockSetMaker.registerSingleBlock("weathered_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(Blocks.WEATHERED_CUT_COPPER)), true, false);
        BlockSetMaker.registerSingleBlock("oxidized_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(Blocks.OXIDIZED_CUT_COPPER)), true, false);
        BlockSetMaker.registerSingleBlock("waxed_copper_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.CUT_COPPER)), true, false);
        BlockSetMaker.registerSingleBlock("waxed_exposed_copper_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.EXPOSED_CUT_COPPER)), true, false);
        BlockSetMaker.registerSingleBlock("waxed_weathered_copper_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.WEATHERED_CUT_COPPER)), true, false);
        BlockSetMaker.registerSingleBlock("waxed_oxidized_copper_pillar",  new PillarBlock(AbstractBlock.Settings.copy(Blocks.OXIDIZED_CUT_COPPER)), true, false);
        BlockSetMaker.registerSingleBlock("flint_block", new MushroomBlock(AbstractBlock.Settings.copy(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY).hardness(1.8f).sounds(BlockSoundGroup.GILDED_BLACKSTONE)), true, false);
        BlockSetMaker.registerSingleBlock("polished_flint_block", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(BlockSetMaker.BLOCK_SET_BLOCKS.get("flint_block"))), true, false);
        BlockSetMaker.registerSingleBlock("stripped_dripstone", new PillarBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK)), true, false);
        BlockSetMaker.registerSingleBlock("stripped_dripstone_ore", new PillarBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK)), true, false);
    }
}
