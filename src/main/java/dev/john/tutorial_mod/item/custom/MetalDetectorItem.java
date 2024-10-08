package dev.john.tutorial_mod.item.custom;

import dev.john.tutorial_mod.component.FoundBlockData;
import dev.john.tutorial_mod.component.ModDataComponentsTypes;
import dev.john.tutorial_mod.item.ModItems;
import dev.john.tutorial_mod.util.InventoryUtil;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(!context.getLevel().isClientSide()) {
            BlockPos positionClicked = context.getClickedPos();
            Player player = context.getPlayer();
            boolean foundBlock = false;

            for(int i=0; i <= positionClicked.getY() + 64; i++){
                BlockState blockState = context.getLevel().getBlockState(positionClicked.below(i));

                if(isValuableBlock(blockState)){
                    outputVauableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                if(InventoryUtil.hasPlayerStackInInventory(player,ModItems.DATA_TABLET.get())) {
                    addDataToDataTablet(player, positionClicked.below(i), blockState.getBlock());
                }
                context.getLevel().playSeededSound(null, player.getX(), player.getY(),player.getZ(),
                        SoundEvents.ANVIL_STEP, SoundSource.BLOCKS, 1f,1f,0);

                    break;
                }
            }

            if(!foundBlock) {
                outputNoValuebleFound(player);
            }



        }
        return InteractionResult.SUCCESS;
    }

        private void addDataToDataTablet(Player player, BlockPos below, Block block){
            ItemStack dataTablet = player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET.get()));

            FoundBlockData data = new FoundBlockData(block.defaultBlockState(), below);
            dataTablet.set(ModDataComponentsTypes.FOUND_BLOCK.get(), data);

        }
        private void outputNoValuebleFound(Player player) {
            player.sendSystemMessage(Component.translatable("item.tutorial_mod.metal_detector.no_valuables"));
        }

        private void outputVauableCoordinates(BlockPos below, Player player, Block block){
            player.sendSystemMessage(Component.literal("Valuable Found: " + I18n.get(block.getDescriptionId())
                    + " at (" + below.getX() +","+ below.getY() +","+ below.getZ() +")"));
        }

        private boolean isValuableBlock(BlockState blockState) { return blockState.is(Blocks.IRON_ORE);}



















}
