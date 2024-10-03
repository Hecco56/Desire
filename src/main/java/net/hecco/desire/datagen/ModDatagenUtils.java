package net.hecco.desire.datagen;

import net.hecco.desire.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.*;

public class ModDatagenUtils {
    public static final Map<Block, Block> VARIANT_TO_BASE_BLOCK = new HashMap<>();
    public static final ArrayList<String> BASE_BLOCK_IDS = new ArrayList<>();
    public static final ArrayList<Block> CUSTOM_STAIRS_MODEL = new ArrayList<>();
    public static final ArrayList<Block> CUSTOM_SLAB_MODEL = new ArrayList<>();
    public static final ArrayList<Block> CUSTOM_WALL_MODEL = new ArrayList<>();
    public static Set<Identifier> allBlockIdsInNamespace(String namespace) {
        Set<Identifier> set = Registries.BLOCK.getIds();
        Set<Identifier> a = new HashSet<>();
        for(Identifier id : set) {
            if(Objects.equals(id.getNamespace(), namespace)) {
                a.add(id);
            }
        }
        return a;
    }

    public static Block getBlockFromId(String name) {
        Set<Identifier> set = Registries.BLOCK.getIds();
        for(Identifier id : set) {
            if(Objects.equals(id.getPath(), name)) {
                return Registries.BLOCK.get(id);
            }
        }
        return Blocks.AIR;
    }
    public static Set<Identifier> allItemIdsInNamespace(String namespace) {
        Set<Identifier> set = Registries.ITEM.getIds();
        Set<Identifier> a = new HashSet<>();
        for(Identifier id : set) {
            if(Objects.equals(id.getNamespace(), namespace)) {
                a.add(id);
            }
        }
        return a;
    }

    public static String toSentanceCase(String s) {
        String words[] = s.split("[\\s|_]");
        StringBuilder capitalizeWord = new StringBuilder();
        for(String w : words){
            String first = w.substring(0,1);
            String afterfirst = w.substring(1);
            capitalizeWord
                    .append(first.toUpperCase())
                    .append(afterfirst)
                    .append(" ");
        }
        return capitalizeWord.toString().trim();
    }
}
