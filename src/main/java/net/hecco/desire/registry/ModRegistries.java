package net.hecco.desire.registry;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.hecco.desire.util.BlockSetGenerator;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.event.GameEvent;

public class ModRegistries {
    public static void register() {
        registerOxidizables();
        registerFlammables();
        registerEvents();
    }

    public static void registerOxidizables() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"));
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"));
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_exposed_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_weathered_copper_pillar"));
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockSetGenerator.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"), BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_oxidized_copper_pillar"));
    }

    public static void registerFlammables() {
        for (String name : BlockSetGenerator.WoodVariantsBlockMaker.WOOD_TYPES) {
            FlammableBlockRegistry.getDefaultInstance().add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_mosaic"), 5, 20);
            FlammableBlockRegistry.getDefaultInstance().add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_mosaic_stairs"), 5, 20);
            FlammableBlockRegistry.getDefaultInstance().add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(name + "_mosaic_slab"), 5, 20);
        }
    }

    public static void registerEvents() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (world.getBlockState(hitResult.getBlockPos()).isOf(Blocks.DRIPSTONE_BLOCK)) {
                BlockPos pos = hitResult.getBlockPos();
                ItemStack stack = player.getStackInHand(hand);
                BlockState state = world.getBlockState(pos);
                if (stack.getItem() instanceof PickaxeItem) {
                    world.playSound(player, pos, SoundEvents.BLOCK_DRIPSTONE_BLOCK_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    if (player instanceof ServerPlayerEntity) {
                        Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)player, pos, stack);
                    }
                    if (Random.create().nextFloat() > 0.1f) {
                        world.setBlockState(pos, BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone").getDefaultState(), 11);
                    } else {
                        world.setBlockState(pos, BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore").getDefaultState(), 11);
                    }
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state));
                    stack.damage(1, player, (playerx) -> playerx.sendToolBreakStatus(hand));
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.PASS;
        });
    }
}
