package net.hecco.desire.util;

import net.hecco.desire.Desire;
import net.hecco.desire.datagen.ModBlockTagProvider;
import net.hecco.desire.datagen.ModDatagenUtils;
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
                Block block = registerBlock(id, new Block(settings));
                BLOCK_SET_BLOCKS.put(id, block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.BASE_BLOCK_IDS.add(id);
            }
            if (raw_stairs) {
                Block block = registerBlock(id + "_stairs", new StairsBlock(BLOCK_SET_BLOCKS.get(id).getDefaultState(), settings));
                BLOCK_SET_BLOCKS.put(id + "_stairs", block);
                ModBlockTagProvider.STAIRS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id));
            }
            if (raw_slab) {
                Block block = registerBlock(id + "_slab", new SlabBlock(settings));
                BLOCK_SET_BLOCKS.put(id + "_slab", block);
                ModBlockTagProvider.SLABS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id));
            }
            if (raw_wall) {
                Block block = registerBlock(id + "_wall", new WallBlock(settings));
                BLOCK_SET_BLOCKS.put(id + "_wall", block);
                ModBlockTagProvider.WALLS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id));
            }

            id = prefix + "polished_" + name;
            if (polished) {
                Block block = registerBlock(id, new Block(settings));
                BLOCK_SET_BLOCKS.put(id, block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.BASE_BLOCK_IDS.add(id);
            }
            if (polished_stairs) {
                Block block = registerBlock(id + "_stairs", new StairsBlock(BLOCK_SET_BLOCKS.get(id).getDefaultState(), settings));
                BLOCK_SET_BLOCKS.put(id + "_stairs", block);
                ModBlockTagProvider.STAIRS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id));
            }
            if (polished_slab) {
                Block block = registerBlock(id + "_slab", new SlabBlock(settings));
                BLOCK_SET_BLOCKS.put(id + "_slab", block);
                ModBlockTagProvider.SLABS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id));
            }
            if (polished_wall) {
                Block block = registerBlock(id + "_wall", new WallBlock(settings));
                BLOCK_SET_BLOCKS.put(id + "_wall", block);
                ModBlockTagProvider.WALLS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id));
            }

            id = prefix + "chiseled_" + name;
            if (chiseled) {
                Block block = registerBlock(id, new Block(settings));
                BLOCK_SET_BLOCKS.put(id, registerBlock(id, new Block(settings)));
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
            }

            id = prefix + name + "_brick";
            if (bricks) {
                Block block = registerBlock(id + "s", new Block(settings));
                BLOCK_SET_BLOCKS.put(id + "s", block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.BASE_BLOCK_IDS.add(id + "s");
            }
            if (brick_stairs) {
                Block block = registerBlock(id + "_stairs", new StairsBlock(BLOCK_SET_BLOCKS.get(id + "s").getDefaultState(), settings));
                BLOCK_SET_BLOCKS.put(id + "_stairs", block);
                ModBlockTagProvider.STAIRS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id + "s"));
            }
            if (brick_slab) {
                Block block = registerBlock(id + "_slab", new SlabBlock(settings));
                BLOCK_SET_BLOCKS.put(id + "_slab", block);
                ModBlockTagProvider.SLABS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id + "s"));
            }
            if (brick_wall) {
                Block block = registerBlock(id + "_wall", new WallBlock(settings));
                BLOCK_SET_BLOCKS.put(id + "_wall", block);
                ModBlockTagProvider.WALLS.add(BLOCK_SET_BLOCKS.get(id + "_wall"));
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id + "s"));
            }
            id = prefix + "cracked_" + name + "_bricks";
            if (cracked_bricks) {
                Block block = registerBlock(id, new Block(settings));
                BLOCK_SET_BLOCKS.put(id, block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
            }
            id = prefix + "chiseled_" + name + "_bricks";
            if (chiseled_bricks) {
                Block block = registerBlock(id, new Block(settings));
                BLOCK_SET_BLOCKS.put(id, block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
            }

            id = prefix + name + "_tile";
            if (tiles) {
                Block block = registerBlock(id + "s", new Block(settings));
                BLOCK_SET_BLOCKS.put(id + "s", block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.BASE_BLOCK_IDS.add(id + "s");
            }
            if (tile_stairs) {
                Block block = registerBlock(id + "_stairs", new StairsBlock(BLOCK_SET_BLOCKS.get(id + "s").getDefaultState(), settings));
                BLOCK_SET_BLOCKS.put(id + "_stairs", block);
                ModBlockTagProvider.STAIRS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id + "s"));
            }
            if (tile_slab) {
                Block block = registerBlock(id + "_slab", new SlabBlock(settings));
                BLOCK_SET_BLOCKS.put(id + "_slab", block);
                ModBlockTagProvider.SLABS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id + "s"));
            }
            if (tile_wall) {
                Block block = registerBlock(id + "_wall", new WallBlock(settings));
                BLOCK_SET_BLOCKS.put(id + "_wall", block);
                ModBlockTagProvider.WALLS.add(block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(block, BLOCK_SET_BLOCKS.get(id + "s"));
            }
            id = prefix + "cracked_" + name + "_tiles";
            if (cracked_tiles) {
                Block block = registerBlock(id, new Block(settings));
                BLOCK_SET_BLOCKS.put(id, block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
            }

            id = prefix + name + "_pillar";
            if (pillar) {
                Block block = registerBlock(id, new PillarBlock(settings));
                BLOCK_SET_BLOCKS.put(id, block);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(block);
            }
        }
    }
    public static class BlockSetExtension {
        public BlockSetExtension(Block block, AbstractBlock.Settings settings, String name, boolean stairs, boolean slab, boolean wall, boolean cracked, boolean mossy, boolean chiseled, boolean pillar) {
            if (stairs) {
                Block newBlock = registerBlock(name + "_stairs", new StairsBlock(block.getDefaultState(), settings));
                BLOCK_SET_BLOCKS.put(name + "_stairs", newBlock);
                ModBlockTagProvider.STAIRS.add(newBlock);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(newBlock);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(newBlock, block);
            }
            if (slab) {
                Block newBlock = registerBlock(name + "_slab", new SlabBlock(settings));
                BLOCK_SET_BLOCKS.put(name + "_slab", newBlock);
                ModBlockTagProvider.SLABS.add(newBlock);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(newBlock);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(newBlock, block);
            }
            if (wall) {
                Block newBlock = registerBlock(name + "_wall", new WallBlock(settings));
                BLOCK_SET_BLOCKS.put(name + "_wall", newBlock);
                ModBlockTagProvider.WALLS.add(newBlock);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(newBlock);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(newBlock, block);
            }
            if (chiseled) {
                Block newBlock = registerBlock("chiseled_" + name, new Block(settings));
                BLOCK_SET_BLOCKS.put("chiseled_" + name, newBlock);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(newBlock);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(newBlock, block);
            }
            if (pillar) {
                Block newBlock = registerBlock(name + "_pillar", new PillarBlock(settings));
                BLOCK_SET_BLOCKS.put(name + "_pillar", newBlock);
                ModBlockTagProvider.PICKAXE_MINEABLE.add(newBlock);
                ModDatagenUtils.VARIANT_TO_BASE_BLOCK.put(newBlock, block);
            }
        }
    }
}