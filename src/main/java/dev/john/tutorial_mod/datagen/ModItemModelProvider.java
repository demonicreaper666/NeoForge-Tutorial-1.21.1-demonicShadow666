package dev.john.tutorial_mod.datagen;

import dev.john.tutorial_mod.TutorialMod;
import dev.john.tutorial_mod.block.ModBlocks;
import dev.john.tutorial_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static dev.john.tutorial_mod.TutorialMod.MOD_ID;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BISMUTH.get());
        basicItem(ModItems.RAW_BISMUTH.get());

        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());
        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.CHAINSAW.get());



        buttonItem(ModBlocks.BISMUTH_BUTTON, ModBlocks.BISMUTH_BLOCK);
        fenceItem(ModBlocks.BISMUTH_FENCE, ModBlocks.BISMUTH_BLOCK);
        wallItem(ModBlocks.BISMUTH_WALL, ModBlocks.BISMUTH_BLOCK);


        basicItem(ModBlocks.BISMUTH_DOOR.asItem());

        //handheld
        handheldItem(ModItems.BISMUTH_SWORD);
        handheldItem(ModItems.BISMUTH_SHOVEL);
        handheldItem(ModItems.BISMUTH_AXE);
        handheldItem(ModItems.BISMUTH_PICKAXE);
        handheldItem(ModItems.BISMUTH_HOE);
        handheldItem(ModItems.BISMUTH_PAXEL);
        handheldItem(ModItems.BISMUTH_HAMMER);

        basicItem(ModItems.BISMUTH_HELMET.get());
        basicItem(ModItems.BISMUTH_CHESTPLATE.get());
        basicItem(ModItems.BISMUTH_LEGGINGS.get());
        basicItem(ModItems.BISMUTH_BOOTS.get());
        basicItem(ModItems.METAL_DETECTOR.get());
        basicItem(ModItems.TOMATO.get());
        basicItem(ModItems.TOMATO_SEEDS.get());






    }


    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }


    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return  withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/" + item.getId().getPath()));

    }










}
