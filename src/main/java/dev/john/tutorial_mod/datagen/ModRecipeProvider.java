package dev.john.tutorial_mod.datagen;

import dev.john.tutorial_mod.TutorialMod;
import dev.john.tutorial_mod.block.ModBlocks;
import dev.john.tutorial_mod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> BISMUTH_SMELTABLES = List.of(
                ModItems.RAW_BISMUTH,
                ModBlocks.BISMUTH_ORE
        );



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BISMUTH.get())
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.BISMUTH.get(), 9)
                .requires(ModBlocks.BISMUTH_BLOCK)
                .unlockedBy("has_bismuth_block", has(ModBlocks.BISMUTH_BLOCK)).save(recipeOutput);

        oreSmelting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.5f, 200, "bismuth");
        oreBlasting(recipeOutput, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.5f, 100, "bismuth");


        stairBuilder(ModBlocks.BISMUTH_STAIRS.get(), Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);

        slab(recipeOutput, RecipeCategory.MISC, ModBlocks.BISMUTH_SLAB.get(), ModItems.BISMUTH.get());
        wall(recipeOutput, RecipeCategory.MISC, ModBlocks.BISMUTH_WALL.get(), ModItems.BISMUTH.get());
        pressurePlate(recipeOutput,ModBlocks.BISMUTH_PRESSURE_PLATE.get(), ModItems.BISMUTH.get());

        buttonBuilder(ModBlocks.BISMUTH_BUTTON, Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);
        fenceBuilder(ModBlocks.BISMUTH_FENCE, Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);
        fenceGateBuilder(ModBlocks.BISMUTH_FENCE_GATE, Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);




        doorBuilder(
                ModBlocks.BISMUTH_DOOR.get(),
                Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);
        trapdoorBuilder(
                ModBlocks.BISMUTH_TRAPDOOR.get(),
                Ingredient.of(ModItems.BISMUTH))
                .group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH))
                .save(recipeOutput);



















    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput,
                                                                       RecipeSerializer<T> pCookingSerializer,
                                                                       AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory,
                                                                       ItemLike pResult, float pExperience, int pCookingTime,
                                                                       String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(
                    Ingredient.of(itemlike),
                            pCategory,
                            pResult,
                            pExperience,
                            pCookingTime,
                            pCookingSerializer,
                            factory
                    )
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(
                            recipeOutput,
                            TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }


    }

}
