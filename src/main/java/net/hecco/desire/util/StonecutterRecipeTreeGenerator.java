package net.hecco.desire.util;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.desire.Desire;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StonecutterRecipeTreeGenerator extends FabricRecipeProvider {
    public static List<Map.Entry<ItemConvertible, ItemConvertible>> SHADOW_RECIPES = new ArrayList<>();
    public static List<Map.Entry<ItemConvertible, ItemConvertible>> RECIPES = new ArrayList<>();
    private static final Map<Map.Entry<ItemConvertible, ItemConvertible>, Integer> ENTRY_TO_COUNT = new HashMap<>();

    public StonecutterRecipeTreeGenerator(FabricDataOutput output) {
        super(output);
    }

    public static void putShadowRecipe(ItemConvertible output, ItemConvertible input) {
        SHADOW_RECIPES.add(Map.entry(input, output));
        ENTRY_TO_COUNT.put(Map.entry(input, output), 1);
    }
    public static void putShadowRecipe(ItemConvertible output, ItemConvertible input, int count) {
        SHADOW_RECIPES.add(Map.entry(input, output));
        ENTRY_TO_COUNT.put(Map.entry(input, output), count);
    }
    public static void putRecipe(ItemConvertible output, ItemConvertible input) {
        RECIPES.add(Map.entry(input, output));
        ENTRY_TO_COUNT.put(Map.entry(input, output), 1);
    }

    public static void putRecipe(ItemConvertible output, ItemConvertible input, int count) {
        RECIPES.add(Map.entry(input, output));
        ENTRY_TO_COUNT.put(Map.entry(input, output), count);
    }

    public static void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        for (Map.Entry<ItemConvertible, ItemConvertible> entry : RECIPES) {
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.getValue(), entry.getKey(), ENTRY_TO_COUNT.get(entry));
        }
        List<Map.Entry<ItemConvertible, ItemConvertible>> RECIPES = new ArrayList<>(Stream.concat(StonecutterRecipeTreeGenerator.RECIPES.stream(), SHADOW_RECIPES.stream()).toList());
        for (Map.Entry<ItemConvertible, ItemConvertible> entry : RECIPES) {
            if (RECIPES.contains(entry)) {
                for (Map.Entry<ItemConvertible, ItemConvertible> secondEntry : RECIPES) {
                    if (secondEntry.getValue() == entry.getKey()) {
                        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.getValue(), secondEntry.getKey(), ENTRY_TO_COUNT.get(entry));

                        for (Map.Entry<ItemConvertible, ItemConvertible> thirdEntry : RECIPES) {
                            if (thirdEntry.getValue() == secondEntry.getKey()) {
                                offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.getValue(), thirdEntry.getKey(), ENTRY_TO_COUNT.get(entry));

                                for (Map.Entry<ItemConvertible, ItemConvertible> fourthEntry : RECIPES) {
                                    if (fourthEntry.getValue() == thirdEntry.getKey()) {
                                        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, entry.getValue(), fourthEntry.getKey(), ENTRY_TO_COUNT.get(entry));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

    }
}
