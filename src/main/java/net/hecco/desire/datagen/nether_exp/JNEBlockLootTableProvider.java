package net.hecco.desire.datagen.nether_exp;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.netherexp.JNEModBlocks;
import net.hecco.desire.datagen.DesireBlockLootTableProvider;

public class JNEBlockLootTableProvider extends DesireBlockLootTableProvider {
    public JNEBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput, Desire.JADENS_NETHER_EXPANSION);
    }
}
