package dev.john.tutorial_mod.datagen;

import dev.john.tutorial_mod.block.ModBlocks;
import dev.john.tutorial_mod.block.custom.TomatoCropBlock;
import dev.john.tutorial_mod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Set;



public class ModBlockLootTableProvider extends BlockLootSubProvider {


    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        dropSelf(ModBlocks.BISMUTH_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());

        this.add(ModBlocks.BISMUTH_ORE.get(),
                block -> createOreDrop(ModBlocks.BISMUTH_ORE.get(), ModItems.RAW_BISMUTH.get()));




        dropSelf(ModBlocks.BISMUTH_STAIRS.get());
        this.add(ModBlocks.BISMUTH_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BISMUTH_SLAB.get()));

        dropSelf(ModBlocks.BISMUTH_WALL.get());
        dropSelf(ModBlocks.BISMUTH_FENCE.get());
        dropSelf(ModBlocks.BISMUTH_FENCE_GATE.get());
        dropSelf(ModBlocks.BISMUTH_LAMP.get());

        dropSelf(ModBlocks.BISMUTH_BUTTON.get());
        dropSelf(ModBlocks.BISMUTH_PRESSURE_PLATE.get());

        dropSelf(ModBlocks.BISMUTH_TRAPDOOR.get());
        dropSelf(ModBlocks.PEDESTAL.get());

        this.add(ModBlocks.BISMUTH_DOOR.get(),
                block -> createDoorTable(ModBlocks.BISMUTH_DOOR.get()));

        LootItemCondition.Builder lootItemConditionBuilder =
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 5));
        this.add(ModBlocks.TOMATO_CROP.get(), this.createCropDrops(ModBlocks.TOMATO_CROP.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.get(), lootItemConditionBuilder));



    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
            return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;

    }
}
