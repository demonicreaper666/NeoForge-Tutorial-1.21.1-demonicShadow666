package dev.john.tutorial_mod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties RADISH = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(2.25f)
            .fast().
            effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST,
                    400), 0.35f).build();

}
