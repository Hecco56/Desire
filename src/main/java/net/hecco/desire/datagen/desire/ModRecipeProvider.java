package net.hecco.desire.datagen.desire;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hecco.desire.Desire;
import net.hecco.desire.datagen.DesireRecipeProvider;
import net.hecco.desire.oldutil.StonecutterRecipeTreeGenerator;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodType;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class ModRecipeProvider extends DesireRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offer2x2ReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModBlocks.STONE_BOULDER, RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE, "cobblestone_from_stone_boulder", "cobblestone", "stone_boulder", "stone_boulder");
        offer2x2ReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModBlocks.DEEPSLATE_SHEET, RecipeCategory.BUILDING_BLOCKS, Items.COBBLED_DEEPSLATE, "cobbled_deepslate_from_deepslate_sheet", "cobbled_deepslate", "deepslate_sheet", "deepslate_sheet");
        offer2x2ReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModBlocks.BLACKSTONE_CHUNK, RecipeCategory.BUILDING_BLOCKS, Items.BLACKSTONE, "blackstone_from_blackstone_chunk", "blackstone", "blackstone_chunk", "blackstone_chunk");
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("stone_wall"), Blocks.STONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_granite_wall"), Blocks.POLISHED_GRANITE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_andesite_wall"), Blocks.POLISHED_ANDESITE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_diorite_wall"), Blocks.POLISHED_DIORITE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("smooth_sandstone_wall"), Blocks.SMOOTH_SANDSTONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("smooth_red_sandstone_wall"), Blocks.SMOOTH_RED_SANDSTONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("smooth_quartz_wall"), Blocks.SMOOTH_QUARTZ);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("dark_prismarine_wall"), Blocks.DARK_PRISMARINE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("prismarine_brick_wall"), Blocks.PRISMARINE_BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_stone"), Blocks.STONE_SLAB);
        createStairsRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_stone_stairs"), Ingredient.ofItems(Blocks.SMOOTH_STONE)).criterion("has_smooth_stone", conditionsFromItem(Blocks.SMOOTH_STONE)).offerTo(exporter);
        createStairsRecipe(BlockFamilyGenerator.BLOCKS.get("cut_sandstone_stairs"), Ingredient.ofItems(Blocks.CUT_SANDSTONE)).criterion(hasItem(Blocks.CUT_SANDSTONE), conditionsFromItem(Blocks.CUT_SANDSTONE)).offerTo(exporter);
        createStairsRecipe(BlockFamilyGenerator.BLOCKS.get("cut_red_sandstone_stairs"), Ingredient.ofItems(Blocks.CUT_RED_SANDSTONE)).criterion(hasItem(Blocks.CUT_RED_SANDSTONE), conditionsFromItem(Blocks.CUT_RED_SANDSTONE)).offerTo(exporter);
        generateSSWFamily(exporter, Blocks.SMOOTH_BASALT, "smooth_basalt");
        generateSSWFamily(exporter, Blocks.QUARTZ_BRICKS, "quartz_brick");
        generateSSWFamily(exporter, Blocks.CALCITE, "calcite");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("cobblestone_bricks"), Blocks.COBBLESTONE);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("cobblestone_bricks"), "cobblestone_brick");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("mossy_cobblestone_bricks"), Blocks.MOSSY_COBBLESTONE);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("mossy_cobblestone_bricks"))
                .input(BlockFamilyGenerator.BLOCKS.get("cobblestone_bricks"))
                .input(Blocks.MOSS_BLOCK)
                .group("mossy_cobblestone")
                .criterion(hasItem(BlockFamilyGenerator.BLOCKS.get("cobblestone_bricks")), conditionsFromItem(BlockFamilyGenerator.BLOCKS.get("cobblestone_bricks")))
                .offerTo(exporter, "mossy_cobblestone_bricks_from_cobblestone_bricks");
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("mossy_cobblestone_bricks"), "mossy_cobblestone_brick");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("smooth_stone_bricks"), Blocks.SMOOTH_STONE);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("smooth_stone_bricks"), "smooth_stone_brick");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS, BlockFamilyGenerator.BLOCKS.get("polished_stone"));
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("polished_stone"), "polished_stone");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("stone_tiles"), Blocks.STONE_BRICKS);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("stone_tiles"), "stone_tile");
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("cracked_stone_tiles"), BlockFamilyGenerator.BLOCKS.get("stone_tiles"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_granite_bricks"), Blocks.POLISHED_GRANITE);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("polished_granite_bricks"), "polished_granite_brick");
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("cracked_polished_granite_bricks"), BlockFamilyGenerator.BLOCKS.get("polished_granite_bricks"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_andesite_bricks"), Blocks.POLISHED_ANDESITE);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("polished_andesite_bricks"), "polished_andesite_brick");
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("cracked_polished_andesite_bricks"), BlockFamilyGenerator.BLOCKS.get("polished_andesite_bricks"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_diorite_bricks"), Blocks.POLISHED_DIORITE);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("polished_diorite_bricks"), "polished_diorite_brick");
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("cracked_polished_diorite_bricks"), BlockFamilyGenerator.BLOCKS.get("polished_diorite_bricks"));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_deepslate_bricks"), Blocks.DEEPSLATE_BRICK_SLAB);
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("cracked_bricks"), Blocks.BRICKS);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("mossy_bricks"))
                .input(Blocks.BRICKS)
                .input(Blocks.MOSS_BLOCK)
                .group("mossy_bricks")
                .criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS))
                .offerTo(exporter);
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            createRoughConcreteRecipe(BlockFamilyGenerator.BLOCKS.get("rough_concrete"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_concrete"))).offerTo(exporter, color + "_rough_concrete");
        }

        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("rough_concrete_block"), BlockFamilyGenerator.BLOCKS.get("rough_concrete"));
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("rough_concrete_block"), "rough_concrete");
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("polished_mud"), "polished_mud");
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("cracked_mud_bricks"), Blocks.MUD_BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_mud_bricks"), Blocks.MUD_BRICK_SLAB);
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("smooth_packed_mud"), Blocks.PACKED_MUD);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks"), Blocks.POLISHED_BASALT);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_polished_basalt_bricks"))
                .pattern("##")
                .input('#', BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks"))
                .criterion(hasItem(BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks")), conditionsFromItem(BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks")))
                .offerTo(exporter);
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("cracked_polished_basalt_bricks"), BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("basalt_tiles"), 4)
                .pattern("#B")
                .pattern("B#")
                .input('#', Blocks.POLISHED_BASALT)
                .input('B', Blocks.POLISHED_BLACKSTONE)
                .criterion(hasItem(Blocks.POLISHED_BASALT), conditionsFromItem(Blocks.POLISHED_BASALT))
                .offerTo(exporter);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("basalt_tiles"), "basalt_tile");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("smooth_basalt_bricks"), Blocks.SMOOTH_BASALT);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("smooth_basalt_bricks"), "smooth_basalt_brick");
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_blackstone"), Blocks.BLACKSTONE_SLAB);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tiles"), Blocks.POLISHED_BLACKSTONE_BRICKS);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tiles"), "polished_blackstone_tile");
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("cracked_polished_blackstone_tiles"), BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tiles"));
        for (WoodType wood : WoodType.stream().toList()) {
            String name = wood.name();
            if (wood.name() != "bamboo" && !wood.name().contains(":")) {
                offerMosaicRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get(name + "_mosaic"), Registries.BLOCK.get(Identifier.of("minecraft", name + "_slab")));
                generateSSFamily(exporter, BlockFamilyGenerator.BLOCKS.get(name + "_mosaic"), name + "_mosaic");
            }
        }
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("flintstone"), Blocks.GRAVEL);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("flintstone"), "flintstone");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("flintstone_bricks"), BlockFamilyGenerator.BLOCKS.get("flintstone"));
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("flintstone_bricks"), "flintstone_brick");
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("smooth_flintstone"), BlockFamilyGenerator.BLOCKS.get("flintstone"));
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("smooth_flintstone"), "smooth_flintstone");
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.GRAVEL, 1)
                .input(Items.FLINT, 2)
                .input(Ingredient.fromTag(ModItemTagProvider.ROCKS), 2)
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .offerTo(exporter);
        offerPillarRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("copper_pillar"), Blocks.COPPER_BLOCK);
        offerPillarRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("exposed_copper_pillar"), Blocks.EXPOSED_COPPER);
        offerPillarRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("weathered_copper_pillar"), Blocks.WEATHERED_COPPER);
        offerPillarRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("oxidized_copper_pillar"), Blocks.WEATHERED_COPPER);
        offerPillarRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("waxed_copper_pillar"), Blocks.WAXED_COPPER_BLOCK);
        offerPillarRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("waxed_exposed_copper_pillar"), Blocks.WAXED_EXPOSED_COPPER);
        offerPillarRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("waxed_weathered_copper_pillar"), Blocks.WAXED_WEATHERED_COPPER);
        offerPillarRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("waxed_oxidized_copper_pillar"), Blocks.WAXED_WEATHERED_COPPER);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.FLINT, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("flint_block"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_flint_block"), BlockFamilyGenerator.BLOCKS.get("flint_block"));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_calcite"), BlockFamilyGenerator.BLOCKS.get("calcite_slab"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_calcite"), Blocks.CALCITE);
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("polished_calcite"), "polished_calcite");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("calcite_bricks"), BlockFamilyGenerator.BLOCKS.get("polished_calcite"));
        generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get("calcite_bricks"), "calcite_brick");
        offerCrackingRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("cracked_calcite_bricks"), BlockFamilyGenerator.BLOCKS.get("calcite_bricks"));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_calcite_bricks"), BlockFamilyGenerator.BLOCKS.get("calcite_brick_slab"));
        offerPillarRecipe(exporter, BlockFamilyGenerator.BLOCKS.get("brick_pillar"), Blocks.BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_bricks"), Blocks.BRICK_SLAB);
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get(color + "_concrete_bricks"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_concrete")));
            generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get(color + "_concrete_bricks"), color + "_concrete_brick");
            offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get(color + "_terracotta_mosaic"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_glazed_terracotta")));
            generateSSWFamily(exporter, BlockFamilyGenerator.BLOCKS.get(color + "_terracotta_mosaic"), color + "_terracotta_mosaic");
        }
        generateSSWFamily(exporter, Blocks.DRIPSTONE_BLOCK, "dripstone");


        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("stone_wall"), Blocks.STONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("chiseled_stone"), Blocks.STONE);

        StonecutterRecipeTreeGenerator.putShadowRecipe(Blocks.POLISHED_ANDESITE, Blocks.ANDESITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_andesite_wall"), Blocks.POLISHED_ANDESITE);

        StonecutterRecipeTreeGenerator.putShadowRecipe(Blocks.POLISHED_GRANITE, Blocks.GRANITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_granite_wall"), Blocks.POLISHED_GRANITE);

        StonecutterRecipeTreeGenerator.putShadowRecipe(Blocks.POLISHED_DIORITE, Blocks.DIORITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_diorite_wall"), Blocks.POLISHED_DIORITE);

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("prismarine_brick_wall"), Blocks.PRISMARINE_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("dark_prismarine_wall"), Blocks.DARK_PRISMARINE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_quartz_wall"), Blocks.SMOOTH_QUARTZ);

        StonecutterRecipeTreeGenerator.putShadowRecipe(Blocks.QUARTZ_BRICKS, Blocks.QUARTZ_BLOCK);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("quartz_brick_wall"), Blocks.QUARTZ_BRICKS);

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_sandstone_wall"), Blocks.SMOOTH_SANDSTONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_red_sandstone_wall"), Blocks.SMOOTH_RED_SANDSTONE);

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("calcite_stairs"), Blocks.CALCITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("calcite_slab"), Blocks.CALCITE, 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("calcite_wall"), Blocks.CALCITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("chiseled_calcite"), Blocks.CALCITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_calcite"), Blocks.CALCITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_calcite_stairs"), BlockFamilyGenerator.BLOCKS.get("polished_calcite"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_calcite_slab"), BlockFamilyGenerator.BLOCKS.get("polished_calcite"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_calcite_wall"), BlockFamilyGenerator.BLOCKS.get("polished_calcite"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("calcite_bricks"), BlockFamilyGenerator.BLOCKS.get("polished_calcite"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("calcite_brick_stairs"), BlockFamilyGenerator.BLOCKS.get("calcite_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("calcite_brick_slab"), BlockFamilyGenerator.BLOCKS.get("calcite_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("calcite_brick_wall"), BlockFamilyGenerator.BLOCKS.get("calcite_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("chiseled_calcite_bricks"), BlockFamilyGenerator.BLOCKS.get("calcite_bricks"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("flintstone_stairs"), BlockFamilyGenerator.BLOCKS.get("flintstone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("flintstone_slab"), BlockFamilyGenerator.BLOCKS.get("flintstone"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("flintstone_wall"), BlockFamilyGenerator.BLOCKS.get("flintstone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("flintstone_bricks"), BlockFamilyGenerator.BLOCKS.get("flintstone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("flintstone_brick_stairs"), BlockFamilyGenerator.BLOCKS.get("flintstone_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("flintstone_brick_slab"), BlockFamilyGenerator.BLOCKS.get("flintstone_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("flintstone_brick_wall"), BlockFamilyGenerator.BLOCKS.get("flintstone_bricks"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_flintstone_stairs"), BlockFamilyGenerator.BLOCKS.get("smooth_flintstone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_flintstone_slab"), BlockFamilyGenerator.BLOCKS.get("smooth_flintstone"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_flintstone_wall"), BlockFamilyGenerator.BLOCKS.get("smooth_flintstone"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_flint_block"), BlockFamilyGenerator.BLOCKS.get("flint_block"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("copper_pillar"), Blocks.COPPER_BLOCK);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("exposed_copper_pillar"), Blocks.EXPOSED_COPPER);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("weathered_copper_pillar"), Blocks.WEATHERED_COPPER);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("oxidized_copper_pillar"), Blocks.OXIDIZED_COPPER);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("waxed_copper_pillar"), Blocks.WAXED_COPPER_BLOCK);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("waxed_exposed_copper_pillar"), Blocks.WAXED_EXPOSED_COPPER);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("waxed_weathered_copper_pillar"), Blocks.WAXED_WEATHERED_COPPER);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("waxed_oxidized_copper_pillar"), Blocks.WAXED_OXIDIZED_COPPER);

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_stone_stairs"), Blocks.SMOOTH_STONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_stone_bricks"), Blocks.SMOOTH_STONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_stone_brick_stairs"), BlockFamilyGenerator.BLOCKS.get("smooth_stone_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_stone_brick_slab"), BlockFamilyGenerator.BLOCKS.get("smooth_stone_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_stone_brick_wall"), BlockFamilyGenerator.BLOCKS.get("smooth_stone_bricks"));


        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_granite_bricks"), Blocks.POLISHED_GRANITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_granite_brick_stairs"), BlockFamilyGenerator.BLOCKS.get("polished_granite_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_granite_brick_slab"), BlockFamilyGenerator.BLOCKS.get("polished_granite_bricks"), 2);

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_andesite_bricks"), Blocks.POLISHED_ANDESITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_andesite_brick_stairs"), BlockFamilyGenerator.BLOCKS.get("polished_andesite_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_andesite_brick_slab"), BlockFamilyGenerator.BLOCKS.get("polished_andesite_bricks"), 2);

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_diorite_bricks"), Blocks.POLISHED_DIORITE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_diorite_brick_stairs"), BlockFamilyGenerator.BLOCKS.get("polished_diorite_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_diorite_brick_slab"), BlockFamilyGenerator.BLOCKS.get("polished_diorite_bricks"), 2);


        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_stone"), Blocks.STONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_stone_stairs"), BlockFamilyGenerator.BLOCKS.get("polished_stone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_stone_slab"), BlockFamilyGenerator.BLOCKS.get("polished_stone"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_stone_wall"), BlockFamilyGenerator.BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS, BlockFamilyGenerator.BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICK_STAIRS, BlockFamilyGenerator.BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICK_SLAB, BlockFamilyGenerator.BLOCKS.get("polished_stone"), 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICK_WALL, BlockFamilyGenerator.BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("stone_tiles"), BlockFamilyGenerator.BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("stone_tile_stairs"), BlockFamilyGenerator.BLOCKS.get("polished_stone"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("stone_tile_slab"), BlockFamilyGenerator.BLOCKS.get("polished_stone"), 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("stone_tile_wall"), BlockFamilyGenerator.BLOCKS.get("polished_stone"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("stone_tiles"), Blocks.STONE_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("stone_tile_stairs"), Blocks.STONE_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("stone_tile_slab"), Blocks.STONE_BRICKS, 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("stone_tile_wall"), Blocks.STONE_BRICKS);

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("cobblestone_bricks"), Blocks.COBBLESTONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("cobblestone_brick_stairs"), BlockFamilyGenerator.BLOCKS.get("cobblestone_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("cobblestone_brick_slab"), BlockFamilyGenerator.BLOCKS.get("cobblestone_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("cobblestone_brick_wall"), BlockFamilyGenerator.BLOCKS.get("cobblestone_bricks"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("mossy_cobblestone_bricks"), Blocks.MOSSY_COBBLESTONE);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("mossy_cobblestone_brick_stairs"), BlockFamilyGenerator.BLOCKS.get("mossy_cobblestone_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("mossy_cobblestone_brick_slab"), BlockFamilyGenerator.BLOCKS.get("mossy_cobblestone_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("mossy_cobblestone_brick_wall"), BlockFamilyGenerator.BLOCKS.get("mossy_cobblestone_bricks"));

        StonecutterRecipeTreeGenerator.putRecipe(Blocks.MUD_BRICKS, Blocks.PACKED_MUD);
        StonecutterRecipeTreeGenerator.putRecipe(Blocks.MUD_BRICK_STAIRS, Blocks.MUD_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(Blocks.MUD_BRICK_SLAB, Blocks.MUD_BRICKS, 2);
        StonecutterRecipeTreeGenerator.putRecipe(Blocks.MUD_BRICK_WALL, Blocks.MUD_BRICKS);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("polished_mud"), Blocks.MUD_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_mud"), Blocks.PACKED_MUD);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_mud_stairs"), BlockFamilyGenerator.BLOCKS.get("polished_mud"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_mud_slab"), BlockFamilyGenerator.BLOCKS.get("polished_mud"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_mud_wall"), BlockFamilyGenerator.BLOCKS.get("polished_mud"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICKS, BlockFamilyGenerator.BLOCKS.get("polished_mud"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_STAIRS, BlockFamilyGenerator.BLOCKS.get("polished_mud"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_SLAB, BlockFamilyGenerator.BLOCKS.get("polished_mud"), 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.MUD_BRICK_WALL, BlockFamilyGenerator.BLOCKS.get("polished_mud"));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_mud_bricks"), BlockFamilyGenerator.BLOCKS.get("polished_mud"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("chiseled_mud_bricks"), Blocks.MUD_BRICKS);

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_stairs"), Blocks.SMOOTH_BASALT);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_slab"), Blocks.SMOOTH_BASALT, 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_wall"), Blocks.SMOOTH_BASALT);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_bricks"), Blocks.SMOOTH_BASALT);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_brick_stairs"), BlockFamilyGenerator.BLOCKS.get("smooth_basalt_bricks"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_brick_slab"), BlockFamilyGenerator.BLOCKS.get("smooth_basalt_bricks"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_brick_wall"), BlockFamilyGenerator.BLOCKS.get("smooth_basalt_bricks"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("basalt_tile_stairs"), BlockFamilyGenerator.BLOCKS.get("basalt_tiles"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("basalt_tile_slab"), BlockFamilyGenerator.BLOCKS.get("basalt_tiles"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("basalt_tile_wall"), BlockFamilyGenerator.BLOCKS.get("basalt_tiles"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tiles"), Blocks.POLISHED_BLACKSTONE_BRICKS);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tile_stairs"), BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tiles"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tile_slab"), BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tiles"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tile_wall"), BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tiles"));

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("rough_concrete_block"), BlockFamilyGenerator.BLOCKS.get("rough_concrete"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("rough_concrete_stairs"), BlockFamilyGenerator.BLOCKS.get("rough_concrete_block"));
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("rough_concrete_slab"), BlockFamilyGenerator.BLOCKS.get("rough_concrete_block"), 2);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("rough_concrete_wall"), BlockFamilyGenerator.BLOCKS.get("rough_concrete_block"));
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get(color + "_concrete_bricks"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_concrete")));
            StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get(color + "_concrete_brick_stairs"), BlockFamilyGenerator.BLOCKS.get(color + "_concrete_bricks"));
            StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get(color + "_concrete_brick_slab"), BlockFamilyGenerator.BLOCKS.get(color + "_concrete_bricks"), 2);
            StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get(color + "_concrete_brick_wall"), BlockFamilyGenerator.BLOCKS.get(color + "_concrete_bricks"));

            StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get(color + "_terracotta_mosaic"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_glazed_terracotta")));
            StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get(color + "_terracotta_mosaic_stairs"), BlockFamilyGenerator.BLOCKS.get(color + "_terracotta_mosaic"));
            StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get(color + "_terracotta_mosaic_slab"), BlockFamilyGenerator.BLOCKS.get(color + "_terracotta_mosaic"), 2);
            StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get(color + "_terracotta_mosaic_wall"), BlockFamilyGenerator.BLOCKS.get(color + "_terracotta_mosaic"));
        }

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_deepslate_bricks"), Blocks.DEEPSLATE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_deepslate_bricks"), Blocks.POLISHED_DEEPSLATE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_deepslate_bricks"), Blocks.DEEPSLATE);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("brick_pillar"), Blocks.BRICKS);

        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks"), Blocks.POLISHED_BASALT);
        StonecutterRecipeTreeGenerator.putRecipe(BlockFamilyGenerator.BLOCKS.get("chiseled_polished_basalt_bricks"), BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks"));

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("chiseled_blackstone"), Blocks.BLACKSTONE);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("dripstone_stairs"), Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("dripstone_slab"), Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("dripstone_wall"), Blocks.DRIPSTONE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockFamilyGenerator.BLOCKS.get("carved_dripstone"), Blocks.DRIPSTONE_BLOCK);



        StonecutterRecipeTreeGenerator.generateRecipes(exporter);
    }
}
