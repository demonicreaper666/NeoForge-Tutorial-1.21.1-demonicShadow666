package dev.john.tutorial_mod.item;

import dev.john.tutorial_mod.TutorialMod;
import dev.john.tutorial_mod.item.custom.ChiselItem;
import dev.john.tutorial_mod.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(
            TutorialMod.MOD_ID
    );

    public static final DeferredItem<Item> BISMUTH = ITEMS.register(
      "bismuth", ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register(
      "raw_bismuth", ()-> new Item(new Item.Properties()));


    public static final DeferredItem<Item> CHISEL = ITEMS.register(
            "chisel", ()-> new ChiselItem(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> RADISH = ITEMS.register(
            "radish", ()-> new Item(new Item.Properties().food(ModFoodProperties.RADISH)));

    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register(
            "frostfire_ice", ()-> new FuelItem(new Item.Properties(), 800));

    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register(
            "starlight_ashes", ()-> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
