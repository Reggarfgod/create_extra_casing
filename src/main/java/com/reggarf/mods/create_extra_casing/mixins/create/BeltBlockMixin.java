package com.reggarf.mods.create_extra_casing.mixins.create;

import com.reggarf.mods.create_extra_casing.registry.CECBlocks;
import com.simibubi.create.content.kinetics.belt.BeltBlock;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value = BeltBlock.class)
public abstract class BeltBlockMixin {

    @Shadow public abstract void updateCoverProperty(LevelAccessor world, BlockPos pos, BlockState state);

    @Inject(method = "use",at = @At(value = "INVOKE", target = "Lcom/tterrag/registrate/util/entry/BlockEntry;isIn(Lnet/minecraft/world/item/ItemStack;)Z",ordinal = 1,shift = At.Shift.BEFORE),locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private void encased$otherCasingUses(BlockState state, Level world, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir, ItemStack heldItem, boolean isWrench, boolean isConnector, boolean isShaft){
        if (cmr$customCasingUse(CECBlocks.LIGHT_GRAY_CASING,CECBlocks.LIGHT_GRAY_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.RED_CASING,CECBlocks.RED_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.GRAY_CASING,CECBlocks.GRAY_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.BLACK_CASING,CECBlocks.BLACK_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.WHITE_CASING,CECBlocks.WHITE_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.LIGHT_BLUE_CASING,CECBlocks.LIGHT_BLUE_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.BLUE_CASING,CECBlocks.BLUE_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.YELLOW_CASING,CECBlocks.YELLOW_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.GREEN_CASING,CECBlocks.GREEN_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.ORANGE_CASING,CECBlocks.ORANGE_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.PINK_CASING,CECBlocks.PINK_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.MAGENTA_CASING,CECBlocks.MAGENTA_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.LIME_CASING,CECBlocks.LIME_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.BROWN_CASING,CECBlocks.BROWN_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.CYAN_CASING,CECBlocks.CYAN_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }
        if (cmr$customCasingUse(CECBlocks.PURPLE_CASING,CECBlocks.PURPLE_BELT_CASING,heldItem,world,pos,player)) {
            cir.setReturnValue(InteractionResult.SUCCESS);
            return;
        }


    }


    @Unique
    private boolean cmr$customCasingUse(BlockEntry<? extends Block> entry, BeltBlockEntity.CasingType type,ItemStack heldItem,Level world,BlockPos pos,Player player){
        if (entry.isIn(heldItem) && type != null) {
            if (world.getBlockEntity(pos) instanceof BeltBlockEntity be)
                be.setCasingType(type);
            updateCoverProperty(world, pos, world.getBlockState(pos));

            SoundType soundType = entry.getDefaultState()
                    .getSoundType(world, pos, player);
            world.playSound(null, pos, soundType.getPlaceSound(), SoundSource.BLOCKS,
                    (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);

            return true;
        }
        return false;
    }

}
