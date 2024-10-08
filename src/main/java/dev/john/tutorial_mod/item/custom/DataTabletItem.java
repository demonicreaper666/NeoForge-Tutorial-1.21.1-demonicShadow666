package dev.john.tutorial_mod.item.custom;

import dev.john.tutorial_mod.component.ModDataComponentsTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class DataTabletItem extends Item {
    public DataTabletItem(Properties properties) {  super(properties);}

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand){
        if(player.getItemInHand(usedHand).get(ModDataComponentsTypes.FOUND_BLOCK.get()) != null){
            player.getItemInHand(usedHand).set(ModDataComponentsTypes.FOUND_BLOCK.get(), null);
        }
        return InteractionResultHolder.success(player.getItemInHand(usedHand));
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return stack.get(ModDataComponentsTypes.FOUND_BLOCK.get()) != null;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (stack.get(ModDataComponentsTypes.FOUND_BLOCK.get()) != null ){
            tooltipComponents.add(Component.literal(stack.get(ModDataComponentsTypes.FOUND_BLOCK.get()).getOutputString()));
        }


        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
