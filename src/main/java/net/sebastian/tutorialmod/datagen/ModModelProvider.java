package net.sebastian.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.sebastian.tutorialmod.block.ModBlocks;
import net.sebastian.tutorialmod.block.custom.CauliflowerCropBlock;
import net.sebastian.tutorialmod.block.custom.RubyLampBlock;
import net.sebastian.tutorialmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool rubyTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);
        rubyTexturePool.stairs(ModBlocks.RUBY_STAIRS);
        rubyTexturePool.slab(ModBlocks.RUBY_SLAB);
        rubyTexturePool.button(ModBlocks.RUBY_BUTTON);
        rubyTexturePool.pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE);
        rubyTexturePool.fence(ModBlocks.RUBY_FENCE);
        rubyTexturePool.fenceGate(ModBlocks.RUBY_FENCE_GATE);
        rubyTexturePool.wall(ModBlocks.RUBY_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.RUBY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_TRAPDOOR);

        registerCustomLamp(blockStateModelGenerator);
        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CauliflowerCropBlock.AGE, 0,1,2,3,4,5,6);
    }
    private void registerCustomLamp(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.RUBY_LAMP_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.RUBY_LAMP_BLOCK, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.RUBY_LAMP_BLOCK).coordinate(BlockStateModelGenerator.createBooleanModelMap(RubyLampBlock.CLICKED, identifier2, identifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.COAL_SIGMA, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAXEL, Models.GENERATED);
        //itemModelGenerator.register(ModItems.DATA_TABLET, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.RUBY_BOOTS));

        itemModelGenerator.register(ModItems.RUBY_HORSE_ARMOR, Models.GENERATED);


        itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);
    }
}
