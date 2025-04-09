package net.hecco.desire.compat;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.hecco.desire.Desire;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModPacks {
    private static void registerBuiltinDataPack(ModContainer modContainer, String packId) {
        if (Desire.isModLoaded(packId)) {
            ResourceManagerHelper.registerBuiltinResourcePack(
                    new Identifier(Desire.MOD_ID, packId + "_dat"),
                    modContainer,
                    Text.translatable("pack." + Desire.MOD_ID + "." + packId),
                    ResourcePackActivationType.ALWAYS_ENABLED
            );
        }
    }

    public static void registerBuiltinPacks() {
        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(Desire.MOD_ID);
        if (modContainer.isPresent()) {
            registerBuiltinDataPack(modContainer.get(), Desire.JADENS_NETHER_EXPANSION);
        }
    }
}
