package net.hecco.desire.datagen;

import net.hecco.desire.Desire;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public abstract class DesireDatagenItems {
    protected static void registerDatagenOnlyItem(String modId, String name) {
        if (Desire.isDatagen()) {
            Registry.register(Registries.ITEM, Identifier.of(modId, name), new Item(new Item.Settings()));
        }
    }
}
