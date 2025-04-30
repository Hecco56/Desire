package net.hecco.desire.util;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.hecco.desire.Desire;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockFamilyGenerator {
    public static final String MOD_ID = Desire.MOD_ID;


    public static Map<String, BlockFamilyGenerator> BLOCK_FAMILIES = new HashMap<>();
    public static Map<String, Block> BLOCKS = new HashMap<>();
    public static Map<Block, Block> VARIANT_TO_BASE_BLOCK = new HashMap<>();

    public static final ArrayList<Block> CUBE_ALL = new ArrayList<>();
    public static final ArrayList<Block> STAIRS = new ArrayList<>();
    public static final ArrayList<Block> SLABS = new ArrayList<>();
    public static final ArrayList<Block> WALLS = new ArrayList<>();
    public static final ArrayList<Block> FENCES = new ArrayList<>();
    public static final ArrayList<Block> WOODEN_FENCES = new ArrayList<>();
    public static final ArrayList<Block> FENCE_GATES = new ArrayList<>();
    public static final ArrayList<Block> DOORS = new ArrayList<>();
    public static final ArrayList<Block> WOODEN_DOORS = new ArrayList<>();
    public static final ArrayList<Block> TRAPDOORS = new ArrayList<>();
    public static final ArrayList<Block> WOODEN_TRAPDOORS = new ArrayList<>();
    public static final ArrayList<Block> PRESSURE_PLATES = new ArrayList<>();
    public static final ArrayList<Block> WOODEN_PRESSURE_PLATES = new ArrayList<>();
    public static final ArrayList<Block> STONE_PRESSURE_PLATES = new ArrayList<>();
    public static final ArrayList<Block> BUTTONS = new ArrayList<>();
    public static final ArrayList<Block> WOODEN_BUTTONS = new ArrayList<>();
    public static final ArrayList<Block> STONE_BUTTONS = new ArrayList<>();
    public static final ArrayList<Block> LEAVES = new ArrayList<>();
    public static final ArrayList<Block> FLOWERS = new ArrayList<>();
    public static final ArrayList<Block> SAPLINGS = new ArrayList<>();
    public static final ArrayList<Block> FLOWER_POTS = new ArrayList<>();

    public static Map<Block, Block> LOGS_TO_WOODS = new HashMap<>();
    public static final ArrayList<TagKey<Block>> FLAMMABLE_LOG_TAGS = new ArrayList<>();
    public static final ArrayList<TagKey<Block>> LOG_TAGS = new ArrayList<>();
    public static final ArrayList<Block> OVERWORLD_NATURAL_LOGS = new ArrayList<>();

    public static final ArrayList<Block> PICKAXE_MINEABLE = new ArrayList<>();
    public static final ArrayList<Block> AXE_MINEABLE = new ArrayList<>();
    public static final ArrayList<Block> SHOVEL_MINEABLE = new ArrayList<>();
    public static final ArrayList<Block> HOE_MINEABLE = new ArrayList<>();
    public static final ArrayList<Block> NEEDS_STONE_TOOL = new ArrayList<>();
    public static final ArrayList<Block> NEEDS_IRON_TOOL = new ArrayList<>();
    public static final ArrayList<Block> NEEDS_DIAMOND_TOOL = new ArrayList<>();

    public static final ArrayList<Block> FOLIAGE_TINTED = new ArrayList<>();

    public static final HashMap<Block, Block> STRIPPABLE = new HashMap<>();

    public static final ArrayList<Block> CUSTOM_STAIRS_MODEL = new ArrayList<>();
    public static final ArrayList<Block> CUSTOM_SLAB_MODEL = new ArrayList<>();
    public static final ArrayList<Block> CUSTOM_WALL_MODEL = new ArrayList<>();

    private Block registerBlock(String name, Mineables mineable, Block block) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, new Item.Settings()));
        Block block1 = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
        switch (mineable) {
            case PICKAXE -> PICKAXE_MINEABLE.add(block1);
            case AXE -> AXE_MINEABLE.add(block1);
            case SHOVEL -> SHOVEL_MINEABLE.add(block1);
            case HOE -> HOE_MINEABLE.add(block1);
        }
        switch (minMiningToolTier) {
            case STONE -> NEEDS_STONE_TOOL.add(block1);
            case IRON -> NEEDS_IRON_TOOL.add(block1);
            case DIAMOND -> NEEDS_DIAMOND_TOOL.add(block1);
        }
        BLOCKS.put(name, block1);
        blockFamilyBlocks.add(block);
        return block1;
    }

    private Block registerBlockNoItem(String name, Mineables mineable, Block block) {
        Block block1 = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
        switch (mineable) {
            case PICKAXE -> PICKAXE_MINEABLE.add(block1);
            case AXE -> AXE_MINEABLE.add(block1);
            case SHOVEL -> SHOVEL_MINEABLE.add(block1);
            case HOE -> HOE_MINEABLE.add(block1);
        }
        switch (minMiningToolTier) {
            case STONE -> NEEDS_STONE_TOOL.add(block1);
            case IRON -> NEEDS_IRON_TOOL.add(block1);
            case DIAMOND -> NEEDS_DIAMOND_TOOL.add(block1);
        }
        BLOCKS.put(name, block1);
        blockFamilyBlocks.add(block);
        return block1;
    }

    private final String name;
    private String prefix = "";
    private String suffix = "";
    private final Mineables mineable;
    private final MinMiningToolTier minMiningToolTier;
    private Block baseBlock;
    private final Block masterBaseBlock;
    private final AbstractBlock.Settings settings;
    private final ArrayList<Block> blockFamilyBlocks = new ArrayList<>();

    public BlockFamilyGenerator(String name, Mineables mineable, MinMiningToolTier minMiningToolTier, Block baseBlock, AbstractBlock.Settings settings, boolean generateBaseBlockModel) {
        this.name = name;
        this.mineable = mineable;
        this.minMiningToolTier = minMiningToolTier;
        this.baseBlock = baseBlock;
        this.masterBaseBlock = baseBlock;
        this.settings = settings;
        if (generateBaseBlockModel) {
            CUBE_ALL.add(baseBlock);
        }
        BLOCKS.put(Registries.BLOCK.getId(baseBlock).getPath(), baseBlock);
        BLOCK_FAMILIES.put(name, this);
    }

    public BlockFamilyGenerator block(String prefix, String suffix, boolean generateModel) {
        Block block = registerBlock((prefix != "" ? prefix + "_" : "") + name + (suffix != "" ? "_" + suffix : ""), mineable, new Block(settings));
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);
        this.baseBlock = block;

        this.prefix = prefix == "" ? "" : prefix + "_";
        this.suffix = suffix == "" ? "" : "_" + suffix;
        if (suffix == "bricks") {
            this.suffix = "_brick";
        } else if (suffix == "tiles") {
            this.suffix = "_tile";
        }

        if (generateModel) {
            CUBE_ALL.add(block);
        }
        return this;
    }

    public BlockFamilyGenerator block(String prefix, String suffix, Block block, boolean generateModel) {
        block = registerBlock((prefix != "" ? prefix + "_" : "") + name + (suffix != "" ? "_" + suffix : ""), mineable, block);
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);
        this.baseBlock = block;

        this.prefix = prefix == "" ? "" : prefix + "_";
        this.suffix = suffix == "" ? "" : "_" + suffix;
        if (suffix == "bricks") {
            this.suffix = "_brick";
        } else if (suffix == "tiles") {
            this.suffix = "_tile";
        }

        if (generateModel) {
            CUBE_ALL.add(block);
        }
        return this;
    }

    public BlockFamilyGenerator stairs() {
        Block block = registerBlock(prefix + name + suffix + "_stairs", mineable, new StairsBlock(baseBlock.getDefaultState(), settings));
        STAIRS.add(block);
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator stairs(boolean customModel) {
        Block block = registerBlock(prefix + name + suffix + "_stairs", mineable, new StairsBlock(baseBlock.getDefaultState(), settings));
        STAIRS.add(block);
        if (customModel) {
            CUSTOM_STAIRS_MODEL.add(block);
        }
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator slab() {
        Block block = registerBlock(prefix + name + suffix + "_slab", mineable, new SlabBlock(settings));
        SLABS.add(block);
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator slab(boolean customModel) {
        Block block = registerBlock(prefix + name + suffix + "_slab", mineable, new SlabBlock(settings));
        SLABS.add(block);
        if (customModel) {
            CUSTOM_SLAB_MODEL.add(block);
        }
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator wall() {
        Block block = registerBlock(prefix + name + suffix + "_wall", mineable, new WallBlock(settings));
        WALLS.add(block);
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator wall(boolean customModel) {
        Block block = registerBlock(prefix + name + suffix + "_wall", mineable, new WallBlock(settings));
        WALLS.add(block);
        if (customModel) {
            CUSTOM_WALL_MODEL.add(block);
        }
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator fence(boolean wooden) {
        Block block = registerBlock(name + "_fence", mineable, new FenceBlock(settings));
        if (wooden) {
            WOODEN_FENCES.add(block);
        } else {
            FENCES.add(block);
        }
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator fenceGate(WoodType woodType) {
        Block block = registerBlock(name + "_fence_gate", mineable, new FenceGateBlock(settings, woodType));
        FENCE_GATES.add(block);
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator logs(boolean burnable, boolean overworld) {
        Block log = registerBlock(name + "_log", mineable, new PillarBlock(settings));

        Block strippedLog = registerBlock("stripped_" + name + "_log", mineable, new PillarBlock(settings));

        Block wood = registerBlock(name + "_wood", mineable, new PillarBlock(settings));

        Block strippedWood = registerBlock("stripped_" + name + "_wood", mineable, new PillarBlock(settings));

        LOGS_TO_WOODS.put(log, wood);
        LOGS_TO_WOODS.put(strippedLog, strippedWood);
        if (burnable) {
            FLAMMABLE_LOG_TAGS.add(TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, this.name + "_logs")));
        } else {
            LOG_TAGS.add(TagKey.of(RegistryKeys.BLOCK, new Identifier(MOD_ID, this.name + "_logs")));
        }
        if (overworld) {
            OVERWORLD_NATURAL_LOGS.add(log);
        }

        STRIPPABLE.put(wood, strippedWood);
        STRIPPABLE.put(log, strippedLog);

        return this;
    }

    public BlockFamilyGenerator door(BlockSetType blockSetType, boolean wooden) {
        Block block = registerBlock(name + "_door", mineable, new DoorBlock(settings, blockSetType));
        if (wooden) {
            WOODEN_DOORS.add(block);
        } else {
            DOORS.add(block);
        }

        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator trapdoor(BlockSetType blockSetType, boolean wooden) {
        Block block = registerBlock(name + "_trapdoor", mineable, new TrapdoorBlock(settings, blockSetType));
        if (wooden) {
            WOODEN_TRAPDOORS.add(block);
        } else {
            TRAPDOORS.add(block);
        }

        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator pressurePlate(BlockSetType blockSetType, boolean wooden, boolean stone) {
        Block block = registerBlock(name + "_pressure_plate", mineable, new PressurePlateBlock(wooden ? PressurePlateBlock.ActivationRule.EVERYTHING : PressurePlateBlock.ActivationRule.MOBS, settings.solid().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY), blockSetType));
        if (wooden) {
            WOODEN_PRESSURE_PLATES.add(block);
        } else if (stone) {
            STONE_PRESSURE_PLATES.add(block);
        } else {
            PRESSURE_PLATES.add(block);
        }
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator button(BlockSetType blockSetType, boolean wooden, boolean stone, int pressTicks) {
        Block block = registerBlock(name + "_button", mineable, new ButtonBlock(AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY), blockSetType, pressTicks, wooden));
        if (wooden) {
            WOODEN_BUTTONS.add(block);
        } else if (stone) {
            STONE_BUTTONS.add(block);
        } else {
            BUTTONS.add(block);
        }
        VARIANT_TO_BASE_BLOCK.put(block, baseBlock);

        return this;
    }

    public BlockFamilyGenerator leaves(BlockSoundGroup sounds, MapColor mapColor, boolean tint) {
        Block block = registerBlock(name + "_leaves", Mineables.HOE, new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).sounds(sounds).mapColor(mapColor)));
        LEAVES.add(block);
        if (tint) {
            FOLIAGE_TINTED.add(block);
        }

        return this;
    }

    public BlockFamilyGenerator leavesVariant(BlockSoundGroup sounds, MapColor mapColor, String name, boolean flower, boolean tint) {
        Block block = registerBlock(name + "_" + this.name + "_leaves", Mineables.HOE, new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).sounds(sounds).mapColor(mapColor)));
        LEAVES.add(block);
        if (flower) {
            FLOWERS.add(block);
        }
        if (tint) {
            FOLIAGE_TINTED.add(block);
        }

        return this;
    }

    public BlockFamilyGenerator sapling(SaplingGenerator saplingGenerator) {
        Block block = registerBlock(name + "_sapling", Mineables.NONE, new SaplingBlock(saplingGenerator, AbstractBlock.Settings.create().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
        Block pottedBlock = registerBlockNoItem("potted_" + name + "_sapling", Mineables.NONE, new FlowerPotBlock(block, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
        SAPLINGS.add(block);
        FLOWER_POTS.add(pottedBlock);

        return this;
    }

    public BlockFamilyGenerator sapling(String id, SaplingGenerator saplingGenerator) {
        Block block = registerBlock(id + "_" + this.name + "_sapling", Mineables.NONE, new SaplingBlock(saplingGenerator, AbstractBlock.Settings.create().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
        Block pottedBlock = registerBlockNoItem("potted_" + id + "_" + this.name + "_sapling", Mineables.NONE, new FlowerPotBlock(block, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
        SAPLINGS.add(block);
        FLOWER_POTS.add(pottedBlock);

        return this;
    }

    public Block getVariant(String variant) {
        if (!variant.isEmpty()) {
            for (Block block : this.blockFamilyBlocks) {
                if (Registries.BLOCK.getId(block).getPath().contains(this.name)) {
                    String id = Registries.BLOCK.getId(block).getPath().replace(this.name + "_", "").replace("_" + this.name, "");
                    if (id.equals(variant)) {
                        return block;
                    }
                }
            }
        } else {
            return this.masterBaseBlock;
        }
        throw new RuntimeException("No such " + this.name + " block variant " + variant + " exists");
    }

    public void addAllBlocksToItemGroup(ItemGroup.Entries entries) {
        for (Block block : this.blockFamilyBlocks) {
            try {
                entries.add(block);
            } catch (Exception ignored) {
            }
        }
    }

    public void addAllBlocksToItemGroup(ItemGroup.Entries entries, List<String> ignoredVariants) {
        for (Block block : this.blockFamilyBlocks) {
            boolean bl = true;
            for (String variant : ignoredVariants) {
                if (getVariant(variant) == block) {
                    bl = false;
                }
            }
            if (bl) {
                try {
                    entries.add(block);
                } catch (Exception ignored) {
                }
            }
        }
    }

    public void addWoodSetToVanillaItemGroups(String idBefore, String woodBefore) {
        Item beforeButton = Registries.ITEM.get(new Identifier(idBefore, woodBefore + "_button"));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(beforeButton, this.getVariant("log"));
            entries.addAfter(this.getVariant("log"), this.getVariant("wood"));
            entries.addAfter(this.getVariant("wood"), this.getVariant("stripped_log"));
            entries.addAfter(this.getVariant("stripped_log"), this.getVariant("stripped_wood"));
            entries.addAfter(this.getVariant("stripped_wood"), this.getVariant("planks"));
            entries.addAfter(this.getVariant("planks"), this.getVariant("stairs"));
            entries.addAfter(this.getVariant("stairs"), this.getVariant("slab"));
            entries.addAfter(this.getVariant("slab"), this.getVariant("fence"));
            entries.addAfter(this.getVariant("fence"), this.getVariant("fence_gate"));
            entries.addAfter(this.getVariant("fence_gate"), this.getVariant("door"));
            entries.addAfter(this.getVariant("door"), this.getVariant("trapdoor"));
            entries.addAfter(this.getVariant("trapdoor"), this.getVariant("pressure_plate"));
            entries.addAfter(this.getVariant("pressure_plate"), this.getVariant("button"));
        });
        Item beforeLog = Registries.ITEM.get(new Identifier(idBefore, woodBefore + "_log"));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(beforeLog, this.getVariant("log"));
        });
        try {
            Item beforeLeaves = Registries.ITEM.get(new Identifier(idBefore, woodBefore + "_leaves"));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
                entries.addAfter(beforeLeaves, this.getVariant("leaves"));
            });
        } catch (Exception ignored) {}
        try {
            Item beforeSapling = Registries.ITEM.get(new Identifier(idBefore, woodBefore + "_sapling"));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
                entries.addAfter(beforeSapling, this.getVariant("sapling"));
            });
        } catch (Exception ignored) {}
    }
}

