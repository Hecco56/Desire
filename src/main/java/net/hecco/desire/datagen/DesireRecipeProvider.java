package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

import static net.minecraft.data.family.BlockFamilies.register;

public abstract class DesireRecipeProvider extends FabricRecipeProvider {
    public DesireRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public abstract void generate(Consumer<RecipeJsonProvider> exporter);

    public static void generateSSFamily(Consumer<RecipeJsonProvider> exporter, Block baseBlock, String name) {
        BlockFamily family = register(baseBlock).stairs(BlockFamilyGenerator.BLOCKS.get(name + "_stairs")).slab(BlockFamilyGenerator.BLOCKS.get(name + "_slab")).build();
        generateFamily(exporter, family);
    }

    public static void generateSSWFamily(Consumer<RecipeJsonProvider> exporter, Block baseBlock, String name) {
        BlockFamily family = register(baseBlock).stairs(BlockFamilyGenerator.BLOCKS.get(name + "_stairs")).slab(BlockFamilyGenerator.BLOCKS.get(name + "_slab")).wall(BlockFamilyGenerator.BLOCKS.get(name + "_wall")).build();
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

    public static void generateCraftingFix(Consumer<RecipeJsonProvider> exporter, ItemConvertible item1, ItemConvertible item2) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, item2, 2)
                .pattern("##")
                .input('#', item1)
                .criterion(hasItem(item1), conditionsFromItem(item1))
                .criterion(hasItem(item2) + "2", conditionsFromItem(item2))
                .offerTo(exporter, Registries.ITEM.getId(item1.asItem()).getPath() + "_fix_1");
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, item1, 2)
                .pattern("##")
                .input('#', item2)
                .criterion(hasItem(item1), conditionsFromItem(item1))
                .criterion(hasItem(item2) + "2", conditionsFromItem(item2))
                .offerTo(exporter, Registries.ITEM.getId(item1.asItem()).getPath() + "_fix_2");
    }
}
