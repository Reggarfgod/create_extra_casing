package com.reggarf.mods.create_extra_casing.registry;


import com.reggarf.mods.create_extra_casing.CEC;
import com.simibubi.create.AllCreativeModeTabs;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class CECCreativeTab {

    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER =
            net.neoforged.neoforge.registries.DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CEC.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = TAB_REGISTER.register("tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.create_extra_casing_tab"))
                    .withTabsBefore(AllCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .icon(CECBlocks.RGB_CASING::asStack)
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(CECBlocks.BLACK_CASING.get());
                        pOutput.accept(CECBlocks.BLUE_CASING.get());
                        pOutput.accept(CECBlocks.BROWN_CASING.get());
                        pOutput.accept(CECBlocks.CYAN_CASING.get());
                        pOutput.accept(CECBlocks.GRAY_CASING.get());
                        pOutput.accept(CECBlocks.GREEN_CASING.get());
                        pOutput.accept(CECBlocks.LIGHT_BLUE_CASING.get());
                        pOutput.accept(CECBlocks.LIGHT_GRAY_CASING.get());
                        pOutput.accept(CECBlocks.LIME_CASING.get());
                        pOutput.accept(CECBlocks.MAGENTA_CASING.get());
                        pOutput.accept(CECBlocks.ORANGE_CASING.get());
                        pOutput.accept(CECBlocks.PINK_CASING.get());
                        pOutput.accept(CECBlocks.PURPLE_CASING.get());
                        pOutput.accept(CECBlocks.RED_CASING.get());
                        pOutput.accept(CECBlocks.WHITE_CASING.get());
                        pOutput.accept(CECBlocks.YELLOW_CASING.get());
                        pOutput.accept(CECBlocks.RGB_CASING.get());

                    })
                    .build());


    public static void register(IEventBus modEventBus) {
        TAB_REGISTER.register(modEventBus);
    }
    public static CreativeModeTab getBaseTab() {
        return MAIN_TAB.get();
    }
}