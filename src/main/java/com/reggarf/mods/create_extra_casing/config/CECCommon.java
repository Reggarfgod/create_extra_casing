package com.reggarf.mods.create_extra_casing.config;

import net.createmod.catnip.config.ConfigBase;
import net.minecraftforge.common.ForgeConfigSpec;

public class CECCommon extends ConfigBase {

    public final CECKinetics kinetics = new CECKinetics();
    public ForgeConfigSpec.BooleanValue messageEnabled;

    @Override
    public void registerAll(ForgeConfigSpec.Builder builder) {
        builder.push("General");

        messageEnabled = builder
                .comment("Enable or disable in-game messages")
                .define("messageEnabled", true);

        builder.pop();

        builder.comment(Comments.kinetics).push("Kinetics");
        kinetics.registerAll(builder);
        builder.pop();
    }

    @Override
    public String getName() {
        return "common";
    }

    private static class Comments {
        static String kinetics = "CEC blocks comportements";
    }
}
