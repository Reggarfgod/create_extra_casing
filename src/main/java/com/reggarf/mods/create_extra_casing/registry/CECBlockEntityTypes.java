package com.reggarf.mods.create_extra_casing.registry;

import com.reggarf.mods.create_extra_casing.CEC;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;

import com.simibubi.create.content.kinetics.base.ShaftRenderer;
import com.simibubi.create.content.kinetics.base.ShaftVisual;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;

import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogVisual;

import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.reggarf.mods.create_extra_casing.CEC.REGISTRATE;


public class CECBlockEntityTypes {



    public static final BlockEntityEntry<KineticBlockEntity> ENCASED_SHAFT = REGISTRATE
            .blockEntity("rencased_shaft", KineticBlockEntity::new)
            .visual(() -> ShaftVisual::new, false)
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
                    CECBlocks.BROWN_ENCASED_SHAFT,
                    CECBlocks.ORANGE_ENCASED_SHAFT,
                    CECBlocks.YELLOW_ENCASED_SHAFT,
                    CECBlocks.MAGENTA_ENCASED_SHAFT,
                    CECBlocks.PINK_ENCASED_SHAFT,
                    CECBlocks.PURPLE_ENCASED_SHAFT,
                    CECBlocks.RGB_ENCASED_SHAFT,
                    //BRASS
                    CECBlocks.RED_BRASS_ENCASED_SHAFT,
                    CECBlocks.WHITE_BRASS_ENCASED_SHAFT,
                    CECBlocks.BLACK_BRASS_ENCASED_SHAFT,
                    CECBlocks.GRAY_BRASS_ENCASED_SHAFT,
                    CECBlocks.LIGHT_GRAY_BRASS_ENCASED_SHAFT,
                    CECBlocks.BLUE_BRASS_ENCASED_SHAFT,
                    CECBlocks.LIGHT_BLUE_BRASS_ENCASED_SHAFT,
                    CECBlocks.GREEN_BRASS_ENCASED_SHAFT,
                    CECBlocks.LIME_BRASS_ENCASED_SHAFT,
                    CECBlocks.CYAN_BRASS_ENCASED_SHAFT,
                    CECBlocks.BROWN_BRASS_ENCASED_SHAFT,
                    CECBlocks.ORANGE_BRASS_ENCASED_SHAFT,
                    CECBlocks.YELLOW_BRASS_ENCASED_SHAFT,
                    CECBlocks.MAGENTA_BRASS_ENCASED_SHAFT,
                    CECBlocks.PINK_BRASS_ENCASED_SHAFT,
                    CECBlocks.PURPLE_BRASS_ENCASED_SHAFT,
                    CECBlocks.RGB_BRASS_ENCASED_SHAFT,

