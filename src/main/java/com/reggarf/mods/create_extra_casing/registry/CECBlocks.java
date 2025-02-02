package com.reggarf.mods.create_extra_casing.registry;

import com.reggarf.mods.create_extra_casing.CEC;
import com.reggarf.mods.create_extra_casing.custom_casing.CECEncasedCogwheelBlock;
import com.reggarf.mods.create_extra_casing.custom_casing.CECEncasedPipeBlock;
import com.reggarf.mods.create_extra_casing.custom_casing.CECEncasedShaftBlock;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.fluids.PipeAttachmentModel;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.utility.Couple;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class CECBlocks {
    private static final CreateRegistrate REGISTRATE = CEC.registrate();

    // - https://github.com/Creators-of-Create/Create/blob/mc1.20.1/dev/src/main/java/com/simibubi/create/AllBlocks.java

    static {
        REGISTRATE.setCreativeTab(CECCreativeTab.CC_TAB);
    }

    //   Red Casing
    public static final BlockEntry<CasingBlock> RED_CASING = REGISTRATE
            .block("red_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_RED))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.RED_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> RED_ENCASED_SHAFT = REGISTRATE
            .block("red_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.RED_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_RED))
            .transform(BuilderTransformers.encasedShaft("red", () -> CECSpriteShifts.RED_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> RED_ENCASED_COGWHEEL = REGISTRATE
            .block("red_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.RED_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_RED))
            .transform(BuilderTransformers.encasedCogwheel("red", () -> CECSpriteShifts.RED_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.RED_CASING,
                    Couple.create(CECSpriteShifts.RED_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.RED_ENCASED_COGWHEEL_OTHERSIDE))))
            .item()
            .transform(customItemModel())
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> RED_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("red_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.RED_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_RED))
            .transform(BuilderTransformers.encasedLargeCogwheel("red", () -> CECSpriteShifts.RED_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .item()
            .transform(customItemModel())
            .register();


    public static final BlockEntry<CECEncasedPipeBlock> RED_ENCASED_FLUID_PIPE = REGISTRATE
            .block("red_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.RED_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_RED))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.RED_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.RED_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();



    //   White Casing
    public static final BlockEntry<CasingBlock> WHITE_CASING = REGISTRATE
            .block("white_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.SNOW))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.WHITE_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> WHITE_ENCASED_SHAFT = REGISTRATE
            .block("white_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.WHITE_CASING::get))
            .properties(p -> p.mapColor(MapColor.SNOW))
            .transform(BuilderTransformers.encasedShaft("white", () -> CECSpriteShifts.WHITE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> WHITE_ENCASED_COGWHEEL = REGISTRATE
            .block("white_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.WHITE_CASING::get))
            .properties(p -> p.mapColor(MapColor.SNOW))
            .transform(BuilderTransformers.encasedCogwheel("white", () -> CECSpriteShifts.WHITE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.WHITE_CASING,
                    Couple.create(CECSpriteShifts.WHITE_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.WHITE_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> WHITE_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("white_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.WHITE_CASING::get))
            .properties(p -> p.mapColor(MapColor.SNOW))
            .transform(BuilderTransformers.encasedLargeCogwheel("white", () -> CECSpriteShifts.WHITE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> WHITE_ENCASED_FLUID_PIPE = REGISTRATE
            .block("white_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.WHITE_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.SNOW))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.WHITE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.WHITE_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Black Casing
    public static final BlockEntry<CasingBlock> BLACK_CASING = REGISTRATE
            .block("black_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.BLACK_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> BLACK_ENCASED_SHAFT = REGISTRATE
            .block("black_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.BLACK_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
            .transform(BuilderTransformers.encasedShaft("black", () -> CECSpriteShifts.BLACK_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> BLACK_ENCASED_COGWHEEL = REGISTRATE
            .block("black_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.BLACK_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
            .transform(BuilderTransformers.encasedCogwheel("black", () -> CECSpriteShifts.BLACK_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.BLACK_CASING,
                    Couple.create(CECSpriteShifts.BLACK_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.BLACK_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> BLACK_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("black_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.BLACK_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
            .transform(BuilderTransformers.encasedLargeCogwheel("black", () -> CECSpriteShifts.BLACK_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> BLACK_ENCASED_FLUID_PIPE = REGISTRATE
            .block("black_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.BLACK_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.BLACK_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.BLACK_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Gray Casing
    public static final BlockEntry<CasingBlock> GRAY_CASING = REGISTRATE
            .block("gray_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.GRAY_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> GRAY_ENCASED_SHAFT = REGISTRATE
            .block("gray_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.GRAY_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
            .transform(BuilderTransformers.encasedShaft("gray", () -> CECSpriteShifts.GRAY_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> GRAY_ENCASED_COGWHEEL = REGISTRATE
            .block("gray_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.GRAY_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
            .transform(BuilderTransformers.encasedCogwheel("gray", () -> CECSpriteShifts.GRAY_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.GRAY_CASING,
                    Couple.create(CECSpriteShifts.GRAY_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.GRAY_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> GRAY_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("gray_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.GRAY_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
            .transform(BuilderTransformers.encasedLargeCogwheel("gray", () -> CECSpriteShifts.GRAY_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> GRAY_ENCASED_FLUID_PIPE = REGISTRATE
            .block("gray_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.GRAY_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.GRAY_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.GRAY_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();


    //   LightGray Casing
    public static final BlockEntry<CasingBlock> LIGHT_GRAY_CASING = REGISTRATE
            .block("light_gray_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GRAY))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.LIGHT_GRAY_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> LIGHT_GRAY_ENCASED_SHAFT = REGISTRATE
            .block("light_gray_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.LIGHT_GRAY_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GRAY))
            .transform(BuilderTransformers.encasedShaft("light_gray", () -> CECSpriteShifts.LIGHT_GRAY_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> LIGHT_GRAY_ENCASED_COGWHEEL = REGISTRATE
            .block("light_gray_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.LIGHT_GRAY_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GRAY))
            .transform(BuilderTransformers.encasedCogwheel("light_gray", () -> CECSpriteShifts.LIGHT_GRAY_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.LIGHT_GRAY_CASING,
                    Couple.create(CECSpriteShifts.LIGHT_GRAY_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.LIGHT_GRAY_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> LIGHT_GRAY_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("light_gray_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.LIGHT_GRAY_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GRAY))
            .transform(BuilderTransformers.encasedLargeCogwheel("light_gray", () -> CECSpriteShifts.LIGHT_GRAY_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> LIGHT_GRAY_ENCASED_FLUID_PIPE = REGISTRATE
            .block("light_gray_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.LIGHT_GRAY_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GRAY))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.LIGHT_GRAY_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.LIGHT_GRAY_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   LightBlue Casing
    public static final BlockEntry<CasingBlock> LIGHT_BLUE_CASING = REGISTRATE
            .block("light_blue_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_BLUE))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.LIGHT_BLUE_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> LIGHT_BLUE_ENCASED_SHAFT = REGISTRATE
            .block("light_blue_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.LIGHT_BLUE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_BLUE))
            .transform(BuilderTransformers.encasedShaft("light_blue", () -> CECSpriteShifts.LIGHT_BLUE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> LIGHT_BLUE_ENCASED_COGWHEEL = REGISTRATE
            .block("light_blue_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.LIGHT_BLUE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_BLUE))
            .transform(BuilderTransformers.encasedCogwheel("light_blue", () -> CECSpriteShifts.LIGHT_BLUE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.LIGHT_BLUE_CASING,
                    Couple.create(CECSpriteShifts.LIGHT_BLUE_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.LIGHT_BLUE_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> LIGHT_BLUE_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("light_blue_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.LIGHT_BLUE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_BLUE))
            .transform(BuilderTransformers.encasedLargeCogwheel("light_blue", () -> CECSpriteShifts.LIGHT_BLUE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> LIGHT_BLUE_ENCASED_FLUID_PIPE = REGISTRATE
            .block("light_blue_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.LIGHT_BLUE_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_BLUE))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.LIGHT_BLUE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.LIGHT_BLUE_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();
    
    //   Blue Casing
    public static final BlockEntry<CasingBlock> BLUE_CASING = REGISTRATE
            .block("blue_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_BLUE))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.BLUE_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> BLUE_ENCASED_SHAFT = REGISTRATE
            .block("blue_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.BLUE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_BLUE))
            .transform(BuilderTransformers.encasedShaft("blue", () -> CECSpriteShifts.BLUE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> BLUE_ENCASED_COGWHEEL = REGISTRATE
            .block("blue_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.BLUE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_BLUE))
            .transform(BuilderTransformers.encasedCogwheel("blue", () -> CECSpriteShifts.BLUE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.BLUE_CASING,
                    Couple.create(CECSpriteShifts.BLUE_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.BLUE_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> BLUE_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("blue_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.BLUE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_BLUE))
            .transform(BuilderTransformers.encasedLargeCogwheel("blue", () -> CECSpriteShifts.BLUE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> BLUE_ENCASED_FLUID_PIPE = REGISTRATE
            .block("blue_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.BLUE_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_BLUE))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.BLUE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.ORANGE_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Brown Casing
    public static final BlockEntry<CasingBlock> BROWN_CASING = REGISTRATE
            .block("brown_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_BROWN))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.BROWN_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> BROWN_ENCASED_SHAFT = REGISTRATE
            .block("brown_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.BROWN_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_BROWN))
            .transform(BuilderTransformers.encasedShaft("brown", () -> CECSpriteShifts.BROWN_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> BROWN_ENCASED_COGWHEEL = REGISTRATE
            .block("brown_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.BROWN_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_BROWN))
            .transform(BuilderTransformers.encasedCogwheel("brown", () -> CECSpriteShifts.BROWN_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.BROWN_CASING,
                    Couple.create(CECSpriteShifts.BROWN_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.BROWN_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> BROWN_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("brown_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.BROWN_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_BROWN))
            .transform(BuilderTransformers.encasedLargeCogwheel("brown", () -> CECSpriteShifts.BROWN_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> BROWN_ENCASED_FLUID_PIPE = REGISTRATE
            .block("brown_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.BROWN_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_BROWN))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.BROWN_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.BROWN_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Orange Casing
    public static final BlockEntry<CasingBlock> ORANGE_CASING = REGISTRATE
            .block("orange_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.ORANGE_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> ORANGE_ENCASED_SHAFT = REGISTRATE
            .block("orange_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.ORANGE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .transform(BuilderTransformers.encasedShaft("orange", () -> CECSpriteShifts.ORANGE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> ORANGE_ENCASED_COGWHEEL = REGISTRATE
            .block("orange_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.ORANGE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .transform(BuilderTransformers.encasedCogwheel("orange", () -> CECSpriteShifts.ORANGE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.ORANGE_CASING,
                    Couple.create(CECSpriteShifts.ORANGE_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.ORANGE_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> ORANGE_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("orange_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.ORANGE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .transform(BuilderTransformers.encasedLargeCogwheel("orange", () -> CECSpriteShifts.ORANGE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();



    public static final BlockEntry<CECEncasedPipeBlock> ORANGE_ENCASED_FLUID_PIPE = REGISTRATE
            .block("orange_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.ORANGE_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.ORANGE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.ORANGE_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();


    //   Yellow Casing
    public static final BlockEntry<CasingBlock> YELLOW_CASING = REGISTRATE
            .block("yellow_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_YELLOW))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.YELLOW_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> YELLOW_ENCASED_SHAFT = REGISTRATE
            .block("yellow_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.YELLOW_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_YELLOW))
            .transform(BuilderTransformers.encasedShaft("yellow", () -> CECSpriteShifts.YELLOW_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> YELLOW_ENCASED_COGWHEEL = REGISTRATE
            .block("yellow_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.YELLOW_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_YELLOW))
            .transform(BuilderTransformers.encasedCogwheel("yellow", () -> CECSpriteShifts.YELLOW_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.YELLOW_CASING,
                    Couple.create(CECSpriteShifts.YELLOW_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.YELLOW_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> YELLOW_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("yellow_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.YELLOW_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_YELLOW))
            .transform(BuilderTransformers.encasedLargeCogwheel("yellow", () -> CECSpriteShifts.YELLOW_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> YELLOW_ENCASED_FLUID_PIPE = REGISTRATE
            .block("yellow_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.YELLOW_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_YELLOW))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.YELLOW_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.YELLOW_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Pink Casing
    public static final BlockEntry<CasingBlock> PINK_CASING = REGISTRATE
            .block("pink_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_PINK))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.PINK_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> PINK_ENCASED_SHAFT = REGISTRATE
            .block("pink_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.PINK_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_PINK))
            .transform(BuilderTransformers.encasedShaft("pink", () -> CECSpriteShifts.PINK_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> PINK_ENCASED_COGWHEEL = REGISTRATE
            .block("pink_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.PINK_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_PINK))
            .transform(BuilderTransformers.encasedCogwheel("pink", () -> CECSpriteShifts.PINK_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.PINK_CASING,
                    Couple.create(CECSpriteShifts.PINK_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.PINK_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> PINK_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("pink_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.PINK_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_PINK))
            .transform(BuilderTransformers.encasedLargeCogwheel("pink", () -> CECSpriteShifts.PINK_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> PINK_ENCASED_FLUID_PIPE = REGISTRATE
            .block("pink_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.PINK_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_PINK))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.PINK_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.PINK_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Green Casing
    public static final BlockEntry<CasingBlock> GREEN_CASING = REGISTRATE
            .block("green_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_GREEN))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.GREEN_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> GREEN_ENCASED_SHAFT = REGISTRATE
            .block("green_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.GREEN_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_GREEN))
            .transform(BuilderTransformers.encasedShaft("green", () -> CECSpriteShifts.GREEN_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> GREEN_ENCASED_COGWHEEL = REGISTRATE
            .block("green_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.GREEN_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_GREEN))
            .transform(BuilderTransformers.encasedCogwheel("green", () -> CECSpriteShifts.GREEN_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.GREEN_CASING,
                    Couple.create(CECSpriteShifts.GREEN_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.GREEN_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> GREEN_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("green_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.GREEN_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_GREEN))
            .transform(BuilderTransformers.encasedLargeCogwheel("green", () -> CECSpriteShifts.GREEN_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> GREEN_ENCASED_FLUID_PIPE = REGISTRATE
            .block("green_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.GREEN_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_GREEN))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.GREEN_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.GREEN_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Lime Casing
    public static final BlockEntry<CasingBlock> LIME_CASING = REGISTRATE
            .block("lime_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.LIME_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> LIME_ENCASED_SHAFT = REGISTRATE
            .block("lime_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.LIME_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN))
            .transform(BuilderTransformers.encasedShaft("lime", () -> CECSpriteShifts.LIME_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> LIME_ENCASED_COGWHEEL = REGISTRATE
            .block("lime_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.LIME_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN))
            .transform(BuilderTransformers.encasedCogwheel("lime", () -> CECSpriteShifts.LIME_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.LIME_CASING,
                    Couple.create(CECSpriteShifts.LIME_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.LIME_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> LIME_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("lime_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.LIME_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN))
            .transform(BuilderTransformers.encasedLargeCogwheel("lime", () -> CECSpriteShifts.LIME_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> LIME_ENCASED_FLUID_PIPE = REGISTRATE
            .block("lime_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.LIME_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.LIME_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.LIME_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Cyan Casing
    public static final BlockEntry<CasingBlock> CYAN_CASING = REGISTRATE
            .block("cyan_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_CYAN))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.CYAN_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> CYAN_ENCASED_SHAFT = REGISTRATE
            .block("cyan_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.CYAN_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_CYAN))
            .transform(BuilderTransformers.encasedShaft("cyan", () -> CECSpriteShifts.CYAN_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> CYAN_ENCASED_COGWHEEL = REGISTRATE
            .block("cyan_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.CYAN_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_CYAN))
            .transform(BuilderTransformers.encasedCogwheel("cyan", () -> CECSpriteShifts.CYAN_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.CYAN_CASING,
                    Couple.create(CECSpriteShifts.CYAN_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.CYAN_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> CYAN_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("cyan_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.CYAN_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_CYAN))
            .transform(BuilderTransformers.encasedLargeCogwheel("cyan", () -> CECSpriteShifts.CYAN_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> CYAN_ENCASED_FLUID_PIPE = REGISTRATE
            .block("cyan_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.CYAN_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_CYAN))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.CYAN_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.CYAN_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //    Magenta Casing
    public static final BlockEntry<CasingBlock> MAGENTA_CASING = REGISTRATE
            .block("magenta_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_MAGENTA))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.MAGENTA_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> MAGENTA_ENCASED_SHAFT = REGISTRATE
            .block("magenta_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.MAGENTA_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_MAGENTA))
            .transform(BuilderTransformers.encasedShaft("magenta", () -> CECSpriteShifts.MAGENTA_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> MAGENTA_ENCASED_COGWHEEL = REGISTRATE
            .block("magenta_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.MAGENTA_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_MAGENTA))
            .transform(BuilderTransformers.encasedCogwheel("magenta", () -> CECSpriteShifts.MAGENTA_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.MAGENTA_CASING,
                    Couple.create(CECSpriteShifts.MAGENTA_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.MAGENTA_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> MAGENTA_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("magenta_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.MAGENTA_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_MAGENTA))
            .transform(BuilderTransformers.encasedLargeCogwheel("magenta", () -> CECSpriteShifts.MAGENTA_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> MAGENTA_ENCASED_FLUID_PIPE = REGISTRATE
            .block("magenta_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.MAGENTA_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_MAGENTA))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.MAGENTA_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.MAGENTA_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Purple Casing
    public static final BlockEntry<CasingBlock> PURPLE_CASING = REGISTRATE
            .block("purple_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .transform(BuilderTransformers.casing(() -> CECSpriteShifts.PURPLE_CASING))
            .register();
    public static final BlockEntry<CECEncasedShaftBlock> PURPLE_ENCASED_SHAFT = REGISTRATE
            .block("purple_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.PURPLE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .transform(BuilderTransformers.encasedShaft("purple", () -> CECSpriteShifts.PURPLE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> PURPLE_ENCASED_COGWHEEL = REGISTRATE
            .block("purple_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.PURPLE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .transform(BuilderTransformers.encasedCogwheel("purple", () -> CECSpriteShifts.PURPLE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.PURPLE_CASING,
                    Couple.create(CECSpriteShifts.PURPLE_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.PURPLE_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> PURPLE_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("purple_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.PURPLE_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .transform(BuilderTransformers.encasedLargeCogwheel("purple", () -> CECSpriteShifts.PURPLE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> PURPLE_ENCASED_FLUID_PIPE = REGISTRATE
            .block("purple_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.PURPLE_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::new))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.PURPLE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.PURPLE_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();
    public static void register() {}
}
