package com.reggarf.mods.create_extra_casing.mixins.create;

import com.reggarf.mods.create_extra_casing.CEC;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AllSpriteShifts.class,remap = false)
public abstract class AllSpriteShiftsMixin {

    @Inject(method = "getCT(Lcom/simibubi/create/foundation/block/connected/CTType;Ljava/lang/String;)Lcom/simibubi/create/foundation/block/connected/CTSpriteShiftEntry;", at = @At("HEAD"), cancellable = true)
    private static void encased$modifyCreativeCT(CTType type, String blockTextureName, CallbackInfoReturnable<CTSpriteShiftEntry> cir){
        if (blockTextureName.equals("red_brass_casing") && type.equals(AllCTTypes.RECTANGLE))
            cir.setReturnValue(CTSpriteShifter.getCT(AllCTTypes.OMNIDIRECTIONAL, Create.asResource("block/" + blockTextureName), CEC.asResource("block/" + blockTextureName + "_connected")));
    }

}
