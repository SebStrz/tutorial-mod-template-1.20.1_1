package net.sebastian.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sebastian.tutorialmod.block.ModBlocks;
import net.sebastian.tutorialmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.RUBY_ORE)
                .forceAddTag(BlockTags.GOLD_ORES)
                .forceAddTag(BlockTags.DIAMOND_ORES)
                .forceAddTag(BlockTags.IRON_ORES)
                .forceAddTag(BlockTags.LAPIS_ORES)
                .forceAddTag(BlockTags.EMERALD_ORES)
                .forceAddTag(BlockTags.REDSTONE_ORES)
                .forceAddTag(BlockTags.COPPER_ORES)
                .forceAddTag(BlockTags.COAL_ORES);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RUBY_ORE,
                        ModBlocks.RAW_RUBY_BLOCK,
                        ModBlocks.DEEPSLATE_RUBY_ORE,
                        ModBlocks.END_STONE_RUBY_ORE,
                        ModBlocks.RUBY_BLOCK,
                        ModBlocks.RAW_RUBY_BLOCK,
                        ModBlocks.NETHER_RUBY_ORE,
                        ModBlocks.RUBY_STAIRS,
                        ModBlocks.RUBY_SLAB,
                        ModBlocks.RUBY_PRESSURE_PLATE,
                        ModBlocks.RUBY_BUTTON,
                        ModBlocks.RUBY_FENCE,
                        ModBlocks.RUBY_FENCE_GATE,
                        ModBlocks.RUBY_WALL,
                        ModBlocks.RUBY_DOOR,
                        ModBlocks.RUBY_TRAPDOOR

                        );

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlocks.END_STONE_RUBY_ORE
                );
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.RAW_RUBY_BLOCK,
                        ModBlocks.RUBY_ORE,
                        ModBlocks.RUBY_BLOCK,
                        ModBlocks.RUBY_STAIRS,
                        ModBlocks.RUBY_SLAB,
                        ModBlocks.RUBY_FENCE,
                        ModBlocks.RUBY_FENCE_GATE,
                        ModBlocks.RUBY_WALL,
                        ModBlocks.RUBY_DOOR,
                        ModBlocks.RUBY_TRAPDOOR
                );
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.RUBY_WALL);
        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.RUBY_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.RUBY_FENCE_GATE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_4")))
                .add(ModBlocks.NETHER_RUBY_ORE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_5")))
                .add(ModBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.PAXEL_MINABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE);
    }
}
