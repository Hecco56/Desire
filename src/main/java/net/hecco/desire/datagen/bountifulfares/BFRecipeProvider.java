package net.hecco.desire.datagen.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.bountifulfares.BFModBlocks;
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

public class BFRecipeProvider extends DesireRecipeProvider {
    public BFRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        for (String wood : BFModBlocks.WOOD_TYPES) {
            offerMosaicRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BFModBlocks.WOOD_MOSAICS.get(wood), Registries.ITEM.get(Identifier.of(Desire.BOUNTIFUL_FARES, wood + "_slab")));
            generateFamily(exporter, register(BFModBlocks.WOOD_MOSAICS.get(wood)).stairs(BFModBlocks.WOOD_MOSAIC_STAIRS.get(wood)).slab(BFModBlocks.WOOD_MOSAIC_SLABS.get(wood)).build());
        }
    }
}
