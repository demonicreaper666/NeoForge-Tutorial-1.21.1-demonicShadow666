package dev.john.tutorial_mod.gui;

import dev.john.tutorial_mod.TutorialMod;
import dev.john.tutorial_mod.block.ModBlocks;
import dev.john.tutorial_mod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


import java.util.function.Supplier;



public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    //Items
    //Blocks
    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("bismuth_items_tab",
                    CreativeModeTab.builder()
                            .icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                            .title(Component.translatable("itemGroup." + TutorialMod.MOD_ID + ".items"))
                            .displayItems((params,output) -> {
                                output.accept(ModBlocks.MAGIC_BLOCK);
                                output.accept(ModBlocks.BISMUTH_BLOCK);
                                output.accept(ModBlocks.BISMUTH_ORE);

                                output.accept(ModBlocks.BISMUTH_SLAB);
                                output.accept(ModBlocks.BISMUTH_STAIRS);

                                output.accept(ModBlocks.BISMUTH_FENCE);
                                output.accept(ModBlocks.BISMUTH_FENCE_GATE);
                                output.accept(ModBlocks.BISMUTH_WALL);

                                output.accept(ModBlocks.BISMUTH_DOOR);
                                output.accept(ModBlocks.BISMUTH_TRAPDOOR);

                                output.accept(ModBlocks.BISMUTH_BUTTON);
                                output.accept(ModBlocks.BISMUTH_PRESSURE_PLATE);
                                output.accept(ModBlocks.BISMUTH_LAMP);

                                output.accept(ModItems.BISMUTH);
                                output.accept(ModItems.RAW_BISMUTH);
                                output.accept(ModItems.FROSTFIRE_ICE);
                                output.accept(ModItems.STARLIGHT_ASHES);
                                output.accept(ModItems.RADISH);
                                output.accept(ModItems.CHISEL);
                                output.accept(ModItems.CHAINSAW);

                                output.accept(ModItems.DATA_TABLET);
                                output.accept(ModItems.METAL_DETECTOR);

                                output.accept(ModItems.BISMUTH_AXE);
                                output.accept(ModItems.BISMUTH_HOE);
                                output.accept(ModItems.BISMUTH_PICKAXE);
                                output.accept(ModItems.BISMUTH_SHOVEL);
                                output.accept(ModItems.BISMUTH_SWORD);
                                output.accept(ModItems.BISMUTH_PAXEL);
                                output.accept(ModItems.BISMUTH_HAMMER);


                                output.accept(ModItems.BISMUTH_HELMET);
                                output.accept(ModItems.BISMUTH_CHESTPLATE);
                                output.accept(ModItems.BISMUTH_LEGGINGS);
                                output.accept(ModItems.BISMUTH_BOOTS);

                                output.accept(ModItems.DEMON_BOW);
                                output.accept(ModItems.TOMATO);
                                output.accept(ModItems.TOMATO_SEEDS);

                                output.accept(ModBlocks.PEDESTAL);




                            })::build);








    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
