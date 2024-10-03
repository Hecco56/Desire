package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;

import java.util.function.Consumer;

import static net.minecraft.data.family.BlockFamilies.register;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModBlocks.STONE_BOULDER, RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE, "cobblestone_from_stone_boulder", "cobblestone", "stone_boulder", "stone_boulder");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModBlocks.DEEPSLATE_SHEET, RecipeCategory.BUILDING_BLOCKS, Items.COBBLED_DEEPSLATE, "cobbled_deepslate_from_deepslate_sheet", "cobbled_deepslate", "deepslate_sheet", "deepslate_sheet");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.DECORATIONS, ModBlocks.BLACKSTONE_CHUNK, RecipeCategory.BUILDING_BLOCKS, Items.BLACKSTONE, "blackstone_from_blackstone_chunk", "blackstone", "blackstone_chunk", "blackstone_chunk");
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
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_bricks"), "cobblestone_brick");
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"), "mossy_cobblestone_brick");
    }

    public static void generateSSFamily(Consumer<RecipeJsonProvider> exporter, Block baseBlock, String name) {
        BlockFamily family = register(baseBlock).stairs(BlockSetMaker.BLOCK_SET_BLOCKS.get(name + "_stairs")).slab(BlockSetMaker.BLOCK_SET_BLOCKS.get(name + "_slab")).build();
        generateFamily(exporter, family);
    }

    public static void generateSSWFamily(Consumer<RecipeJsonProvider> exporter, Block baseBlock, String name) {
        BlockFamily family = register(baseBlock).stairs(BlockSetMaker.BLOCK_SET_BLOCKS.get(name + "_stairs")).slab(BlockSetMaker.BLOCK_SET_BLOCKS.get(name + "_slab")).wall(BlockSetMaker.BLOCK_SET_BLOCKS.get(name + "_wall")).build();
        generateFamily(exporter, family);
    }
}
