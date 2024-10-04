package net.hecco.desire;

import net.fabricmc.api.ModInitializer;

import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.registry.ModItemGroups;
import net.hecco.desire.registry.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Desire implements ModInitializer {
	public static final String MOD_ID = "desire";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.register();
		ModItemGroups.register();
		ModRegistries.registerOxidizables();
	}
}