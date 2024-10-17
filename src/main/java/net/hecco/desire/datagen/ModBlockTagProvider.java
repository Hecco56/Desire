package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public static final ArrayList<Block> STAIRS = new ArrayList<>();
    public static final ArrayList<Block> SLABS = new ArrayList<>();
    public static final ArrayList<Block> WALLS = new ArrayList<>();
    public static final ArrayList<Block> POLISHED_WALLS = new ArrayList<>();
    public static final ArrayList<Block> PICKAXE_MINEABLE = new ArrayList<>();
    public static final ArrayList<Block> AXE_MINEABLE = new ArrayList<>();

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        for (Block block : WALLS) {
            getOrCreateTagBuilder(BlockTags.WALLS).add(block);
        }
        for (Block block : STAIRS) {
            getOrCreateTagBuilder(BlockTags.STAIRS).add(block);
        }
        for (Block block : SLABS) {
            getOrCreateTagBuilder(BlockTags.SLABS).add(block);
        }
        for (Block block : PICKAXE_MINEABLE) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for (Block block : AXE_MINEABLE) {
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(block);
        }
    }
}