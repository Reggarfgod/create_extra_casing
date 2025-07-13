package com.reggarf.mods.create_extra_casing.registry;

import com.reggarf.mods.create_extra_casing.CEC;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import net.createmod.catnip.data.Couple;
import net.createmod.catnip.render.SpriteShiftEntry;
import net.createmod.catnip.render.SpriteShifter;

import static com.simibubi.create.foundation.block.connected.AllCTTypes.*;

public class CECSpriteShifts {

    public static final SpriteShiftEntry LIGHT_GRAY_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/light_gray_belt_casing");
    public static final SpriteShiftEntry RED_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/red_belt_casing");
    public static final SpriteShiftEntry GRAY_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/gray_belt_casing");
    public static final SpriteShiftEntry BLACK_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/black_belt_casing");
    public static final SpriteShiftEntry WHITE_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/white_belt_casing");
    public static final SpriteShiftEntry LIGHT_BLUE_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/light_blue_belt_casing");
    public static final SpriteShiftEntry BLUE_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/blue_belt_casing");
    public static final SpriteShiftEntry YELLOW_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/yellow_belt_casing");
    public static final SpriteShiftEntry GREEN_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/green_belt_casing");
    public static final SpriteShiftEntry PURPLE_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/purple_belt_casing");
    public static final SpriteShiftEntry ORANGE_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/orange_belt_casing");
    public static final SpriteShiftEntry PINK_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/pink_belt_casing");
    public static final SpriteShiftEntry BROWN_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/brown_belt_casing");
    public static final SpriteShiftEntry MAGENTA_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/magenta_belt_casing");
    public static final SpriteShiftEntry LIME_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/lime_belt_casing");
    public static final SpriteShiftEntry CYAN_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/cyan_belt_casing");
    public static final SpriteShiftEntry RGB_BELT_CASING = getFromCreate("block/belt/brass_belt_casing", "block/rgb_belt_casing");

    //BRASS
    public static final SpriteShiftEntry LIGHT_GRAY_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/light_gray_belt_brass_casing");
    public static final SpriteShiftEntry RED_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/red_brass_belt_casing");
    public static final SpriteShiftEntry GRAY_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/gray_brass_belt_casing");
    public static final SpriteShiftEntry BLACK_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/black_brass_belt_casing");
    public static final SpriteShiftEntry WHITE_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/white_brass_belt_casing");
    public static final SpriteShiftEntry LIGHT_BLUE_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/light_blue_belt_brass_casing");
    public static final SpriteShiftEntry BLUE_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/blue_brass_belt_casing");
    public static final SpriteShiftEntry YELLOW_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/yellow_brass_belt_casing");
    public static final SpriteShiftEntry GREEN_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/green_brass_belt_casing");
    public static final SpriteShiftEntry PURPLE_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/purple_brass_belt_casing");
    public static final SpriteShiftEntry ORANGE_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/orange_brass_belt_casing");
    public static final SpriteShiftEntry PINK_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/pink_brass_belt_casing");
    public static final SpriteShiftEntry BROWN_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/brown_brass_belt_casing");
    public static final SpriteShiftEntry MAGENTA_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/magenta_brass_belt_casing");
    public static final SpriteShiftEntry LIME_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/lime_brass_belt_casing");
    public static final SpriteShiftEntry CYAN_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/cyan_brass_belt_casing");
    public static final SpriteShiftEntry RGB_BELT_BRASS_CASING = getFromCreate("block/belt/brass_belt_casing", "block/rgb_brass_belt_casing");



