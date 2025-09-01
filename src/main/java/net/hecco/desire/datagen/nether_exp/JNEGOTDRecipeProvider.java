package net.hecco.desire.datagen.nether_exp;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.netherexp.JNEModBlocks;
import net.hecco.desire.datagen.DesireRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class JNEGOTDRecipeProvider extends DesireRecipeProvider {
    public JNEGOTDRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.POLISHED_YELLOW_NETHER_BRICKS, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_bricks")));
        offerCrackingRecipe(exporter, JNEModBlocks.CRACKED_YELLOW_NETHER_BRICKS, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_bricks")));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.CHISELED_YELLOW_NETHER_BRICKS, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_brick_slab")));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.YELLOW_NETHER_BRICK_FENCE, 6)
                .pattern("#B#")
                .pattern("#B#")
                .input('#', Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_bricks")))
                .input('B', Items.NETHER_BRICK)
                .criterion("has_yellow_nether_bricks", conditionsFromItem(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_bricks"))))
                .offerTo(exporter);
        offerPillarRecipe(exporter, JNEModBlocks.YELLOW_NETHER_BRICK_PILLAR, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_bricks")));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.YELLOW_NETHER_BRICK_FENCE_GATE, 2)
                .pattern("B#B")
                .pattern("B#B")
                .input('#', Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_bricks")))
                .input('B', Items.NETHER_BRICK)
                .criterion("has_yellow_nether_bricks", conditionsFromItem(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_bricks"))))
                .offerTo(exporter);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.POLISHED_YELLOW_NETHER_BRICKS, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_bricks")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.YELLOW_NETHER_BRICK_PILLAR, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_bricks")));

    }
}
