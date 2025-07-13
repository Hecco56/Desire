package net.hecco.desire.datagen.natures_spirit;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.hecco.desire.Desire;
import net.hecco.desire.datagen.DesireBlockLootTableProvider;

public class NSBlockLootTableProvider extends DesireBlockLootTableProvider {
    public NSBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput, Desire.NATURES_SPIRIT);
    }
}
