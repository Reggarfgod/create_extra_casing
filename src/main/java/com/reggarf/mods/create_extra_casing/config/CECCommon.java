package com.reggarf.mods.create_extra_casing.config;

import net.createmod.catnip.config.ConfigBase;
import net.neoforged.neoforge.common.ModConfigSpec;

public class CECCommon extends ConfigBase {

    public final CECKinetics kinetics = nested(0, CECKinetics::new, Comments.kinetics);

    public ModConfigSpec.BooleanValue messageEnabled;

    @Override
    public void registerAll(ModConfigSpec.Builder builder) {
        builder.push("General");

        messageEnabled = builder
                .comment(Comments.messageEnabled)
                .define("messageEnabled", true);

        builder.pop();
    }

    @Override
    public String getName() {
        return "common";
    }

    private static class Comments {
        static String kinetics = "Modify CEC blocks";
        static String messageEnabled = "Enable or disable startup messages.";
    }
}
