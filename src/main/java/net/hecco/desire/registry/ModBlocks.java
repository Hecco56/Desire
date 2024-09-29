package net.hecco.desire.registry;

import net.hecco.desire.Desire;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    private static Block registerBlock(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Desire.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, Identifier.of(Desire.MOD_ID, name), block);
    }
    public static void register() {
        BlockSetMaker.BLOCK_SET_BLOCKS.put("dripstone", Blocks.DRIPSTONE_BLOCK);
        BlockSetMaker.StoneBlockSetMaker DRIPSTONE = new BlockSetMaker.StoneBlockSetMaker("", "dripstone", AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK),
                false,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                false, true, false, false, false, false, false, false
        );
    }
}
