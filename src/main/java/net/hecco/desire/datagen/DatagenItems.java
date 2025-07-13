package net.hecco.desire.datagen;

import net.hecco.desire.Desire;
import net.hecco.desire.compat.natures_spirit.NSModBlocks;
import net.hecco.desire.datagen.desire.ModDatagenUtils;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class DatagenItems {
    public static void register() {
        registerDatagenOnlyItem(Desire.JADENS_NETHER_EXPANSION, "claret_slab");
        registerDatagenOnlyItem(Desire.JADENS_NETHER_EXPANSION, "polished_basalt_bricks");
        registerDatagenOnlyItem(Desire.JADENS_NETHER_EXPANSION, "blue_nether_bricks");
        registerDatagenOnlyItem(Desire.JADENS_NETHER_EXPANSION, "blue_nether_brick_slab");
        for (DyeColor color : ModDatagenUtils.VANILLA_COLORS.stream().map((color) -> DyeColor.byName(color, DyeColor.WHITE)).toList()) {
            registerDatagenOnlyItem(Desire.NATURES_SPIRIT, color.getName() + "_kaolin_bricks");
        }
    }

    protected static void registerDatagenOnlyItem(String modId, String name) {
        if (Desire.isDatagen()) {
            Registry.register(Registries.ITEM, Identifier.of(modId, name), new Item(new Item.Settings()));
        }
    }
}
