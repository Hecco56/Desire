package net.hecco.desire.datagen.desire;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.netherexp.JNEModBlocks;
import net.hecco.desire.datagen.DesireModelProvider;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.registry.ModItems;
import net.hecco.desire.util.BlockSetGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends DesireModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
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
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block"));
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
        blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_calcite_bricks"));
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_calcite"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_calcite_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore"), TexturedModel.END_FOR_TOP_CUBE_COLUMN.get(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone")).textures((textureMap -> textureMap.put(TextureKey.SIDE, TextureMap.getId(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore"))))).upload(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore"), blockStateModelGenerator.modelCollector));
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"));
            blockStateModelGenerator.registerSimpleCubeAll(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"));
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

        blockStateModelGenerator.registerSimpleCubeAll(JNEModBlocks.CLARET_MOSAIC);
        blockStateModelGenerator.registerParentedItemModel(JNEModBlocks.CLARET_MOSAIC, Identifier.of(Desire.JADENS_NETHER_EXPANSION, "claret_mosaic").withPrefixedPath("block/"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.STONE_BOULDER.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DEEPSLATE_SHEET.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLACKSTONE_CHUNK.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.DESIRE_ICON.asItem(), Models.GENERATED);
    }
}
