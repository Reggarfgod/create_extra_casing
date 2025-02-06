package com.reggarf.mods.create_extra_casing.mixins.create;

import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.lang.reflect.InvocationTargetException;


@Mixin(value = BeltBlockEntity.class)
public abstract class BeltBlockEntityMixin {


    @Shadow public BeltBlockEntity.CasingType casing;

    @Shadow public abstract BeltBlockEntity getControllerBE();

    @Inject(method = "setCasingType",at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;levelEvent(ILnet/minecraft/core/BlockPos;I)V",shift = At.Shift.BEFORE),locals = LocalCapture.CAPTURE_FAILSOFT,cancellable = true)
    private void encased$changeParticle(BeltBlockEntity.CasingType type, CallbackInfo ci, BlockState blockState, boolean shouldBlockHaveCasing) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

    }


}
