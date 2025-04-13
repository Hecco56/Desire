package net.hecco.desire.registry;

import net.hecco.desire.Desire;
import net.hecco.desire.block.OxidizablePillarBlock;
import net.hecco.desire.block.PlaceableRockBlock;
import net.hecco.desire.datagen.desire.ModDatagenUtils;
import net.hecco.desire.oldutil.BlockSetGenerator;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.hecco.desire.util.MinMiningToolTier;
import net.hecco.desire.util.Mineables;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block STONE_BOULDER = register("stone_boulder", new PlaceableRockBlock(AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.STONE_GRAY).strength(0.2F, 2.0F)));
    public static final Block DEEPSLATE_SHEET = register("deepslate_sheet", new PlaceableRockBlock(AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.DEEPSLATE_GRAY).sounds(BlockSoundGroup.DEEPSLATE).strength(0.4F, 2.0F)));
    public static final Block BLACKSTONE_CHUNK = register("blackstone_chunk", new PlaceableRockBlock(AbstractBlock.Settings.create().nonOpaque().mapColor(MapColor.BLACK).strength(0.2F, 2.0F)));

    private static Block register(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Desire.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, Identifier.of(Desire.MOD_ID, name), block);
    }
    public static void register() {
        new BlockFamilyGenerator(
                "stone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.STONE,
                AbstractBlock.Settings.copy(Blocks.STONE),
                false
        )
                .wall().block("chiseled", "", false)
                .block("polished", "", true).stairs().slab().wall(true)
                .block("", "tiles", true).stairs().slab().wall().block("cracked", "tiles", true)
                ;

        new BlockFamilyGenerator(
                "polished_andesite",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.POLISHED_ANDESITE,
                AbstractBlock.Settings.copy(Blocks.POLISHED_ANDESITE),
                false
        )
                .wall(true)
                .block("", "bricks", true).stairs().slab().wall().block("cracked", "bricks", true)
        ;
        new BlockFamilyGenerator(
                "polished_granite",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.POLISHED_GRANITE,
                AbstractBlock.Settings.copy(Blocks.POLISHED_GRANITE),
                false
        )
                .wall(true)
                .block("", "bricks", false).stairs(true).slab(true).wall().block("cracked", "bricks", false)
        ;

        new BlockFamilyGenerator(
                "polished_diorite",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.POLISHED_DIORITE,
                AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE),
                false
        )
                .wall(true)
                .block("", "bricks", true).stairs().slab().wall().block("cracked", "bricks", true)
        ;

        new BlockFamilyGenerator(
                "smooth_sandstone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.SMOOTH_SANDSTONE,
                AbstractBlock.Settings.copy(Blocks.SMOOTH_SANDSTONE),
                false
        )
                .wall(true)
        ;
        new BlockFamilyGenerator(
                "smooth_red_sandstone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.SMOOTH_RED_SANDSTONE,
                AbstractBlock.Settings.copy(Blocks.SMOOTH_RED_SANDSTONE),
                false
        )
                .wall(true)
        ;
        new BlockFamilyGenerator(
                "smooth_quartz",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.SMOOTH_QUARTZ,
                AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ),
                false
        )
                .wall(true)
        ;
        new BlockFamilyGenerator(
                "dark_prismarine",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.DARK_PRISMARINE,
                AbstractBlock.Settings.copy(Blocks.DARK_PRISMARINE),
                false
        )
                .wall(true)
        ;
        new BlockFamilyGenerator(
                "prismarine_brick",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.PRISMARINE_BRICKS,
                AbstractBlock.Settings.copy(Blocks.PRISMARINE),
                false
        )
                .wall(true)
        ;
        new BlockFamilyGenerator(
                "smooth_stone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.SMOOTH_STONE,
                AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE),
                false
        )
                .stairs(true)
        ;
        new BlockFamilyGenerator(
                "cut_sandstone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.CUT_SANDSTONE,
                AbstractBlock.Settings.copy(Blocks.CUT_SANDSTONE),
                false
        )
                .stairs(true)
        ;
        new BlockFamilyGenerator(
                "cut_red_sandstone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.CUT_RED_SANDSTONE,
                AbstractBlock.Settings.copy(Blocks.CUT_RED_SANDSTONE),
                false
        )
                .stairs(true)
        ;
        new BlockFamilyGenerator(
                "smooth_basalt",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.SMOOTH_BASALT,
                AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT),
                false
        )
                .stairs().slab().wall()
        ;
        new BlockFamilyGenerator(
                "quartz_brick",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.QUARTZ_BRICKS,
                AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS),
                false
        )
                .stairs().slab().wall()
        ;
        new BlockFamilyGenerator(
                "calcite",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.CALCITE,
                AbstractBlock.Settings.copy(Blocks.CALCITE),
                false
        )
                .stairs().slab().wall()
                .block("polished", "", true).stairs().slab().wall(true)
                .block("chiseled", "", false)
                .block("", "bricks", true).stairs().slab().wall()
                .block("cracked", "bricks", true)
                .block("chiseled", "bricks", false)
        ;

        new BlockFamilyGenerator(
                "cobblestone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.COBBLESTONE,
                AbstractBlock.Settings.copy(Blocks.COBBLESTONE),
                false
        )
                .block("", "bricks", true).stairs().slab().wall()
        ;

        new BlockFamilyGenerator(
                "mossy_cobblestone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.MOSSY_COBBLESTONE,
                AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE),
                false
        )
                .block("", "bricks", true).stairs().slab().wall()
        ;

        new BlockFamilyGenerator(
                "smooth_stone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.SMOOTH_STONE,
                AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE),
                false
        )
                .block("", "bricks", true).stairs().slab().wall()
        ;

        new BlockFamilyGenerator(
                "mud",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.MUD_BRICKS,
                AbstractBlock.Settings.copy(Blocks.MUD_BRICKS),
                false
        )
                .block("polished", "", true).stairs().slab().wall(true)
                .block("cracked", "bricks", true)
                .block("chiseled", "bricks", true)
        ;

