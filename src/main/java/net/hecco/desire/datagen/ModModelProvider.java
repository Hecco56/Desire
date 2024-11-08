package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.desire.Desire;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.registry.ModItemGroups;
import net.hecco.desire.registry.ModItems;
import net.hecco.desire.util.BlockSetGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    public static final TextureKey POST = TextureKey.of("post");
    public static final TextureKey TALLSIDE = TextureKey.of("tallside");
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_stone"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tiles"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_stone_tiles"));
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_granite_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_andesite_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_diorite_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_deepslate_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("brick_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_mud_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_mud_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_packed_mud"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_basalt_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_polished_basalt_bricks"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tiles"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_blackstone"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_blackstone_tiles"));
        for (String wood : BlockSetGenerator.WoodVariantsBlockMaker.WOOD_TYPES) {
            if (wood != "bamboo") {
                blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get(wood + "_mosaic"));
            }
        }
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        registerParentedPillar(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_copper_pillar"));
        registerParentedPillar(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_exposed_copper_pillar"));
        registerParentedPillar(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_weathered_copper_pillar"));
        registerParentedPillar(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_oxidized_copper_pillar"));
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone"), TexturedModel.CUBE_BOTTOM_TOP);

        Identifier smoothFlintstoneModel = Models.CUBE_ALL.upload(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone"), TextureMap.all(Identifier.of(Desire.MOD_ID, "block/flintstone_top")), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone"), BlockStateVariant.create().put(VariantSettings.MODEL, smoothFlintstoneModel)));
        blockStateModelGenerator.registerParentedItemModel(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone"), smoothFlintstoneModel);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_bricks"));
        registerMushroomLikeBlock(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("flint_block"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_flint_block"), TexturedModel.TEMPLATE_GLAZED_TERRACOTTA);
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite"));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_calcite"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_calcite_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore"), TexturedModel.END_FOR_TOP_CUBE_COLUMN.get(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone")).textures((textureMap -> textureMap.put(TextureKey.SIDE, TextureMap.getId(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore"))))).upload(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore"), blockStateModelGenerator.modelCollector));
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("scute_shingles"));
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"));
            blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"));
            blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_scute_shingles"));
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
        customTextureWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_sandstone_wall"), Identifier.of("minecraft", "block/sandstone_top"));
        customTextureWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_red_sandstone_wall"), Identifier.of("minecraft", "block/red_sandstone_top"));
        customTextureWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_quartz_wall"), Identifier.of("minecraft", "block/quartz_block_bottom"));
        sideTopStairs(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_stairs"), Identifier.of("minecraft", "block/smooth_stone_slab_side"), Identifier.of("minecraft", "block/smooth_stone"), Identifier.of("minecraft", "block/smooth_stone"));
        sideTopStairs(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_stairs"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"));
        sideTopSlab(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_slab"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_slab_side"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"));
        customTextureStairs(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_stairs"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"));
        customTextureSlab(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"));
        customTextureWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_wall"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"));
        sideTopStairs(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_stairs"), Identifier.of(Desire.MOD_ID, "block/flintstone_side"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"), Identifier.of(Desire.MOD_ID, "block/flintstone_bottom"));
        sideTopSlab(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_slab"), Identifier.of(Desire.MOD_ID, "block/flintstone_side"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"), Identifier.of(Desire.MOD_ID, "block/flintstone_bottom"));
        sideTopWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_wall"), Identifier.of(Desire.MOD_ID, "block/flintstone_side"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"), Identifier.of(Desire.MOD_ID, "block/flintstone_bottom"));
        sideTopStairs(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_brick_stairs"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks_top"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks_top"));
        sideTopSlab(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_brick_slab"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks_top"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks_top"));

        polishedWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone_wall"), Identifier.of(Desire.MOD_ID, "block/polished_stone_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_stone_wall_side"), Identifier.of(Desire.MOD_ID, "block/polished_stone"));
        polishedWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud_wall"), Identifier.of(Desire.MOD_ID, "block/polished_mud_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_mud_wall_side"), Identifier.of(Desire.MOD_ID, "block/polished_mud"));
        polishedWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_wall"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_wall_post"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_wall_side"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block"));
        polishedWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite_wall"), Identifier.of(Desire.MOD_ID, "block/polished_calcite_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_calcite_wall_side"), Identifier.of(Desire.MOD_ID, "block/polished_calcite"));
        polishedWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_wall"), Identifier.of(Desire.MOD_ID, "block/polished_andesite_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_andesite_wall_side"), Identifier.of("minecraft", "block/polished_andesite"));
        polishedWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_wall"), Identifier.of(Desire.MOD_ID, "block/polished_granite_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_granite_wall_side"), Identifier.of("minecraft", "block/polished_granite"));
        polishedWall(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_wall"), Identifier.of(Desire.MOD_ID, "block/polished_diorite_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_diorite_wall_side"), Identifier.of("minecraft", "block/polished_diorite"));
        polishedWall(blockStateModelGenerator, Blocks.POLISHED_BLACKSTONE_WALL, Identifier.of(Desire.MOD_ID, "block/polished_blackstone_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_blackstone_wall_side"), Identifier.of("minecraft", "block/polished_blackstone"));
        polishedWall(blockStateModelGenerator, Blocks.POLISHED_DEEPSLATE_WALL, Identifier.of(Desire.MOD_ID, "block/polished_deepslate_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_deepslate_wall_side"), Identifier.of("minecraft", "block/polished_deepslate"));
        sideTopStairs(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cut_sandstone_stairs"), Identifier.of(Desire.MOD_ID, "block/cut_sandstone_slab"), Identifier.of(Desire.MOD_ID, "block/cut_sandstone_top"), Identifier.of(Desire.MOD_ID, "block/cut_sandstone_top"));
        sideTopStairs(blockStateModelGenerator, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cut_red_sandstone_stairs"), Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_slab"), Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_top"), Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_top"));

        Identifier cutSandstoneModel = Models.CUBE_BOTTOM_TOP.upload(Blocks.CUT_SANDSTONE, TextureMap.sideTopBottom(Blocks.CUT_SANDSTONE).put(TextureKey.SIDE, Identifier.of("minecraft", "block/cut_sandstone")).put(TextureKey.TOP , Identifier.of(Desire.MOD_ID, "block/cut_sandstone_top")).put(TextureKey.BOTTOM , Identifier.of(Desire.MOD_ID, "block/cut_sandstone_top")), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(Blocks.CUT_SANDSTONE, BlockStateVariant.create().put(VariantSettings.MODEL, cutSandstoneModel)));
        blockStateModelGenerator.registerParentedItemModel(Blocks.CUT_SANDSTONE, cutSandstoneModel);
        Identifier cutRedSandstoneModel = Models.CUBE_BOTTOM_TOP.upload(Blocks.CUT_RED_SANDSTONE, TextureMap.sideTopBottom(Blocks.CUT_RED_SANDSTONE).put(TextureKey.SIDE, Identifier.of("minecraft", "block/cut_red_sandstone")).put(TextureKey.TOP , Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_top")).put(TextureKey.BOTTOM , Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_top")), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(Blocks.CUT_RED_SANDSTONE, BlockStateVariant.create().put(VariantSettings.MODEL, cutRedSandstoneModel)));
        blockStateModelGenerator.registerParentedItemModel(Blocks.CUT_RED_SANDSTONE, cutRedSandstoneModel);
        cutSandstoneSlab(blockStateModelGenerator, Blocks.CUT_SANDSTONE_SLAB, Blocks.CUT_SANDSTONE, Identifier.of(Desire.MOD_ID, "block/cut_sandstone_slab"), Identifier.of(Desire.MOD_ID, "block/cut_sandstone_top"), Identifier.of(Desire.MOD_ID, "block/cut_sandstone_top"));
        cutSandstoneSlab(blockStateModelGenerator, Blocks.CUT_RED_SANDSTONE_SLAB, Blocks.CUT_RED_SANDSTONE, Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_slab"), Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_top"), Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_top"));

        Identifier chiseledSandstoneModel = Models.CUBE_BOTTOM_TOP.upload(Blocks.CHISELED_SANDSTONE, TextureMap.sideTopBottom(Blocks.CHISELED_SANDSTONE).put(TextureKey.SIDE, Identifier.of("minecraft", "block/chiseled_sandstone")).put(TextureKey.TOP , Identifier.of(Desire.MOD_ID, "block/cut_sandstone_top")).put(TextureKey.BOTTOM , Identifier.of(Desire.MOD_ID, "block/cut_sandstone_top")), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(Blocks.CHISELED_SANDSTONE, BlockStateVariant.create().put(VariantSettings.MODEL, chiseledSandstoneModel)));
        blockStateModelGenerator.registerParentedItemModel(Blocks.CHISELED_SANDSTONE, chiseledSandstoneModel);
        Identifier chiseledRedSandstoneModel = Models.CUBE_BOTTOM_TOP.upload(Blocks.CHISELED_RED_SANDSTONE, TextureMap.sideTopBottom(Blocks.CHISELED_RED_SANDSTONE).put(TextureKey.SIDE, Identifier.of("minecraft", "block/chiseled_red_sandstone")).put(TextureKey.TOP , Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_top")).put(TextureKey.BOTTOM , Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_top")), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(Blocks.CHISELED_RED_SANDSTONE, BlockStateVariant.create().put(VariantSettings.MODEL, chiseledRedSandstoneModel)));
        blockStateModelGenerator.registerParentedItemModel(Blocks.CHISELED_RED_SANDSTONE, chiseledRedSandstoneModel);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.STONE_BOULDER.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DEEPSLATE_SHEET.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLACKSTONE_CHUNK.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.DESIRE_ICON.asItem(), Models.GENERATED);
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

    public void cutSandstoneSlab(BlockStateModelGenerator blockStateModelGenerator, Block block, Block baseBlock, Identifier sideTexture, Identifier topTexture, Identifier bottomTexture) {
        TextureMap textures = new TextureMap().put(TextureKey.SIDE, sideTexture).put(TextureKey.TOP, topTexture).put(TextureKey.BOTTOM, bottomTexture);
        Identifier identifier = Models.SLAB.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = Models.SLAB_TOP.upload(block, textures, blockStateModelGenerator.modelCollector);
        Identifier identifier3 = ModelIds.getBlockModelId(baseBlock);
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
