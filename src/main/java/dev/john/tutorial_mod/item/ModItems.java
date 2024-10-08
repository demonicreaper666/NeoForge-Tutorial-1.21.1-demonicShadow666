package dev.john.tutorial_mod.item;


import dev.john.tutorial_mod.block.ModBlocks;
import dev.john.tutorial_mod.item.custom.*;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;

import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.swing.*;

import java.util.List;

import static dev.john.tutorial_mod.TutorialMod.MOD_ID;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(
            MOD_ID
    );

    public static final DeferredItem<Item> BISMUTH = ITEMS.register(
      "bismuth", ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register(
      "raw_bismuth", ()-> new Item(new Item.Properties()));


    public static final DeferredItem<Item> CHISEL = ITEMS.register(
            "chisel", ()-> new ChiselItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> CHAINSAW = ITEMS.register(
            "chainsaw", ()-> new ChainsawItem(new Item.Properties().durability(32)));

    public static final DeferredItem<Item> RADISH = ITEMS.register(
            "radish", ()-> new Item(new Item.Properties().food(ModFoodProperties.RADISH)));

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register(
            "frostfire_ice", ()-> new FuelItem(new Item.Properties(), 800));

    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register(
            "starlight_ashes", ()-> new Item(new Item.Properties()));


    public static final DeferredItem<SwordItem> BISMUTH_SWORD = ITEMS.register("bismuth_sword",
            ()-> new ModEffectSwordItem(ModToolTeirs.BISMUTH, new Item.Properties().attributes(
                    SwordItem.createAttributes(ModToolTeirs.BISMUTH, 32, -2.5f)), MobEffects.LEVITATION));



    public static final DeferredItem<PickaxeItem> BISMUTH_PICKAXE = ITEMS.register("bismuth_pickaxe",
            ()-> new PickaxeItem(ModToolTeirs.BISMUTH, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTeirs.BISMUTH, 1.5f, -2.5f))));

    public static final DeferredItem<ShovelItem> BISMUTH_SHOVEL = ITEMS.register("bismuth_shovel",
            ()->new ShovelItem(ModToolTeirs.BISMUTH, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTeirs.BISMUTH, 1.5f,-3.1f))));

    public static final DeferredItem<AxeItem> BISMUTH_AXE = ITEMS.register("bismuth_axe",
            ()-> new AxeItem(ModToolTeirs.BISMUTH, new Item.Properties().attributes(
                    AxeItem.createAttributes(ModToolTeirs.BISMUTH, 8f, -2.5f))));

    public static final DeferredItem<HoeItem> BISMUTH_HOE = ITEMS.register("bismuth_hoe",
            ()-> new HoeItem(ModToolTeirs.BISMUTH, new Item.Properties().attributes(
                    HoeItem.createAttributes(ModToolTeirs.BISMUTH, 5, -2.4f))));

    public static final DeferredItem<Item> BISMUTH_PAXEL = ITEMS.register("bismuth_paxel",
            ()-> new PaxelItem(ModToolTeirs.BISMUTH,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTeirs.BISMUTH,10,-1f))));



    public static final DeferredItem<Item> BISMUTH_HAMMER = ITEMS.register("bismuth_hammer",
            ()-> new HammerItem(ModToolTeirs.BISMUTH,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTeirs.BISMUTH,20,-1f))));


    public static final DeferredItem<Item> BISMUTH_CHESTPLATE = ITEMS.register("bismuth_chestplate",
            ()-> new ModArmorItem(ModArmorMaterials.BISMUTH,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(16)).fireResistant()));


    public static final DeferredItem<Item> BISMUTH_HELMET = ITEMS.register("bismuth_helmet",
            ()->new ArmorItem(ModArmorMaterials.BISMUTH,
                    ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16))));



    public static final DeferredItem<Item> BISMUTH_LEGGINGS = ITEMS.register("bismuth_leggings",
            ()->new ArmorItem(ModArmorMaterials.BISMUTH,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(16))));



    public static final DeferredItem<Item> BISMUTH_BOOTS = ITEMS.register("bismuth_boots",
            ()->new ArmorItem(ModArmorMaterials.BISMUTH,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(16))));

    public  static final  DeferredItem<Item> DATA_TABLET = ITEMS.register("data_tablet",
            ()-> new DataTabletItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            ()-> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final DeferredItem<Item> DEMON_BOW = ITEMS.register("demon_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    public static final DeferredItem<Item> TOMATO =
            ITEMS.registerItem("tomato", properties -> new Item(properties){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.literal("Tomatoe ToolTip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }, new Item.Properties().food(ModFoodProperties.RADISH));





    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
    ()-> new ItemNameBlockItem(ModBlocks.TOMATO_CROP.get(), new Item.Properties()));







    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
