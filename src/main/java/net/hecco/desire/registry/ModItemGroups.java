package net.hecco.desire.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hecco.desire.Desire;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static ItemGroup DESIRE = Registry.register(Registries.ITEM_GROUP, Identifier.of(Desire.MOD_ID, "desire"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.desire"))
                    .icon(() -> new ItemStack(Items.OAK_PLANKS)).entries((displayContext, entries) -> {

                    }).build());
    public static void register() {
    }
}
