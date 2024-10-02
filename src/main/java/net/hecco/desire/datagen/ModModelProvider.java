package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool dripstoneTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockSetMaker.BLOCK_SET_BLOCKS.get("dripstone"));
        dripstoneTexturePool.stairs(BlockSetMaker.BLOCK_SET_BLOCKS.get("dripstone_stairs"));
        dripstoneTexturePool.slab(BlockSetMaker.BLOCK_SET_BLOCKS.get("dripstone_slab"));
        dripstoneTexturePool.wall(BlockSetMaker.BLOCK_SET_BLOCKS.get("dripstone_wall"));
        BlockStateModelGenerator.BlockTexturePool polishedDripstoneTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_dripstone"));
        polishedDripstoneTexturePool.stairs(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_dripstone_stairs"));
        polishedDripstoneTexturePool.slab(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_dripstone_slab"));
        polishedDripstoneTexturePool.wall(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_dripstone_wall"));
        BlockStateModelGenerator.BlockTexturePool dripstoneBrickTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(BlockSetMaker.BLOCK_SET_BLOCKS.get("dripstone_bricks"));
        dripstoneBrickTexturePool.stairs(BlockSetMaker.BLOCK_SET_BLOCKS.get("dripstone_brick_stairs"));
        dripstoneBrickTexturePool.slab(BlockSetMaker.BLOCK_SET_BLOCKS.get("dripstone_brick_slab"));
        dripstoneBrickTexturePool.wall(BlockSetMaker.BLOCK_SET_BLOCKS.get("dripstone_brick_wall"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.STONE_BOULDER.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DEEPSLATE_SHEET.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLACKSTONE_CHUNK.asItem(), Models.GENERATED);
    }
}
