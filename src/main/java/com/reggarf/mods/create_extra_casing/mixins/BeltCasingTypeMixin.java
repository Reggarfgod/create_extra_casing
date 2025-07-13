package com.reggarf.mods.create_extra_casing.mixins;

import com.reggarf.mods.create_extra_casing.registry.CECBlocks;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(value = BeltBlockEntity.CasingType.class,remap = false)
public class BeltCasingTypeMixin {
    @Shadow
    @Final
    @Mutable
    private static BeltBlockEntity.CasingType[] $VALUES;

    @Invoker("<init>")
    public static BeltBlockEntity.CasingType encased$initInvoker(String internalName, int internalId){
        throw new AssertionError();
    }

    @Inject(method = "<clinit>",at = @At("TAIL"))
    private static void cmr$clinit(CallbackInfo ci) {

        CECBlocks.LIGHT_GRAY_BELT_CASING = encased$addVariant("light_gray");
        CECBlocks.RED_BELT_CASING = encased$addVariant("red");
        CECBlocks.GRAY_BELT_CASING = encased$addVariant("gray");
        CECBlocks.BLACK_BELT_CASING = encased$addVariant("black");
        CECBlocks.WHITE_BELT_CASING = encased$addVariant("white");
        CECBlocks.LIGHT_BLUE_BELT_CASING = encased$addVariant("light_blue");
        CECBlocks.BLUE_BELT_CASING = encased$addVariant("blue");
        CECBlocks.BROWN_BELT_CASING = encased$addVariant("brown");
        CECBlocks.GREEN_BELT_CASING = encased$addVariant("green");
        CECBlocks.PURPLE_BELT_CASING = encased$addVariant("purple");
        CECBlocks.LIME_BELT_CASING = encased$addVariant("lime");
        CECBlocks.YELLOW_BELT_CASING = encased$addVariant("yellow");
        CECBlocks.PINK_BELT_CASING = encased$addVariant("pink");
        CECBlocks.ORANGE_BELT_CASING = encased$addVariant("orange");
        CECBlocks.CYAN_BELT_CASING = encased$addVariant("cyan");
        CECBlocks.MAGENTA_BELT_CASING = encased$addVariant("magenta");
        CECBlocks.RGB_BELT_CASING = encased$addVariant("magenta");
        //BRASS

        CECBlocks.LIGHT_GRAY_BELT_BRASS_CASING = encased$addVariant("light_gray_brass");
        CECBlocks.RED_BELT_BRASS_CASING = encased$addVariant("red_brass");
        CECBlocks.GRAY_BELT_BRASS_CASING = encased$addVariant("gray_brass");
        CECBlocks.BLACK_BELT_BRASS_CASING = encased$addVariant("black_brass");
        CECBlocks.WHITE_BELT_BRASS_CASING = encased$addVariant("white_brass");
        CECBlocks.LIGHT_BLUE_BELT_BRASS_CASING = encased$addVariant("light_blue_brass");
        CECBlocks.BLUE_BELT_BRASS_CASING = encased$addVariant("blue_brass");
        CECBlocks.BROWN_BELT_BRASS_CASING = encased$addVariant("brown_brass");
        CECBlocks.GREEN_BELT_BRASS_CASING = encased$addVariant("green_brass");
        CECBlocks.PURPLE_BELT_BRASS_CASING = encased$addVariant("purple_brass");
        CECBlocks.LIME_BELT_BRASS_CASING = encased$addVariant("lime_brass");
        CECBlocks.YELLOW_BELT_BRASS_CASING = encased$addVariant("yellow_brass");
        CECBlocks.PINK_BELT_BRASS_CASING = encased$addVariant("pink_brass");
        CECBlocks.ORANGE_BELT_BRASS_CASING = encased$addVariant("orange_brass");
        CECBlocks.CYAN_BELT_BRASS_CASING = encased$addVariant("cyan_brass");
        CECBlocks.MAGENTA_BELT_BRASS_CASING = encased$addVariant("magenta_brass");
        CECBlocks.RGB_BELT_BRASS_CASING = encased$addVariant("rgb_brass");
    }

    @Unique
    private static BeltBlockEntity.CasingType encased$addVariant(String internalName) {
        ArrayList<BeltBlockEntity.CasingType> variants = new ArrayList<>(Arrays.asList($VALUES));
        BeltBlockEntity.CasingType casing = encased$initInvoker(internalName, variants.get(variants.size() - 1).ordinal() + 1);
        variants.add(casing);
        BeltCasingTypeMixin.$VALUES = variants.toArray(new BeltBlockEntity.CasingType[0]);
        return casing;
    }
}
