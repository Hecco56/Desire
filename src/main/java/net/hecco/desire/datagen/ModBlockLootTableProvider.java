package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.desire.Desire;
import net.hecco.desire.block.PlaceableRockBlock;
import net.hecco.desire.registry.ModBlocks;
import net.hecco.desire.util.BlockSetGenerator;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public static final ArrayList<Block> usedBlocks = new ArrayList<>();
    @Override
    public void addDrop(Block block, LootTable.Builder lootTable) {
        if(usedBlocks.contains(block)) {
            return;
        }
        super.addDrop(block, lootTable);
        usedBlocks.add(block);
    }
    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.STONE_BOULDER, placeableRockDrops(ModBlocks.STONE_BOULDER));
        addDrop(ModBlocks.DEEPSLATE_SHEET, placeableRockDrops(ModBlocks.DEEPSLATE_SHEET));
        addDrop(ModBlocks.BLACKSTONE_CHUNK, placeableRockDrops(ModBlocks.BLACKSTONE_CHUNK));
        addDrop(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore"), dropsWithSilkTouch(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore"), this.applyExplosionDecay(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore"), ItemEntry.builder(Items.NAUTILUS_SHELL).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))));
        for (Block block : ModBlockTagProvider.SLABS) {
            addDrop(block, slabDrops(block));
        }
        for(Identifier id : ModDatagenUtils.allBlockIdsInNamespace(Desire.MOD_ID)) {
            Block block = Registries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
            this.addDrop(block);
        }
    }

    public LootTable.Builder placeableRockDrops(Block block) {
        return LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F)).with(this.applyExplosionDecay(block, ItemEntry.builder(block).apply(IntStream.rangeClosed(1, 4).boxed().toList(), (amount) -> SetCountLootFunction.builder(ConstantLootNumberProvider.create((float)amount)).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(PlaceableRockBlock.AMOUNT, amount)))))));
    }
}
