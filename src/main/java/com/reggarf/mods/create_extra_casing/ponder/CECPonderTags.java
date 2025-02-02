package com.reggarf.mods.create_extra_casing.ponder;

import com.reggarf.mods.create_extra_casing.registry.CECBlocks;
import com.simibubi.create.foundation.ponder.PonderRegistry;


import static com.simibubi.create.infrastructure.ponder.AllPonderTags.DECORATION;

public class CECPonderTags {

    public static void register() {
        PonderRegistry.TAGS.forTag(DECORATION)
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
                .add(CECBlocks.CYAN_CASING);
    }
}
