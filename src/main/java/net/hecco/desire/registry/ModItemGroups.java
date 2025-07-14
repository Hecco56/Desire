package net.hecco.desire.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.bountifulfares.BFModBlocks;
import net.hecco.desire.compat.natures_spirit.NSModBlocks;
import net.hecco.desire.compat.netherexp.JNEModBlocks;
import net.hecco.desire.datagen.desire.ModDatagenUtils;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static ItemGroup DESIRE = Registry.register(Registries.ITEM_GROUP, Identifier.of(Desire.MOD_ID, "desire"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.desire"))
                    .icon(() -> new ItemStack(ModItems.DESIRE_ICON)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.STONE_BOULDER);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("chiseled"));
                        entries.add(ModBlocks.DEEPSLATE_SHEET);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("chiseled_deepslate_bricks"));
                        entries.add(ModBlocks.BLACKSTONE_CHUNK);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("chiseled_blackstone"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("oak").getVariant("mosaic"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("oak").getVariant("mosaic_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("oak").getVariant("mosaic_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("spruce").getVariant("mosaic"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("spruce").getVariant("mosaic_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("spruce").getVariant("mosaic_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("birch").getVariant("mosaic"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("birch").getVariant("mosaic_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("birch").getVariant("mosaic_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("jungle").getVariant("mosaic"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("jungle").getVariant("mosaic_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("jungle").getVariant("mosaic_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("acacia").getVariant("mosaic"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("acacia").getVariant("mosaic_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("acacia").getVariant("mosaic_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("dark_oak").getVariant("mosaic"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("dark_oak").getVariant("mosaic_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("dark_oak").getVariant("mosaic_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mangrove").getVariant("mosaic"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mangrove").getVariant("mosaic_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mangrove").getVariant("mosaic_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("cherry").getVariant("mosaic"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("cherry").getVariant("mosaic_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("cherry").getVariant("mosaic_slab"));
                        entries.add(Blocks.BAMBOO_MOSAIC);
                        entries.add(Blocks.BAMBOO_MOSAIC_STAIRS);
                        entries.add(Blocks.BAMBOO_MOSAIC_SLAB);
                        for (String wood : BFModBlocks.WOOD_TYPES) {
                            entries.add(BFModBlocks.WOOD_MOSAICS.get(wood));
                            entries.add(BFModBlocks.WOOD_MOSAIC_STAIRS.get(wood));
                            entries.add(BFModBlocks.WOOD_MOSAIC_SLABS.get(wood));
                        }
                        for (String wood : NSModBlocks.WOOD_TYPES) {
                            entries.add(NSModBlocks.WOOD_MOSAICS.get(wood));
                            entries.add(NSModBlocks.WOOD_MOSAIC_STAIRS.get(wood));
                            entries.add(NSModBlocks.WOOD_MOSAIC_SLABS.get(wood));
                        }
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("crimson").getVariant("mosaic"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("crimson").getVariant("mosaic_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("crimson").getVariant("mosaic_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("warped").getVariant("mosaic"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("warped").getVariant("mosaic_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("warped").getVariant("mosaic_slab"));
                        entries.add(JNEModBlocks.CLARET_MOSAIC);
                        entries.add(JNEModBlocks.CLARET_MOSAIC_STAIRS);
                        entries.add(JNEModBlocks.CLARET_MOSAIC_SLAB);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("polished"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("polished_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("polished_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("polished_wall"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("tiles"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("cracked_tiles"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("tile_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("tile_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("tile_wall"));
                        entries.add(Blocks.SMOOTH_STONE);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("smooth_stone").getVariant("stairs"));
                        entries.add(Blocks.SMOOTH_STONE_SLAB);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("smooth_stone").getVariant("bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("smooth_stone").getVariant("brick_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("smooth_stone").getVariant("brick_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("smooth_stone").getVariant("brick_wall"));
                        entries.add(Blocks.COBBLESTONE);
                        entries.add(Blocks.COBBLESTONE_STAIRS);
                        entries.add(Blocks.COBBLESTONE_SLAB);
                        entries.add(Blocks.COBBLESTONE_WALL);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("cobblestone").getVariant("bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("cobblestone").getVariant("brick_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("cobblestone").getVariant("brick_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("cobblestone").getVariant("brick_wall"));
                        entries.add(Blocks.MOSSY_COBBLESTONE);
                        entries.add(Blocks.MOSSY_COBBLESTONE_STAIRS);
                        entries.add(Blocks.MOSSY_COBBLESTONE_SLAB);
                        entries.add(Blocks.MOSSY_COBBLESTONE_WALL);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mossy_cobblestone").getVariant("bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mossy_cobblestone").getVariant("brick_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mossy_cobblestone").getVariant("brick_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mossy_cobblestone").getVariant("brick_wall"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_granite").getVariant("bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_granite").getVariant("cracked_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_granite").getVariant("brick_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_granite").getVariant("brick_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_granite").getVariant("brick_wall"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_andesite").getVariant("bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_andesite").getVariant("cracked_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_andesite").getVariant("brick_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_andesite").getVariant("brick_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_andesite").getVariant("brick_wall"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_diorite").getVariant("bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_diorite").getVariant("cracked_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_diorite").getVariant("brick_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_diorite").getVariant("brick_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("polished_diorite").getVariant("brick_wall"));
                        entries.add(NSModBlocks.CHISELED_TRAVERTINE_BRICKS);
                        entries.add(NSModBlocks.CHISELED_CHERT_BRICKS);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("cracked_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("mossy_bricks"));
                        entries.add(Blocks.BRICKS);
                        entries.add(Blocks.BRICK_STAIRS);
                        entries.add(Blocks.BRICK_SLAB);
                        entries.add(Blocks.BRICK_WALL);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("chiseled_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("brick_pillar"));
                        entries.add(Blocks.PACKED_MUD);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mud").getVariant("polished"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mud").getVariant("polished_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mud").getVariant("polished_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mud").getVariant("polished_wall"));
                        entries.add(Blocks.MUD_BRICKS);
                        entries.add(Blocks.MUD_BRICK_STAIRS);
                        entries.add(Blocks.MUD_BRICK_SLAB);
                        entries.add(Blocks.MUD_BRICK_WALL);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mud").getVariant("cracked_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mud").getVariant("chiseled_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("mud").getVariant("smooth_packed"));
                        entries.add(Blocks.GRAVEL);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant(""));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("wall"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("brick_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("brick_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("brick_wall"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("smooth"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("smooth_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("smooth_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("flintstone").getVariant("smooth_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("flint_block"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("polished_flint_block"));
                        entries.add(Blocks.CALCITE);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("wall"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("chiseled"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("polished"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("polished_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("polished_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("polished_wall"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("cracked_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("brick_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("brick_slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("brick_wall"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("calcite").getVariant("chiseled_bricks"));
                        entries.add(Blocks.DRIPSTONE_BLOCK);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("dripstone_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("dripstone_slab"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("dripstone_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("carved_dripstone"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("carved_dripstone_ore"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("rough_concrete").getVariant(""));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("rough_concrete").getVariant("block"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("rough_concrete").getVariant("stairs"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("rough_concrete").getVariant("slab"));
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("rough_concrete").getVariant("wall"));
                        entries.add(Blocks.BASALT);
                        entries.add(Blocks.POLISHED_BASALT);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("polished_basalt_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("chiseled_polished_basalt_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("basalt_tiles"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("basalt_tile_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("basalt_tile_slab"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("basalt_tile_wall"));
                        entries.add(Blocks.SMOOTH_BASALT);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_slab"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_bricks"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_brick_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_brick_slab"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_brick_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tiles"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("cracked_polished_blackstone_tiles"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tile_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tile_slab"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("polished_blackstone_tile_wall"));
                        entries.add(JNEModBlocks.POLISHED_NETHER_BRICKS);
                        entries.add(JNEModBlocks.POLISHED_RED_NETHER_BRICKS);
                        entries.add(JNEModBlocks.CRACKED_RED_NETHER_BRICKS);
                        entries.add(JNEModBlocks.CHISELED_RED_NETHER_BRICKS);
                        entries.add(JNEModBlocks.RED_NETHER_BRICK_FENCE);
                        entries.add(JNEModBlocks.POLISHED_BLUE_NETHER_BRICKS);
                        entries.add(JNEModBlocks.CRACKED_BLUE_NETHER_BRICKS);
                        entries.add(JNEModBlocks.CHISELED_BLUE_NETHER_BRICKS);
                        entries.add(JNEModBlocks.BLUE_NETHER_BRICK_FENCE);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("copper_pillar"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("exposed_copper_pillar"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("weathered_copper_pillar"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("oxidized_copper_pillar"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("waxed_copper_pillar"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("waxed_exposed_copper_pillar"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("waxed_weathered_copper_pillar"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("waxed_oxidized_copper_pillar"));
                        for (String color : ModDatagenUtils.VANILLA_COLORS) {
                            entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get(color + "_concrete").getVariant("bricks"));
                            entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get(color + "_concrete").getVariant("brick_stairs"));
                            entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get(color + "_concrete").getVariant("brick_slab"));
                            entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get(color + "_concrete").getVariant("brick_wall"));
                        }
                        for (String color : ModDatagenUtils.VANILLA_COLORS) {
                            entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get(color + "_terracotta").getVariant("mosaic"));
                            entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get(color + "_terracotta").getVariant("mosaic_stairs"));
                            entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get(color + "_terracotta").getVariant("mosaic_slab"));
                            entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get(color + "_terracotta").getVariant("mosaic_wall"));
                        }
                        entries.add(BlockFamilyGenerator.BLOCKS.get("cut_sandstone_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("cut_red_sandstone_stairs"));
                        entries.add(NSModBlocks.CUT_PINK_SANDSTONE_STAIRS);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("quartz_brick_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("quartz_brick_slab"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("quartz_brick_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("stone_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("polished_granite_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("polished_andesite_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("polished_diorite_wall"));
                        entries.add(NSModBlocks.KAOLIN_BRICK_WALL);
                        for (DyeColor color : ModDatagenUtils.VANILLA_COLORS.stream().map((color) -> DyeColor.byName(color, DyeColor.WHITE)).toList()) {
                            entries.add(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(color));
                        }
                        entries.add(NSModBlocks.TRAVERTINE_WALL);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_sandstone_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_red_sandstone_wall"));
                        entries.add(NSModBlocks.SMOOTH_PINK_SANDSTONE_WALL);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_quartz_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("prismarine_brick_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("dark_prismarine_wall"));
                    }).build());
    public static void register() {

        if (Desire.isModLoaded(Desire.JADENS_NETHER_EXPANSION)) {
            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP,
                    Identifier.of(Desire.JADENS_NETHER_EXPANSION, "netherexp")))
                    .register(entries -> {
                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "claret_planks")), JNEModBlocks.CLARET_MOSAIC);
                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "claret_stairs")), JNEModBlocks.CLARET_MOSAIC_STAIRS);
                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "claret_slab")), JNEModBlocks.CLARET_MOSAIC_SLAB);
                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "nether_brick_pillar")), JNEModBlocks.POLISHED_NETHER_BRICKS);
                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "red_nether_brick_wall")), JNEModBlocks.POLISHED_RED_NETHER_BRICKS);
                entries.addAfter(JNEModBlocks.POLISHED_RED_NETHER_BRICKS, JNEModBlocks.CRACKED_RED_NETHER_BRICKS);
                entries.addAfter(JNEModBlocks.CRACKED_RED_NETHER_BRICKS, JNEModBlocks.CHISELED_RED_NETHER_BRICKS);
                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "blue_nether_brick_wall")), JNEModBlocks.POLISHED_BLUE_NETHER_BRICKS);
                entries.addAfter(JNEModBlocks.POLISHED_BLUE_NETHER_BRICKS, JNEModBlocks.CRACKED_BLUE_NETHER_BRICKS);
                entries.addAfter(JNEModBlocks.CRACKED_BLUE_NETHER_BRICKS, JNEModBlocks.CHISELED_BLUE_NETHER_BRICKS);
            }
            );

        }


        if (Desire.isModLoaded(Desire.NATURES_SPIRIT)) {
            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP,
                            Identifier.of(Desire.NATURES_SPIRIT, "tab")))
                    .register(entries -> {
                                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "cut_pink_sandstone")), NSModBlocks.CUT_PINK_SANDSTONE_STAIRS);
                                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "smooth_pink_sandstone_slab")), NSModBlocks.SMOOTH_PINK_SANDSTONE_WALL);
                                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "travertine_slab")), NSModBlocks.TRAVERTINE_WALL);
                                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "travertine_brick_slab")), NSModBlocks.CHISELED_TRAVERTINE_BRICKS);
                                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "chert_brick_wall")), NSModBlocks.CHISELED_CHERT_BRICKS);
                                for (String wood : NSModBlocks.WOOD_TYPES) {
                                    entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, wood + "_planks")), NSModBlocks.WOOD_MOSAICS.get(wood));
                                    entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, wood + "_stairs")), NSModBlocks.WOOD_MOSAIC_STAIRS.get(wood));
                                    entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, wood + "_slab")), NSModBlocks.WOOD_MOSAIC_SLABS.get(wood));
                                }
                                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.NATURES_SPIRIT, "pink_kaolin_brick_slab")), NSModBlocks.KAOLIN_BRICK_WALL);
                                entries.addAfter(NSModBlocks.KAOLIN_BRICK_WALL.asItem(), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.WHITE));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.WHITE), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.LIGHT_GRAY));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.LIGHT_GRAY), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.GRAY));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.GRAY), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.BLACK));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.BLACK), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.BROWN));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.BROWN), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.RED));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.RED), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.ORANGE));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.ORANGE), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.YELLOW));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.YELLOW), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.LIME));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.LIME), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.GREEN));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.GREEN), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.CYAN));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.CYAN), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.LIGHT_BLUE));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.LIGHT_BLUE), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.BLUE));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.BLUE), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.PURPLE));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.PURPLE), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.MAGENTA));
                                entries.addAfter(NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.MAGENTA), NSModBlocks.DYED_KAOLIN_BRICK_WALLS.get(DyeColor.PINK));
                        }
                    );

        }

        if (Desire.isModLoaded(Desire.BOUNTIFUL_FARES)) {
            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP,
                            Identifier.of(Desire.BOUNTIFUL_FARES, "bountiful_fares")))
                    .register(entries -> {
                                for (String wood : BFModBlocks.WOOD_TYPES) {
                                    entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.BOUNTIFUL_FARES, wood + "_planks")), BFModBlocks.WOOD_MOSAICS.get(wood));
                                    entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.BOUNTIFUL_FARES, wood + "_stairs")), BFModBlocks.WOOD_MOSAIC_STAIRS.get(wood));
                                    entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.BOUNTIFUL_FARES, wood + "_slab")), BFModBlocks.WOOD_MOSAIC_SLABS.get(wood));
                                }
                            }
                    );

        }
    }
}