//        BlockSetGenerator.StoneBlockSetMaker SMOOTH_BASALT_BRICKS = new BlockSetGenerator.StoneBlockSetMaker("", "smooth_basalt", AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT),
//                false, false, false, false, false, false, false, false, false,
//                true,
//                true,
//                true,
//                true,
//                false, false, false, false, false, false, false, false
//        );
//        BlockSetGenerator.StoneBlockSetMaker BASALT_TILES = new BlockSetGenerator.StoneBlockSetMaker("", "basalt", AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT),
//                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
//                true,
//                true,
//                true,
//                true,
//                false, false
//        );
//        BlockSetGenerator.StoneBlockSetMaker BLACKSTONE_TILES = new BlockSetGenerator.StoneBlockSetMaker("", "polished_blackstone", AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS),
//                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
//                true,
//                true,
//                true,
//                true,
//                true,
//                false
//        );
//        BlockSetGenerator.WoodVariantsBlockMaker MOSAIC = new BlockSetGenerator.WoodVariantsBlockMaker("mosaic", "mosaic", true).stairsAndSlab();
//        BlockSetGenerator.StoneBlockSetMaker FLINTSTONE = new BlockSetGenerator.StoneBlockSetMaker("", "flintstone", AbstractBlock.Settings.copy(Blocks.SANDSTONE).mapColor(MapColor.STONE_GRAY),
//                true,
//                true,
//                true,
//                true,
//                false, false, false, false, false,
//                true,
//                true,
//                true,
//                true,
//                false, false, false, false, false, false, false, false
//        );
//        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_stairs"));
//        ModDatagenUtils.CUSTOM_SLAB_MODEL.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_slab"));
//        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_wall"));
//        BlockSetGenerator.StoneBlockSetMaker SMOOTH_FLINTSTONE = new BlockSetGenerator.StoneBlockSetMaker("", "smooth_flintstone", AbstractBlock.Settings.copy(Blocks.SANDSTONE).mapColor(MapColor.STONE_GRAY),
//                true,
//                true,
//                true,
//                true,
//                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
//        );
//        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_stairs"));
//        ModDatagenUtils.CUSTOM_SLAB_MODEL.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_slab"));
//        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_wall"));
//
//        BlockSetGenerator.registerSingleBlock("rough_concrete", new PillarBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE).strength(2.2f).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)), true, false);
//        BlockSetGenerator.registerSingleBlock("rough_concrete_block", new PillarBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE).strength(2.2f).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)), true, false);
//        BlockSetGenerator.BlockSetExtension ROUGH_CONCRETE_EXTENSION = new BlockSetGenerator.BlockSetExtension(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block"), AbstractBlock.Settings.copy(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block")), "rough_concrete", true, true, true, false, false,false, false);
//
//        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_stairs"));
//        ModDatagenUtils.CUSTOM_SLAB_MODEL.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_slab"));
//        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_wall"));

