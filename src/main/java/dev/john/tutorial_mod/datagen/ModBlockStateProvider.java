package dev.john.tutorial_mod.datagen;

import dev.john.tutorial_mod.TutorialMod;
import dev.john.tutorial_mod.block.ModBlocks;
import dev.john.tutorial_mod.block.custom.BismuthLampBlock;
import dev.john.tutorial_mod.block.custom.TomatoCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BISMUTH_BLOCK);
        blockWithItem(ModBlocks.BISMUTH_ORE);
        blockWithItem(ModBlocks.MAGIC_BLOCK);


        stairsBlock(ModBlocks.BISMUTH_STAIRS.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        slabBlock(ModBlocks.BISMUTH_SLAB.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));

        buttonBlock(ModBlocks.BISMUTH_BUTTON.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        pressurePlateBlock(ModBlocks.BISMUTH_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));

        fenceBlock(ModBlocks.BISMUTH_FENCE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        fenceGateBlock(ModBlocks.BISMUTH_FENCE_GATE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        wallBlock(ModBlocks.BISMUTH_WALL.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.BISMUTH_DOOR.get(), modLoc("block/bismuth_door_bottom"), modLoc("block/bismuth_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.BISMUTH_TRAPDOOR.get(), modLoc("block/bismuth_trapdoor"), true, "cutout");

        blockItem(ModBlocks.BISMUTH_STAIRS);
        blockItem(ModBlocks.BISMUTH_SLAB);
        blockItem(ModBlocks.BISMUTH_PRESSURE_PLATE);
        blockItem(ModBlocks.BISMUTH_FENCE_GATE);
        blockItem(ModBlocks.BISMUTH_TRAPDOOR, "_bottom");


        customLamp();

        makeCrop(((TomatoCropBlock) ModBlocks.TOMATO_CROP.get()),"tomato_crop_stage","tomato_crop_stage");

    }











    public void makeCrop(CropBlock block, String modelName, String textureName){
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName,textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(
                modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + textureName +
                        state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));


        return models;
    }






    private void customLamp() {
        getVariantBuilder(ModBlocks.BISMUTH_LAMP.get()).forAllStates(state -> {
            if (state.getValue(BismuthLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("bismuth_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "bismuth_lamp_on")))};
            }
            else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("bismuth_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "bismuth_lamp_off")))};

            }
        });
            simpleBlockItem(ModBlocks.BISMUTH_LAMP.get(), models().cubeAll("bismuth_lamp_on",
                    ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "block/" + "bismuth_lamp_on")));
    }














    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorial_mod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorial_mod:block/" + deferredBlock.getId().getPath() + appendix));
    }


}
