package dev.john.tutorial_mod.gui;

import dev.john.tutorial_mod.TutorialMod;
import dev.john.tutorial_mod.block.ModBlocks;
import dev.john.tutorial_mod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("bismuth_items_tab",
                    () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.BISMUTH.get()))
                            .title(Component.translatable("creativetab.tutorial_mod.bismuth_items"))
                            .displayItems((itemDisplayParameters, output) -> {

                                //Items
                                output.accept(ModItems.BISMUTH);
                                output.accept(ModItems.RAW_BISMUTH);
                                output.accept(ModItems.CHISEL);
                                output.accept(ModItems.RADISH);
                                output.accept(ModItems.STARLIGHT_ASHES);
                                output.accept(ModItems.FROSTFIRE_ICE);

                                //Blocks
                                output.accept(ModBlocks.BISMUTH_BLOCK);
                                output.accept(ModBlocks.BISMUTH_ORE);
                                output.accept(ModBlocks.MAGIC_BLOCK);



                            }).build());




    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
