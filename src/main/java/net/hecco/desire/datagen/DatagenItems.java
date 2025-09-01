package net.hecco.desire.datagen;

import net.hecco.desire.Desire;
import net.hecco.desire.compat.bountifulfares.BFModBlocks;
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
        registerDatagenOnlyItem(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_bricks");
        registerDatagenOnlyItem(Desire.JADENS_NETHER_EXPANSION, "yellow_nether_brick_slab");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "travertine_brick_slab");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "travertine_bricks");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "polished_travertine");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "chert_brick_slab");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "chert_bricks");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "polished_chert");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "chert");
        registerDatagenOnlyBlock(Desire.NATURES_SPIRIT, "kaolin_bricks");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "kaolin_bricks");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "kaolin");
        registerDatagenOnlyBlock(Desire.NATURES_SPIRIT, "travertine");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "travertine");
        registerDatagenOnlyBlock(Desire.NATURES_SPIRIT, "smooth_pink_sandstone");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "smooth_pink_sandstone");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "cut_pink_sandstone");
        registerDatagenOnlyItem(Desire.NATURES_SPIRIT, "pink_sandstone");
        for (String wood : NSModBlocks.WOOD_TYPES) {
            registerDatagenOnlyItem(Desire.NATURES_SPIRIT, wood + "_slab");
        }
        for (DyeColor color : ModDatagenUtils.VANILLA_COLORS.stream().map((color) -> DyeColor.byName(color, DyeColor.WHITE)).toList()) {
            registerDatagenOnlyBlock(Desire.NATURES_SPIRIT, color.getName() + "_kaolin_bricks");
            registerDatagenOnlyItem(Desire.NATURES_SPIRIT, color.getName() + "_kaolin_bricks");
            registerDatagenOnlyItem(Desire.NATURES_SPIRIT, color.getName() + "_kaolin");
        }

        for (String wood : BFModBlocks.WOOD_TYPES) {
            registerDatagenOnlyItem(Desire.BOUNTIFUL_FARES, wood + "_slab");
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
