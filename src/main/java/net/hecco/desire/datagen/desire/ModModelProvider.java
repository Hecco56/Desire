package net.hecco.desire.datagen.desire;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.natures_spirit.NSModBlocks;
import net.hecco.desire.compat.netherexp.JNEModBlocks;
import net.hecco.desire.datagen.DesireModelProvider;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.registry.ModItems;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;
import java.util.stream.Stream;

public class ModModelProvider extends DesireModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (Block block : BlockFamilyGenerator.CUBE_ALL) {
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }
        for (Block block : BlockFamilyGenerator.STAIRS) {
            if (!BlockFamilyGenerator.CUSTOM_STAIRS_MODEL.contains(block)) {
                stairs(blockStateModelGenerator, block, BlockFamilyGenerator.VARIANT_TO_BASE_BLOCK.get(block));
            }
        }
        for (Block block : BlockFamilyGenerator.SLABS) {
            if (!BlockFamilyGenerator.CUSTOM_SLAB_MODEL.contains(block)) {
                slab(blockStateModelGenerator, block, BlockFamilyGenerator.VARIANT_TO_BASE_BLOCK.get(block));
            }
        }
        for (Block block : BlockFamilyGenerator.WALLS) {
            if (!BlockFamilyGenerator.CUSTOM_WALL_MODEL.contains(block)) {
                wall(blockStateModelGenerator, block, BlockFamilyGenerator.VARIANT_TO_BASE_BLOCK.get(block));
            }
        }
        for (Object block : ArrayUtils.addAll(BlockFamilyGenerator.WOODEN_FENCES.toArray(), BlockFamilyGenerator.FENCES.toArray())) {
            fence(blockStateModelGenerator, (Block) block, BlockFamilyGenerator.VARIANT_TO_BASE_BLOCK.get((Block) block));
        }
        for (Block block : BlockFamilyGenerator.FENCE_GATES) {
            fenceGate(blockStateModelGenerator, block, BlockFamilyGenerator.VARIANT_TO_BASE_BLOCK.get(block));
        }
        for (Map.Entry<Block, Block> entry : BlockFamilyGenerator.LOGS_TO_WOODS.entrySet()) {
            blockStateModelGenerator.registerLog(entry.getKey()).log(entry.getKey()).wood(entry.getValue());
        }
        for (Object block : ArrayUtils.addAll(BlockFamilyGenerator.WOODEN_DOORS.toArray(), BlockFamilyGenerator.DOORS.toArray())) {
            blockStateModelGenerator.registerDoor((Block) block);
        }
        for (Object block : ArrayUtils.addAll(BlockFamilyGenerator.WOODEN_TRAPDOORS.toArray(), BlockFamilyGenerator.TRAPDOORS.toArray())) {
            blockStateModelGenerator.registerOrientableTrapdoor((Block) block);
        }
        for (Block block : Stream.concat(Stream.concat(BlockFamilyGenerator.WOODEN_PRESSURE_PLATES.stream(), BlockFamilyGenerator.STONE_PRESSURE_PLATES.stream()), BlockFamilyGenerator.PRESSURE_PLATES.stream()).toList()) {
            pressurePlate(blockStateModelGenerator, block, BlockFamilyGenerator.VARIANT_TO_BASE_BLOCK.get(block));
        }
        for (Block block : Stream.concat(Stream.concat(BlockFamilyGenerator.WOODEN_BUTTONS.stream(), BlockFamilyGenerator.STONE_BUTTONS.stream()), BlockFamilyGenerator.BUTTONS.stream()).toList()) {
            button(blockStateModelGenerator, block, BlockFamilyGenerator.VARIANT_TO_BASE_BLOCK.get(block));
        }
        for (Block block : BlockFamilyGenerator.LEAVES) {
            blockStateModelGenerator.registerSingleton(block, TexturedModel.LEAVES);
        }
        for (Block block : BlockFamilyGenerator.FLOWER_POTS) {
            blockStateModelGenerator.registerFlowerPotPlant(((FlowerPotBlock) block).getContent(), block, BlockStateModelGenerator.TintType.NOT_TINTED);
        }


        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("chiseled"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_granite").getVariant("bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_granite").getVariant("cracked_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("chiseled"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCKS.get("chiseled_calcite_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCKS.get("chiseled_deepslate_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCKS.get("chiseled_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockFamilyGenerator.BLOCKS.get("brick_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCK_FAMILIES.get("mud").getVariant("chiseled_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockFamilyGenerator.BLOCK_FAMILIES.get("mud").getVariant("smooth_packed"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockFamilyGenerator.BLOCKS.get("cracked_polished_basalt_bricks"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCKS.get("chiseled_blackstone"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockFamilyGenerator.BLOCKS.get("copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockFamilyGenerator.BLOCKS.get("exposed_copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockFamilyGenerator.BLOCKS.get("weathered_copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockFamilyGenerator.BLOCKS.get("oxidized_copper_pillar"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        registerParentedPillar(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("copper_pillar"), BlockFamilyGenerator.BLOCKS.get("waxed_copper_pillar"));
        registerParentedPillar(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("exposed_copper_pillar"), BlockFamilyGenerator.BLOCKS.get("waxed_exposed_copper_pillar"));
        registerParentedPillar(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("weathered_copper_pillar"), BlockFamilyGenerator.BLOCKS.get("waxed_weathered_copper_pillar"));
        registerParentedPillar(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("oxidized_copper_pillar"), BlockFamilyGenerator.BLOCKS.get("waxed_oxidized_copper_pillar"));
        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCKS.get("flintstone"), TexturedModel.CUBE_BOTTOM_TOP);
        Identifier smoothFlintstoneModel = Models.CUBE_ALL.upload(BlockFamilyGenerator.BLOCKS.get("smooth_flintstone"), TextureMap.all(Identifier.of(Desire.MOD_ID, "block/flintstone_top")), blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlockFamilyGenerator.BLOCKS.get("smooth_flintstone"), BlockStateVariant.create().put(VariantSettings.MODEL, smoothFlintstoneModel)));
        blockStateModelGenerator.registerParentedItemModel(BlockFamilyGenerator.BLOCKS.get("smooth_flintstone"), smoothFlintstoneModel);
        registerMushroomLikeBlock(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("flint_block"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotated(BlockFamilyGenerator.BLOCKS.get("polished_flint_block"), TexturedModel.TEMPLATE_GLAZED_TERRACOTTA);
        blockStateModelGenerator.registerAxisRotated(BlockFamilyGenerator.BLOCKS.get("carved_dripstone"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(BlockFamilyGenerator.BLOCKS.get("carved_dripstone_ore"), TexturedModel.END_FOR_TOP_CUBE_COLUMN.get(BlockFamilyGenerator.BLOCKS.get("carved_dripstone")).textures((textureMap -> textureMap.put(TextureKey.SIDE, TextureMap.getId(BlockFamilyGenerator.BLOCKS.get("carved_dripstone_ore"))))).upload(BlockFamilyGenerator.BLOCKS.get("carved_dripstone_ore"), blockStateModelGenerator.modelCollector));

        customTextureWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("smooth_sandstone_wall"), Identifier.of("minecraft", "block/sandstone_top"));
        customTextureWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("smooth_red_sandstone_wall"), Identifier.of("minecraft", "block/red_sandstone_top"));
        customTextureWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("smooth_quartz_wall"), Identifier.of("minecraft", "block/quartz_block_bottom"));
        sideTopStairs(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("smooth_stone_stairs"), Identifier.of("minecraft", "block/smooth_stone_slab_side"), Identifier.of("minecraft", "block/smooth_stone"), Identifier.of("minecraft", "block/smooth_stone"));
        sideTopStairs(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("rough_concrete_stairs"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"));
        sideTopSlab(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("rough_concrete_slab"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_slab_side"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block_top"));
        customTextureStairs(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("smooth_flintstone_stairs"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"));
        customTextureSlab(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("smooth_flintstone_slab"), BlockFamilyGenerator.BLOCKS.get("smooth_flintstone"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"));
        customTextureWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("smooth_flintstone_wall"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"));
        sideTopStairs(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("flintstone_stairs"), Identifier.of(Desire.MOD_ID, "block/flintstone_side"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"), Identifier.of(Desire.MOD_ID, "block/flintstone_bottom"));
        sideTopSlab(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("flintstone_slab"), Identifier.of(Desire.MOD_ID, "block/flintstone_side"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"), Identifier.of(Desire.MOD_ID, "block/flintstone_bottom"));
        sideTopWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("flintstone_wall"), Identifier.of(Desire.MOD_ID, "block/flintstone_side"), Identifier.of(Desire.MOD_ID, "block/flintstone_top"), Identifier.of(Desire.MOD_ID, "block/flintstone_bottom"));
        sideTopStairs(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("polished_granite_brick_stairs"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks_top"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks_top"));
        sideTopSlab(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("polished_granite_brick_slab"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks_top"), Identifier.of(Desire.MOD_ID, "block/polished_granite_bricks_top"));
        blockStateModelGenerator.registerSingleton(BlockFamilyGenerator.BLOCK_FAMILIES.get("rough_concrete").getVariant("block"), TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        polishedWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("polished_stone_wall"), Identifier.of(Desire.MOD_ID, "block/polished_stone_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_stone_wall_side"), Identifier.of(Desire.MOD_ID, "block/polished_stone"));
        polishedWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("polished_mud_wall"), Identifier.of(Desire.MOD_ID, "block/polished_mud_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_mud_wall_side"), Identifier.of(Desire.MOD_ID, "block/polished_mud"));
        polishedWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("rough_concrete_wall"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_wall_post"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_wall_side"), Identifier.of(Desire.MOD_ID, "block/rough_concrete_block"));
        polishedWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("polished_calcite_wall"), Identifier.of(Desire.MOD_ID, "block/polished_calcite_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_calcite_wall_side"), Identifier.of(Desire.MOD_ID, "block/polished_calcite"));
        polishedWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("polished_andesite_wall"), new Identifier(Desire.MOD_ID, "block/polished_andesite_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_andesite_wall_side"), new Identifier("minecraft", "block/polished_andesite"));
        polishedWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("polished_granite_wall"), new Identifier(Desire.MOD_ID, "block/polished_granite_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_granite_wall_side"), new Identifier("minecraft", "block/polished_granite"));
        polishedWall(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("polished_diorite_wall"), new Identifier(Desire.MOD_ID, "block/polished_diorite_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_diorite_wall_side"), new Identifier("minecraft", "block/polished_diorite"));
        polishedWall(blockStateModelGenerator, Blocks.POLISHED_BLACKSTONE_WALL, Identifier.of(Desire.MOD_ID, "block/polished_blackstone_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_blackstone_wall_side"), Identifier.of("minecraft", "block/polished_blackstone"));
        polishedWall(blockStateModelGenerator, Blocks.POLISHED_DEEPSLATE_WALL, Identifier.of(Desire.MOD_ID, "block/polished_deepslate_wall_post"), Identifier.of(Desire.MOD_ID, "block/polished_deepslate_wall_side"), Identifier.of("minecraft", "block/polished_deepslate"));
        sideTopStairs(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("cut_sandstone_stairs"), Identifier.of(Desire.MOD_ID, "block/cut_sandstone_slab"), Identifier.of(Desire.MOD_ID, "block/cut_sandstone_top"), Identifier.of(Desire.MOD_ID, "block/cut_sandstone_top"));
        sideTopStairs(blockStateModelGenerator, BlockFamilyGenerator.BLOCKS.get("cut_red_sandstone_stairs"), Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_slab"), Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_top"), Identifier.of(Desire.MOD_ID, "block/cut_red_sandstone_top"));

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
        stairs(blockStateModelGenerator, JNEModBlocks.CLARET_MOSAIC_STAIRS, JNEModBlocks.CLARET_MOSAIC);
        slab(blockStateModelGenerator, JNEModBlocks.CLARET_MOSAIC_SLAB, JNEModBlocks.CLARET_MOSAIC);

        blockStateModelGenerator.registerSimpleCubeAll(JNEModBlocks.POLISHED_NETHER_BRICKS);
        blockStateModelGenerator.registerParentedItemModel(JNEModBlocks.POLISHED_NETHER_BRICKS, Registries.BLOCK.getId(JNEModBlocks.POLISHED_NETHER_BRICKS).withPrefixedPath("block/"));

        blockStateModelGenerator.registerSimpleCubeAll(JNEModBlocks.POLISHED_RED_NETHER_BRICKS);
        blockStateModelGenerator.registerParentedItemModel(JNEModBlocks.POLISHED_RED_NETHER_BRICKS, Registries.BLOCK.getId(JNEModBlocks.POLISHED_RED_NETHER_BRICKS).withPrefixedPath("block/"));

        blockStateModelGenerator.registerSimpleCubeAll(JNEModBlocks.POLISHED_BLUE_NETHER_BRICKS);
        blockStateModelGenerator.registerParentedItemModel(JNEModBlocks.POLISHED_BLUE_NETHER_BRICKS, Registries.BLOCK.getId(JNEModBlocks.POLISHED_BLUE_NETHER_BRICKS).withPrefixedPath("block/"));

        blockStateModelGenerator.registerSimpleCubeAll(JNEModBlocks.CRACKED_RED_NETHER_BRICKS);
        blockStateModelGenerator.registerParentedItemModel(JNEModBlocks.CRACKED_RED_NETHER_BRICKS, Registries.BLOCK.getId(JNEModBlocks.CRACKED_RED_NETHER_BRICKS).withPrefixedPath("block/"));

        blockStateModelGenerator.registerSimpleCubeAll(JNEModBlocks.CRACKED_BLUE_NETHER_BRICKS);
        blockStateModelGenerator.registerParentedItemModel(JNEModBlocks.CRACKED_BLUE_NETHER_BRICKS, Registries.BLOCK.getId(JNEModBlocks.CRACKED_BLUE_NETHER_BRICKS).withPrefixedPath("block/"));

        blockStateModelGenerator.registerSimpleCubeAll(JNEModBlocks.CHISELED_RED_NETHER_BRICKS);
        blockStateModelGenerator.registerParentedItemModel(JNEModBlocks.CHISELED_RED_NETHER_BRICKS, Registries.BLOCK.getId(JNEModBlocks.CHISELED_RED_NETHER_BRICKS).withPrefixedPath("block/"));

        blockStateModelGenerator.registerSimpleCubeAll(JNEModBlocks.CHISELED_BLUE_NETHER_BRICKS);
        blockStateModelGenerator.registerParentedItemModel(JNEModBlocks.CHISELED_BLUE_NETHER_BRICKS, Registries.BLOCK.getId(JNEModBlocks.CHISELED_BLUE_NETHER_BRICKS).withPrefixedPath("block/"));

        fence(blockStateModelGenerator, JNEModBlocks.RED_NETHER_BRICK_FENCE, Blocks.RED_NETHER_BRICKS);



        for (DyeColor color : ModDatagenUtils.VANILLA_COLORS.stream().map((color) -> DyeColor.byName(color, DyeColor.WHITE)).toList()) {
            wall(blockStateModelGenerator, NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(color), Registries.BLOCK.get(Identifier.of(Desire.NATURES_SPIRIT, color.getName() + "_kaolin_bricks")));
        }

        for (String wood : NSModBlocks.WOOD_TYPES) {
            blockStateModelGenerator.registerSimpleCubeAll(NSModBlocks.WOOD_MOSAICS.get(wood));
            blockStateModelGenerator.registerParentedItemModel(NSModBlocks.WOOD_MOSAICS.get(wood), Identifier.of(Desire.NATURES_SPIRIT, wood + "_mosaic").withPrefixedPath("block/"));
            stairs(blockStateModelGenerator, NSModBlocks.WOOD_MOSAIC_STAIRS.get(wood), NSModBlocks.WOOD_MOSAICS.get(wood));
            slab(blockStateModelGenerator, NSModBlocks.WOOD_MOSAIC_SLABS.get(wood), NSModBlocks.WOOD_MOSAICS.get(wood));
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.STONE_BOULDER.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.DEEPSLATE_SHEET.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLACKSTONE_CHUNK.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.DESIRE_ICON.asItem(), Models.GENERATED);
    }
}
