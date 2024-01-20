package net.sebastian.tutorialmod.util;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import net.sebastian.tutorialmod.TutorialMod;
import net.sebastian.tutorialmod.item.ModItems;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, new Identifier(TutorialMod.MOD_ID, "on"),
                (stack, world, entity, seed) -> stack.hasNbt() ? 1f : 0f);
    }
}
