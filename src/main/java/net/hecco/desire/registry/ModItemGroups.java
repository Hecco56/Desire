package net.hecco.desire.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.hecco.desire.Desire;
import net.hecco.desire.datagen.ModDatagenUtils;
import net.hecco.desire.util.BlockSetMaker;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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
                        for (String wood : BlockSetMaker.WoodVariantsBlockMaker.WOOD_TYPES) {
                            if (wood != "bamboo") {
                                entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(wood + "_mosaic"));
                                entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(wood + "_mosaic_stairs"));
                                entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(wood + "_mosaic_slab"));
                            }
                        }
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_stone"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_stone"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_stone_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_stone_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_stone_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("stone_tiles"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_stone_tiles"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("stone_tile_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("stone_tile_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("stone_tile_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_brick_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_brick_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_brick_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_brick_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cobblestone_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_cobblestone_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_cobblestone_brick_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_cobblestone_brick_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_cobblestone_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_granite_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_brick_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_brick_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_andesite_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_brick_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_brick_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_diorite_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_brick_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_brick_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_deepslate_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("mossy_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("brick_pillar"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_mud"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_mud_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_mud_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_mud_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_mud_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_mud_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_packed_mud"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_polished_basalt_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("basalt_tiles"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("basalt_tile_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("basalt_tile_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("basalt_tile_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_basalt_brick_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_basalt_brick_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_basalt_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cracked_polished_blackstone_tiles"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_blackstone_tile_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_blackstone_tile_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_blackstone_tile_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_brick_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_brick_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flintstone_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_flintstone_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("flint_block"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_flint_block"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_calcite"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_calcite_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_calcite_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_calcite_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_brick_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_brick_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("chiseled_calcite_bricks"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("stripped_dripstone"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("stripped_dripstone_ore"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("copper_pillar"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_copper_pillar"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_exposed_copper_pillar"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_weathered_copper_pillar"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("waxed_oxidized_copper_pillar"));
                        for (String color : ModDatagenUtils.VANILLA_COLORS) {
                            entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"));
                            entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_concrete_brick_stairs"));
                            entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_concrete_brick_slab"));
                            entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_concrete_brick_wall"));
                        }
                        for (String color : ModDatagenUtils.VANILLA_COLORS) {
                            entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"));
                            entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic_stairs"));
                            entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic_slab"));
                            entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic_wall"));
                        }
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_stone_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cut_sandstone_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("cut_red_sandstone_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("quartz_brick_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("quartz_brick_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("quartz_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_stairs"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_slab"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("calcite_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("stone_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_granite_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_andesite_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("polished_diorite_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_sandstone_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_red_sandstone_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("smooth_quartz_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("prismarine_brick_wall"));
                        entries.add(BlockSetMaker.BLOCK_SET_BLOCKS.get("dark_prismarine_wall"));
                        }).build());
    public static void register() {
    }
}
