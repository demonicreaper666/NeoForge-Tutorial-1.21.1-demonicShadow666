package dev.john.tutorial_mod.datagen;

import dev.john.tutorial_mod.TutorialMod;
import dev.john.tutorial_mod.item.ModItems;
import dev.john.tutorial_mod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider  extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BISMUTH.get())
                .add(ModItems.RAW_BISMUTH.get())

                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);
        //end of transformable_items


        tag(ItemTags.PICKAXES).add(ModItems.BISMUTH_PICKAXE.get());
        tag(ItemTags.AXES).add(ModItems.BISMUTH_AXE.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModItems.BISMUTH_SWORD.get()).add(ModItems.BISMUTH_AXE.get());
        tag(ItemTags.SHOVELS).add(ModItems.BISMUTH_SHOVEL.get());
        tag(ItemTags.SWORDS).add(ModItems.BISMUTH_SWORD.get());

        tag(ItemTags.SWORD_ENCHANTABLE).add(ModItems.BISMUTH_SWORD.get());

        tag(ItemTags.HOES).add(ModItems.BISMUTH_HOE.get());









    }
}
