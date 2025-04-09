package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.hecco.desire.Desire;
import net.hecco.desire.datagen.desire.ModBlockTagProvider;
import net.hecco.desire.datagen.desire.ModDatagenUtils;
import net.minecraft.block.Block;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public abstract class DesireBlockLootTableProvider extends FabricBlockLootTableProvider {
    protected DesireBlockLootTableProvider(FabricDataOutput dataOutput, String modID) {
        super(dataOutput);
        this.MODID = modID;
    }

    public final String MODID;

    public static final ArrayList<Block> usedBlocks = new ArrayList<>();
    @Override
    public void addDrop(Block block, LootTable.Builder lootTable) {
        if(usedBlocks.contains(block)) {
            return;
        }
        super.addDrop(block, lootTable);
        usedBlocks.add(block);
    }

    @Override
    public void generate() {
        for (Block block : ModBlockTagProvider.SLABS) {
            addDrop(block, slabDrops(block));
        }
        for(Identifier id : ModDatagenUtils.allBlockIdsInNamespace(MODID)) {
            Desire.LOGGER.info(ModDatagenUtils.allBlockIdsInNamespace(MODID) + "");
            Block block = Registries.BLOCK.get(id);
            if(usedBlocks.contains(block)) { continue; }
            this.addDrop(block);
        }
    }
}
