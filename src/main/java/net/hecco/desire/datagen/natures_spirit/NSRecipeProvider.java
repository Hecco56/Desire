package net.hecco.desire.datagen.natures_spirit;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.natures_spirit.NSModBlocks;
import net.hecco.desire.datagen.DesireRecipeProvider;
import net.hecco.desire.datagen.desire.ModDatagenUtils;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

import static net.minecraft.data.family.BlockFamilies.register;

public class NSRecipeProvider extends DesireRecipeProvider {
    public NSRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        for (String wood : NSModBlocks.WOOD_TYPES) {
            offerMosaicRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.WOOD_MOSAICS.get(wood), Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, wood + "_slab")));
            generateFamily(exporter, register(NSModBlocks.WOOD_MOSAICS.get(wood)).stairs(NSModBlocks.WOOD_MOSAIC_STAIRS.get(wood)).slab(NSModBlocks.WOOD_MOSAIC_SLABS.get(wood)).build());
        }

        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.CHISELED_TRAVERTINE_BRICKS, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "travertine_brick_slab")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.CHISELED_TRAVERTINE_BRICKS, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "travertine_bricks")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.CHISELED_TRAVERTINE_BRICKS, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "polished_travertine")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.CHISELED_TRAVERTINE_BRICKS, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "travertine")));

        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.CHISELED_CHERT_BRICKS, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "chert_brick_slab")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.CHISELED_CHERT_BRICKS, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "chert_bricks")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.CHISELED_CHERT_BRICKS, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "polished_chert")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.CHISELED_CHERT_BRICKS, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "chert")));

        createStairsRecipe(NSModBlocks.CUT_PINK_SANDSTONE_STAIRS, Ingredient.ofItems(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "cut_pink_sandstone")))).criterion(hasItem(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "cut_pink_sandstone"))), conditionsFromItem(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "cut_pink_sandstone")))).offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.CUT_PINK_SANDSTONE_STAIRS, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "cut_pink_sandstone")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.CUT_PINK_SANDSTONE_STAIRS, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "pink_sandstone")));


        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.TRAVERTINE_WALL, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "travertine")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.TRAVERTINE_WALL, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "travertine")));

        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.SMOOTH_PINK_SANDSTONE_WALL, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "smooth_pink_sandstone")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.SMOOTH_PINK_SANDSTONE_WALL, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "smooth_pink_sandstone")));

        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.KAOLIN_BRICK_WALL, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "kaolin_bricks")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.KAOLIN_BRICK_WALL, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "kaolin_bricks")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.KAOLIN_BRICK_WALL, Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "kaolin")));

        for (DyeColor color : ModDatagenUtils.VANILLA_COLORS.stream().map((color) -> DyeColor.byName(color, DyeColor.WHITE)).toList()) {
            offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(color), Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, color.getName() + "_kaolin_bricks")));
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(color), Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, color.getName() + "_kaolin_bricks")));
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(color), Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, color.getName() + "_kaolin")));
        }
    }
}
