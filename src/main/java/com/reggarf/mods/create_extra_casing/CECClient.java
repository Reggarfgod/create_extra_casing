package com.reggarf.mods.create_extra_casing;


import com.reggarf.mods.create_extra_casing.ponder.CECPonderPlugin;
import net.createmod.ponder.foundation.PonderIndex;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

public class CECClient {


    public static void onCtorClient(IEventBus modEventBus) {
        IEventBus neoEventBus = NeoForge.EVENT_BUS;

        modEventBus.addListener(CECClient::clientInit);

    }

    public static void clientInit(final FMLClientSetupEvent event) {

        PonderIndex.addPlugin(new CECPonderPlugin());
    }
}