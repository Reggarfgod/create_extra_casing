package com.reggarf.mods.create_extra_casing.ponder;


import com.reggarf.mods.create_extra_casing.block.CECEncasedCogwheelBlock;
import com.reggarf.mods.create_extra_casing.block.CECEncasedShaftBlock;
import com.reggarf.mods.create_extra_casing.registry.CECBlocks;
import com.simibubi.create.foundation.ponder.*;
import com.simibubi.create.foundation.ponder.element.InputWindowElement;
import com.simibubi.create.foundation.ponder.element.WorldSectionElement;
import com.simibubi.create.foundation.utility.Pointing;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.Vec3i;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class CECEncasingPonder {
    public static void ExtraCasingShaftEncasing(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("shaft_extra_casing", "Encasing Shafts with Extra casings");
        scene.configureBasePlate(0, 0, 5);
        scene.world.showSection(util.select.layer(0), Direction.UP);

        Selection shaft = util.select.cuboid(new BlockPos(0, 1, 2), new Vec3i(5, 0, 2));
        Selection red = util.select.position(3, 1, 2);
        Selection black = util.select.position(1, 1, 2);

        scene.world.showSection(shaft, Direction.DOWN);
        scene.idle(20);

        BlockEntry<CECEncasedShaftBlock> redEncased = CECBlocks.RED_ENCASED_SHAFT;
        ItemStack redCasingItem = CECBlocks.RED_CASING.asStack();

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(3, 1, 2), Pointing.DOWN).rightClick()
                .withItem(redCasingItem), 60);
        scene.idle(7);
        scene.world.setBlocks(red, redEncased.getDefaultState()
                .setValue(CECEncasedShaftBlock.AXIS, Axis.X), true);
        scene.world.setKineticSpeed(shaft, 32);
        scene.idle(10);

        BlockEntry<CECEncasedShaftBlock> orangeEncased = CECBlocks.ORANGE_ENCASED_SHAFT;
        ItemStack orangeCasingItem = CECBlocks.ORANGE_CASING.asStack();

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(1, 0, 2), Pointing.UP).rightClick()
                .withItem(orangeCasingItem), 60);
        scene.idle(7);
        scene.world.setBlocks(black, orangeEncased.getDefaultState()
                .setValue(CECEncasedShaftBlock.AXIS, Axis.X), true);
        scene.world.setKineticSpeed(shaft, 32);

        scene.idle(10);
        scene.overlay.showText(100)
                .placeNearTarget()
                .text("All Colored Casings can be used to decorate Shafts")
                .pointAt(util.vector.topOf(1, 1, 2));
        scene.idle(70);
    }

    public static void ExtraCasingCogEncasing(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("cogwheel_extra_casing", "Encasing Cogwheels with Extra Casings");
        scene.configureBasePlate(0, 0, 5);
        scene.world.showSection(util.select.layer(0), Direction.UP);

        Selection large1 = util.select.position(4, 1, 3);
        Selection small1 = util.select.fromTo(3, 1, 2, 3, 2, 2);
        Selection small2 = util.select.position(2, 1, 2);
        Selection large2 = util.select.fromTo(1, 1, 3, 1, 1, 4);
        Selection shaft2 = util.select.position(2, 2, 2);

        scene.world.setKineticSpeed(shaft2, 0);
        scene.idle(10);

        scene.world.showSection(large1, Direction.DOWN);
        scene.idle(5);
        scene.world.showSection(small1, Direction.DOWN);
        scene.world.showSection(small2, Direction.DOWN);
        scene.idle(5);
        scene.world.showSection(large2, Direction.EAST);
        scene.idle(20);

        BlockEntry<CECEncasedCogwheelBlock> cyanEncased = CECBlocks.CYAN_ENCASED_COGWHEEL;
        ItemStack cyanCasingItem = CECBlocks.CYAN_CASING.asStack();

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(3, 0, 2), Pointing.UP).rightClick()
                .withItem(cyanCasingItem), 100);
        scene.idle(7);
        scene.world.setBlocks(util.select.position(3, 1, 2), cyanEncased.getDefaultState()
                .setValue(CECEncasedCogwheelBlock.AXIS, Axis.Y)
                .setValue(CECEncasedCogwheelBlock.TOP_SHAFT, true), true);
        scene.world.setKineticSpeed(util.select.position(3, 1, 2), -32);
        scene.idle(15);

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(2, 1, 2), Pointing.DOWN).rightClick()
                .withItem(cyanCasingItem), 30);
        scene.idle(7);
        scene.world.setBlocks(small2, cyanEncased.getDefaultState()
                .setValue(CECEncasedCogwheelBlock.AXIS, Axis.Y), true);
        scene.world.setKineticSpeed(small2, 32);
        scene.idle(15);

        BlockEntry<CECEncasedCogwheelBlock> orangeEncased = CECBlocks.ORANGE_ENCASED_LARGE_COGWHEEL;
        ItemStack orangeCasingItem = CECBlocks.ORANGE_CASING.asStack();

        scene.overlay.showControls(new InputWindowElement(util.vector.topOf(1, 0, 3), Pointing.UP).rightClick()
                .withItem(orangeCasingItem), 60);
        scene.idle(7);
        scene.world.setBlocks(util.select.position(1, 1, 3), orangeEncased.getDefaultState()
                .setValue(CECEncasedCogwheelBlock.AXIS, Axis.Y), true);
        scene.world.setKineticSpeed(util.select.position(1, 1, 3), -16);

        scene.idle(10);
        scene.overlay.showText(70)
                .placeNearTarget()
                .attachKeyFrame()
                .text("Extra Casings can be used to decorate Cogwheels")
                .pointAt(util.vector.topOf(1, 1, 3));
        scene.idle(80);

        ElementLink<WorldSectionElement> shaftLink = scene.world.showIndependentSection(shaft2, Direction.DOWN);
        scene.idle(15);
        scene.overlay.showText(90)
                .placeNearTarget()
                .colored(PonderPalette.RED)
                .attachKeyFrame()
                .text("Components added after encasing will not connect to the shaft outputs")
                .pointAt(util.vector.centerOf(2, 2, 2));
        scene.idle(90);

        scene.world.moveSection(shaftLink, new Vec3(0, .5f, 0), 10);
        scene.idle(10);

        scene.addKeyframe();
        Vec3 wrenchHere = util.vector.topOf(2, 1, 2)
                .add(.25, 0, -.25);
        scene.overlay.showControls(new InputWindowElement(wrenchHere, Pointing.RIGHT).rightClick()
                .withWrench(), 25);
        scene.idle(7);
        scene.world.cycleBlockProperty(util.grid.at(2, 1, 2), CECEncasedCogwheelBlock.TOP_SHAFT);
        scene.idle(15);
        scene.world.moveSection(shaftLink, new Vec3(0, -.5f, 0), 10);
        scene.idle(10);
        scene.world.setKineticSpeed(shaft2, 32);
        scene.effects.rotationDirectionIndicator(util.grid.at(2, 2, 2));
        scene.idle(20);

        scene.overlay.showText(90)
                .placeNearTarget()
                .colored(PonderPalette.GREEN)
                .text("The Wrench can be used to toggle connections")
                .pointAt(wrenchHere.add(-.5, 0, .5));
        scene.idle(40);

        scene.overlay.showControls(new InputWindowElement(wrenchHere, Pointing.RIGHT).rightClick()
                .withWrench(), 25);
        scene.idle(7);
        scene.world.cycleBlockProperty(util.grid.at(2, 1, 2), CECEncasedCogwheelBlock.TOP_SHAFT);
        scene.world.setKineticSpeed(shaft2, 0);
    }
}