//        for (String color : ModDatagenUtils.VANILLA_COLORS) {
//            BlockSetGenerator.StoneBlockSetMaker CONCRETE_BRICKS = new BlockSetGenerator.StoneBlockSetMaker(color, "concrete", AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("minecraft", color + "_concrete"))),
//                    false, false, false, false, false, false, false, false, false,
//                    true,
//                    true,
//                    true,
//                    true,
//                    false, false, false, false, false, false, false, false
//            );
//            BlockSetGenerator.registerSingleBlock(color + "_terracotta_mosaic", new Block(AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("minecraft", color + "_glazed_terracotta")))), true, false);
//            BlockSetGenerator.BlockSetExtension TERRACOTTA_MOSAIC_EXTENSION = new BlockSetGenerator.BlockSetExtension(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"), AbstractBlock.Settings.copy(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic")), color + "_terracotta_mosaic", true, true, true, false, false,false, false);
//        }
//
//        BlockSetGenerator.registerSingleBlock("chiseled_deepslate_bricks", new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICKS)), true, false);
//        BlockSetGenerator.registerSingleBlock("cracked_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)), true, false);
//        BlockSetGenerator.registerSingleBlock("mossy_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)), true, false);
//        BlockSetGenerator.registerSingleBlock("chiseled_bricks", new Block(AbstractBlock.Settings.copy(Blocks.BRICKS)), true, false);
//        BlockSetGenerator.registerSingleBlock("brick_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.BRICKS)), true, false);
//        BlockSetGenerator.registerSingleBlock("smooth_packed_mud", new PillarBlock(AbstractBlock.Settings.copy(Blocks.PACKED_MUD)), true, false);
//        BlockSetGenerator.registerSingleBlock("polished_basalt_bricks", new PillarBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BASALT)), true, false);
//        BlockSetGenerator.registerSingleBlock("cracked_polished_basalt_bricks", new PillarBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BASALT)), true, false);
//        BlockSetGenerator.registerSingleBlock("chiseled_polished_basalt_bricks", new PillarBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BASALT)), true, false);
//        BlockSetGenerator.registerSingleBlock("chiseled_blackstone",new Block(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS)), true, false);
//        BlockSetGenerator.registerSingleBlock("copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(Blocks.CUT_COPPER)), true, false);
//        BlockSetGenerator.registerSingleBlock("exposed_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(Blocks.EXPOSED_CUT_COPPER)), true, false);
//        BlockSetGenerator.registerSingleBlock("weathered_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(Blocks.WEATHERED_CUT_COPPER)), true, false);
//        BlockSetGenerator.registerSingleBlock("oxidized_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(Blocks.OXIDIZED_CUT_COPPER)), true, false);
//        BlockSetGenerator.registerSingleBlock("waxed_copper_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.CUT_COPPER)), true, false);
//        BlockSetGenerator.registerSingleBlock("waxed_exposed_copper_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.EXPOSED_CUT_COPPER)), true, false);
//        BlockSetGenerator.registerSingleBlock("waxed_weathered_copper_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.WEATHERED_CUT_COPPER)), true, false);
//        BlockSetGenerator.registerSingleBlock("waxed_oxidized_copper_pillar",  new PillarBlock(AbstractBlock.Settings.copy(Blocks.OXIDIZED_CUT_COPPER)), true, false);
//        BlockSetGenerator.registerSingleBlock("flint_block", new MushroomBlock(AbstractBlock.Settings.copy(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY).hardness(1.8f).sounds(BlockSoundGroup.GILDED_BLACKSTONE)), true, false);
//        BlockSetGenerator.registerSingleBlock("polished_flint_block", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flint_block"))), true, false);
//        BlockSetGenerator.registerSingleBlock("carved_dripstone", new PillarBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK)), true, false);
//        BlockSetGenerator.registerSingleBlock("carved_dripstone_ore", new PillarBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK)), true, false);
    }
}
