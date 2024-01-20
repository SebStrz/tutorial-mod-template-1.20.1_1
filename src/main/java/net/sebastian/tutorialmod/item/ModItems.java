package net.sebastian.tutorialmod.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.item.*;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import net.minecraft.util.Identifier;

import net.sebastian.tutorialmod.TutorialMod;
import net.sebastian.tutorialmod.block.ModBlocks;
import net.sebastian.tutorialmod.item.custom.*;


public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(FoodItemComponents.TOMATO)));
    public static final Item COAL_SIGMA = registerItem("coal_sigma", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(128)));

    public static final Item PAXEL = registerItem("paxel", new PaxelItem(1,0f,ModToolMaterial.RUBY, new FabricItemSettings().maxDamage(1200)));

    public static final Item RUBY_SWORD = registerItem("ruby_sword", new ModPoisonSwordItem(ModToolMaterial.RUBY,
            9,2.3f,new FabricItemSettings()));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterial.RUBY,
            4,3f,new FabricItemSettings()));
    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterial.RUBY,
            10,-3f,new FabricItemSettings()));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterial.RUBY,
            2,3f,new FabricItemSettings()));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterial.RUBY,
            1,4f,new FabricItemSettings()));

    public static final Item RUBY_HELMET = registerItem("ruby_helmet",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item RUBY_LEGGINGS = registerItem("ruby_leggings",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item RUBY_BOOTS = registerItem("ruby_boots",
            new ModArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    public static final Item RUBY_HORSE_ARMOR = registerItem("ruby_horse_armor",
            new HorseArmorItem(14,"ruby", new FabricItemSettings()));

    public static final Item DATA_TABLET = registerItem("data_tablet",
            new DataTabletItem(new FabricItemSettings().maxCount(1)));

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
            new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP,new FabricItemSettings()));


    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name), item);
    }
    public static void registerModItems(){
        TutorialMod.LOGGER.info("Registering Mod Items for "+TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }


}
