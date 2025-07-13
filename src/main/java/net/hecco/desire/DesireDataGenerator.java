package net.hecco.desire;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hecco.desire.datagen.desire.*;
import net.hecco.desire.datagen.natures_spirit.NSRecipeProvider;
import net.hecco.desire.datagen.nether_exp.JNERecipeProvider;
import net.minecraft.util.Identifier;

public class DesireDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack jnePack = fabricDataGenerator.createBuiltinResourcePack(new Identifier(Desire.MOD_ID, Desire.JADENS_NETHER_EXPANSION + "_dat"));
		jnePack.addProvider(JNERecipeProvider::new);

		FabricDataGenerator.Pack nsPack = fabricDataGenerator.createBuiltinResourcePack(new Identifier(Desire.MOD_ID, Desire.NATURES_SPIRIT + "_dat"));
		nsPack.addProvider(NSRecipeProvider::new);

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLangProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
