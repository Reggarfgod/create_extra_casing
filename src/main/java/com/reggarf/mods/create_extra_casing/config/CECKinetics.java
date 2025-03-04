package com.reggarf.mods.create_extra_casing.config;


import net.createmod.catnip.config.ConfigBase;

public class CECKinetics extends ConfigBase {



    public final CECStress stressValues = nested(1, CECStress::new, Comments.stress);

    @Override
    public String getName() {
        return "kinetics";
    }

    private static class Comments {

        static String stress = "kinetic stats";

    }
}
