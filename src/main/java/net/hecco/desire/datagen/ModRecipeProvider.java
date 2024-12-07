package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.util.BlockSetGenerator;
import net.hecco.desire.util.StonecutterRecipeTreeGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

import static net.minecraft.data.family.BlockFamilies.register;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offer2x2ReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModBlocks.STONE_BOULDER, RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE, "cobblestone_from_stone_boulder", "cobblestone", "stone_boulder", "stone_boulder");
        offer2x2ReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModBlocks.DEEPSLATE_SHEET, RecipeCategory.BUILDING_BLOCKS, Items.COBBLED_DEEPSLATE, "cobbled_deepslate_from_deepslate_sheet", "cobbled_deepslate", "deepslate_sheet", "deepslate_sheet");
        offer2x2ReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModBlocks.BLACKSTONE_CHUNK, RecipeCategory.BUILDING_BLOCKS, Items.BLACKSTONE, "blackstone_from_blackstone_chunk", "blackstone", "blackstone_chunk", "blackstone_chunk");
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_wall"), Blocks.STONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_wall"), Blocks.POLISHED_GRANITE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_wall"), Blocks.POLISHED_ANDESITE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_wall"), Blocks.POLISHED_DIORITE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_sandstone_wall"), Blocks.SMOOTH_SANDSTONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_red_sandstone_wall"), Blocks.SMOOTH_RED_SANDSTONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_quartz_wall"), Blocks.SMOOTH_QUARTZ);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("dark_prismarine_wall"), Blocks.DARK_PRISMARINE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("prismarine_brick_wall"), Blocks.PRISMARINE_BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_stone"), Blocks.STONE_SLAB);
        createStairsRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_stairs"), Ingredient.ofItems(Blocks.SMOOTH_STONE)).criterion("has_smooth_stone", conditionsFromItem(Blocks.SMOOTH_STONE)).offerTo(exporter);
        createStairsRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cut_sandstone_stairs"), Ingredient.ofItems(Blocks.CUT_SANDSTONE)).criterion(hasItem(Blocks.CUT_SANDSTONE), conditionsFromItem(Blocks.CUT_SANDSTONE)).offerTo(exporter);
        createStairsRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cut_red_sandstone_stairs"), Ingredient.ofItems(Blocks.CUT_RED_SANDSTONE)).criterion(hasItem(Blocks.CUT_RED_SANDSTONE), conditionsFromItem(Blocks.CUT_RED_SANDSTONE)).offerTo(exporter);
        generateSSWFamily(exporter, Blocks.SMOOTH_BASALT, "smooth_basalt");
        generateSSWFamily(exporter, Blocks.QUARTZ_BRICKS, "quartz_brick");
        generateSSWFamily(exporter, Blocks.CALCITE, "calcite");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_bricks"), Blocks.COBBLESTONE);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_bricks"), "cobblestone_brick");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"), Blocks.MOSSY_COBBLESTONE);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"))
                .input(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_bricks"))
                .input(Blocks.MOSS_BLOCK)
                .group("mossy_cobblestone")
                .criterion(hasItem(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_bricks")), conditionsFromItem(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_bricks")))
                .offerTo(exporter, "mossy_cobblestone_bricks_from_cobblestone_bricks");
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"), "mossy_cobblestone_brick");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_bricks"), Blocks.SMOOTH_STONE);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_bricks"), "smooth_stone_brick");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"));
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"), "polished_stone");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tiles"), Blocks.STONE_BRICKS);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tiles"), "stone_tile");
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_stone_tiles"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tiles"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_bricks"), Blocks.POLISHED_GRANITE);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_bricks"), "polished_granite_brick");
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_granite_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_bricks"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"), Blocks.POLISHED_ANDESITE);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"), "polished_andesite_brick");
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_andesite_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"), Blocks.POLISHED_DIORITE);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"), "polished_diorite_brick");
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_diorite_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_deepslate_bricks"), Blocks.DEEPSLATE_BRICK_SLAB);
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_bricks"), Blocks.BRICKS);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_bricks"))
                .input(Blocks.BRICKS)
                .input(Blocks.MOSS_BLOCK)
                .group("mossy_bricks")
                .criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS))
                .offerTo(exporter);
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            createRoughConcreteRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_concrete"))).offerTo(exporter, color + "_rough_concrete");
        }
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete"));
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block"), "rough_concrete");
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"), "polished_mud");
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_mud_bricks"), Blocks.MUD_BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_mud_bricks"), Blocks.MUD_BRICK_SLAB);
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_packed_mud"), Blocks.PACKED_MUD);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"), Blocks.POLISHED_BASALT);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_polished_basalt_bricks"))
                .pattern("##")
                .input('#', BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"))
                .criterion(hasItem(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_basalt_bricks")), conditionsFromItem(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_basalt_bricks")))
                .offerTo(exporter);
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_basalt_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tiles"), 4)
                .pattern("#B")
                .pattern("B#")
                .input('#', Blocks.POLISHED_BASALT)
                .input('B', Blocks.POLISHED_BLACKSTONE)
                .criterion(hasItem(Blocks.POLISHED_BASALT), conditionsFromItem(Blocks.POLISHED_BASALT))
                .offerTo(exporter);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tiles"), "basalt_tile");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"), Blocks.SMOOTH_BASALT);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"), "smooth_basalt_brick");
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_blackstone"), Blocks.BLACKSTONE_SLAB);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"), Blocks.POLISHED_BLACKSTONE_BRICKS);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"), "polished_blackstone_tile");
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_blackstone_tiles"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"));
        for (String wood : BlockSetGenerator.WoodVariantsBlockMaker.WOOD_TYPES) {
            if (wood != "bamboo") {
                offerMosaicRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get(wood + "_mosaic"), BlockSetGenerator.WoodVariantsBlockMaker.WOOD_SLABS.get(BlockSetGenerator.WoodVariantsBlockMaker.WOOD_TYPES.indexOf(wood)));
                generateSSFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get(wood + "_mosaic"), wood + "_mosaic");
            }
        }
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone"), Blocks.GRAVEL);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone"), "flintstone");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone"));
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_bricks"), "flintstone_brick");
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone"));
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone"), "smooth_flintstone");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.GRAVEL, 1)
                .input(Items.FLINT, 2)
                .input(Ingredient.fromTag(ModItemTagProvider.ROCKS), 2)
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .offerTo(exporter);
        offerPillarRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("copper_pillar"), Blocks.COPPER_BLOCK);
        offerPillarRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), Blocks.EXPOSED_COPPER);
        offerPillarRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), Blocks.WEATHERED_COPPER);
        offerPillarRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"), Blocks.WEATHERED_COPPER);
        offerPillarRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_copper_pillar"), Blocks.WAXED_COPPER_BLOCK);
        offerPillarRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_exposed_copper_pillar"), Blocks.WAXED_EXPOSED_COPPER);
        offerPillarRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_weathered_copper_pillar"), Blocks.WAXED_WEATHERED_COPPER);
        offerPillarRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_oxidized_copper_pillar"), Blocks.WAXED_WEATHERED_COPPER);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.FLINT, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("flint_block"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_flint_block"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flint_block"));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_calcite"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_slab"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite"), Blocks.CALCITE);
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite"), "polished_calcite");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite"));
        generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_bricks"), "calcite_brick");
        offerCrackingRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_calcite_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_bricks"));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_calcite_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_brick_slab"));
        offerPillarRecipe(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("brick_pillar"), Blocks.BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_bricks"), Blocks.BRICK_SLAB);
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_concrete")));
            generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"), color + "_concrete_brick");
            offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_glazed_terracotta")));
            generateSSWFamily(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"), color + "_terracotta_mosaic");
        }

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_wall"), Blocks.STONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_stone"), Blocks.STONE);

        StonecutterRecipeTreeGenerator.putShadowRecipe(Blocks.POLISHED_ANDESITE, Blocks.ANDESITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_wall"), Blocks.POLISHED_ANDESITE);

        StonecutterRecipeTreeGenerator.putShadowRecipe(Blocks.POLISHED_GRANITE, Blocks.GRANITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_wall"), Blocks.POLISHED_GRANITE);

        StonecutterRecipeTreeGenerator.putShadowRecipe(Blocks.POLISHED_DIORITE, Blocks.DIORITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_wall"), Blocks.POLISHED_DIORITE);

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("prismarine_brick_wall"), Blocks.PRISMARINE_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("dark_prismarine_wall"), Blocks.DARK_PRISMARINE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_quartz_wall"), Blocks.SMOOTH_QUARTZ);

        StonecutterRecipeTreeGenerator.putShadowRecipe(Blocks.QUARTZ_BRICKS, Blocks.QUARTZ_BLOCK);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("quartz_brick_wall"), Blocks.QUARTZ_BRICKS);

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_sandstone_wall"), Blocks.SMOOTH_SANDSTONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_red_sandstone_wall"), Blocks.SMOOTH_RED_SANDSTONE);

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_stairs"), Blocks.CALCITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_slab"), Blocks.CALCITE, 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_wall"), Blocks.CALCITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_calcite"), Blocks.CALCITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite"), Blocks.CALCITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_calcite"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_brick_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_brick_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_brick_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_calcite_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("calcite_bricks"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_brick_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_brick_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_brick_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_bricks"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_flint_block"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("flint_block"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("copper_pillar"), Blocks.COPPER_BLOCK);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), Blocks.EXPOSED_COPPER);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), Blocks.WEATHERED_COPPER);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"), Blocks.OXIDIZED_COPPER);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_copper_pillar"), Blocks.WAXED_COPPER_BLOCK);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_exposed_copper_pillar"), Blocks.WAXED_EXPOSED_COPPER);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_weathered_copper_pillar"), Blocks.WAXED_WEATHERED_COPPER);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_oxidized_copper_pillar"), Blocks.WAXED_OXIDIZED_COPPER);

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_stairs"), Blocks.SMOOTH_STONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_bricks"), Blocks.SMOOTH_STONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_brick_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_brick_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_brick_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_stone_bricks"));


        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_bricks"), Blocks.POLISHED_GRANITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_brick_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_brick_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_bricks"), 2);

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"), Blocks.POLISHED_ANDESITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_brick_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_brick_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"), 2);

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"), Blocks.POLISHED_DIORITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_brick_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_brick_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"), 2);


        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"), Blocks.STONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICK_STAIRS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICK_SLAB, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"), 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICK_WALL, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tiles"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tile_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tile_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"), 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tile_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_stone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tiles"), Blocks.STONE_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tile_stairs"), Blocks.STONE_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tile_slab"), Blocks.STONE_BRICKS, 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_tile_wall"), Blocks.STONE_BRICKS);

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_bricks"), Blocks.COBBLESTONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_brick_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_brick_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_brick_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("cobblestone_bricks"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"), Blocks.MOSSY_COBBLESTONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_brick_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_brick_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_brick_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"));

        StonecutterRecipeTreeGenerator.putRecipe(Blocks.MUD_BRICKS, Blocks.PACKED_MUD);
        StonecutterRecipeTreeGenerator.putRecipe(Blocks.MUD_BRICK_STAIRS, Blocks.MUD_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(Blocks.MUD_BRICK_SLAB, Blocks.MUD_BRICKS, 2);
        StonecutterRecipeTreeGenerator.putRecipe(Blocks.MUD_BRICK_WALL, Blocks.MUD_BRICKS);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"), Blocks.MUD_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"), Blocks.PACKED_MUD);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_STAIRS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_SLAB, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"), 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_WALL, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_mud_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_mud_bricks"), Blocks.MUD_BRICKS);

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_stairs"), Blocks.SMOOTH_BASALT);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_slab"), Blocks.SMOOTH_BASALT, 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_wall"), Blocks.SMOOTH_BASALT);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"), Blocks.SMOOTH_BASALT);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_brick_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_brick_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_brick_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tile_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tiles"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tile_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tiles"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tile_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tiles"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"), Blocks.POLISHED_BLACKSTONE_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tile_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tile_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tile_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block"));
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_concrete")));
            StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_brick_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"));
            StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_brick_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"), 2);
            StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_brick_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"));

            StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_glazed_terracotta")));
            StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic_stairs"), BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"));
            StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic_slab"), BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"), 2);
            StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic_wall"), BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"));
        }

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_deepslate_bricks"), Blocks.DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_deepslate_bricks"), Blocks.POLISHED_DEEPSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_deepslate_bricks"), Blocks.DEEPSLATE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("brick_pillar"), Blocks.BRICKS);

        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"), Blocks.POLISHED_BASALT);
        StonecutterRecipeTreeGenerator.putRecipe(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_polished_basalt_bricks"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_blackstone"), Blocks.BLACKSTONE);



        StonecutterRecipeTreeGenerator.generateRecipes(exporter);
    }

    public static void generateSSFamily(Consumer<RecipeJsonProvider> exporter, Block baseBlock, String name) {
        BlockFamily family = register(baseBlock).stairs(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_stairs")).slab(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_slab")).build();
        generateFamily(exporter, family);
    }

    public static void generateSSWFamily(Consumer<RecipeJsonProvider> exporter, Block baseBlock, String name) {
        BlockFamily family = register(baseBlock).stairs(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_stairs")).slab(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_slab")).wall(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_wall")).build();
        generateFamily(exporter, family);
    }

    public static CookingRecipeJsonBuilder createRoughConcreteRecipe(ItemConvertible output, ItemConvertible input) {
        return CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(input), RecipeCategory.BUILDING_BLOCKS, output, 0.1F, 200).criterion(hasItem(input), conditionsFromItem(input));
    }

    public static void offerPillarRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output)
                .pattern("#")
                .pattern("#")
                .input('#', input)
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }

    public static void offer2x2ReversibleCompactingRecipes(Consumer<RecipeJsonProvider> exporter, RecipeCategory reverseCategory, ItemConvertible baseItem, RecipeCategory compactingCategory, ItemConvertible compactItem) {
        offer2x2ReversibleCompactingRecipes(exporter, reverseCategory, baseItem, compactingCategory, compactItem, getRecipeName(compactItem), null, getRecipeName(baseItem), null);
    }

    public static void offer2x2ReversibleCompactingRecipes(Consumer<RecipeJsonProvider> exporter, RecipeCategory reverseCategory, ItemConvertible baseItem, RecipeCategory compactingCategory, ItemConvertible compactItem, String compactingId, @Nullable String compactingGroup, String reverseId, @Nullable String reverseGroup) {
        ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 4).input(compactItem).group(reverseGroup).criterion(hasItem(compactItem), conditionsFromItem(compactItem)).offerTo(exporter, new Identifier(reverseId));
        ShapedRecipeJsonBuilder.create(compactingCategory, compactItem).input('#', baseItem).pattern("##").pattern("##").group(compactingGroup).criterion(hasItem(baseItem), conditionsFromItem(baseItem)).offerTo(exporter, new Identifier(compactingId));
    }
}
