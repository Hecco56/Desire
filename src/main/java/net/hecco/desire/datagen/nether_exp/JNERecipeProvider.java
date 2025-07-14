package net.hecco.desire.datagen.nether_exp;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.natures_spirit.NSModBlocks;
import net.hecco.desire.compat.netherexp.JNEModBlocks;
import net.hecco.desire.datagen.DesireRecipeProvider;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

import static net.minecraft.data.family.BlockFamilies.register;

public class JNERecipeProvider extends DesireRecipeProvider {
    public JNERecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerMosaicRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.CLARET_MOSAIC, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "claret_slab")));
        generateFamily(exporter, register(JNEModBlocks.CLARET_MOSAIC).stairs(JNEModBlocks.CLARET_MOSAIC_STAIRS).slab(JNEModBlocks.CLARET_MOSAIC_SLAB).build());
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.POLISHED_NETHER_BRICKS, Blocks.NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.POLISHED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
        offerPolishedStoneRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.POLISHED_BLUE_NETHER_BRICKS, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks")));
        offerCrackingRecipe(exporter, JNEModBlocks.CRACKED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
        offerCrackingRecipe(exporter, JNEModBlocks.CRACKED_BLUE_NETHER_BRICKS, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks")));
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.CHISELED_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICK_SLAB);
        offerChiseledBlockRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.CHISELED_BLUE_NETHER_BRICKS, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_brick_slab")));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.RED_NETHER_BRICK_FENCE, 6)
                .pattern("#B#")
                .pattern("#B#")
                .input('#', Blocks.RED_NETHER_BRICKS)
                .input('B', Items.NETHER_BRICK)
                .criterion(hasItem(Blocks.RED_NETHER_BRICKS), conditionsFromItem(Blocks.RED_NETHER_BRICKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.BLUE_NETHER_BRICK_FENCE, 6)
                .pattern("#B#")
                .pattern("#B#")
                .input('#', Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks")))
                .input('B', Items.NETHER_BRICK)
                .criterion("has_blue_nether_bricks", conditionsFromItem(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks"))))
                .offerTo(exporter);

        offerPillarRecipe(exporter, JNEModBlocks.RED_NETHER_BRICK_PILLAR, Blocks.RED_NETHER_BRICKS);
        offerPillarRecipe(exporter, JNEModBlocks.BLUE_NETHER_BRICK_PILLAR, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks")));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.NETHER_BRICK_FENCE_GATE, 2)
                .pattern("B#B")
                .pattern("B#B")
                .input('#', Blocks.NETHER_BRICKS)
                .input('B', Items.NETHER_BRICK)
                .criterion(hasItem(Blocks.RED_NETHER_BRICKS), conditionsFromItem(Blocks.RED_NETHER_BRICKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.RED_NETHER_BRICK_FENCE_GATE, 2)
                .pattern("B#B")
                .pattern("B#B")
                .input('#', Blocks.RED_NETHER_BRICKS)
                .input('B', Items.NETHER_BRICK)
                .criterion(hasItem(Blocks.RED_NETHER_BRICKS), conditionsFromItem(Blocks.RED_NETHER_BRICKS))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.BLUE_NETHER_BRICK_FENCE_GATE, 2)
                .pattern("B#B")
                .pattern("B#B")
                .input('#', Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks")))
                .input('B', Items.NETHER_BRICK)
                .criterion("has_blue_nether_bricks", conditionsFromItem(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks"))))
                .offerTo(exporter);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.POLISHED_NETHER_BRICKS, Items.NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.POLISHED_RED_NETHER_BRICKS, Items.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.POLISHED_BLUE_NETHER_BRICKS, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.CHISELED_RED_NETHER_BRICKS, Items.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.CHISELED_RED_NETHER_BRICKS, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks")));
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.RED_NETHER_BRICK_PILLAR, Items.RED_NETHER_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, JNEModBlocks.BLUE_NETHER_BRICK_PILLAR, Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks")));



        generateCraftingFix(exporter, BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks"), Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "polished_basalt_bricks")));
    }
}
