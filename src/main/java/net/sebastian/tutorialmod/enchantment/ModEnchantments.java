package net.sebastian.tutorialmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sebastian.tutorialmod.TutorialMod;

public class ModEnchantments {

    public static final Enchantment LIGHTNING_STRIKER = register("lightning_striker",
            new LightningStrikerEnchantment(Enchantment.Rarity.COMMON, EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));

    public static Enchantment register(String name,Enchantment enchantment){
        return Registry.register(Registries.ENCHANTMENT, new Identifier(TutorialMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments(){
        TutorialMod.LOGGER.info("Registering mod enchantments for: "+TutorialMod.MOD_ID);
    }
}
