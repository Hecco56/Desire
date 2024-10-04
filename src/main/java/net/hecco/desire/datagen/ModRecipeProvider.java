package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.ItemTags;
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
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("stone_wall"), Blocks.STONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_wall"), Blocks.POLISHED_GRANITE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_wall"), Blocks.POLISHED_ANDESITE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_wall"), Blocks.POLISHED_DIORITE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_sandstone_wall"), Blocks.SMOOTH_SANDSTONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_red_sandstone_wall"), Blocks.SMOOTH_RED_SANDSTONE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_quartz_wall"), Blocks.SMOOTH_QUARTZ);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("dark_prismarine_wall"), Blocks.DARK_PRISMARINE);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("prismarine_brick_wall"), Blocks.PRISMARINE_BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_stone"), Blocks.STONE_SLAB);
        createStairsRecipe(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_stairs"), Ingredient.ofItems(Blocks.SMOOTH_STONE)).criterion("has_smooth_stone", conditionsFromItem(Blocks.SMOOTH_STONE)).offerTo(exporter);
        createStairsRecipe(BlockSetMaker.BLOCK_SET_BLOCKS.get("cut_sandstone_stairs"), Ingredient.ofItems(Blocks.CUT_SANDSTONE)).criterion(hasItem(Blocks.CUT_SANDSTONE), conditionsFromItem(Blocks.CUT_SANDSTONE)).offerTo(exporter);
        createStairsRecipe(BlockSetMaker.BLOCK_SET_BLOCKS.get("cut_red_sandstone_stairs"), Ingredient.ofItems(Blocks.CUT_RED_SANDSTONE)).criterion(hasItem(Blocks.CUT_RED_SANDSTONE), conditionsFromItem(Blocks.CUT_RED_SANDSTONE)).offerTo(exporter);
        generateSSWFamily(exporter, Blocks.SMOOTH_BASALT, "smooth_basalt");
        generateSSWFamily(exporter, Blocks.QUARTZ_BRICKS, "quartz_brick");
        generateSSWFamily(exporter, Blocks.CALCITE, "calcite");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_bricks"), Blocks.COBBLESTONE);
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_bricks"), "cobblestone_brick");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"), Blocks.MOSSY_COBBLESTONE);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"))
                .input(BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_bricks"))
                .input(Blocks.MOSS_BLOCK)
                .group("mossy_cobblestone")
                .criterion(hasItem(BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_bricks")), conditionsFromItem(BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_bricks")))
                .offerTo(exporter, "mossy_cobblestone_bricks_from_cobblestone_bricks");
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"), "mossy_cobblestone_brick");
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_bricks"), "smooth_stone_brick");
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("stone_tiles"), "stone_tile");
        offerCrackingRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_stone_tiles"), BlockSetMaker.BLOCK_SET_BLOCKS.get("stone_tiles"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_bricks"), Blocks.POLISHED_GRANITE);
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_bricks"), "polished_granite_brick");
        offerCrackingRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_granite_bricks"), BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_bricks"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"), Blocks.POLISHED_ANDESITE);
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"), "polished_andesite_brick");
        offerCrackingRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_andesite_bricks"), BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"), Blocks.POLISHED_DIORITE);
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"), "polished_diorite_brick");
        offerCrackingRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_diorite_bricks"), BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_deepslate_bricks"), Blocks.DEEPSLATE_BRICK_SLAB);
        offerCrackingRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_bricks"), Blocks.BRICKS);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_bricks"))
                .input(Blocks.BRICKS)
                .input(Blocks.MOSS_BLOCK)
                .group("mossy_bricks")
                .criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS))
                .offerTo(exporter);
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            createRoughConcreteRecipe(BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_concrete"))).offerTo(exporter, color + "_rough_concrete");
        }
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_block"), BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete"));
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("rough_concrete_block"), "rough_concrete");
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_mud"), "polished_mud");
        offerCrackingRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_mud_bricks"), Blocks.MUD_BRICKS);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_mud_bricks"), Blocks.MUD_BRICK_SLAB);
        offerCrackingRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_packed_mud"), Blocks.PACKED_MUD);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"), Blocks.POLISHED_BASALT);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_polished_basalt_bricks"))
                .pattern("##")
                .input('#', BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"))
                .criterion(hasItem(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_basalt_bricks")), conditionsFromItem(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_basalt_bricks")))
                .offerTo(exporter);
        offerCrackingRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_basalt_bricks"), BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("basalt_tiles"), 4).input(Blocks.POLISHED_BASALT).input(Blocks.POLISHED_BLACKSTONE).criterion("has_stone", conditionsFromItem(Blocks.POLISHED_BASALT)).offerTo(exporter);
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("basalt_tiles"), "basalt_tile");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"), Blocks.SMOOTH_BASALT);
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"), "smooth_basalt_brick");
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_blackstone"), Blocks.BLACKSTONE_SLAB);
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"), "polished_blackstone_tile");
        offerCrackingRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_blackstone_tiles"), BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"));
        for (String wood : BlockSetMaker.WoodVariantsBlockMaker.WOOD_TYPES) {
            if (wood != "bamboo") {
                offerMosaicRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get(wood + "_mosaic"), BlockSetMaker.WoodVariantsBlockMaker.WOOD_SLABS.get(BlockSetMaker.WoodVariantsBlockMaker.WOOD_TYPES.indexOf(wood)));
                generateSSFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get(wood + "_mosaic"), wood + "_mosaic");
            }
        }
        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone"), Blocks.GRAVEL);
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone"), "flintstone");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_bricks"), BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone"));
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_bricks"), "flintstone_brick");
        offerCrackingRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone"), BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone"));
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone"), "smooth_flintstone");
        offerPillarRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("copper_pillar"), Blocks.COPPER_BLOCK);
        offerPillarRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), Blocks.EXPOSED_COPPER);
        offerPillarRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), Blocks.WEATHERED_COPPER);
        offerPillarRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"), Blocks.WEATHERED_COPPER);
        offerPillarRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_copper_pillar"), Blocks.WAXED_COPPER_BLOCK);
        offerPillarRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_exposed_copper_pillar"), Blocks.WAXED_EXPOSED_COPPER);
        offerPillarRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_weathered_copper_pillar"), Blocks.WAXED_WEATHERED_COPPER);
        offerPillarRecipe(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_oxidized_copper_pillar"), Blocks.WAXED_WEATHERED_COPPER);
        offer2x2ReversibleCompactingRecipes(exporter, RecipeCategory.MISC, BlockSetMaker.BLOCK_SET_BLOCKS.get("flint_block"), RecipeCategory.BUILDING_BLOCKS, Items.FLINT);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_flint_block"), BlockSetMaker.BLOCK_SET_BLOCKS.get("flint_block"));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_calcite"), BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_slab"));
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_calcite"), Blocks.CALCITE);
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_calcite"), "polished_calcite");
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_bricks"), BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_calcite"));
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_bricks"), "calcite_brick");
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_calcite_bricks"), BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_brick_slab"));
        for (String color : ModDatagenUtils.VANILLA_COLORS) {
            offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_concrete")));
            generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"), color + "_concrete_brick");
            offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"), Registries.BLOCK.get(Identifier.of("minecraft", color + "_glazed_terracotta")));
            generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"), color + "_terracotta_mosaic");
        }
    }

    public static void generateSSFamily(Consumer<RecipeJsonProvider> exporter, Block baseBlock, String name) {
        BlockFamily family = register(baseBlock).stairs(BlockSetMaker.BLOCK_SET_BLOCKS.get(name + "_stairs")).slab(BlockSetMaker.BLOCK_SET_BLOCKS.get(name + "_slab")).build();
        generateFamily(exporter, family);
    }

    public static void generateSSWFamily(Consumer<RecipeJsonProvider> exporter, Block baseBlock, String name) {
        BlockFamily family = register(baseBlock).stairs(BlockSetMaker.BLOCK_SET_BLOCKS.get(name + "_stairs")).slab(BlockSetMaker.BLOCK_SET_BLOCKS.get(name + "_slab")).wall(BlockSetMaker.BLOCK_SET_BLOCKS.get(name + "_wall")).build();
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
        ShapelessRecipeJsonBuilder.create(reverseCategory, baseItem, 9).input(compactItem).group(reverseGroup).criterion(hasItem(compactItem), conditionsFromItem(compactItem)).offerTo(exporter, new Identifier(reverseId));
        ShapedRecipeJsonBuilder.create(compactingCategory, compactItem).input('#', baseItem).pattern("##").pattern("##").group(compactingGroup).criterion(hasItem(baseItem), conditionsFromItem(baseItem)).offerTo(exporter, new Identifier(compactingId));
    }
}
