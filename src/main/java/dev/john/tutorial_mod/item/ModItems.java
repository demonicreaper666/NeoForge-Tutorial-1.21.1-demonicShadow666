package dev.john.tutorial_mod.item;

import dev.john.tutorial_mod.TutorialMod;
import dev.john.tutorial_mod.item.custom.ChiselItem;
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



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
