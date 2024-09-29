package net.hecco.desire.util;

import net.hecco.desire.Desire;
import net.hecco.desire.datagen.ModBlockTagProvider;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BlockSetMaker {
    public static Map<String, Block> BLOCK_SET_BLOCKS = new HashMap<>();

    private static Block registerBlock(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Desire.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, Identifier.of(Desire.MOD_ID, name), block);
    }

    public static class StoneBlockSetMaker {
        public StoneBlockSetMaker(String prefix, String name, AbstractBlock.Settings settings, boolean raw, boolean raw_stairs, boolean raw_slab, boolean raw_wall, boolean polished, boolean polished_stairs, boolean polished_slab, boolean polished_wall, boolean chiseled, boolean bricks, boolean brick_stairs, boolean brick_slab, boolean brick_wall, boolean cracked_bricks, boolean chiseled_bricks, boolean tiles, boolean tile_stairs, boolean tile_slab, boolean tile_wall, boolean cracked_tiles, boolean pillar) {
            registerBlocks(prefix, name, settings,
                    raw,
                    raw_stairs,
                    raw_slab,
                    raw_wall,
                    polished,
                    polished_stairs,
                    polished_slab,
                    polished_wall,
                    chiseled,
                    bricks,
                    brick_stairs,
                    brick_slab,
                    brick_wall,
                    cracked_bricks,
                    chiseled_bricks,
                    tiles,
                    tile_stairs,
                    tile_slab,
                    tile_wall,
                    cracked_tiles,
                    pillar);
        }

        public StoneBlockSetMaker(List<String> colorVariantsList, boolean colorAtBeginning, String name, AbstractBlock.Settings settings,
                                  boolean raw,
                                  boolean raw_stairs,
                                  boolean raw_slab,
                                  boolean raw_wall,
                                  boolean polished,
                                  boolean polished_stairs,
                                  boolean polished_slab,
                                  boolean polished_wall,
                                  boolean chiseled,
                                  boolean bricks,
                                  boolean brick_stairs,
                                  boolean brick_slab,
                                  boolean brick_wall,
                                  boolean cracked_bricks,
                                  boolean chiseled_bricks,
                                  boolean tiles,
                                  boolean tile_stairs,
                                  boolean tile_slab,
                                  boolean tile_wall,
                                  boolean cracked_tiles,
                                  boolean pillar) {
            if (colorAtBeginning) {
                for (String color : colorVariantsList) {
                    registerBlocks(color, name, settings, raw, raw_stairs, raw_slab, raw_wall, polished, polished_stairs, polished_slab, polished_wall, chiseled, bricks, brick_stairs, brick_slab, brick_wall, cracked_bricks, chiseled_bricks, tiles, tile_stairs, tile_slab, tile_wall, cracked_tiles, pillar);
                }
            } else {
                for (String color : colorVariantsList) {
                    registerBlocks("", color + "_" + name, settings, raw, raw_stairs, raw_slab, raw_wall, polished, polished_stairs, polished_slab, polished_wall, chiseled, bricks, brick_stairs, brick_slab, brick_wall, cracked_bricks, chiseled_bricks, tiles, tile_stairs, tile_slab, tile_wall, cracked_tiles, pillar);
                }
            }
        }

        private static void registerBlocks(String prefix, String name, AbstractBlock.Settings settings,
                                           boolean raw,
                                           boolean raw_stairs,
                                           boolean raw_slab,
                                           boolean raw_wall,
                                           boolean polished,
                                           boolean polished_stairs,
                                           boolean polished_slab,
                                           boolean polished_wall,
                                           boolean chiseled,
                                           boolean bricks,
                                           boolean brick_stairs,
                                           boolean brick_slab,
                                           boolean brick_wall,
                                           boolean cracked_bricks,
                                           boolean chiseled_bricks,
                                           boolean tiles,
                                           boolean tile_stairs,
                                           boolean tile_slab,
                                           boolean tile_wall,
                                           boolean cracked_tiles,
                                           boolean pillar) {
            if (!Objects.equals(prefix, "")) {
                prefix = prefix + "_";
            }
            String id = prefix + name;
            if (raw) {
                BLOCK_SET_BLOCKS.put(id, registerBlock(id, new Block(settings)));
            }
            if (raw_stairs) {
                BLOCK_SET_BLOCKS.put(id + "_stairs", registerBlock(id + "_stairs", new StairsBlock(BLOCK_SET_BLOCKS.get(id).getDefaultState(), settings)));
                ModBlockTagProvider.STAIRS.add(BLOCK_SET_BLOCKS.get(id + "_stairs"));
            }
            if (raw_slab) {
                BLOCK_SET_BLOCKS.put(id + "_slab", registerBlock(id + "_slab", new SlabBlock(settings)));
                ModBlockTagProvider.SLABS.add(BLOCK_SET_BLOCKS.get(id + "_slab"));
            }
            if (raw_wall) {
                BLOCK_SET_BLOCKS.put(id + "_wall", registerBlock(id + "_wall", new WallBlock(settings)));
                ModBlockTagProvider.WALLS.add(BLOCK_SET_BLOCKS.get(id + "_wall"));
            }

            id = prefix + "polished_" + name;
            if (polished) {
                BLOCK_SET_BLOCKS.put(id, registerBlock(id, new Block(settings)));
            }
            if (polished_stairs) {
                BLOCK_SET_BLOCKS.put(id + "_stairs", registerBlock(id + "_stairs", new StairsBlock(BLOCK_SET_BLOCKS.get(id).getDefaultState(), settings)));
                ModBlockTagProvider.STAIRS.add(BLOCK_SET_BLOCKS.get(id + "_stairs"));
            }
            if (polished_slab) {
                BLOCK_SET_BLOCKS.put(id + "_slab", registerBlock(id + "_slab", new SlabBlock(settings)));
                ModBlockTagProvider.SLABS.add(BLOCK_SET_BLOCKS.get(id + "_slab"));
            }
            if (polished_wall) {
                BLOCK_SET_BLOCKS.put(id + "_wall", registerBlock(id + "_wall", new WallBlock(settings)));
                ModBlockTagProvider.WALLS.add(BLOCK_SET_BLOCKS.get(id + "_wall"));
            }

            id = prefix + "chiseled_" + name;
            if (chiseled) {
                BLOCK_SET_BLOCKS.put(id, registerBlock(id, new Block(settings)));
            }

            id = prefix + name + "_brick";
            if (bricks) {
                BLOCK_SET_BLOCKS.put(id + "s", registerBlock(id + "s", new Block(settings)));
            }
            if (brick_stairs) {
                BLOCK_SET_BLOCKS.put(id + "_stairs", registerBlock(id + "_stairs", new StairsBlock(BLOCK_SET_BLOCKS.get(id + "s").getDefaultState(), settings)));
                ModBlockTagProvider.STAIRS.add(BLOCK_SET_BLOCKS.get(id + "_stairs"));
            }
            if (brick_slab) {
                BLOCK_SET_BLOCKS.put(id + "_slab", registerBlock(id + "_slab", new SlabBlock(settings)));
                ModBlockTagProvider.SLABS.add(BLOCK_SET_BLOCKS.get(id + "_slab"));
            }
            if (brick_wall) {
                BLOCK_SET_BLOCKS.put(id + "_wall", registerBlock(id + "_wall", new WallBlock(settings)));
                ModBlockTagProvider.WALLS.add(BLOCK_SET_BLOCKS.get(id + "_wall"));
            }
            id = prefix + "cracked_" + name + "_bricks";
            if (cracked_bricks) {
                BLOCK_SET_BLOCKS.put(id, registerBlock(id, new Block(settings)));
            }
            id = prefix + "chiseled_" + name + "_bricks";
            if (chiseled_bricks) {
                BLOCK_SET_BLOCKS.put(id, registerBlock(id, new Block(settings)));
            }

            id = prefix + name + "_tile";
            if (tiles) {
                BLOCK_SET_BLOCKS.put(id + "s", registerBlock(id + "s", new Block(settings)));
            }
            if (tile_stairs) {
                BLOCK_SET_BLOCKS.put(id + "_stairs", registerBlock(id + "_stairs", new StairsBlock(BLOCK_SET_BLOCKS.get(id + "s").getDefaultState(), settings)));
                ModBlockTagProvider.STAIRS.add(BLOCK_SET_BLOCKS.get(id + "_stairs"));
            }
            if (tile_slab) {
                BLOCK_SET_BLOCKS.put(id + "_slab", registerBlock(id + "_slab", new SlabBlock(settings)));
                ModBlockTagProvider.SLABS.add(BLOCK_SET_BLOCKS.get(id + "_slab"));
            }
            if (tile_wall) {
                BLOCK_SET_BLOCKS.put(id + "_wall", registerBlock(id + "_wall", new WallBlock(settings)));
                ModBlockTagProvider.WALLS.add(BLOCK_SET_BLOCKS.get(id + "_wall"));
            }
            id = prefix + "cracked_" + name + "_tiles";
            if (cracked_tiles) {
                BLOCK_SET_BLOCKS.put(id, registerBlock(id, new Block(settings)));
            }

            id = prefix + name + "_pillar";
            if (pillar) {
                BLOCK_SET_BLOCKS.put(id, registerBlock(id, new PillarBlock(settings)));
            }
        }
    }

    public static class GemstoneBlockSetMaker {

        public GemstoneBlockSetMaker(List<String> colorVariantsList, boolean colorAtBeginning, String name, AbstractBlock.Settings settings,
                                     boolean cut,
                                     boolean cut_stairs,
                                     boolean cut_slab,
                                     boolean cut_wall,
                                     boolean pillar) {
            if (colorAtBeginning) {
                for (String color : colorVariantsList) {
                    registerBlocks(color, name, settings, cut, cut_slab, cut_stairs, cut_wall, pillar);
                }
            } else {
                for (String color : colorVariantsList) {
                    registerBlocks("", color + "_" + name, settings, cut, cut_slab, cut_stairs, cut_wall, pillar);
                }
            }
        }
        public GemstoneBlockSetMaker(String prefix, String name, AbstractBlock.Settings settings,
                                     boolean cut,
                                     boolean cut_stairs,
                                     boolean cut_slab,
                                     boolean cut_wall,
                                     boolean pillar) {

            registerBlocks(prefix, name, settings, cut, cut_slab, cut_stairs, cut_wall, pillar);
        }

        private static void registerBlocks(String prefix, String name, AbstractBlock.Settings settings,
                                           boolean cut,
                                           boolean cut_slab,
                                           boolean cut_stairs,
                                           boolean cut_wall,
                                           boolean pillar) {
            if (!Objects.equals(prefix, "")) {
                prefix = prefix + "_";
            }
            String id = prefix + "cut_" + name;
            if (cut) {
                BLOCK_SET_BLOCKS.put(id, registerBlock(id, new Block(settings)));
            }
            if (cut_stairs) {
                BLOCK_SET_BLOCKS.put(id + "_stairs", registerBlock(id + "_stairs", new StairsBlock(BLOCK_SET_BLOCKS.get(id).getDefaultState(), settings)));
                ModBlockTagProvider.STAIRS.add(BLOCK_SET_BLOCKS.get(id + "_stairs"));
            }
            if (cut_slab) {
                BLOCK_SET_BLOCKS.put(id + "_slab", registerBlock(id + "_slab", new SlabBlock(settings)));
                ModBlockTagProvider.SLABS.add(BLOCK_SET_BLOCKS.get(id + "_slab"));
            }
            if (cut_wall) {
                BLOCK_SET_BLOCKS.put(id + "_wall", registerBlock(id + "_wall", new WallBlock(settings)));
                ModBlockTagProvider.WALLS.add(BLOCK_SET_BLOCKS.get(id + "_wall"));
            }

            id = prefix + name + "_pillar";
            if (pillar) {
                BLOCK_SET_BLOCKS.put(id, registerBlock(id, new PillarBlock(settings)));
            }
        }
    }
}