package dev.john.tutorial_mod.datagen;

import dev.john.tutorial_mod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.STARLIGHT_ASHES.getId(), new FurnaceFuel(1200), false)
                .add(ModItems.RADISH.getId(), new FurnaceFuel(600), false)
                .add(ModItems.FROSTFIRE_ICE.getId(), new FurnaceFuel(1200), false);
    }
}
