package net.sebastian.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.sebastian.tutorialmod.block.ModBlocks;
import net.sebastian.tutorialmod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY)
                .pattern("SSS")
                .pattern("SKS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('K', ModItems.RUBY)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_RUBY)));
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RUBY, RecipeCategory.MISC, ModBlocks.RUBY_BLOCK);

        offerSmelting(exporter, List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE,
                ModBlocks.END_STONE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE), RecipeCategory.MISC,ModItems.RUBY,
                2f,100,"ruby");
        offerBlasting(exporter, List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE,
                        ModBlocks.END_STONE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE), RecipeCategory.MISC,ModItems.RUBY,
                2f,100,"ruby");
    }
}
