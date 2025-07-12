package net.hecco.desire;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hecco.desire.datagen.desire.*;
import net.hecco.desire.datagen.nether_exp.JNEBlockLootTableProvider;
import net.hecco.desire.datagen.nether_exp.JNERecipeProvider;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class DesireDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		Desire.LOGGER.info(Registries.BLOCK.getIds().stream().filter(block -> block.getNamespace() == Desire.MOD_ID).toList().toString());
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLangProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);

		FabricDataGenerator.Pack jnePack = fabricDataGenerator.createBuiltinResourcePack(new Identifier(Desire.MOD_ID, Desire.JADENS_NETHER_EXPANSION + "_dat"));
		jnePack.addProvider(JNEBlockLootTableProvider::new);
		jnePack.addProvider(JNERecipeProvider::new);
	}
}
