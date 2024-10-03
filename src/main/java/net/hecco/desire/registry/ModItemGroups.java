package net.hecco.desire.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hecco.desire.Desire;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.block.Block;
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
                    .icon(() -> new ItemStack(ModBlocks.STONE_BOULDER)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.STONE_BOULDER);
                        entries.add(ModBlocks.DEEPSLATE_SHEET);
                        entries.add(ModBlocks.BLACKSTONE_CHUNK);
                        for (Block block : BlockSetMaker.BLOCK_SET_BLOCKS.values()) {
                            entries.add(block);
                        }
                    }).build());
    public static void register() {
    }
}
