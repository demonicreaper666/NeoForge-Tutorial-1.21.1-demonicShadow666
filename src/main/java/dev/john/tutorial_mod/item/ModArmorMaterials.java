package dev.john.tutorial_mod.item;

import dev.john.tutorial_mod.TutorialMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;



public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, TutorialMod.MOD_ID);

    public static final Holder<ArmorMaterial> BISMUTH =
            ARMOR_MATERIALS.register("bismuth",
                    ()-> new ArmorMaterial(
                            Util.make(new EnumMap<>(ArmorItem.Type.class), map ->{
                                map.put(ArmorItem.Type.BOOTS, 2);
                                map.put(ArmorItem.Type.BODY, 4);
                                map.put(ArmorItem.Type.LEGGINGS, 4);
                                map.put(ArmorItem.Type.CHESTPLATE, 6);
                                map.put(ArmorItem.Type.HELMET, 2);
                            }), 10, SoundEvents.ARMOR_EQUIP_GOLD, ()-> Ingredient.of(ModItems.BISMUTH.get()),
                            List.of(new ArmorMaterial.Layer(
                                    ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "bismuth"))),
                            0,0));

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}
