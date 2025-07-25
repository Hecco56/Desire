package net.hecco.desire.registry;

import net.hecco.desire.Desire;
import net.hecco.desire.block.OxidizablePillarBlock;
import net.hecco.desire.block.PlaceableRockBlock;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.hecco.desire.util.MinMiningToolTier;
import net.hecco.desire.util.Mineables;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
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
                .wall()
        ;
        new BlockFamilyGenerator(
                "prismarine_brick",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.PRISMARINE_BRICKS,
                AbstractBlock.Settings.copy(Blocks.PRISMARINE),
                false
        )
                .wall()
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
                .stairs(true)
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
                .block("chiseled", "bricks", false)
                .block("smooth_packed", "", new PillarBlock(AbstractBlock.Settings.copy(Blocks.MUD_BRICKS)), false)
        ;

        new BlockFamilyGenerator(
                "basalt",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.SMOOTH_BASALT,
                AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT),
                false
        )
                .block("smooth", "bricks", true).stairs().slab().wall()
                .block("polished", "bricks", new PillarBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BASALT)), false)
                .block("cracked_polished", "bricks", new PillarBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BASALT)), false)
                .block("chiseled_polished", "bricks", new PillarBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BASALT)), true)
                .block("", "tiles", true).stairs().slab().wall()
        ;

        new BlockFamilyGenerator(
                "blackstone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.POLISHED_BLACKSTONE_BRICKS,
                AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS),
                false
        )
                .block("polished", "tiles", true).stairs().slab().wall()
                .block("cracked_polished", "tiles", true)
                .block("chiseled", "", false)
        ;

        for (WoodType woodType : WoodType.stream().toList()) {
            if (woodType.name() != "bamboo" && !woodType.name().contains(":")) {
                new BlockFamilyGenerator(
                        woodType.name(),
                        Mineables.AXE,
                        MinMiningToolTier.NONE,
                        Registries.BLOCK.get(Identifier.of("minecraft", woodType.name() + "_planks")),
                        AbstractBlock.Settings.copy(Registries.BLOCK.get(Identifier.of("minecraft", woodType.name() + "_planks"))),
                        false
                )
                        .block("", "mosaic", true).stairs().slab()
                ;
            }
        }

        new BlockFamilyGenerator(
                "flintstone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                register("flintstone", new Block(AbstractBlock.Settings.copy(Blocks.SANDSTONE).mapColor(MapColor.STONE_GRAY))),
                AbstractBlock.Settings.copy(Blocks.SANDSTONE).mapColor(MapColor.STONE_GRAY),
                false
        )
                .stairs(true).slab(true).wall(true)
                .block("", "bricks", true).stairs().slab().wall()
                .block("smooth", "", false).stairs(true).slab(true).wall(true)
        ;

        new BlockFamilyGenerator(
                "rough_concrete",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                register("rough_concrete", new PillarBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE).strength(2.2f).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))),
                AbstractBlock.Settings.copy(Blocks.RED_CONCRETE).strength(2.2f).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY),
                false
        )
                .stairs(true).slab(true).wall(true)
                .block("", "block", false)
        ;

        new BlockFamilyGenerator(
                "scute",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.WHITE_CONCRETE,
                AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE).mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).sounds(BlockSoundGroup.BAMBOO_WOOD).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool().strength(0.8F, 16F),
                false
        )
                .block("", "shingles", true).stairs().slab()
        ;

        for (DyeColor color : DyeColor.values()) {
            new BlockFamilyGenerator(
                    color.getName() + "_concrete",
                    Mineables.PICKAXE,
                    MinMiningToolTier.NONE,
                    Blocks.WHITE_CONCRETE,
                    AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE).mapColor(color),
                    false
            )
                    .block("", "bricks", true).stairs().slab().wall()
            ;
            new BlockFamilyGenerator(
                    color.getName() + "_terracotta",
                    Mineables.PICKAXE,
                    MinMiningToolTier.NONE,
                    Blocks.WHITE_GLAZED_TERRACOTTA,
                    AbstractBlock.Settings.copy(Blocks.WHITE_GLAZED_TERRACOTTA).mapColor(color),
                    false
            )
                    .block("", "mosaic", true).stairs().slab().wall()
            ;

            new BlockFamilyGenerator(
                    color.getName() + "_scute",
                    Mineables.PICKAXE,
                    MinMiningToolTier.NONE,
                    Blocks.WHITE_CONCRETE,
                    AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE).mapColor(color).sounds(BlockSoundGroup.BAMBOO_WOOD).instrument(NoteBlockInstrument.XYLOPHONE).requiresTool().strength(0.8F, 16F),
                    false
            )
                    .block("", "shingles", true).stairs().slab()
            ;
        }
        new BlockFamilyGenerator(
                "deepslate",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.POLISHED_DEEPSLATE,
                AbstractBlock.Settings.copy(Blocks.POLISHED_DEEPSLATE),
                false
        )
                .block("chiseled", "bricks", false)
        ;
        new BlockFamilyGenerator(
                "bricks",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.BRICKS,
                AbstractBlock.Settings.copy(Blocks.BRICKS),
                false
        )
                .block("cracked", "", true)
                .block("mossy", "", true)
                .block("chiseled", "", false)
        ;
        new BlockFamilyGenerator(
                "brick",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.BRICKS,
                AbstractBlock.Settings.copy(Blocks.BRICKS),
                false
        )
                .block("", "pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.BRICKS)), false)
        ;

        new BlockFamilyGenerator(
                "dripstone",
                Mineables.PICKAXE,
                MinMiningToolTier.NONE,
                Blocks.DRIPSTONE_BLOCK,
                AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK),
                false
        )
                .stairs().slab().wall()
        ;

        BlockFamilyGenerator.registerSingleBlock("copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(Blocks.CUT_COPPER)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("exposed_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(Blocks.EXPOSED_CUT_COPPER)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("weathered_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(Blocks.WEATHERED_CUT_COPPER)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("oxidized_copper_pillar", new OxidizablePillarBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(Blocks.OXIDIZED_CUT_COPPER)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("waxed_copper_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.CUT_COPPER)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("waxed_exposed_copper_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.EXPOSED_CUT_COPPER)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("waxed_weathered_copper_pillar", new PillarBlock(AbstractBlock.Settings.copy(Blocks.WEATHERED_CUT_COPPER)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("waxed_oxidized_copper_pillar",  new PillarBlock(AbstractBlock.Settings.copy(Blocks.OXIDIZED_CUT_COPPER)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("flint_block", new MushroomBlock(AbstractBlock.Settings.copy(Blocks.STONE).mapColor(MapColor.DEEPSLATE_GRAY).hardness(1.8f).sounds(BlockSoundGroup.GILDED_BLACKSTONE)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("polished_flint_block", new GlazedTerracottaBlock(AbstractBlock.Settings.copy(BlockFamilyGenerator.BLOCKS.get("flint_block"))), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("carved_dripstone", new PillarBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
        BlockFamilyGenerator.registerSingleBlock("carved_dripstone_ore", new PillarBlock(AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK)), Mineables.PICKAXE, MinMiningToolTier.NONE, false);
    }
}
