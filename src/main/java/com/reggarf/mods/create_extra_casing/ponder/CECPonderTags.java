package com.reggarf.mods.create_extra_casing.ponder;

import com.reggarf.mods.create_extra_casing.CEC;
import com.reggarf.mods.create_extra_casing.registry.CECBlocks;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.catnip.platform.CatnipServices;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;


import static com.simibubi.create.infrastructure.ponder.AllCreatePonderTags.DECORATION;


public class CECPonderTags {
    public static final ResourceLocation ENCASED_BLOCKS = loc("encased_blocks");
    public static final ResourceLocation DECORATION = loc("decoration");

    private static ResourceLocation loc(String id) {
        return CEC.asResource(id);
    }


    public static void register(PonderTagRegistrationHelper<ResourceLocation> helper) {
        PonderTagRegistrationHelper<RegistryEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);
        PonderTagRegistrationHelper<ItemLike> itemHelper = helper.withKeyFunction(
                CatnipServices.REGISTRIES::getKeyOrThrow);

        HELPER.addToTag(DECORATION)
                .add(CECBlocks.BLACK_CASING)
                .add(CECBlocks.RED_CASING)
                .add(CECBlocks.GRAY_CASING)
                .add(CECBlocks.BLUE_CASING)
                .add(CECBlocks.LIGHT_BLUE_CASING)
                .add(CECBlocks.LIGHT_GRAY_CASING)
                .add(CECBlocks.WHITE_CASING)
                .add(CECBlocks.GREEN_CASING)
                .add(CECBlocks.LIME_CASING)
                .add(CECBlocks.MAGENTA_CASING)
                .add(CECBlocks.PURPLE_CASING)
                .add(CECBlocks.PINK_CASING)
                .add(CECBlocks.BROWN_CASING)
                .add(CECBlocks.YELLOW_CASING)
                .add(CECBlocks.ORANGE_CASING)
                .add(CECBlocks.CYAN_CASING)
                .add(CECBlocks.RGB_CASING);
    }
}
