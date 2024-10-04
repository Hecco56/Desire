package net.hecco.desire.mixin;

import com.google.common.collect.BiMap;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Oxidizable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoneycombItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.Optional;

@Mixin(PickaxeItem.class)
public class PickaxeItemMixin {
    @Unique
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockState = world.getBlockState(blockPos);
        ItemStack itemStack = context.getStack();
        if (blockState.isOf(Blocks.DRIPSTONE_BLOCK)) {
            world.playSound(playerEntity, blockPos, SoundEvents.BLOCK_DRIPSTONE_BLOCK_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (playerEntity instanceof ServerPlayerEntity) {
                Criteria.ITEM_USED_ON_BLOCK.trigger((ServerPlayerEntity)playerEntity, blockPos, itemStack);
            }
            if (Random.create().nextFloat() > 0.1f) {
                world.setBlockState(blockPos, BlockSetMaker.BLOCK_SET_BLOCKS.get("stripped_dripstone").getDefaultState(), 11);
            } else {
                world.setBlockState(blockPos, BlockSetMaker.BLOCK_SET_BLOCKS.get("stripped_dripstone_ore").getDefaultState(), 11);
            }
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, blockState));
            if (playerEntity != null) {
                itemStack.damage(1, playerEntity, (p) -> {
                    p.sendToolBreakStatus(context.getHand());
                });
            }

            return ActionResult.success(world.isClient);
        } else {
            return ActionResult.PASS;
        }
    }
}