package net.hecco.desire.registry;

import net.hecco.desire.Desire;
import net.hecco.desire.block.PlaceableRockBlock;
import net.hecco.desire.datagen.ModDatagenUtils;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
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
        BlockSetMaker.BlockSetExtension STONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.STONE, AbstractBlock.Settings.copy(Blocks.STONE), "stone", false, false, true, true, false);
        BlockSetMaker.BlockSetExtension POLISHED_ANDESITE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.POLISHED_ANDESITE, AbstractBlock.Settings.copy(Blocks.POLISHED_ANDESITE), "polished_andesite", false, false, true, false, false);
        BlockSetMaker.BlockSetExtension POLISHED_GRANITE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.POLISHED_GRANITE, AbstractBlock.Settings.copy(Blocks.POLISHED_GRANITE), "polished_granite", false, false, true, false, false);
        BlockSetMaker.BlockSetExtension POLISHED_DIORITE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.POLISHED_DIORITE, AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE), "polished_diorite", false, false, true, false, false);

        BlockSetMaker.BlockSetExtension SMOOTH_SANDSTONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.SMOOTH_SANDSTONE, AbstractBlock.Settings.copy(Blocks.SMOOTH_SANDSTONE), "smooth_sandstone", false, false, true, false, false);
        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_sandstone_wall"));

        BlockSetMaker.BlockSetExtension SMOOTH_RED_SANDSTONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.SMOOTH_RED_SANDSTONE, AbstractBlock.Settings.copy(Blocks.SMOOTH_RED_SANDSTONE), "smooth_red_sandstone", false, false, true, false, false);
        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_red_sandstone_wall"));

        BlockSetMaker.BlockSetExtension SMOOTH_QUARTZ_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.SMOOTH_QUARTZ, AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ), "smooth_quartz", false, false, true, false, false);
        ModDatagenUtils.CUSTOM_WALL_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_quartz_wall"));

        BlockSetMaker.BlockSetExtension DARK_PRISMARINE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.DARK_PRISMARINE, AbstractBlock.Settings.copy(Blocks.DARK_PRISMARINE), "dark_prismarine", false, false, true, false, false);
        BlockSetMaker.BlockSetExtension PRISMARINE_BRICK_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.PRISMARINE_BRICKS, AbstractBlock.Settings.copy(Blocks.PRISMARINE_BRICKS), "prismarine_brick", false, false, true, false, false);

        BlockSetMaker.BlockSetExtension SMOOTH_STONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.SMOOTH_STONE, AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE), "smooth_stone", true, false, false, false, false);
        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_stairs"));

        BlockSetMaker.BlockSetExtension CUT_SANDSTONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.CUT_SANDSTONE, AbstractBlock.Settings.copy(Blocks.CUT_SANDSTONE), "cut_sandstone", true, false, false, false, false);
        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cut_sandstone_stairs"));

        BlockSetMaker.BlockSetExtension CUT_RED_SANDSTONE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.CUT_RED_SANDSTONE, AbstractBlock.Settings.copy(Blocks.CUT_RED_SANDSTONE), "cut_red_sandstone", true, false, false, false, false);
        ModDatagenUtils.CUSTOM_STAIRS_MODEL.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cut_red_sandstone_stairs"));

        BlockSetMaker.BlockSetExtension SMOOTH_BASALT_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.SMOOTH_BASALT, AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT), "smooth_basalt", true, true, true, false, false);
        BlockSetMaker.BlockSetExtension QUARTZ_BRICK_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.QUARTZ_BRICKS, AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS), "quartz_brick", true, true, true, false, false);
        BlockSetMaker.BlockSetExtension CALCITE_EXTENSION = new BlockSetMaker.BlockSetExtension(Blocks.CALCITE, AbstractBlock.Settings.copy(Blocks.CALCITE), "calcite", true, true, true, false, false);



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
    }
}
