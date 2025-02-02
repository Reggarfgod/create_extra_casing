package com.reggarf.mods.create_extra_casing;


import com.reggarf.mods.create_extra_casing.registry.CECBlockEntityTypes;
import com.reggarf.mods.create_extra_casing.registry.CECBlocks;
import com.reggarf.mods.create_extra_casing.registry.CECCreativeTab;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(CEC.MODID)
public class CEC {

    public static final String MODID = "create_extra_casing";
    private static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CEC.MODID);


    public CEC() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        MinecraftForge.EVENT_BUS.register(this);

        CEC.REGISTRATE.registerEventListeners(modEventBus);

        CECCreativeTab.register(modEventBus);
        CECBlocks.register();
        CECBlockEntityTypes.register();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> CECClient.onCtorClient(modEventBus, forgeEventBus));
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MODID, path);
    }

    public static CreateRegistrate registrate() {
        return REGISTRATE;
    }
}