package net.hecco.desire.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hecco.desire.Desire;
import net.hecco.desire.compat.netherexp.JNEModBlocks;
import net.hecco.desire.datagen.desire.ModDatagenUtils;
import net.hecco.desire.oldutil.BlockSetGenerator;
import net.hecco.desire.util.BlockFamilyGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static ItemGroup DESIRE = Registry.register(Registries.ITEM_GROUP, Identifier.of(Desire.MOD_ID, "desire"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.desire"))
                    .icon(() -> new ItemStack(ModItems.DESIRE_ICON)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.STONE_BOULDER);
                        entries.add(BlockFamilyGenerator.BLOCK_FAMILIES.get("stone").getVariant("chiseled"));
                        entries.add(ModBlocks.DEEPSLATE_SHEET);
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_deepslate_bricks"));
                        entries.add(ModBlocks.BLACKSTONE_CHUNK);
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_blackstone"));
//                        for (String wood : BlockSetGenerator.WoodVariantsBlockMaker.WOOD_TYPES) {
//                            if (wood != "bamboo") {
//                                entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(wood + "_mosaic"));
//                                entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(wood + "_mosaic_stairs"));
//                                entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(wood + "_mosaic_slab"));
//                            }
//                        }
//                        entries.add(JNEModBlocks.CLARET_MOSAIC);
//                        entries.add(JNEModBlocks.CLARET_MOSAIC_STAIRS);
//                        entries.add(JNEModBlocks.CLARET_MOSAIC_SLAB);
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
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_bricks"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("mossy_bricks"));
                        entries.add(Blocks.BRICKS);
                        entries.add(Blocks.BRICK_STAIRS);
                        entries.add(Blocks.BRICK_SLAB);
                        entries.add(Blocks.BRICK_WALL);
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_bricks"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("brick_pillar"));
                        entries.add(Blocks.PACKED_MUD);
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud_slab"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_mud_wall"));
                        entries.add(Blocks.MUD_BRICKS);
                        entries.add(Blocks.MUD_BRICK_STAIRS);
                        entries.add(Blocks.MUD_BRICK_SLAB);
                        entries.add(Blocks.MUD_BRICK_WALL);
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_mud_bricks"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_mud_bricks"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_packed_mud"));
                        entries.add(Blocks.GRAVEL);
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_slab"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_bricks"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_brick_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_brick_slab"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flintstone_brick_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_slab"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_flintstone_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("flint_block"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_flint_block"));
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
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("carved_dripstone_ore"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_block"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_slab"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("rough_concrete_wall"));
                        entries.add(Blocks.BASALT);
                        entries.add(Blocks.POLISHED_BASALT);
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_basalt_bricks"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("chiseled_polished_basalt_bricks"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tiles"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tile_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tile_slab"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("basalt_tile_wall"));
                        entries.add(Blocks.SMOOTH_BASALT);
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_stairs"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_slab"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("smooth_basalt_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_bricks"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_brick_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_brick_slab"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_basalt_brick_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tiles"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cracked_polished_blackstone_tiles"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tile_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tile_slab"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_blackstone_tile_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("copper_pillar"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("exposed_copper_pillar"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("weathered_copper_pillar"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("oxidized_copper_pillar"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_copper_pillar"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_exposed_copper_pillar"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_weathered_copper_pillar"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("waxed_oxidized_copper_pillar"));
//                        for (String color : ModDatagenUtils.VANILLA_COLORS) {
//                            entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_bricks"));
//                            entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_brick_stairs"));
//                            entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_brick_slab"));
//                            entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_concrete_brick_wall"));
//                        }
//                        for (String color : ModDatagenUtils.VANILLA_COLORS) {
//                            entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic"));
//                            entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic_stairs"));
//                            entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic_slab"));
//                            entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get(color + "_terracotta_mosaic_wall"));
//                        }
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cut_sandstone_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("cut_red_sandstone_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("quartz_brick_stairs"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("quartz_brick_slab"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("quartz_brick_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("stone_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_granite_wall"));
                        entries.add(BlockFamilyGenerator.BLOCKS.get("polished_andesite_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("polished_diorite_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_sandstone_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_red_sandstone_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("smooth_quartz_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("prismarine_brick_wall"));
//                        entries.add(BlockSetGenerator.BLOCK_SET_BLOCKS.get("dark_prismarine_wall"));
                        }).build());
    public static void register() {

        if (Desire.isModLoaded(Desire.JADENS_NETHER_EXPANSION)) {
            ItemGroupEvents.modifyEntriesEvent(RegistryKey.of(RegistryKeys.ITEM_GROUP,
                    Identifier.of(Desire.JADENS_NETHER_EXPANSION, "netherexp")))
                    .register(entries -> {
                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "claret_planks")), JNEModBlocks.CLARET_MOSAIC);
                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "claret_stairs")), JNEModBlocks.CLARET_MOSAIC_STAIRS);
                entries.addAfter(Registries.ITEM.get(Identifier.of(Desire.JADENS_NETHER_EXPANSION, "claret_slab")), JNEModBlocks.CLARET_MOSAIC_SLAB);
            }
            );

        }
    }
}
