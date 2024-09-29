package net.hecco.desire.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.hecco.desire.Desire;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;

import static net.hecco.desire.datagen.ModDatagenUtils.toSentanceCase;

public class ModLangProvider extends FabricLanguageProvider {
    Set<String> usedTranslationKeys = new HashSet<>();
    public ModLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }
    private void generate(TranslationBuilder translationBuilder, String key, String translation) {
        if(usedTranslationKeys.contains(key)) {
            return;
        }
        translationBuilder.add(key, translation);
        usedTranslationKeys.add(key);
    }
    private void generate(TranslationBuilder translationBuilder, Block block, String translation) {
        generate(translationBuilder, block.getTranslationKey(), translation);
    }
    private void generate(TranslationBuilder translationBuilder, Item item, String translation) {
        generate(translationBuilder, item.getTranslationKey(), translation);
    }

    private void generateRaw(TranslationBuilder translationBuilder, String key, String translation) {
        translationBuilder.add(key, translation);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for(Identifier id : ModDatagenUtils.allBlockIdsInNamespace(Desire.MOD_ID)) {
            String key = Registries.BLOCK.get(id).getTranslationKey();
            if(usedTranslationKeys.contains(key)) { continue; }
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentanceCase(id.getPath()));
        }
        for(Identifier id : ModDatagenUtils.allItemIdsInNamespace(Desire.MOD_ID)) {
            String key = Registries.ITEM.get(id).getTranslationKey();
            if (usedTranslationKeys.contains(key)) {
                continue;
            }
            usedTranslationKeys.add(key);
            translationBuilder.add(key, toSentanceCase(id.getPath()));
        }
    }
}
