package com.reggarf.mods.create_extra_casing;


import com.reggarf.mods.create_extra_casing.ponder.CECPonderPlugin;
import net.createmod.catnip.config.ui.BaseConfigScreen;
import net.createmod.ponder.foundation.PonderIndex;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings({"unused"})
public class CECClient {

    public static void onCtorClient(IEventBus eventBus, IEventBus forgeEventBus) {

        eventBus.addListener(CECClient::clientInit);

        ModContainer modContainer = ModList.get()
                .getModContainerById(CEC.MODID)
                .orElseThrow(() -> new IllegalStateException("What the..."));

        modContainer.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (mc, previousScreen) -> new BaseConfigScreen(previousScreen, CEC.MODID)));

    }

    public static void clientInit(final FMLClientSetupEvent event) {
//        CECPonderTags.register();
//        CECPonderIndex.register();
        PonderIndex.addPlugin(new CECPonderPlugin());



    }
}