                    /// /////////////////////////
                    CECBlocks.RED_COPPER_ENCASED_SHAFT,
                    CECBlocks.WHITE_COPPER_ENCASED_SHAFT,
                    CECBlocks.BLACK_COPPER_ENCASED_SHAFT,
                    CECBlocks.GRAY_COPPER_ENCASED_SHAFT,
                    CECBlocks.LIGHT_GRAY_COPPER_ENCASED_SHAFT,
                    CECBlocks.BLUE_COPPER_ENCASED_SHAFT,
                    CECBlocks.LIGHT_BLUE_COPPER_ENCASED_SHAFT,
                    CECBlocks.GREEN_COPPER_ENCASED_SHAFT,
                    CECBlocks.LIME_COPPER_ENCASED_SHAFT,
                    CECBlocks.CYAN_COPPER_ENCASED_SHAFT,
                    CECBlocks.BROWN_COPPER_ENCASED_SHAFT,
                    CECBlocks.ORANGE_COPPER_ENCASED_SHAFT,
                    CECBlocks.YELLOW_COPPER_ENCASED_SHAFT,
                    CECBlocks.MAGENTA_COPPER_ENCASED_SHAFT,
                    CECBlocks.PINK_COPPER_ENCASED_SHAFT,
                    CECBlocks.PURPLE_COPPER_ENCASED_SHAFT,
                    CECBlocks.RGB_COPPER_ENCASED_SHAFT
                    )
            .renderer(() -> ShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<SimpleKineticBlockEntity> ENCASED_COGWHEEL = REGISTRATE
            .blockEntity("encased_cogwheel", SimpleKineticBlockEntity::new)
            .visual(() -> EncasedCogVisual::small, false)
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
                    CECBlocks.PURPLE_ENCASED_COGWHEEL,
                    CECBlocks.RGB_ENCASED_COGWHEEL,
                    //BRASS
                    CECBlocks.RED_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.WHITE_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.BLACK_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.GRAY_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.LIGHT_GRAY_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.BLUE_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.LIGHT_BLUE_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.GREEN_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.LIME_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.CYAN_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.BROWN_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.ORANGE_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.YELLOW_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.MAGENTA_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.PINK_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.PURPLE_BRASS_ENCASED_COGWHEEL,
                    CECBlocks.RGB_BRASS_ENCASED_COGWHEEL,
                    /// ////////
                    CECBlocks.RED_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.WHITE_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.BLACK_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.GRAY_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.LIGHT_GRAY_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.BLUE_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.LIGHT_BLUE_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.GREEN_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.LIME_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.CYAN_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.BROWN_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.ORANGE_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.YELLOW_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.MAGENTA_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.PINK_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.PURPLE_COPPER_ENCASED_COGWHEEL,
                    CECBlocks.RGB_COPPER_ENCASED_COGWHEEL
            )


            .renderer(() -> EncasedCogRenderer::small)
            .register();

    public static final BlockEntityEntry<SimpleKineticBlockEntity>ENCASED_LARGE_COGWHEEL = REGISTRATE
            .blockEntity("encased_large_cogwheel", SimpleKineticBlockEntity::new)
            .visual(() -> EncasedCogVisual::large, false)
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
                CECBlocks.PURPLE_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.RGB_ENCASED_LARGE_COGWHEEL,

                    //BRASS
                    CECBlocks.RED_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.WHITE_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.BLACK_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.GRAY_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.LIGHT_GRAY_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.BLUE_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.LIGHT_BLUE_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.GREEN_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.LIME_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.CYAN_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.BROWN_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.ORANGE_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.YELLOW_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.MAGENTA_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.PINK_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.PURPLE_BRASS_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.RGB_BRASS_ENCASED_LARGE_COGWHEEL,
                    //COPPER
                    CECBlocks.RED_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.WHITE_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.BLACK_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.GRAY_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.LIGHT_GRAY_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.BLUE_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.LIGHT_BLUE_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.GREEN_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.LIME_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.CYAN_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.BROWN_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.ORANGE_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.YELLOW_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.MAGENTA_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.PINK_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.PURPLE_COPPER_ENCASED_LARGE_COGWHEEL,
                    CECBlocks.RGB_COPPER_ENCASED_LARGE_COGWHEEL
            )

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
                    CECBlocks.PURPLE_ENCASED_FLUID_PIPE,
                    CECBlocks.RGB_ENCASED_FLUID_PIPE,

                    //brass
                    CECBlocks.RED_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.WHITE_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.BLACK_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.GRAY_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.LIGHT_GRAY_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.BLUE_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.LIGHT_BLUE_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.GREEN_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.LIME_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.CYAN_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.BROWN_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.ORANGE_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.YELLOW_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.MAGENTA_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.PINK_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.PURPLE_BRASS_ENCASED_FLUID_PIPE,
                    CECBlocks.RGB_BRASS_ENCASED_FLUID_PIPE,
                    // COPPER
                    CECBlocks.RED_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.WHITE_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.BLACK_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.GRAY_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.LIGHT_GRAY_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.BLUE_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.LIGHT_BLUE_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.GREEN_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.LIME_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.CYAN_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.BROWN_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.ORANGE_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.YELLOW_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.MAGENTA_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.PINK_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.PURPLE_COPPER_ENCASED_FLUID_PIPE,
                    CECBlocks.RGB_COPPER_ENCASED_FLUID_PIPE
            )
            .register();

    public static void register() {}
}
