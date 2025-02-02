package com.reggarf.mods.create_extra_casing;


import com.reggarf.mods.create_extra_casing.ponder.CECPonderIndex;
import com.reggarf.mods.create_extra_casing.ponder.CECPonderTags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings({"unused"})
public class CECClient {

    public static void onCtorClient(IEventBus eventBus, IEventBus forgeEventBus) {

        eventBus.addListener(CECClient::clientInit);
    }

    public static void clientInit(final FMLClientSetupEvent event) {
        CECPonderTags.register();
        CECPonderIndex.register();
    }
}
