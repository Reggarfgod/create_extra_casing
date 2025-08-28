package com.reggarf.mods.create_extra_casing.registry;


import com.reggarf.mods.create_extra_casing.CEC;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CECCreativeTab {
    public static final DeferredRegister<CreativeModeTab>  TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CEC.MODID);

    public static final RegistryObject<CreativeModeTab> CC_TAB = TABS.register("create_extra_casing_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CECBlocks.RGB_CASING.get()))
                    .title(Component.translatable("creativetab.create_extra_casing_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(CECBlocks.RGB_CASING.get());
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


                        //brass

                        pOutput.accept(CECBlocks.RGB_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.BLACK_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.BLUE_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.BROWN_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.CYAN_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.GRAY_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.GREEN_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.LIGHT_BLUE_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.LIGHT_GRAY_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.LIME_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.MAGENTA_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.ORANGE_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.PINK_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.PURPLE_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.RED_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.WHITE_BRASS_CASING.get());
                        pOutput.accept(CECBlocks.YELLOW_BRASS_CASING.get());

                        //copper

                        pOutput.accept(CECBlocks.RGB_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.BLACK_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.BLUE_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.BROWN_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.CYAN_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.GRAY_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.GREEN_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.LIGHT_BLUE_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.LIGHT_GRAY_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.LIME_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.MAGENTA_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.ORANGE_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.PINK_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.PURPLE_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.RED_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.WHITE_COPPER_CASING.get());
                        pOutput.accept(CECBlocks.YELLOW_COPPER_CASING.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}