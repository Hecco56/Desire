package net.hecco.desire.compat.bountifulfares;

import net.hecco.desire.Desire;
import net.hecco.desire.compat.blocks.CompatBlock;
import net.hecco.desire.compat.blocks.CompatBlockItem;
import net.hecco.desire.compat.blocks.CompatSlabBlock;
import net.hecco.desire.compat.blocks.CompatStairsBlock;
import net.hecco.desire.oldutil.ModCompat;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BFModBlocks {
    public static final String MOD_ID = Desire.BOUNTIFUL_FARES;

    public static final List<String> WOOD_TYPES = List.of("hoary", "walnut");
    public static final List<MapColor> WOOD_MAP_COLORS = List.of(MapColor.TERRACOTTA_GRAY, MapColor.BROWN);

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
        for (String wood : WOOD_TYPES) {
            Block mosaicBlock = registerBlock(wood + "_mosaic", new CompatBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(WOOD_MAP_COLORS.get(WOOD_TYPES.indexOf(wood))), MOD_ID));
            Block stairsBlock = registerBlock(wood + "_mosaic_stairs", new CompatStairsBlock(mosaicBlock, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(WOOD_MAP_COLORS.get(WOOD_TYPES.indexOf(wood))), MOD_ID));
            Block slabBlock = registerBlock(wood + "_mosaic_slab", new CompatSlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).mapColor(WOOD_MAP_COLORS.get(WOOD_TYPES.indexOf(wood))), MOD_ID));
            WOOD_MOSAICS.put(wood, mosaicBlock);
            WOOD_MOSAIC_STAIRS.put(wood, stairsBlock);
            WOOD_MOSAIC_SLABS.put(wood, slabBlock);

            BlockFamilyGenerator.AXE_MINEABLE.add(WOOD_MOSAICS.get(wood));
            BlockFamilyGenerator.AXE_MINEABLE.add(WOOD_MOSAIC_STAIRS.get(wood));
            BlockFamilyGenerator.AXE_MINEABLE.add(WOOD_MOSAIC_SLABS.get(wood));
            BlockFamilyGenerator.STAIRS.add(WOOD_MOSAIC_STAIRS.get(wood));
            BlockFamilyGenerator.SLABS.add(WOOD_MOSAIC_SLABS.get(wood));
            BlockFamilyGenerator.CUSTOM_STAIRS_MODEL.add(WOOD_MOSAIC_STAIRS.get(wood));
            BlockFamilyGenerator.CUSTOM_SLAB_MODEL.add(WOOD_MOSAIC_SLABS.get(wood));
        }
    }
}
