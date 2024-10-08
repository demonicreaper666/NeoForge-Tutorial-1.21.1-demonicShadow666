package dev.john.tutorial_mod;


import com.mojang.logging.LogUtils;
import dev.john.tutorial_mod.block.ModBlocks;
import dev.john.tutorial_mod.block.entity.ModBlockEntities;
import dev.john.tutorial_mod.block.entity.render.PedestalBlockEntityRenderer;
import dev.john.tutorial_mod.component.ModDataComponentsTypes;
import dev.john.tutorial_mod.gui.ModCreativeModeTabs;
import dev.john.tutorial_mod.gui.screen.ModMenuTypes;
import dev.john.tutorial_mod.gui.screen.custom.PedestalScreen;
import dev.john.tutorial_mod.item.ModArmorMaterials;
import dev.john.tutorial_mod.item.ModItems;
import dev.john.tutorial_mod.util.ModItemProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;

import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;


@Mod(TutorialMod.MOD_ID)
public class TutorialMod
{

    public static final String MOD_ID = "tutorial_mod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TutorialMod(IEventBus modEventBus, ModContainer modContainer)
    {
        LOGGER.info("Mod Started Loading");
        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModArmorMaterials.register(modEventBus);
        ModDataComponentsTypes.register(modEventBus);
        ModMenuTypes.register(modEventBus);




       NeoForge.EVENT_BUS.register(this);

       modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info("{}{}", Config.magicNumberIntroduction, Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));

    }




    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Hello From Server Starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("IM CLIENT AND WORKING");
           ModItemProperties.addCustomItemProperties();
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event){
            event.register(ModMenuTypes.PEDESTAL_MENU.get(), PedestalScreen::new);
        }

    }
}

