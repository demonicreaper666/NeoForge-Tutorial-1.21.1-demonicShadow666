package dev.john.tutorial_mod.item;

import dev.john.tutorial_mod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTeirs {
    public static final Tier BISMUTH = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
            1400,
            4f,
            3f,
            32,
            ()-> Ingredient.of(ModItems.BISMUTH)

    );}