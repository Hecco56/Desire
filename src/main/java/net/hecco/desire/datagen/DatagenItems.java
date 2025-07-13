package net.hecco.desire.datagen;

import net.hecco.desire.Desire;
import net.hecco.desire.compat.natures_spirit.NSModBlocks;
import net.hecco.desire.datagen.desire.ModDatagenUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
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
        registerDatagenOnlyBlock(Desire.NATURES_SPIRIT, "kaolin_bricks");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "kaolin_bricks");
        registerDatagenOnlyBlock(Desire.NATURES_SPIRIT, "travertine");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "travertine");
        registerDatagenOnlyBlock(Desire.NATURES_SPIRIT, "smooth_pink_sandstone");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "smooth_pink_sandstone");
        for (DyeColor color : ModDatagenUtils.VANILLA_COLORS.stream().map((color) -> DyeColor.byName(color, DyeColor.WHITE)).toList()) {
            registerDatagenOnlyBlock(Desire.NATURES_SPIRIT, color.getName() + "_kaolin_bricks");
            registerDatagenOnlyItem(Desire.NATURES_SPIRIT, color.getName() + "_kaolin_bricks");
        }
    }

    protected static void registerDatagenOnlyItem(String modId, String name) {
        if (Desire.isDatagen()) {
            Registry.register(Registries.ITEM, Identifier.of(modId, name), new Item(new Item.Settings()));
        }
    }

    protected static void registerDatagenOnlyBlock(String modId, String name) {
        if (Desire.isDatagen()) {
            Registry.register(Registries.BLOCK, Identifier.of(modId, name), new Block(AbstractBlock.Settings.create()));
        }
    }
}
