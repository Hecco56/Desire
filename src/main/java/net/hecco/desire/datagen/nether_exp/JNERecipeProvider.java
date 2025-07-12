package net.hecco.desire.datagen.nether_exp;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.netherexp.JNEModBlocks;
import net.hecco.desire.datagen.DesireRecipeProvider;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
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
        generateCraftingFix(exporter, BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks"), Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "polished_basalt_bricks")));
    }
}