    public static final CTSpriteShiftEntry RED_CASING = omni( "red_casing"),
            RED_ENCASED_COGWHEEL_SIDE = vertical( "red_encased_cogwheel_side"),
            RED_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "red_encased_cogwheel_side");

    public static final CTSpriteShiftEntry WHITE_CASING = omni( "white_casing"),
            WHITE_ENCASED_COGWHEEL_SIDE = vertical( "white_encased_cogwheel_side"),
            WHITE_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "white_encased_cogwheel_side");

    public static final CTSpriteShiftEntry BLACK_CASING = omni( "black_casing"),
            BLACK_ENCASED_COGWHEEL_SIDE = vertical( "black_encased_cogwheel_side"),
            BLACK_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "black_encased_cogwheel_side");

    public static final CTSpriteShiftEntry GRAY_CASING = omni( "gray_casing"),
            GRAY_ENCASED_COGWHEEL_SIDE = vertical( "gray_encased_cogwheel_side"),
            GRAY_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "gray_encased_cogwheel_side");

    public static final CTSpriteShiftEntry LIGHT_GRAY_CASING = omni("light_gray_casing"),
            LIGHT_GRAY_ENCASED_COGWHEEL_SIDE = vertical("light_gray_encased_cogwheel_side"),
            LIGHT_GRAY_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "light_gray_encased_cogwheel_side");

    public static final CTSpriteShiftEntry LIGHT_BLUE_CASING = omni( "light_blue_casing"),
            LIGHT_BLUE_ENCASED_COGWHEEL_SIDE = vertical("light_blue_encased_cogwheel_side"),
            LIGHT_BLUE_ENCASED_COGWHEEL_OTHERSIDE = horizontal("light_blue_encased_cogwheel_side");

    public static final CTSpriteShiftEntry GREEN_CASING = omni( "green_casing"),
            GREEN_ENCASED_COGWHEEL_SIDE = vertical(  "green_encased_cogwheel_side"),
            GREEN_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "green_encased_cogwheel_side");

    public static final CTSpriteShiftEntry LIME_CASING = omni( "lime_casing"),
            LIME_ENCASED_COGWHEEL_SIDE = vertical(  "lime_encased_cogwheel_side"),
            LIME_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "lime_encased_cogwheel_side");

    public static final CTSpriteShiftEntry CYAN_CASING = omni( "cyan_casing"),
            CYAN_ENCASED_COGWHEEL_SIDE = vertical(  "cyan_encased_cogwheel_side"),
            CYAN_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "cyan_encased_cogwheel_side");

    public static final CTSpriteShiftEntry BROWN_CASING = omni( "brown_casing"),
            BROWN_ENCASED_COGWHEEL_SIDE = vertical(  "brown_encased_cogwheel_side"),
            BROWN_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "brown_encased_cogwheel_side");

    public static final CTSpriteShiftEntry BLUE_CASING = omni( "blue_casing"),
            BLUE_ENCASED_COGWHEEL_SIDE = vertical( "blue_encased_cogwheel_side"),
            BLUE_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "blue_encased_cogwheel_side");

    public static final CTSpriteShiftEntry ORANGE_CASING = omni( "orange_casing"),
            ORANGE_ENCASED_COGWHEEL_SIDE = vertical(  "orange_encased_cogwheel_side"),
            ORANGE_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "orange_encased_cogwheel_side");

    public static final CTSpriteShiftEntry YELLOW_CASING = omni( "yellow_casing"),
            YELLOW_ENCASED_COGWHEEL_SIDE = vertical(  "yellow_encased_cogwheel_side"),
            YELLOW_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "yellow_encased_cogwheel_side");

    public static final CTSpriteShiftEntry PINK_CASING = omni( "pink_casing"),
            PINK_ENCASED_COGWHEEL_SIDE = vertical(  "pink_encased_cogwheel_side"),
            PINK_ENCASED_COGWHEEL_OTHERSIDE = horizontal("pink_encased_cogwheel_side");

    public static final CTSpriteShiftEntry MAGENTA_CASING = omni( "magenta_casing"),
            MAGENTA_ENCASED_COGWHEEL_SIDE = vertical("magenta_encased_cogwheel_side"),
            MAGENTA_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "magenta_encased_cogwheel_side");

    public static final CTSpriteShiftEntry PURPLE_CASING = omni( "purple_casing"),
            PURPLE_ENCASED_COGWHEEL_SIDE = vertical(  "purple_encased_cogwheel_side"),
            PURPLE_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "purple_encased_cogwheel_side");

    public static final CTSpriteShiftEntry RGB_CASING = omni( "rgb_casing"),
            RGB_ENCASED_COGWHEEL_SIDE = vertical(  "rgb_encased_cogwheel_side"),
            RGB_ENCASED_COGWHEEL_OTHERSIDE = horizontal( "rgb_encased_cogwheel_side");


    public static final CTSpriteShiftEntry RED_BRASS_CASING = getCT(OMNIDIRECTIONAL, "red_brass_casing"),
            RED_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "red_brass_encased_cogwheel_side"),
            RED_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "red_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry WHITE_BRASS_CASING = getCT(OMNIDIRECTIONAL, "white_brass_casing"),
            WHITE_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "white_brass_encased_cogwheel_side"),
            WHITE_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "white_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry BLACK_BRASS_CASING = getCT(OMNIDIRECTIONAL, "black_brass_casing"),
            BLACK_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "black_brass_encased_cogwheel_side"),
            BLACK_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "black_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry GRAY_BRASS_CASING = getCT(OMNIDIRECTIONAL, "gray_brass_casing"),
            GRAY_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "gray_brass_encased_cogwheel_side"),
            GRAY_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "gray_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry LIGHT_GRAY_BRASS_CASING = getCT(OMNIDIRECTIONAL, "light_gray_brass_casing"),
            LIGHT_GRAY_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "light_gray_brass_encased_cogwheel_side"),
            LIGHT_GRAY_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "light_gray_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry LIGHT_BLUE_BRASS_CASING = getCT(OMNIDIRECTIONAL, "light_blue_brass_casing"),
            LIGHT_BLUE_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "light_blue_brass_encased_cogwheel_side"),
            LIGHT_BLUE_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "light_blue_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry GREEN_BRASS_CASING = getCT(OMNIDIRECTIONAL, "green_brass_casing"),
            GREEN_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "green_brass_encased_cogwheel_side"),
            GREEN_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "green_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry LIME_BRASS_CASING = getCT(OMNIDIRECTIONAL, "lime_brass_casing"),
            LIME_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "lime_brass_encased_cogwheel_side"),
            LIME_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "lime_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry CYAN_BRASS_CASING = getCT(OMNIDIRECTIONAL, "cyan_brass_casing"),
            CYAN_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "cyan_brass_encased_cogwheel_side"),
            CYAN_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "cyan_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry BROWN_BRASS_CASING = getCT(OMNIDIRECTIONAL, "brown_brass_casing"),
            BROWN_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "brown_brass_encased_cogwheel_side"),
            BROWN_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "brown_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry BLUE_BRASS_CASING = getCT(OMNIDIRECTIONAL, "blue_brass_casing"),
            BLUE_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "blue_brass_encased_cogwheel_side"),
            BLUE_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "blue_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry ORANGE_BRASS_CASING = getCT(OMNIDIRECTIONAL, "orange_brass_casing"),
            ORANGE_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "orange_brass_encased_cogwheel_side"),
            ORANGE_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "orange_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry YELLOW_BRASS_CASING = getCT(OMNIDIRECTIONAL, "yellow_brass_casing"),
            YELLOW_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "yellow_brass_encased_cogwheel_side"),
            YELLOW_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "yellow_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry PINK_BRASS_CASING = getCT(OMNIDIRECTIONAL, "pink_brass_casing"),
            PINK_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "pink_brass_encased_cogwheel_side"),
            PINK_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "pink_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry MAGENTA_BRASS_CASING = getCT(OMNIDIRECTIONAL, "magenta_brass_casing"),
            MAGENTA_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "magenta_brass_encased_cogwheel_side"),
            MAGENTA_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "magenta_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry PURPLE_BRASS_CASING = getCT(OMNIDIRECTIONAL, "purple_brass_casing"),
            PURPLE_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "purple_brass_encased_cogwheel_side"),
            PURPLE_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "purple_brass_encased_cogwheel_side");

    public static final CTSpriteShiftEntry RGB_BRASS_CASING = getCT(OMNIDIRECTIONAL, "rgb_brass_casing"),
            RGB_BRASS_ENCASED_COGWHEEL_SIDE = getCT(VERTICAL, "rgb_brass_encased_cogwheel_side"),
            RGB_BRASS_ENCASED_COGWHEEL_OTHERSIDE = getCT(HORIZONTAL, "rgb_brass_encased_cogwheel_side");

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    private static CTSpriteShiftEntry getSideSprite(String id) {
        return switch (id) {
            case "red_brass" -> CECSpriteShifts.RED_BRASS_ENCASED_COGWHEEL_SIDE;
            case "white_brass" -> CECSpriteShifts.WHITE_BRASS_ENCASED_COGWHEEL_SIDE;
            case "black_brass" -> CECSpriteShifts.BLACK_BRASS_ENCASED_COGWHEEL_SIDE;
            case "gray_brass" -> CECSpriteShifts.GRAY_BRASS_ENCASED_COGWHEEL_SIDE;
            case "light_gray_brass" -> CECSpriteShifts.LIGHT_GRAY_BRASS_ENCASED_COGWHEEL_SIDE;
            case "blue_brass" -> CECSpriteShifts.BLUE_BRASS_ENCASED_COGWHEEL_SIDE;
            case "light_blue_brass" -> CECSpriteShifts.LIGHT_BLUE_BRASS_ENCASED_COGWHEEL_SIDE;
            case "green_brass" -> CECSpriteShifts.GREEN_BRASS_ENCASED_COGWHEEL_SIDE;
            case "lime_brass" -> CECSpriteShifts.LIME_BRASS_ENCASED_COGWHEEL_SIDE;
            case "cyan_brass" -> CECSpriteShifts.CYAN_BRASS_ENCASED_COGWHEEL_SIDE;
            case "brown_brass" -> CECSpriteShifts.BROWN_BRASS_ENCASED_COGWHEEL_SIDE;
            case "orange_brass" -> CECSpriteShifts.ORANGE_BRASS_ENCASED_COGWHEEL_SIDE;
            case "yellow_brass" -> CECSpriteShifts.YELLOW_BRASS_ENCASED_COGWHEEL_SIDE;
            case "magenta_brass" -> CECSpriteShifts.MAGENTA_BRASS_ENCASED_COGWHEEL_SIDE;
            case "pink_brass" -> CECSpriteShifts.PINK_BRASS_ENCASED_COGWHEEL_SIDE;
            case "purple_brass" -> CECSpriteShifts.PURPLE_BRASS_ENCASED_COGWHEEL_SIDE;
            case "rgb_brass" -> CECSpriteShifts.RGB_BRASS_ENCASED_COGWHEEL_SIDE;
            // Add more colors here if needed
            default -> null;
        };
    }

    private static CTSpriteShiftEntry getOtherSideSprite(String id) {
        return switch (id) {
            case "red_brass" -> CECSpriteShifts.RED_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "white_brass" -> CECSpriteShifts.WHITE_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "black_brass" -> CECSpriteShifts.BLACK_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "gray_brass" -> CECSpriteShifts.GRAY_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "light_gray_brass" -> CECSpriteShifts.LIGHT_GRAY_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "blue_brass" -> CECSpriteShifts.BLUE_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "light_blue_brass" -> CECSpriteShifts.LIGHT_BLUE_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "green_brass" -> CECSpriteShifts.GREEN_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "lime_brass" -> CECSpriteShifts.LIME_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "cyan_brass" -> CECSpriteShifts.CYAN_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "brown_brass" -> CECSpriteShifts.BROWN_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "orange_brass" -> CECSpriteShifts.ORANGE_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "yellow_brass" -> CECSpriteShifts.YELLOW_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "magenta_brass" -> CECSpriteShifts.MAGENTA_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "pink_brass" -> CECSpriteShifts.PINK_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "purple_brass" -> CECSpriteShifts.PURPLE_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            case "rgb_brass" -> CECSpriteShifts.RGB_BRASS_ENCASED_COGWHEEL_OTHERSIDE;
            // Add more colors here if needed
            default -> null;
        };
    }

    public static Couple<CTSpriteShiftEntry> getCogwheelSides(String id) {
        return Couple.create(getSideSprite(id), getOtherSideSprite(id));
    }
    /// //////////////////////////////////////////////////////////////////////////////////




    private static CTSpriteShiftEntry horizontal(String name) {
        return getCT(AllCTTypes.HORIZONTAL, name);
    }

    private static CTSpriteShiftEntry vertical(String name) {
        return getCT(AllCTTypes.VERTICAL, name);
    }
    private static CTSpriteShiftEntry omni(String name) {
        return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
    }

    private static SpriteShiftEntry get(String originalLocation, String targetLocation) {
        return SpriteShifter.get
                (CEC.asResource(originalLocation),
                CEC.asResource(targetLocation));
    }

    private static SpriteShiftEntry getFromCreate(String originalLocation, String targetLocation) {
        return SpriteShifter.get(Create.asResource(originalLocation), CEC.asResource(targetLocation));
    }
    private static SpriteShiftEntry getFromCreate(String location) {
        return SpriteShifter.get(Create.asResource(location), CEC.asResource(location));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type,
                CEC.asResource("block/" + blockTextureName),
                CEC.asResource("block/" + connectedTextureName + "_connected"));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }


}
