package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.desire.Desire;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;

public abstract class DesireModelProvider extends FabricModelProvider {
    public DesireModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public abstract void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator);

    @Override
    public abstract void generateItemModels(ItemModelGenerator itemModelGenerator);

    public static final TextureKey POST = TextureKey.of("post");
    public static final TextureKey TALLSIDE = TextureKey.of("tallside");
    public void stairs(BlockStateModelGenerator blockStateModelGenerator, Block block, Block baseBlock) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(baseBlock);
        TextureMap textures = texturedModel.getTextures();
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

    public void fence(BlockStateModelGenerator blockStateModelGenerator, Block fenceBlock, Block baseBlock) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(baseBlock);
        TextureMap textures = texturedModel.getTextures();
        Identifier identifier = Models.FENCE_POST.upload(fenceBlock, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.FENCE_SIDE.upload(fenceBlock, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(fenceBlock, identifier, identifier2));
        Identifier identifier3 = Models.FENCE_INVENTORY.upload(fenceBlock, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerParentedItemModel(fenceBlock, identifier3);
    }

    public void fenceGate(BlockStateModelGenerator blockStateModelGenerator, Block fenceGateBlock, Block baseBlock) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(baseBlock);
        TextureMap textures = texturedModel.getTextures();
        Identifier identifier = Models.TEMPLATE_FENCE_GATE_OPEN.upload(fenceGateBlock, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_FENCE_GATE.upload(fenceGateBlock, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_FENCE_GATE_WALL_OPEN.upload(fenceGateBlock, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier4 = Models.TEMPLATE_FENCE_GATE_WALL.upload(fenceGateBlock, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createFenceGateBlockState(fenceGateBlock, identifier, identifier2, identifier3, identifier4, true));
    }

    public void pressurePlate(BlockStateModelGenerator blockStateModelGenerator, Block pressurePlateBlock, Block baseBlock) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(baseBlock);
        TextureMap textures = texturedModel.getTextures();
        Identifier identifier = Models.PRESSURE_PLATE_UP.upload(pressurePlateBlock, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.PRESSURE_PLATE_DOWN.upload(pressurePlateBlock, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createPressurePlateBlockState(pressurePlateBlock, identifier, identifier2));
    }

    public void button(BlockStateModelGenerator blockStateModelGenerator, Block buttonBlock, Block baseBlock) {
        TexturedModel texturedModel = TexturedModel.CUBE_ALL.get(baseBlock);
        TextureMap textures = texturedModel.getTextures();
        Identifier identifier = Models.BUTTON.upload(buttonBlock, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.BUTTON_PRESSED.upload(buttonBlock, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createButtonBlockState(buttonBlock, identifier, identifier2));
        Identifier identifier3 = Models.BUTTON_INVENTORY.upload(buttonBlock, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerParentedItemModel(buttonBlock, identifier3);
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

    public void cutSandstoneSlab(BlockStateModelGenerator blockStateModelGenerator, Block block, Block baseBlock, Identifier sideTexture, Identifier topTexture, Identifier bottomTexture) {
        TextureMap textures = new TextureMap().put(TextureKey.SIDE, sideTexture).put(TextureKey.TOP, topTexture).put(TextureKey.BOTTOM, bottomTexture);
        Identifier identifier = Models.SLAB.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.SLAB_TOP.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = ModelIds.getBlockModelId(baseBlock);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(block, identifier, identifier2, identifier3));
        blockStateModelGenerator.registerParentedItemModel(block, identifier);
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
        Identifier identifier = new Model(Optional.of(Identifier.of(Desire.MOD_ID, "block/template_wall_post_bottom_top")), Optional.of("_post"), TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP).upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = new Model(Optional.of(Identifier.of(Desire.MOD_ID, "block/template_wall_side_bottom_top")), Optional.of("_side"), TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP).upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = new Model(Optional.of(Identifier.of(Desire.MOD_ID, "block/template_wall_side_tall_bottom_top")), Optional.of("_side_tall"), TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP).upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(block, identifier, identifier2, identifier3));
        Identifier identifier4 = new Model(Optional.of(Identifier.of(Desire.MOD_ID, "block/wall_inventory_bottom_top")), Optional.of("_inventory"), TextureKey.SIDE, TextureKey.BOTTOM, TextureKey.TOP).upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.registerParentedItemModel(block, identifier4);
    }
    public void polishedWall(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier postTexture, Identifier sideTexture, Identifier tallSideTexture) {
        TextureMap textures = new TextureMap().put(POST, postTexture).put(TextureKey.SIDE, sideTexture).put(TALLSIDE, tallSideTexture);
        Identifier identifier = new Model(Optional.of(Identifier.of(Desire.MOD_ID, "block/template_wall_post_polished")), Optional.of("_post"), POST, TextureKey.SIDE, TALLSIDE).upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = new Model(Optional.of(Identifier.of(Desire.MOD_ID, "block/template_wall_side_polished")), Optional.of("_side"), POST, TextureKey.SIDE, TALLSIDE).upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = new Model(Optional.of(Identifier.of(Desire.MOD_ID, "block/template_wall_side_tall_polished")), Optional.of("_side_tall"), POST, TextureKey.SIDE, TALLSIDE).upload(block, textures, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(block, identifier, identifier2, identifier3));
        Identifier identifier4 = new Model(Optional.of(Identifier.of(Desire.MOD_ID, "block/wall_inventory_polished")), Optional.of("_inventory"), POST, TextureKey.SIDE, TALLSIDE).upload(block, textures, blockStateModelGenerator.modelCollector);
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
