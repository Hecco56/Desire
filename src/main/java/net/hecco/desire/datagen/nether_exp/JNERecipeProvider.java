package net.hecco.desire.datagen.nether_exp;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hecco.desire.Desire;
import net.hecco.desire.datagen.DesireRecipeProvider;
import net.hecco.desire.util.BlockSetGenerator;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class JNERecipeProvider extends DesireRecipeProvider {
    public JNERecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        generateCraftingFix(exporter, BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"), Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "polished_basalt_bricks")));
    }
}
