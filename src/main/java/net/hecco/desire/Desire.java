package net.hecco.desire;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.hecco.desire.compat.ModPacks;
import net.hecco.desire.compat.bountifulfares.BFModBlocks;
import net.hecco.desire.compat.natures_spirit.NSModBlocks;
import net.hecco.desire.compat.netherexp.JNEModBlocks;
import net.hecco.desire.datagen.DatagenItems;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.registry.ModItemGroups;
import net.hecco.desire.registry.ModItems;
import net.hecco.desire.registry.ModRegistries;
import net.minecraft.block.WoodType;
import net.minecraft.util.DyeColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Desire implements ModInitializer {
	public static final String MOD_ID = "desire";
	public static final String NATURES_SPIRIT = "natures_spirit";
	public static final String JADENS_NETHER_EXPANSION = "netherexp";
	public static final String GARDENS_OF_THE_DEAD = "gardens_of_the_dead";
	public static final String BOUNTIFUL_FARES = "bountifulfares";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}

	public static boolean isDatagen() {
		try {
			Class.forName("net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint");
			return System.getProperty("fabric-api.datagen") != null;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	@Override
	public void onInitialize() {
		ModBlocks.register();
		ModItems.register();
		ModItemGroups.register();
		ModRegistries.register();

		//COMPAT
		JNEModBlocks.register();
		NSModBlocks.register();
		BFModBlocks.register();

		DatagenItems.register();
		ModPacks.registerBuiltinPacks();
	}
}