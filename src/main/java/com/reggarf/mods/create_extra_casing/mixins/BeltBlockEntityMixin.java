package com.reggarf.mods.create_extra_casing.mixins;

import com.reggarf.mods.create_extra_casing.registry.CECBlocks;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(value = BeltBlockEntity.class)
public abstract class BeltBlockEntityMixin {


    @Shadow public BeltBlockEntity.CasingType casing;
    @Unique public BeltBlockEntity.CasingType createCasing$newCasing;

    @Shadow public abstract BeltBlockEntity getControllerBE();

    @Inject(method = "setCasingType",at=@At("HEAD"),remap=false)
    private void encased$saveNewCasing(BeltBlockEntity.CasingType type, CallbackInfo ci){
        createCasing$newCasing = type;
    }

    @ModifyArg(method = "setCasingType",remap = false,at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;levelEvent(ILnet/minecraft/core/BlockPos;I)V"),index = 2)
    private int encased$changeParticle(int old) {
        if (createCasing$newCasing.equals(CECBlocks.RED_BELT_CASING)) return Block.getId(CECBlocks.RED_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.WHITE_BELT_CASING)) return Block.getId(CECBlocks.WHITE_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.BLACK_BELT_CASING)) return Block.getId(CECBlocks.BLACK_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.GRAY_BELT_CASING)) return Block.getId(CECBlocks.GRAY_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.LIGHT_GRAY_BELT_CASING)) return Block.getId(CECBlocks.LIGHT_GRAY_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.BLUE_BELT_CASING)) return Block.getId(CECBlocks.BLUE_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.LIGHT_BLUE_BELT_CASING)) return Block.getId(CECBlocks.LIGHT_BLUE_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.GREEN_BELT_CASING)) return Block.getId(CECBlocks.GREEN_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.LIME_BELT_CASING)) return Block.getId(CECBlocks.LIME_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.CYAN_BELT_CASING)) return Block.getId(CECBlocks.CYAN_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.ORANGE_BELT_CASING)) return Block.getId(CECBlocks.ORANGE_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.MAGENTA_BELT_CASING)) return Block.getId(CECBlocks.MAGENTA_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.PINK_BELT_CASING)) return Block.getId(CECBlocks.PINK_CASING.getDefaultState());
        if (createCasing$newCasing.equals(CECBlocks.PURPLE_BELT_CASING)) return Block.getId(CECBlocks.PURPLE_CASING.getDefaultState());
        //if (createCasing$newCasing.equals(CECBlocks.BROWN_BELT_CASING)) return Block.getId(CECBlocks.BROWN_CASING.getDefaultState());
        //if (createCasing$newCasing.equals(CECBlocks.YELLOW_BELT_CASING)) return Block.getId(CECBlocks.YELLOW_CASING.getDefaultState());
        return old;
    }


}
