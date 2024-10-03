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
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

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
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_bricks"), "polished_granite_brick");
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"), "polished_andesite_brick");
        generateSSWFamily(exporter, BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"), "polished_diorite_brick");
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
}
