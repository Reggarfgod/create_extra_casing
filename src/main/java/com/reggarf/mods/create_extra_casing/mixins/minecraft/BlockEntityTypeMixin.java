package com.reggarf.mods.create_extra_casing.mixins.minecraft;

import com.reggarf.mods.create_extra_casing.registry.CECBlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BlockEntityType.class)
public class BlockEntityTypeMixin {


    @Inject(method = "isValid",at = @At("HEAD"),cancellable = true)
    private void isValid(BlockState state, CallbackInfoReturnable<Boolean> cir){
        if (CECBlockEntityTypes.ENCASED_SHAFT.isBound() &&( this.equals(CECBlockEntityTypes.ENCASED_SHAFT.get()) ||
                this.equals(CECBlockEntityTypes.ENCASED_COGWHEEL.get()) ||
                this.equals(CECBlockEntityTypes.ENCASED_LARGE_COGWHEEL.get()) ||
                this.equals(CECBlockEntityTypes.ENCASED_FLUID_PIPE.get())))
            cir.setReturnValue(true);

    }

}
