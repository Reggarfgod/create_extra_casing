package com.reggarf.mods.create_extra_casing.config;


import net.createmod.catnip.config.ConfigBase;

public class CECCommon extends ConfigBase {

    public final CECKinetics kinetics = nested(0, CECKinetics::new,Comments.kinetics);


    @Override
    public String getName() {
        return "common";
    }

    private static class Comments {
        static String kinetics = "Modify Create Encased blocks comportements";

    }
}
