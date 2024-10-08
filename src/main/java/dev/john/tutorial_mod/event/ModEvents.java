package dev.john.tutorial_mod.event;

import dev.john.tutorial_mod.TutorialMod;
import dev.john.tutorial_mod.item.ModItems;
import dev.john.tutorial_mod.item.custom.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
    //Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    //Don't be a jerk License
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer){
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)){
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(2, initialBlockPos, serverPlayer)){
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem,event.getLevel().getBlockState(pos))){
                    continue;
                }
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);



            }

        }
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre dEvent){

        if(dEvent.getEntity() instanceof Sheep sheep) {
            if(dEvent.getSource().getDirectEntity() instanceof Player player){
                if(player.getMainHandItem().getItem() == ModItems.METAL_DETECTOR.get()){
                    player.sendSystemMessage(
                            Component.literal(
                                    "§dSheep§r Was Hit By" + player.getName().getString()
                                            + "Using" + player.getMainHandItem().getItem()
                            )
                    );
                    player.sendSystemMessage(Component.literal("Giving Player Blindness Poison Slowness for 30s"));
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 600,3, false ,false));
                    player.addEffect(new MobEffectInstance(MobEffects.POISON, 600,1, false ,false));
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600,10, false ,false));
                    player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200,2, false ,false));
                    player.sendSystemMessage(Component.literal("Maybe next time you will think twice about whacking a sheep with a metal detector"));

                }

                    if(player.getMainHandItem().getItem() == ModItems.RADISH.get()){
                        player.sendSystemMessage(Component.literal("Sheep Was Given Effect by being hit with a radish"));
                        sheep.addEffect(new MobEffectInstance(MobEffects.JUMP, 600, 50));
                        sheep.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1000, 20));
                        player.getMainHandItem().shrink(1);

                    }

                }
            }
        }

}




