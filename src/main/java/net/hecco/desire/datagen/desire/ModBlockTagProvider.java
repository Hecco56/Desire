package net.hecco.desire.datagen.desire;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.desire.compat.netherexp.JNEModBlocks;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.STONE_BOULDER)
                .add(ModBlocks.DEEPSLATE_SHEET)
                .add(ModBlocks.BLACKSTONE_CHUNK)
        ;

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(JNEModBlocks.RED_NETHER_BRICK_FENCE)
                .add(JNEModBlocks.BLUE_NETHER_BRICK_FENCE)
                .add(JNEModBlocks.YELLOW_NETHER_BRICK_FENCE)
        ;

        for (Block block : BlockFamilyGenerator.WALLS) {
            getOrCreateTagBuilder(BlockTags.WALLS).add(block);
        }
        for (Block block : BlockFamilyGenerator.STAIRS) {
            getOrCreateTagBuilder(BlockTags.STAIRS).add(block);
        }
        for (Block block : BlockFamilyGenerator.SLABS) {
            getOrCreateTagBuilder(BlockTags.SLABS).add(block);
        }
        for (Block block : BlockFamilyGenerator.FENCES) {
            getOrCreateTagBuilder(BlockTags.FENCES).add(block);
        }
        for (Block block : BlockFamilyGenerator.WOODEN_FENCES) {
            getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(block);
        }
        for (Block block : BlockFamilyGenerator.FENCE_GATES) {
            getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(block);
        }
        for (Block block : BlockFamilyGenerator.WOODEN_DOORS) {
            getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(block);
        }
        for (Block block : BlockFamilyGenerator.DOORS) {
            getOrCreateTagBuilder(BlockTags.DOORS).add(block);
        }
        for (Block block : BlockFamilyGenerator.WOODEN_TRAPDOORS) {
            getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(block);
        }
        for (Block block : BlockFamilyGenerator.TRAPDOORS) {
            getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(block);
        }
        for (Block block : BlockFamilyGenerator.WOODEN_PRESSURE_PLATES) {
            getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(block);
        }
        for (Block block : BlockFamilyGenerator.STONE_PRESSURE_PLATES) {
            getOrCreateTagBuilder(BlockTags.STONE_PRESSURE_PLATES).add(block);
        }
        for (Block block : BlockFamilyGenerator.PRESSURE_PLATES) {
            getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(block);
        }
        for (Block block : BlockFamilyGenerator.WOODEN_PRESSURE_PLATES) {
            getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(block);
        }
        for (Block block : BlockFamilyGenerator.STONE_PRESSURE_PLATES) {
            getOrCreateTagBuilder(BlockTags.STONE_PRESSURE_PLATES).add(block);
        }
        for (Block block : BlockFamilyGenerator.PRESSURE_PLATES) {
            getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(block);
        }
        for (Block block : BlockFamilyGenerator.WOODEN_BUTTONS) {
            getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(block);
        }
        for (Block block : BlockFamilyGenerator.STONE_BUTTONS) {
            getOrCreateTagBuilder(BlockTags.STONE_BUTTONS).add(block);
        }
        for (Block block : BlockFamilyGenerator.BUTTONS) {
            getOrCreateTagBuilder(BlockTags.BUTTONS).add(block);
        }
        for (TagKey<Block> tag : BlockFamilyGenerator.FLAMMABLE_LOG_TAGS) {
            String name = tag.id().getPath().replace("_logs", "");
            getOrCreateTagBuilder(tag)
                    .add(BlockFamilyGenerator.BLOCKS.get(name + "_log"))
                    .add(BlockFamilyGenerator.BLOCKS.get(name + "_wood"))
                    .add(BlockFamilyGenerator.BLOCKS.get("stripped_" + name + "_log"))
                    .add(BlockFamilyGenerator.BLOCKS.get("stripped_" + name + "_wood"))
            ;
            getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(tag);
        }
        for (TagKey<Block> tag : BlockFamilyGenerator.LOG_TAGS) {
            String name = tag.id().getPath().replace("_logs", "");
            getOrCreateTagBuilder(tag)
                    .add(BlockFamilyGenerator.BLOCKS.get(name + "_log"))
                    .add(BlockFamilyGenerator.BLOCKS.get(name + "_wood"))
                    .add(BlockFamilyGenerator.BLOCKS.get("stripped_" + name + "_log"))
                    .add(BlockFamilyGenerator.BLOCKS.get("stripped_" + name + "_wood"))
            ;
            getOrCreateTagBuilder(BlockTags.LOGS).addTag(tag);
        }
        for (Block block : BlockFamilyGenerator.OVERWORLD_NATURAL_LOGS) {
            getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS).add(block);
        }
        for (Block block : BlockFamilyGenerator.LEAVES) {
            getOrCreateTagBuilder(BlockTags.LEAVES).add(block);
        }
        for (Block block : BlockFamilyGenerator.FLOWERS) {
            getOrCreateTagBuilder(BlockTags.FLOWERS).add(block);
        }
        for (Block block : BlockFamilyGenerator.SAPLINGS) {
            getOrCreateTagBuilder(BlockTags.SAPLINGS).add(block);
        }
        for (Block block : BlockFamilyGenerator.FLOWER_POTS) {
            getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(block);
        }


        for (Block block : BlockFamilyGenerator.PICKAXE_MINEABLE) {
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(block);
        }
        for (Block block : BlockFamilyGenerator.AXE_MINEABLE) {
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).add(block);
        }
        for (Block block : BlockFamilyGenerator.SHOVEL_MINEABLE) {
            getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(block);
        }
        for (Block block : BlockFamilyGenerator.HOE_MINEABLE) {
            getOrCreateTagBuilder(BlockTags.HOE_MINEABLE).add(block);
        }
        for (Block block : BlockFamilyGenerator.NEEDS_STONE_TOOL) {
            getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL).add(block);
        }
        for (Block block : BlockFamilyGenerator.NEEDS_IRON_TOOL) {
            getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(block);
        }
        for (Block block : BlockFamilyGenerator.NEEDS_DIAMOND_TOOL) {
            getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
        }
    }
}