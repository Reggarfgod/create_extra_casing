package com.reggarf.mods.create_extra_casing.registry;


import com.reggarf.mods.create_extra_casing.CEC;
import com.simibubi.create.AllPartialModels;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CECPartialModels {

    public static final List<PartialModel> ALL_ENCASED_MODELS = new ArrayList<>();
    public static final PartialModel

            COPPER_BELT_COVER_X = block("belt_cover/copper_belt_cover_x"), COPPER_BELT_COVER_Z = block("belt_cover/copper_belt_cover_z");


    public static PartialModel block(String path) {
        PartialModel model = PartialModel.of(CEC.asResource("block/" + path));
        if (ALL_ENCASED_MODELS != null) {
            ALL_ENCASED_MODELS.add(model);
        }
        return model;
    }

}
