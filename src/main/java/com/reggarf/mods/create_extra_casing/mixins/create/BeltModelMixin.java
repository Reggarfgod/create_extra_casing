package com.reggarf.mods.create_extra_casing.mixins.create;

import com.reggarf.mods.create_extra_casing.registry.CECBlocks;
import com.reggarf.mods.create_extra_casing.registry.CECSpriteShifts;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.belt.BeltBlockEntity;
import com.simibubi.create.content.kinetics.belt.BeltModel;
import com.simibubi.create.foundation.block.render.SpriteShiftEntry;
import com.simibubi.create.foundation.model.BakedQuadHelper;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.data.ModelProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(value = BeltModel.class,remap = false)
public class BeltModelMixin {


    @Shadow @Final public static ModelProperty<BeltBlockEntity.CasingType> CASING_PROPERTY;

    @Inject(method = "getParticleIcon",at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lnet/minecraftforge/client/model/data/ModelData;get(Lnet/minecraftforge/client/model/data/ModelProperty;)Ljava/lang/Object;"), cancellable = true)
    private void encased$customParticle(ModelData data, CallbackInfoReturnable<TextureAtlasSprite> cir){
        BeltBlockEntity.CasingType type = data.get(CASING_PROPERTY);
        System.out.println(type);
        if (type.equals(CECBlocks.LIGHT_GRAY_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.LIGHT_GRAY_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.RED_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.RED_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.GRAY_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.GRAY_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.BLACK_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.BLACK_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.WHITE_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.WHITE_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.LIGHT_BLUE_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.LIGHT_BLUE_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.BLUE_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.BLUE_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.GREEN_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.GREEN_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.BROWN_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.BROWN_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.PURPLE_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.PURPLE_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.ORANGE_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.ORANGE_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.YELLOW_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.YELLOW_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.PINK_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.PINK_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.LIME_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.LIME_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.MAGENTA_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.MAGENTA_BELT_CASING.getOriginal());
        }
        if (type.equals(CECBlocks.CYAN_BELT_CASING)) {
            cir.setReturnValue(CECSpriteShifts.CYAN_BELT_CASING.getOriginal());
        }


    }

    @Inject(method = "getQuads",at = @At(value = "INVOKE", target = "Ljava/util/List;addAll(Ljava/util/Collection;)Z",ordinal = 0,shift = At.Shift.AFTER),locals = LocalCapture.CAPTURE_FAILSOFT)
    private void encased$customCasingCover(BlockState state, Direction side, RandomSource rand, ModelData extraData, RenderType renderType, CallbackInfoReturnable<List<BakedQuad>> cir, List quads, boolean cover, BeltBlockEntity.CasingType type, boolean brassCasing, boolean alongX, BakedModel coverModel){
        if (type.equals(CECBlocks.LIGHT_GRAY_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.RED_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.GRAY_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.BLACK_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.WHITE_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.LIGHT_BLUE_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.BLUE_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.BROWN_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.GREEN_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.YELLOW_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.ORANGE_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.PINK_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.LIME_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.MAGENTA_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.CYAN_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }
        if (type.equals(CECBlocks.PURPLE_BELT_CASING)){
            quads.removeAll(coverModel.getQuads(state, side, rand, extraData, renderType));
            quads.addAll((alongX ? AllPartialModels.ANDESITE_BELT_COVER_X : AllPartialModels.ANDESITE_BELT_COVER_Z).get().getQuads(state, side, rand, extraData, renderType));
        }


    }

    @Inject(method = "getQuads",at = @At(value = "INVOKE",target = "Ljava/util/List;size()I",ordinal = 0,shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private void encased$customCasingType(BlockState state, Direction side, RandomSource rand, ModelData extraData, RenderType renderType, CallbackInfoReturnable<List<BakedQuad>> cir, List quads, boolean cover, BeltBlockEntity.CasingType type, boolean brassCasing, int i){
        if (type.equals(CECBlocks.LIGHT_GRAY_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.LIGHT_GRAY_BELT_CASING));
            return;
        }
        if (type.equals(CECBlocks.RED_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.RED_BELT_CASING));
            return;
        }
        if (type.equals(CECBlocks.GRAY_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.GRAY_BELT_CASING));
            return;
        }
        if (type.equals(CECBlocks.BLACK_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.BLACK_BELT_CASING));
            return;
        }
        if (type.equals(CECBlocks.WHITE_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.WHITE_BELT_CASING));
            return;
        }
        if (type.equals(CECBlocks.LIGHT_BLUE_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.LIGHT_BLUE_BELT_CASING));
            return;
        }
        if (type.equals(CECBlocks.BLUE_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.BLUE_BELT_CASING));
            return;
        }
        if (type.equals(CECBlocks.BROWN_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.BROWN_BELT_CASING));
            return;
        }

        if (type.equals(CECBlocks.GREEN_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.GREEN_BELT_CASING));
            return;
        }

        if (type.equals(CECBlocks.YELLOW_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.YELLOW_BELT_CASING));
            return;
        }

        if (type.equals(CECBlocks.ORANGE_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.ORANGE_BELT_CASING));
            return;
        }

        if (type.equals(CECBlocks.PINK_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.PINK_BELT_CASING));
            return;
        }

        if (type.equals(CECBlocks.LIME_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.LIME_BELT_CASING));
            return;
        }

        if (type.equals(CECBlocks.MAGENTA_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.MAGENTA_BELT_CASING));
            return;
        }

        if (type.equals(CECBlocks.CYAN_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.CYAN_BELT_CASING));
            return;
        }

        if (type.equals(CECBlocks.PURPLE_BELT_CASING)){
            cir.setReturnValue(getQuadsForSprite(quads, CECSpriteShifts.PURPLE_BELT_CASING));
            return;
        }


    }

    private static List<BakedQuad> getQuadsForSprite(List<BakedQuad> quads, SpriteShiftEntry spriteShift){
        for (int i = 0; i < quads.size(); i++) {
            BakedQuad quad = quads.get(i);
            TextureAtlasSprite original = quad.getSprite();
            if (original != spriteShift.getOriginal())
                continue;

            BakedQuad newQuad = BakedQuadHelper.clone(quad);
            int[] vertexData = newQuad.getVertices();

            for (int vertex = 0; vertex < 4; vertex++) {
                float u = BakedQuadHelper.getU(vertexData, vertex);
                float v = BakedQuadHelper.getV(vertexData, vertex);
                BakedQuadHelper.setU(vertexData, vertex, spriteShift.getTargetU(u));
                BakedQuadHelper.setV(vertexData, vertex, spriteShift.getTargetV(v));
            }

            quads.set(i, newQuad);
        }


        return quads;
    }

}
