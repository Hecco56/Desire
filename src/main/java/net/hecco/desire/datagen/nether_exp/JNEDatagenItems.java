package net.hecco.desire.datagen.nether_exp;

import net.hecco.desire.Desire;
import net.hecco.desire.datagen.DesireDatagenItems;

public class JNEDatagenItems extends DesireDatagenItems {
    public static void register() {
        registerDatagenOnlyItem(Desire.JADENS_NETHER_EXPANSION, "claret_slab");
        registerDatagenOnlyItem(Desire.JADENS_NETHER_EXPANSION, "polished_basalt_bricks");
        registerDatagenOnlyItem(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks");
        registerDatagenOnlyItem(Desire.JADENS_NETHER_EXPANSION, "blue_nether_brick_slab");
    }
}
