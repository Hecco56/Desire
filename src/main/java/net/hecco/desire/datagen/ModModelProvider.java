package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.desire.Desire;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_stone"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_stone"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("stone_tiles"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_stone_tiles"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_granite_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_andesite_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_diorite_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_deepslate_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("brick_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_block"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_mud"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_mud_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_mud_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_packed_mud"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_basalt_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_polished_basalt_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("basalt_tiles"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_blackstone"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_blackstone_tiles"));
        for (String wood : BlockSetMaker.WoodVariantsBlockMaker.WOOD_TYPES) {
            if (wood != "bamboo") {
                blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get(wood + "_mosaic"));
            }
        }
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        registerParentedPillar(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_copper_pillar"));
        registerParentedPillar(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_exposed_copper_pillar"));
        registerParentedPillar(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_weathered_copper_pillar"));
        registerParentedPillar(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"), BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_oxidized_copper_pillar"));
        blockStateModelGenerator.registerSingleton(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone"), TexturedModel.CUBE_BOTTOM_TOP);

        Identifier smoothFlintstoneModel = Models.CUBE_ALL.upload(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone"), TextureMap.all(Identifier.of(Desire.MOD_ID, "block/flintstone_top")), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone"), BlockStateVariant.create().put(VariantSettings.MODEL, smoothFlintstoneModel)));
        blockStateModelGenerator.registerParentedItemModel(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone"), smoothFlintstoneModel);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_bricks"));
        registerMushroomLikeBlock(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("flint_block"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_flint_block"), TexturedModel.TEMPLATE_GLAZED_TERRACOTTA);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_calcite"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_calcite"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_calcite_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("stripped_dripstone"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetMaker.BLOCK_SET_BLOCKS.get("stripped_dripstone_ore"), TexturedModel.END_FOR_TOP_CUBE_COLUMN.get(BlockSetMaker.BLOCK_SET_BLOCKS.get("stripped_dripstone")).textures((textureMap -> textureMap.put(TextureKey.SIDE, TextureMap.getId(BlockSetMaker.BLOCK_SET_BLOCKS.get("stripped_dripstone_ore"))))).upload(BlockSetMaker.BLOCK_SET_BLOCKS.get("stripped_dripstone_ore"), blockStateModelGenerator.modelCollector));
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"));
            blockStateModelGenerator.registerSimpleCubeAll(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"));
        }


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
        sideTopStairs(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_stairs"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"));
        sideTopSlab(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_slab"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_slab_side"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"));
        sideTopWall(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_wall"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"));
        customTextureStairs(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone_stairs"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"));
        customTextureSlab(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone_slab"), BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"));
        customTextureWall(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone_wall"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"));
        sideTopStairs(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_stairs"), Identifier.of(Desire.MOD_ID, "block/flintstone_side"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"), Identifier.of(Desire.MOD_ID, "block/flintstone_bottom"));
        sideTopSlab(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_slab"), Identifier.of(Desire.MOD_ID, "block/flintstone_side"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"), Identifier.of(Desire.MOD_ID, "block/flintstone_bottom"));
        sideTopWall(blockStateModelGenerator, BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_wall"), Identifier.of(Desire.MOD_ID, "block/flintstone_side"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"), Identifier.of(Desire.MOD_ID, "block/flintstone_bottom"));

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

    public void customTextureStairs(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier textureName) {
        TextureMap textures = TextureMap.all(textureName);
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

    public void customTextureSlab(BlockStateModelGenerator blockStateModelGenerator, Block block, Block baseBlock, Identifier textureName) {
        TextureMap textures = TextureMap.all(textureName);
        Identifier identifier = Models.SLAB.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.SLAB_TOP.upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(block, identifier, identifier2, Identifier.of(Registries.BLOCK.getId(baseBlock).getNamespace(), "block/" + Registries.BLOCK.getId(baseBlock).getPath())));
        blockStateModelGenerator.registerParentedItemModel(block, identifier);
    }

    public void sideTopSlab(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier sideTexture, Identifier topTexture, Identifier bottomTexture) {
        TextureMap textures = new TextureMap().put(TextureKey.SIDE, sideTexture).put(TextureKey.TOP, topTexture).put(TextureKey.BOTTOM, bottomTexture);
        Identifier identifier = Models.SLAB.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.SLAB_TOP.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.CUBE_BOTTOM_TOP.upload(Identifier.of(Registries.BLOCK.getId(block).getNamespace(), "block/" + Registries.BLOCK.getId(block).getPath() + "_double"), textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(block, identifier, identifier2, identifier3));
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
    public void sideTopWall(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier sideTexture, Identifier topTexture, Identifier bottomTexture) {
        TextureMap textures = new TextureMap().put(TextureKey.SIDE, sideTexture).put(TextureKey.TOP, topTexture).put(TextureKey.BOTTOM, bottomTexture);
        Identifier identifier = new Model(Optional.of(new Identifier(Desire.MOD_ID, "block/template_wall_post_bottom_top")), Optional.of("_post"), TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP).upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = new Model(Optional.of(new Identifier(Desire.MOD_ID, "block/template_wall_side_bottom_top")), Optional.of("_side"), TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP).upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = new Model(Optional.of(new Identifier(Desire.MOD_ID, "block/template_wall_side_tall_bottom_top")), Optional.of("_side_tall"), TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP).upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(block, identifier, identifier2, identifier3));
        Identifier identifier4 = new Model(Optional.of(new Identifier(Desire.MOD_ID, "block/wall_inventory_bottom_top")), Optional.of("_inventory"), TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP).upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerParentedItemModel(block, identifier4);
    }

    public final void registerParentedPillar(BlockStateModelGenerator blockStateModelGenerator, Block modelSource, Block child) {
        Identifier identifier = ModelIds.getBlockModelId(modelSource);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createAxisRotatedBlockState(child, identifier));
        blockStateModelGenerator.registerParentedItemModel(child, identifier);
    }

    public final void registerMushroomLikeBlock(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier identifier = Models.TEMPLATE_SINGLE_FACE.upload(block, TextureMap.texture(block), blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Identifier.of(Desire.MOD_ID, "block/" + Registries.BLOCK.getId(block).getPath() + "_inside");
        blockStateModelGenerator.blockStateCollector.accept(MultipartBlockStateSupplier.create(block).with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).with(When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true)).with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, true)).with(When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, true)).with(When.create().set(Properties.UP, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, true)).with(When.create().set(Properties.DOWN, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, true)).with(When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)).with(When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.Y, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false)).with(When.create().set(Properties.SOUTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.Y, VariantSettings.Rotation.R180).put(VariantSettings.UVLOCK, false)).with(When.create().set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.Y, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, false)).with(When.create().set(Properties.UP, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.X, VariantSettings.Rotation.R270).put(VariantSettings.UVLOCK, false)).with(When.create().set(Properties.DOWN, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.X, VariantSettings.Rotation.R90).put(VariantSettings.UVLOCK, false)));
        blockStateModelGenerator.registerParentedItemModel(block, TexturedModel.CUBE_ALL.upload(block, "_inventory", blockStateModelGenerator.modelCollector));
    }
}
