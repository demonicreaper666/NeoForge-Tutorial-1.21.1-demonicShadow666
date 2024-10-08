package dev.john.tutorial_mod.datagen;

import dev.john.tutorial_mod.TutorialMod;
import dev.john.tutorial_mod.block.ModBlocks;
import dev.john.tutorial_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {


    public ModLangProvider(PackOutput output) {

        super(
                output,
                TutorialMod.MOD_ID,
                "en_us"
        );

    }

    @Override
    protected void addTranslations() {
        //base blocks
        add(ModBlocks.MAGIC_BLOCK.get(), "Magic Block");
        add(ModBlocks.BISMUTH_BLOCK.get(), "Block of Bismuth");
        add(ModBlocks.BISMUTH_ORE.get(), "Bismuth Ore");

        //fancy non block blocks
        add(ModBlocks.BISMUTH_BUTTON.get(), "Bismuth Button");
        add(ModBlocks.BISMUTH_DOOR.get(), "Bismuth Door");
        add(ModBlocks.BISMUTH_TRAPDOOR.get(), "Bismuth Trapdoor");
        add(ModBlocks.BISMUTH_WALL.get(), "Bismuth Wall");
        add(ModBlocks.BISMUTH_FENCE.get(), "Bismuth Fence");
        add(ModBlocks.BISMUTH_FENCE_GATE.get(), "Bismuth Fence Gate");
        add(ModBlocks.BISMUTH_PRESSURE_PLATE.get(), "Bismuth Pressure Plate");
        add(ModBlocks.BISMUTH_SLAB.get(), "Bismuth Slab");
        add(ModBlocks.BISMUTH_STAIRS.get(), "Bismuth Stairs");
        add(ModBlocks.BISMUTH_LAMP.get(), "Bismuth Lamp");
        add(ModBlocks.PEDESTAL.get(),"Pedestal");




        //base items
        add(ModItems.BISMUTH.get(), "Bismuth");
        add(ModItems.RAW_BISMUTH.get(), "Raw Bismuth");
        add(ModItems.STARLIGHT_ASHES.get(), "Starlight Ashes");
        add(ModItems.FROSTFIRE_ICE.get(), "FrostFire Ice");
        add(ModItems.CHISEL.get(), "Chisel");
        add(ModItems.RADISH.get(), "§dRadish§r");

        // tool items
        add(ModItems.BISMUTH_AXE.get(), "Bismuth Axe");
        add(ModItems.BISMUTH_PICKAXE.get(), "Bismuth Pickaxe");
        add(ModItems.BISMUTH_SWORD.get(), "Bismuth Sword");
        add(ModItems.BISMUTH_SHOVEL.get(), "Bismuth Shovel");
        add(ModItems.BISMUTH_HOE.get(), "Bismuth Hoe");
        add(ModItems.BISMUTH_PAXEL.get(),"Black Opal Paxel");
        add(ModItems.BISMUTH_HAMMER.get(), "Black Opal Hammer");
        add(ModItems.CHAINSAW.get(), "Chainsaw");

        //armour items
        add(ModItems.BISMUTH_HELMET.get(), "Bismuth Helmet");
        add(ModItems.BISMUTH_CHESTPLATE.get(), "Bismuth Chestplate");
        add(ModItems.BISMUTH_LEGGINGS.get(), "Bismuth Leggings");
        add(ModItems.BISMUTH_BOOTS.get(), "Bismuth Boots");

        add(ModItems.DATA_TABLET.get(), "Data Tablet");
        add(ModItems.METAL_DETECTOR.get(), "Metal Detector");
        add(ModItems.DEMON_BOW.get(), "Demon Bow");
        add(ModItems.TOMATO.get(), "Tomato");
        add("item.tutorial_mod.tomato_seeds", "Tomato Seeds");
        add("block.tutorial_mod.tomato_crop", "Tomato Crop");





        // other translations
        add("tooltip.tutorial_mod.magic_block.tooltip", "This block is §9MAGICAL§r");
        add("tooltip.tutorial_mod.chisel", "Hold §eSHIFT§r for more information");
        add("tooltip.tutorial_mod.chisel.shift_down", "Can turn some blocks into  their brick variants");
        add("item.tutorial_mod.metal_detector.no_valuables", "No Valuables For You");



        // item groups (Creative mode tabs)
        add("itemGroup.tutorial_mod.items", "Bismuth Items");
        add("be.tutorial_mod.pedestal", "Pedestal");


    }
}
