package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_stone"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"));

        for (Block block : ModBlockTagProvider.STAIRS) {
            if (!ModDatagenUtils.CUSTOM_STAIRS_MODEL.contains(block)) {
                stairs(blockStateModelGenerator, block, ModDatagenUtils.VARIANT_TO_BASE_BLOCK.get(block));
            }
        }
        for (Block block : ModBlockTagProvider.SLABS) {
            if (!ModDatagenUtils.CUSTOM_SLAB_MODEL.contains(block)) {
                slab(blockStateModelGenerator, block, ModDatagenUtils.VARIANT_TO_BASE_BLOCK.get(block));
            }
        }
        for (Block block : ModBlockTagProvider.WALLS) {
            if (!ModDatagenUtils.CUSTOM_WALL_MODEL.contains(block)) {
                wall(blockStateModelGenerator, block, ModDatagenUtils.VARIANT_TO_BASE_BLOCK.get(block));
            }
        }
        customTextureWall(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_sandstone_wall"), Identifier.of("minecraft", "block/sandstone_top"));
        customTextureWall(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_red_sandstone_wall"), Identifier.of("minecraft", "block/red_sandstone_top"));
        customTextureWall(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_quartz_wall"), Identifier.of("minecraft", "block/quartz_block_bottom"));
        sideTopStairs(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_stairs"), Identifier.of("minecraft", "block/smooth_stone_slab_side"), Identifier.of("minecraft", "block/smooth_stone"), Identifier.of("minecraft", "block/smooth_stone"));
        sideTopStairs(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("cut_sandstone_stairs"), Identifier.of("minecraft", "block/cut_sandstone"), Identifier.of("minecraft", "block/sandstone_top"), Identifier.of("minecraft", "block/sandstone_top"));
        sideTopStairs(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("cut_red_sandstone_stairs"), Identifier.of("minecraft", "block/cut_red_sandstone"), Identifier.of("minecraft", "block/red_sandstone_top"), Identifier.of("minecraft", "block/red_sandstone_top"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.STONE_BOULDER.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DEEPSLATE_SHEET.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLACKSTONE_CHUNK.asItem(), Models.GENERATED);
    }

    public void stairs(BlockStateModelGenerator blockStateModelGenerator, Block block, Block baseBlock) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(baseBlock);
        TextureMap textures = texturedModel.getTextures();
        Identifier identifier = Models.INNER_STAIRS.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.STAIRS.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.OUTER_STAIRS.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(block, identifier, identifier2, identifier3));
        blockStateModelGenerator.registerParentedItemModel(block, identifier2);
    }
    public void sideTopStairs(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier sideTexture, Identifier topTexture, Identifier bottomTexture) {
        TextureMap textures = new TextureMap().put(TextureKey.SIDE, sideTexture).put(TextureKey.TOP, topTexture).put(TextureKey.BOTTOM, bottomTexture);
        Identifier identifier = Models.INNER_STAIRS.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.STAIRS.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.OUTER_STAIRS.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(block, identifier, identifier2, identifier3));
        blockStateModelGenerator.registerParentedItemModel(block, identifier2);
    }

    public void slab(BlockStateModelGenerator blockStateModelGenerator, Block block, Block baseBlock) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(baseBlock);
        TextureMap textures = texturedModel.getTextures();
        Identifier identifier = Models.SLAB.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.SLAB_TOP.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(block, identifier, identifier2, Identifier.of(Registries.BLOCK.getId(baseBlock).getNamespace(), "block/" + Registries.BLOCK.getId(baseBlock).getPath())));
        blockStateModelGenerator.registerParentedItemModel(block, identifier);
    }

    public void sideTopSlab(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier sideTexture, Identifier topTexture, Identifier bottomTexture) {
        TextureMap textures = new TextureMap().put(TextureKey.SIDE, sideTexture).put(TextureKey.TOP, topTexture).put(TextureKey.BOTTOM, bottomTexture);
        Identifier identifier = Models.SLAB.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.SLAB_TOP.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(block, identifier, identifier2, Identifier.of(Registries.BLOCK.getId(block).getNamespace(), Registries.BLOCK.getId(block).getPath())));
        blockStateModelGenerator.registerParentedItemModel(block, identifier);
    }
    public void wall(BlockStateModelGenerator blockStateModelGenerator, Block block, Block baseBlock) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(baseBlock);
        TextureMap textures = texturedModel.getTextures();
        Identifier identifier = Models.TEMPLATE_WALL_POST.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_WALL_SIDE.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_WALL_SIDE_TALL.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(block, identifier, identifier2, identifier3));
        Identifier identifier4 = Models.WALL_INVENTORY.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerParentedItemModel(block, identifier4);
    }

    public void customTextureWall(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier textureName) {
        TextureMap textures = TextureMap.all(textureName);
        Identifier identifier = Models.TEMPLATE_WALL_POST.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_WALL_SIDE.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_WALL_SIDE_TALL.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(block, identifier, identifier2, identifier3));
        Identifier identifier4 = Models.WALL_INVENTORY.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerParentedItemModel(block, identifier4);
    }
}
