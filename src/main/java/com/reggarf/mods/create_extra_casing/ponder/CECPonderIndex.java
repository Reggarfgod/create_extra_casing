package com.reggarf.mods.create_extra_casing.ponder;

import com.reggarf.mods.create_extra_casing.CEC;
import com.reggarf.mods.create_extra_casing.registry.CECBlocks;
import com.simibubi.create.foundation.ponder.PonderRegistrationHelper;


public class CECPonderIndex {

    static final PonderRegistrationHelper HELPER = new PonderRegistrationHelper(CEC.MODID);

    public static void register() {
        HELPER.forComponents(CECBlocks.BLACK_CASING,
                        CECBlocks.RED_CASING,
                        CECBlocks.GRAY_CASING,
                        CECBlocks.BLUE_CASING,
                        CECBlocks.LIGHT_BLUE_CASING,
                        CECBlocks.LIGHT_GRAY_CASING,
                        CECBlocks.WHITE_CASING,
                        CECBlocks.GREEN_CASING,
                        CECBlocks.LIME_CASING,
                        CECBlocks.MAGENTA_CASING,
                        CECBlocks.PURPLE_CASING,
                        CECBlocks.PINK_CASING,
                        CECBlocks.BROWN_CASING,
                        CECBlocks.YELLOW_CASING,
                        CECBlocks.ORANGE_CASING,
                        CECBlocks.CYAN_CASING)
                .addStoryBoard("createextracasing", CECEncasingPonder::ExtraCasingShaftEncasing)
                .addStoryBoard("createextracogcasing", CECEncasingPonder::ExtraCasingCogEncasing);
    }
}
