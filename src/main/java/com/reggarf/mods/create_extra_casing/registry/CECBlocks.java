package com.reggarf.mods.create_extra_casing.registry;

import com.reggarf.mods.create_extra_casing.CEC;
import com.reggarf.mods.create_extra_casing.block.CECEncasedCogwheelBlock;
import com.reggarf.mods.create_extra_casing.block.CECEncasedPipeBlock;
import com.reggarf.mods.create_extra_casing.block.CECEncasedShaftBlock;
import com.reggarf.mods.create_extra_casing.util.BuilderTransformers;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.fluids.PipeAttachmentModel;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.createmod.catnip.data.Couple;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

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
    public static BeltBlockEntity.CasingType RED_BELT_CASING;

    public static final BlockEntry<CasingBlock> RED_CASING = REGISTRATE
            .block("red_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_RED))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.RED_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.RED_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.RED_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   White Casing
    public static BeltBlockEntity.CasingType WHITE_BELT_CASING;

    public static final BlockEntry<CasingBlock> WHITE_CASING = REGISTRATE
            .block("white_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.SNOW))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.WHITE_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.WHITE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.WHITE_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Black Casing
    public static BeltBlockEntity.CasingType BLACK_BELT_CASING;

    public static final BlockEntry<CasingBlock> BLACK_CASING = REGISTRATE
            .block("black_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.BLACK_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.BLACK_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.BLACK_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Gray Casing
    public static BeltBlockEntity.CasingType GRAY_BELT_CASING;

    public static final BlockEntry<CasingBlock> GRAY_CASING = REGISTRATE
            .block("gray_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.GRAY_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.GRAY_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.GRAY_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();


    //   LightGray Casing

    public static BeltBlockEntity.CasingType LIGHT_GRAY_BELT_CASING;

    public static final BlockEntry<CasingBlock> LIGHT_GRAY_CASING = REGISTRATE
            .block("light_gray_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GRAY))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.LIGHT_GRAY_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.LIGHT_GRAY_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.LIGHT_GRAY_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   LightBlue Casing
    public static BeltBlockEntity.CasingType LIGHT_BLUE_BELT_CASING;

    public static final BlockEntry<CasingBlock> LIGHT_BLUE_CASING = REGISTRATE
            .block("light_blue_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_BLUE))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.LIGHT_BLUE_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.LIGHT_BLUE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.LIGHT_BLUE_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();
    
    //   Blue Casing

    public static BeltBlockEntity.CasingType BLUE_BELT_CASING;

    public static final BlockEntry<CasingBlock> BLUE_CASING = REGISTRATE
            .block("blue_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_BLUE))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.BLUE_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.BLUE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.ORANGE_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Brown Casing
    public static BeltBlockEntity.CasingType BROWN_BELT_CASING;

    public static final BlockEntry<CasingBlock> BROWN_CASING = REGISTRATE
            .block("brown_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_BROWN))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.BROWN_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.BROWN_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.BROWN_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Orange Casing
    public static BeltBlockEntity.CasingType ORANGE_BELT_CASING;

    public static final BlockEntry<CasingBlock> ORANGE_CASING = REGISTRATE
            .block("orange_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.ORANGE_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.ORANGE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.ORANGE_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();


    //   Yellow Casing
    public static BeltBlockEntity.CasingType YELLOW_BELT_CASING;

    public static final BlockEntry<CasingBlock> YELLOW_CASING = REGISTRATE
            .block("yellow_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_YELLOW))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.YELLOW_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.YELLOW_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.YELLOW_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Pink Casing
    public static BeltBlockEntity.CasingType PINK_BELT_CASING;

    public static final BlockEntry<CasingBlock> PINK_CASING = REGISTRATE
            .block("pink_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_PINK))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.PINK_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.PINK_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.PINK_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Green Casing
    public static BeltBlockEntity.CasingType GREEN_BELT_CASING;

    public static final BlockEntry<CasingBlock> GREEN_CASING = REGISTRATE
            .block("green_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_GREEN))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.GREEN_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.GREEN_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.GREEN_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Lime Casing
    public static BeltBlockEntity.CasingType LIME_BELT_CASING;

    public static final BlockEntry<CasingBlock> LIME_CASING = REGISTRATE
            .block("lime_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GREEN))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.LIME_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.LIME_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.LIME_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Cyan Casing
    public static BeltBlockEntity.CasingType CYAN_BELT_CASING;

    public static final BlockEntry<CasingBlock> CYAN_CASING = REGISTRATE
            .block("cyan_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_CYAN))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.CYAN_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.CYAN_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.CYAN_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //    Magenta Casing
    public static BeltBlockEntity.CasingType MAGENTA_BELT_CASING;

    public static final BlockEntry<CasingBlock> MAGENTA_CASING = REGISTRATE
            .block("magenta_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_MAGENTA))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.MAGENTA_CASING))
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
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.MAGENTA_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.MAGENTA_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //   Purple Casing
    public static BeltBlockEntity.CasingType PURPLE_BELT_CASING;

    public static final BlockEntry<CasingBlock> PURPLE_CASING = REGISTRATE
            .block("purple_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.PURPLE_CASING))
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
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.PURPLE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.PURPLE_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();


    //RGB color

    public static BeltBlockEntity.CasingType RGB_BELT_CASING;

    public static final BlockEntry<CasingBlock> RGB_CASING = REGISTRATE
            .block("rgb_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(() -> CECSpriteShifts.RGB_CASING))
            .register();

    public static final BlockEntry<CECEncasedShaftBlock> RGB_ENCASED_SHAFT = REGISTRATE
            .block("rgb_encased_shaft", p -> new CECEncasedShaftBlock(p, CECBlocks.RGB_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .transform(BuilderTransformers.encasedShaft("rgb", () -> CECSpriteShifts.RGB_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> RGB_ENCASED_COGWHEEL = REGISTRATE
            .block("rgb_encased_cogwheel", p -> new CECEncasedCogwheelBlock(p, false, CECBlocks.RGB_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .transform(BuilderTransformers.encasedCogwheel("rgb", () -> CECSpriteShifts.RGB_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.COGWHEEL))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(CECSpriteShifts.RGB_CASING,
                    Couple.create(CECSpriteShifts.RGB_ENCASED_COGWHEEL_SIDE,
                            CECSpriteShifts.RGB_ENCASED_COGWHEEL_OTHERSIDE))))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedCogwheelBlock> RGB_ENCASED_LARGE_COGWHEEL = REGISTRATE
            .block("rgb_encased_large_cogwheel",
                    p -> new CECEncasedCogwheelBlock(p, true, CECBlocks.RGB_CASING::get))
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .transform(BuilderTransformers.encasedLargeCogwheel("rgb", () -> CECSpriteShifts.PURPLE_CASING))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.LARGE_COGWHEEL))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CECEncasedPipeBlock> RGB_ENCASED_FLUID_PIPE = REGISTRATE
            .block("rgb_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, CECBlocks.RGB_CASING::get))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
            .blockstate(BlockStateGen.encasedPipe())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(CECSpriteShifts.RGB_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, CECSpriteShifts.RGB_CASING,
                    (s, f) -> !s.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(f)))))
            .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
            .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
            .register();

    //  ---New method---
    //RED
    private static final MapColor RED_BRASS = MapColor.COLOR_RED;
    private static final String RED_ID = "red_brass";
    private static final Supplier<CTSpriteShiftEntry> RED_BRASS_CT = () -> CECSpriteShifts.RED_BRASS_CASING;
    private static final Supplier<Block> RED_BRASS_CASING_SUPPLIER = () -> CECBlocks.RED_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType RED_BELT_BRASS_CASING;


    public static final BlockEntry<CasingBlock> RED_BRASS_CASING = registerCasing(RED_ID, RED_BRASS, RED_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> RED_BRASS_ENCASED_SHAFT = registerEncasedShaft(RED_ID, RED_BRASS, RED_BRASS_CT, RED_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> RED_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(RED_ID, RED_BRASS, RED_BRASS_CT, RED_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> RED_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(RED_ID, RED_BRASS, RED_BRASS_CT, RED_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> RED_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(RED_ID, RED_BRASS, RED_BRASS_CT, RED_BRASS_CASING_SUPPLIER);

    //WHITE
    private static final MapColor WHITE_BRASS = MapColor.SNOW;
    private static final String WHITE_ID = "white_brass";
    private static final Supplier<CTSpriteShiftEntry> WHITE_BRASS_CT = () -> CECSpriteShifts.WHITE_BRASS_CASING;
    private static final Supplier<Block> WHITE_BRASS_CASING_SUPPLIER = () -> CECBlocks.WHITE_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType WHITE_BELT_BRASS_CASING;


    public static final BlockEntry<CasingBlock> WHITE_BRASS_CASING = registerCasing(WHITE_ID, WHITE_BRASS, WHITE_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> WHITE_BRASS_ENCASED_SHAFT = registerEncasedShaft(WHITE_ID, WHITE_BRASS, WHITE_BRASS_CT, WHITE_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> WHITE_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(WHITE_ID, WHITE_BRASS, WHITE_BRASS_CT, WHITE_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> WHITE_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(WHITE_ID, WHITE_BRASS, WHITE_BRASS_CT, WHITE_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> WHITE_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(WHITE_ID, WHITE_BRASS, WHITE_BRASS_CT, WHITE_BRASS_CASING_SUPPLIER);


    //BLACK
    private static final MapColor BLACK_BRASS = MapColor.COLOR_BLACK;
    private static final String BLACK_ID = "black_brass";
    private static final Supplier<CTSpriteShiftEntry> BLACK_BRASS_CT = () -> CECSpriteShifts.BLACK_BRASS_CASING;
    private static final Supplier<Block> BLACK_BRASS_CASING_SUPPLIER = () -> CECBlocks.BLACK_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType BLACK_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> BLACK_BRASS_CASING = registerCasing(BLACK_ID, BLACK_BRASS, BLACK_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> BLACK_BRASS_ENCASED_SHAFT = registerEncasedShaft(BLACK_ID, BLACK_BRASS, BLACK_BRASS_CT, BLACK_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> BLACK_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(BLACK_ID, BLACK_BRASS, BLACK_BRASS_CT, BLACK_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> BLACK_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(BLACK_ID, BLACK_BRASS, BLACK_BRASS_CT, BLACK_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> BLACK_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(BLACK_ID, BLACK_BRASS, BLACK_BRASS_CT, BLACK_BRASS_CASING_SUPPLIER);

    //GRAY
    private static final MapColor GRAY_BRASS = MapColor.COLOR_GRAY;
    private static final String GRAY_ID = "gray_brass";
    private static final Supplier<CTSpriteShiftEntry> GRAY_BRASS_CT = () -> CECSpriteShifts.GRAY_BRASS_CASING;
    private static final Supplier<Block> GRAY_BRASS_CASING_SUPPLIER = () -> CECBlocks.GRAY_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType GRAY_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> GRAY_BRASS_CASING = registerCasing(GRAY_ID, GRAY_BRASS, GRAY_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> GRAY_BRASS_ENCASED_SHAFT = registerEncasedShaft(GRAY_ID, GRAY_BRASS, GRAY_BRASS_CT, GRAY_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> GRAY_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(GRAY_ID, GRAY_BRASS, GRAY_BRASS_CT, GRAY_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> GRAY_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(GRAY_ID, GRAY_BRASS, GRAY_BRASS_CT, GRAY_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> GRAY_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(GRAY_ID, GRAY_BRASS, GRAY_BRASS_CT, GRAY_BRASS_CASING_SUPPLIER);

    //LIGHT GRAY
    private static final MapColor LIGHT_GRAY_BRASS = MapColor.COLOR_LIGHT_GRAY;
    private static final String LIGHT_GRAY_ID = "light_gray_brass";
    private static final Supplier<CTSpriteShiftEntry> LIGHT_GRAY_BRASS_CT = () -> CECSpriteShifts.LIGHT_GRAY_BRASS_CASING;
    private static final Supplier<Block> LIGHT_GRAY_BRASS_CASING_SUPPLIER = () -> CECBlocks.LIGHT_GRAY_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType LIGHT_GRAY_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> LIGHT_GRAY_BRASS_CASING = registerCasing(LIGHT_GRAY_ID, LIGHT_GRAY_BRASS, LIGHT_GRAY_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> LIGHT_GRAY_BRASS_ENCASED_SHAFT = registerEncasedShaft(LIGHT_GRAY_ID, LIGHT_GRAY_BRASS, LIGHT_GRAY_BRASS_CT, LIGHT_GRAY_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> LIGHT_GRAY_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(LIGHT_GRAY_ID, LIGHT_GRAY_BRASS, LIGHT_GRAY_BRASS_CT, LIGHT_GRAY_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> LIGHT_GRAY_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(LIGHT_GRAY_ID, LIGHT_GRAY_BRASS, LIGHT_GRAY_BRASS_CT, LIGHT_GRAY_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> LIGHT_GRAY_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(LIGHT_GRAY_ID, LIGHT_GRAY_BRASS, LIGHT_GRAY_BRASS_CT, LIGHT_GRAY_BRASS_CASING_SUPPLIER);

    //BLUE
    private static final MapColor BLUE_BRASS = MapColor.COLOR_BLUE;
    private static final String BLUE_ID = "blue_brass";
    private static final Supplier<CTSpriteShiftEntry> BLUE_BRASS_CT = () -> CECSpriteShifts.BLUE_BRASS_CASING;
    private static final Supplier<Block> BLUE_BRASS_CASING_SUPPLIER = () -> CECBlocks.BLUE_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType BLUE_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> BLUE_BRASS_CASING = registerCasing(BLUE_ID, BLUE_BRASS, BLUE_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> BLUE_BRASS_ENCASED_SHAFT = registerEncasedShaft(BLUE_ID, BLUE_BRASS, BLUE_BRASS_CT, BLUE_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> BLUE_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(BLUE_ID, BLUE_BRASS, BLUE_BRASS_CT, BLUE_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> BLUE_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(BLUE_ID, BLUE_BRASS, BLUE_BRASS_CT, BLUE_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> BLUE_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(BLUE_ID, BLUE_BRASS, BLUE_BRASS_CT, BLUE_BRASS_CASING_SUPPLIER);

    //LIGHT BLUE
    private static final MapColor LIGHT_BLUE_BRASS = MapColor.COLOR_LIGHT_BLUE;
    private static final String LIGHT_BLUE_ID = "light_blue_brass";
    private static final Supplier<CTSpriteShiftEntry> LIGHT_BLUE_BRASS_CT = () -> CECSpriteShifts.LIGHT_BLUE_BRASS_CASING;
    private static final Supplier<Block> LIGHT_BLUE_BRASS_CASING_SUPPLIER = () -> CECBlocks.LIGHT_BLUE_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType LIGHT_BLUE_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> LIGHT_BLUE_BRASS_CASING = registerCasing(LIGHT_BLUE_ID, LIGHT_BLUE_BRASS, LIGHT_BLUE_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> LIGHT_BLUE_BRASS_ENCASED_SHAFT = registerEncasedShaft(LIGHT_BLUE_ID, LIGHT_BLUE_BRASS, LIGHT_BLUE_BRASS_CT, LIGHT_BLUE_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> LIGHT_BLUE_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(LIGHT_BLUE_ID, LIGHT_BLUE_BRASS, LIGHT_BLUE_BRASS_CT, LIGHT_BLUE_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> LIGHT_BLUE_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(LIGHT_BLUE_ID, LIGHT_BLUE_BRASS, LIGHT_BLUE_BRASS_CT, LIGHT_BLUE_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> LIGHT_BLUE_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(LIGHT_BLUE_ID, LIGHT_BLUE_BRASS, LIGHT_BLUE_BRASS_CT, LIGHT_BLUE_BRASS_CASING_SUPPLIER);

    //GREEN
    private static final MapColor GREEN_BRASS = MapColor.COLOR_GREEN;
    private static final String GREEN_ID = "green_brass";
    private static final Supplier<CTSpriteShiftEntry> GREEN_BRASS_CT = () -> CECSpriteShifts.GREEN_BRASS_CASING;
    private static final Supplier<Block> GREEN_BRASS_CASING_SUPPLIER = () -> CECBlocks.GREEN_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType GREEN_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> GREEN_BRASS_CASING = registerCasing(GREEN_ID, GREEN_BRASS, GREEN_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> GREEN_BRASS_ENCASED_SHAFT = registerEncasedShaft(GREEN_ID, GREEN_BRASS, GREEN_BRASS_CT, GREEN_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> GREEN_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(GREEN_ID, GREEN_BRASS, GREEN_BRASS_CT, GREEN_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> GREEN_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(GREEN_ID, GREEN_BRASS, GREEN_BRASS_CT, GREEN_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> GREEN_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(GREEN_ID, GREEN_BRASS, GREEN_BRASS_CT, GREEN_BRASS_CASING_SUPPLIER);

    //LIME
    private static final MapColor LIME_BRASS = MapColor.COLOR_LIGHT_GREEN;
    private static final String LIME_ID = "lime_brass";
    private static final Supplier<CTSpriteShiftEntry> LIME_BRASS_CT = () -> CECSpriteShifts.LIME_BRASS_CASING;
    private static final Supplier<Block> LIME_BRASS_CASING_SUPPLIER = () -> CECBlocks.LIME_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType LIME_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> LIME_BRASS_CASING = registerCasing(LIME_ID, LIME_BRASS, LIME_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> LIME_BRASS_ENCASED_SHAFT = registerEncasedShaft(LIME_ID, LIME_BRASS, LIME_BRASS_CT, LIME_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> LIME_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(LIME_ID, LIME_BRASS, LIME_BRASS_CT, LIME_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> LIME_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(LIME_ID, LIME_BRASS, LIME_BRASS_CT, LIME_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> LIME_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(LIME_ID, LIME_BRASS, LIME_BRASS_CT, LIME_BRASS_CASING_SUPPLIER);

    //CYAN
    private static final MapColor CYAN_BRASS = MapColor.COLOR_CYAN;
    private static final String CYAN_ID = "cyan_brass";
    private static final Supplier<CTSpriteShiftEntry> CYAN_BRASS_CT = () -> CECSpriteShifts.CYAN_BRASS_CASING;
    private static final Supplier<Block> CYAN_BRASS_CASING_SUPPLIER = () -> CECBlocks.CYAN_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType CYAN_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> CYAN_BRASS_CASING = registerCasing(CYAN_ID, CYAN_BRASS, CYAN_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> CYAN_BRASS_ENCASED_SHAFT = registerEncasedShaft(CYAN_ID, CYAN_BRASS, CYAN_BRASS_CT, CYAN_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> CYAN_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(CYAN_ID, CYAN_BRASS, CYAN_BRASS_CT, CYAN_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> CYAN_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(CYAN_ID, CYAN_BRASS, CYAN_BRASS_CT, CYAN_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> CYAN_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(CYAN_ID, CYAN_BRASS, CYAN_BRASS_CT, CYAN_BRASS_CASING_SUPPLIER);

    //BROWN
    private static final MapColor BROWN_BRASS = MapColor.COLOR_BROWN;
    private static final String BROWN_ID = "brown_brass";
    private static final Supplier<CTSpriteShiftEntry> BROWN_BRASS_CT = () -> CECSpriteShifts.BROWN_BRASS_CASING;
    private static final Supplier<Block> BROWN_BRASS_CASING_SUPPLIER = () -> CECBlocks.BROWN_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType BROWN_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> BROWN_BRASS_CASING = registerCasing(BROWN_ID, BROWN_BRASS, BROWN_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> BROWN_BRASS_ENCASED_SHAFT = registerEncasedShaft(BROWN_ID, BROWN_BRASS, BROWN_BRASS_CT, BROWN_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> BROWN_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(BROWN_ID, BROWN_BRASS, BROWN_BRASS_CT, BROWN_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> BROWN_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(BROWN_ID, BROWN_BRASS, BROWN_BRASS_CT, BROWN_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> BROWN_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(BROWN_ID, BROWN_BRASS, BROWN_BRASS_CT, BROWN_BRASS_CASING_SUPPLIER);

    //ORANGE
    private static final MapColor ORANGE_BRASS = MapColor.COLOR_ORANGE;
    private static final String ORANGE_ID = "orange_brass";
    private static final Supplier<CTSpriteShiftEntry> ORANGE_BRASS_CT = () -> CECSpriteShifts.ORANGE_BRASS_CASING;
    private static final Supplier<Block> ORANGE_BRASS_CASING_SUPPLIER = () -> CECBlocks.ORANGE_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType ORANGE_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> ORANGE_BRASS_CASING = registerCasing(ORANGE_ID, ORANGE_BRASS, ORANGE_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> ORANGE_BRASS_ENCASED_SHAFT = registerEncasedShaft(ORANGE_ID, ORANGE_BRASS, ORANGE_BRASS_CT, ORANGE_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> ORANGE_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(ORANGE_ID, ORANGE_BRASS, ORANGE_BRASS_CT, ORANGE_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> ORANGE_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(ORANGE_ID, ORANGE_BRASS, ORANGE_BRASS_CT, ORANGE_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> ORANGE_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(ORANGE_ID, ORANGE_BRASS, ORANGE_BRASS_CT, ORANGE_BRASS_CASING_SUPPLIER);

    //YELLOW
    private static final MapColor YELLOW_BRASS = MapColor.COLOR_YELLOW;
    private static final String YELLOW_ID = "yellow_brass";
    private static final Supplier<CTSpriteShiftEntry> YELLOW_BRASS_CT = () -> CECSpriteShifts.YELLOW_BRASS_CASING;
    private static final Supplier<Block> YELLOW_BRASS_CASING_SUPPLIER = () -> CECBlocks.YELLOW_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType YELLOW_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> YELLOW_BRASS_CASING = registerCasing(YELLOW_ID, YELLOW_BRASS, YELLOW_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> YELLOW_BRASS_ENCASED_SHAFT = registerEncasedShaft(YELLOW_ID, YELLOW_BRASS, YELLOW_BRASS_CT, YELLOW_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> YELLOW_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(YELLOW_ID, YELLOW_BRASS, YELLOW_BRASS_CT, YELLOW_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> YELLOW_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(YELLOW_ID, YELLOW_BRASS, YELLOW_BRASS_CT, YELLOW_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> YELLOW_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(YELLOW_ID, YELLOW_BRASS, YELLOW_BRASS_CT, YELLOW_BRASS_CASING_SUPPLIER);


    //MAGENTA
    private static final MapColor MAGENTA_BRASS = MapColor.COLOR_MAGENTA;
    private static final String MAGENTA_ID = "magenta_brass";
    private static final Supplier<CTSpriteShiftEntry> MAGENTA_BRASS_CT = () -> CECSpriteShifts.MAGENTA_BRASS_CASING;
    private static final Supplier<Block> MAGENTA_BRASS_CASING_SUPPLIER = () -> CECBlocks.MAGENTA_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType MAGENTA_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> MAGENTA_BRASS_CASING = registerCasing(MAGENTA_ID, MAGENTA_BRASS, MAGENTA_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> MAGENTA_BRASS_ENCASED_SHAFT = registerEncasedShaft(MAGENTA_ID, MAGENTA_BRASS, MAGENTA_BRASS_CT, MAGENTA_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> MAGENTA_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(MAGENTA_ID, MAGENTA_BRASS, MAGENTA_BRASS_CT, MAGENTA_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> MAGENTA_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(MAGENTA_ID, MAGENTA_BRASS, MAGENTA_BRASS_CT, MAGENTA_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> MAGENTA_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(MAGENTA_ID, MAGENTA_BRASS, MAGENTA_BRASS_CT, MAGENTA_BRASS_CASING_SUPPLIER);

    //PINK
    private static final MapColor PINK_BRASS = MapColor.COLOR_PINK;
    private static final String PINK_ID = "pink_brass";
    private static final Supplier<CTSpriteShiftEntry> PINK_BRASS_CT = () -> CECSpriteShifts.PINK_BRASS_CASING;
    private static final Supplier<Block> PINK_BRASS_CASING_SUPPLIER = () -> CECBlocks.PINK_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType PINK_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> PINK_BRASS_CASING = registerCasing(PINK_ID, PINK_BRASS, PINK_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> PINK_BRASS_ENCASED_SHAFT = registerEncasedShaft(PINK_ID, PINK_BRASS, PINK_BRASS_CT, PINK_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> PINK_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(PINK_ID, PINK_BRASS, PINK_BRASS_CT, PINK_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> PINK_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(PINK_ID, PINK_BRASS, PINK_BRASS_CT, PINK_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> PINK_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(PINK_ID, PINK_BRASS, PINK_BRASS_CT, PINK_BRASS_CASING_SUPPLIER);

    //PURPLE
    private static final MapColor PURPLE_BRASS = MapColor.COLOR_PURPLE;
    private static final String PURPLE_ID = "purple_brass";
    private static final Supplier<CTSpriteShiftEntry> PURPLE_BRASS_CT = () -> CECSpriteShifts.PURPLE_BRASS_CASING;
    private static final Supplier<Block> PURPLE_BRASS_CASING_SUPPLIER = () -> CECBlocks.PURPLE_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType PURPLE_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> PURPLE_BRASS_CASING = registerCasing(PURPLE_ID, PURPLE_BRASS, PURPLE_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> PURPLE_BRASS_ENCASED_SHAFT = registerEncasedShaft(PURPLE_ID, PURPLE_BRASS, PURPLE_BRASS_CT, PURPLE_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> PURPLE_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(PURPLE_ID, PURPLE_BRASS, PURPLE_BRASS_CT, PURPLE_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> PURPLE_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(PURPLE_ID, PURPLE_BRASS, PURPLE_BRASS_CT, PURPLE_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> PURPLE_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(PURPLE_ID, PURPLE_BRASS, PURPLE_BRASS_CT, PURPLE_BRASS_CASING_SUPPLIER);


    //RGB
    private static final MapColor RGB_BRASS = MapColor.COLOR_PURPLE;
    private static final String RGB_ID = "rgb_brass";
    private static final Supplier<CTSpriteShiftEntry> RGB_BRASS_CT = () -> CECSpriteShifts.RGB_BRASS_CASING;
    private static final Supplier<Block> RGB_BRASS_CASING_SUPPLIER = () -> CECBlocks.RGB_BRASS_CASING.get();
    public static BeltBlockEntity.CasingType RGB_BELT_BRASS_CASING;



    public static final BlockEntry<CasingBlock> RGB_BRASS_CASING = registerCasing(RGB_ID, RGB_BRASS, RGB_BRASS_CT);
    public static final BlockEntry<CECEncasedShaftBlock> RGB_BRASS_ENCASED_SHAFT = registerEncasedShaft(RGB_ID, RGB_BRASS, RGB_BRASS_CT, RGB_BRASS_CASING_SUPPLIER);
    public static final BlockEntry<CECEncasedCogwheelBlock> RGB_BRASS_ENCASED_COGWHEEL = registerEncasedCogwheel(RGB_ID, RGB_BRASS, RGB_BRASS_CT, RGB_BRASS_CASING_SUPPLIER, false);
    public static final BlockEntry<CECEncasedCogwheelBlock> RGB_BRASS_ENCASED_LARGE_COGWHEEL = registerEncasedCogwheel(RGB_ID, RGB_BRASS, RGB_BRASS_CT, RGB_BRASS_CASING_SUPPLIER, true);
    public static final BlockEntry<CECEncasedPipeBlock> RGB_BRASS_ENCASED_FLUID_PIPE = registerEncasedPipe(RGB_ID, RGB_BRASS, RGB_BRASS_CT, RGB_BRASS_CASING_SUPPLIER);




    // --- Helpers ---
    private static BlockEntry<CasingBlock> registerCasing(String id, MapColor color, Supplier<CTSpriteShiftEntry> sprite) {
        return REGISTRATE.block(id + "_casing", CasingBlock::new)
                .properties(p -> p.mapColor(color))
                .transform(com.simibubi.create.foundation.data.BuilderTransformers.casing(sprite))
                .register();
    }

    private static BlockEntry<CECEncasedShaftBlock> registerEncasedShaft(String id, MapColor color, Supplier<CTSpriteShiftEntry> sprite, Supplier<Block> casing) {
        return REGISTRATE.block(id + "_encased_shaft", p -> new CECEncasedShaftBlock(p, casing))
                .properties(p -> p.mapColor(color))
                .transform(BuilderTransformers.encasedShaft(id, sprite))
                .transform(EncasingRegistry.addVariantTo(AllBlocks.SHAFT))
                .transform(axeOrPickaxe())
                .register();
    }

    private static BlockEntry<CECEncasedCogwheelBlock> registerEncasedCogwheel(String id, MapColor color, Supplier<CTSpriteShiftEntry> sprite, Supplier<Block> casing, boolean large) {
        String blockName = id + "_encased_" + (large ? "large_" : "") + "cogwheel";

        var builder = REGISTRATE.block(blockName, p -> new CECEncasedCogwheelBlock(p, large, casing))
                .properties(p -> p.mapColor(color))
                .transform(large
                        ? BuilderTransformers.encasedLargeCogwheel(id, sprite)
                        : BuilderTransformers.encasedCogwheel(id, sprite))
                .transform(EncasingRegistry.addVariantTo(large ? AllBlocks.LARGE_COGWHEEL : AllBlocks.COGWHEEL));

        if (!large) {
            builder = builder.onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(
                    sprite.get(),
                    CECSpriteShifts.getCogwheelSides(id)
            )));
        }

        return builder
                .item()
                .transform(customItemModel())
                .transform(axeOrPickaxe())
                .register();
    }

    private static BlockEntry<CECEncasedPipeBlock> registerEncasedPipe(String id, MapColor color, Supplier<CTSpriteShiftEntry> sprite, Supplier<Block> casing) {
        return REGISTRATE.block(id + "_encased_fluid_pipe", p -> new CECEncasedPipeBlock(p, casing))
                .initialProperties(SharedProperties::copperMetal)
                .properties(p -> p.mapColor(color))
                .properties(BlockBehaviour.Properties::noOcclusion)
                .transform(pickaxeOnly())
                .onRegister(CreateRegistrate.blockModel(() -> PipeAttachmentModel::withAO))
                .blockstate(BlockStateGen.encasedPipe())
                .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(sprite.get())))
                .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, sprite.get(),
                        (state, face) -> !state.getValue(CECEncasedPipeBlock.FACING_TO_PROPERTY_MAP.get(face)))))
                .loot((p, b) -> p.dropOther(b, AllBlocks.FLUID_PIPE.get()))
                .transform(EncasingRegistry.addVariantTo(AllBlocks.FLUID_PIPE))
                .register();
    }



    public static void register() {}
}
