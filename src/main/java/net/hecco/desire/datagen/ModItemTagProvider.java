package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.desire.Desire;
import net.hecco.desire.registry.ModBlocks;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public static final TagKey<Item> ROCKS = TagKey.of(RegistryKeys.ITEM, new Identifier(Desire.MOD_ID, "rocks"));

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ROCKS)
                .add(ModBlocks.STONE_BOULDER.asItem())
                .add(ModBlocks.DEEPSLATE_SHEET.asItem())
                .add(ModBlocks.BLACKSTONE_CHUNK.asItem())
        ;
    }
}
