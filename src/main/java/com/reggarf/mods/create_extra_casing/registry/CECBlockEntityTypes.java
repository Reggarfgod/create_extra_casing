package com.reggarf.mods.create_extra_casing.registry;

import com.reggarf.mods.create_extra_casing.CEC;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.ShaftInstance;
import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogInstance;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;


public class CECBlockEntityTypes {
    private static final CreateRegistrate REGISTRATE = CEC.registrate();
    // - https://github.com/Creators-of-Create/Create/blob/mc1.18/dev/src/main/java/com/simibubi/create/AllTileEntities.java


    public static final BlockEntityEntry<KineticBlockEntity> ENCASED_SHAFT = REGISTRATE
            .blockEntity("rencased_shaft", KineticBlockEntity::new)
            .instance(() -> ShaftInstance::new, false)
            .validBlocks(CECBlocks.RED_ENCASED_SHAFT,
                         CECBlocks.WHITE_ENCASED_SHAFT,
                         CECBlocks.BLACK_ENCASED_SHAFT,
                         CECBlocks.GRAY_ENCASED_SHAFT,
                         CECBlocks.LIGHT_GRAY_ENCASED_SHAFT,
                    CECBlocks.BLUE_ENCASED_SHAFT,
                    CECBlocks.LIGHT_BLUE_ENCASED_SHAFT,
                    CECBlocks.GREEN_ENCASED_SHAFT,
                    CECBlocks.LIME_ENCASED_SHAFT,
                    CECBlocks.CYAN_ENCASED_SHAFT,
                    //CECBlocks.BROWN_ENCASED_SHAFT,
                    CECBlocks.ORANGE_ENCASED_SHAFT,
                    //CECBlocks.YELLOW_ENCASED_SHAFT,
                    CECBlocks.MAGENTA_ENCASED_SHAFT,
                    CECBlocks.PINK_ENCASED_SHAFT,
                    CECBlocks.PURPLE_ENCASED_SHAFT
                    )
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<SimpleKineticBlockEntity> ENCASED_COGWHEEL = REGISTRATE
            .blockEntity("encased_cogwheel", SimpleKineticBlockEntity::new)
            .instance(() -> EncasedCogInstance::small, false)
            .validBlocks(CECBlocks.RED_ENCASED_COGWHEEL,
                    CECBlocks.WHITE_ENCASED_COGWHEEL,
                    CECBlocks.BLACK_ENCASED_COGWHEEL,
                    CECBlocks.GRAY_ENCASED_COGWHEEL,
                    CECBlocks.LIGHT_GRAY_ENCASED_COGWHEEL,
                    CECBlocks.BLUE_ENCASED_COGWHEEL,
                    CECBlocks.LIGHT_BLUE_ENCASED_COGWHEEL,
                    CECBlocks.GREEN_ENCASED_COGWHEEL,
                    CECBlocks.LIME_ENCASED_COGWHEEL,
                    CECBlocks.CYAN_ENCASED_COGWHEEL,
                    CECBlocks.BROWN_ENCASED_COGWHEEL,
                    CECBlocks.ORANGE_ENCASED_COGWHEEL,
                    CECBlocks.YELLOW_ENCASED_COGWHEEL,
                    CECBlocks.MAGENTA_ENCASED_COGWHEEL,
                    CECBlocks.PINK_ENCASED_COGWHEEL,
                    CECBlocks.PURPLE_ENCASED_COGWHEEL)
            .renderer(() -> EncasedCogRenderer::small)
            .register();

    public static final BlockEntityEntry<SimpleKineticBlockEntity>ENCASED_LARGE_COGWHEEL = REGISTRATE
            .blockEntity("encased_large_cogwheel", SimpleKineticBlockEntity::new)
            .instance(() -> EncasedCogInstance::large, false)
            .validBlocks(CECBlocks.RED_ENCASED_LARGE_COGWHEEL,
                CECBlocks.WHITE_ENCASED_LARGE_COGWHEEL,
                CECBlocks.BLACK_ENCASED_LARGE_COGWHEEL,
                CECBlocks.GRAY_ENCASED_LARGE_COGWHEEL,
                CECBlocks.LIGHT_GRAY_ENCASED_LARGE_COGWHEEL,
                CECBlocks.BLUE_ENCASED_LARGE_COGWHEEL,
                CECBlocks.LIGHT_BLUE_ENCASED_LARGE_COGWHEEL,
                CECBlocks.GREEN_ENCASED_LARGE_COGWHEEL,
                CECBlocks.LIME_ENCASED_LARGE_COGWHEEL,
                CECBlocks.CYAN_ENCASED_LARGE_COGWHEEL,
                CECBlocks.BROWN_ENCASED_LARGE_COGWHEEL,
                CECBlocks.ORANGE_ENCASED_LARGE_COGWHEEL,
                CECBlocks.YELLOW_ENCASED_LARGE_COGWHEEL,
                CECBlocks.MAGENTA_ENCASED_LARGE_COGWHEEL,
                CECBlocks.PINK_ENCASED_LARGE_COGWHEEL,
                CECBlocks.PURPLE_ENCASED_LARGE_COGWHEEL)
            .renderer(() -> EncasedCogRenderer::large)
            .register();

    public static final BlockEntityEntry<FluidPipeBlockEntity> ENCASED_FLUID_PIPE = REGISTRATE
            .blockEntity("encased_fluid_pipe", FluidPipeBlockEntity::new)
            .validBlocks(CECBlocks.RED_ENCASED_FLUID_PIPE,
                    CECBlocks.WHITE_ENCASED_FLUID_PIPE,
                    CECBlocks.BLACK_ENCASED_FLUID_PIPE,
                    CECBlocks.GRAY_ENCASED_FLUID_PIPE,
                    CECBlocks.LIGHT_GRAY_ENCASED_FLUID_PIPE,
                    CECBlocks.BLUE_ENCASED_FLUID_PIPE,
                    CECBlocks.LIGHT_BLUE_ENCASED_FLUID_PIPE,
                    CECBlocks.GREEN_ENCASED_FLUID_PIPE,
                    CECBlocks.LIME_ENCASED_FLUID_PIPE,
                    CECBlocks.CYAN_ENCASED_FLUID_PIPE,
                    CECBlocks.BROWN_ENCASED_FLUID_PIPE,
                    CECBlocks.ORANGE_ENCASED_FLUID_PIPE,
                    CECBlocks.YELLOW_ENCASED_FLUID_PIPE,
                    CECBlocks.MAGENTA_ENCASED_FLUID_PIPE,
                    CECBlocks.PINK_ENCASED_FLUID_PIPE,
                    CECBlocks.PURPLE_ENCASED_FLUID_PIPE
            )
            .register();

    public static void register() {}
}
