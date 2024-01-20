package net.sebastian.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.sebastian.tutorialmod.block.ModBlocks;
import net.sebastian.tutorialmod.enchantment.ModEnchantments;
import net.sebastian.tutorialmod.item.ModItemGroups;
import net.sebastian.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID =  "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.COAL_SIGMA, 4000);

		ModEnchantments.registerModEnchantments();

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TOMATO, 0.5f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CAULIFLOWER_SEEDS, 0.25f);

	}
}