package net.hecco.desire.registry;

import net.hecco.desire.Desire;
import net.hecco.desire.item.IconItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DESIRE_ICON = register("desire_icon", new IconItem(new Item.Settings()));
    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Desire.MOD_ID, name), item);
    }
    public static void register() {}
}
