package com.reggarf.mods.create_extra_casing.ponder;

import com.reggarf.mods.create_extra_casing.registry.CECBlocks;

import com.simibubi.create.infrastructure.ponder.scenes.KineticsScenes;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

public class CECPonderIndex {

	public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {

		PonderSceneRegistrationHelper<ItemProviderEntry<?,?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);
		HELPER.forComponents(CECBlocks.BLACK_CASING,
						CECBlocks.RED_CASING,
						CECBlocks.GRAY_CASING,
						CECBlocks.BLUE_CASING,
						CECBlocks.LIGHT_BLUE_CASING,
						CECBlocks.LIGHT_GRAY_CASING,
						CECBlocks.WHITE_CASING,
						CECBlocks.GREEN_CASING,
						CECBlocks.LIME_CASING,
						CECBlocks.MAGENTA_CASING,
						CECBlocks.PURPLE_CASING,
						CECBlocks.PINK_CASING,
						CECBlocks.BROWN_CASING,
						CECBlocks.YELLOW_CASING,
						CECBlocks.ORANGE_CASING,
						CECBlocks.CYAN_CASING,
						CECBlocks.RGB_CASING,
						//BRASS
						CECBlocks.RED_BRASS_CASING,
						CECBlocks.GRAY_BRASS_CASING,
						CECBlocks.BLUE_BRASS_CASING,
						CECBlocks.LIGHT_BLUE_BRASS_CASING,
						CECBlocks.LIGHT_GRAY_BRASS_CASING,
						CECBlocks.WHITE_BRASS_CASING,
						CECBlocks.GREEN_BRASS_CASING,
						CECBlocks.LIME_BRASS_CASING,
						CECBlocks.MAGENTA_BRASS_CASING,
						CECBlocks.PURPLE_BRASS_CASING,
						CECBlocks.PINK_BRASS_CASING,
						CECBlocks.BROWN_BRASS_CASING,
						CECBlocks.YELLOW_BRASS_CASING,
						CECBlocks.ORANGE_BRASS_CASING,
						CECBlocks.CYAN_BRASS_CASING,
						CECBlocks.RGB_BRASS_CASING,


                        //COPPER

                        CECBlocks.RED_COPPER_CASING,
                        CECBlocks.GRAY_COPPER_CASING,
                        CECBlocks.BLUE_COPPER_CASING,
                        CECBlocks.LIGHT_BLUE_COPPER_CASING,
                        CECBlocks.LIGHT_GRAY_COPPER_CASING,
                        CECBlocks.WHITE_COPPER_CASING,
                        CECBlocks.GREEN_COPPER_CASING,
                        CECBlocks.LIME_COPPER_CASING,
                        CECBlocks.MAGENTA_COPPER_CASING,
                        CECBlocks.PURPLE_COPPER_CASING,
                        CECBlocks.PINK_COPPER_CASING,
                        CECBlocks.BROWN_COPPER_CASING,
                        CECBlocks.YELLOW_COPPER_CASING,
                        CECBlocks.ORANGE_COPPER_CASING,
                        CECBlocks.CYAN_COPPER_CASING,
                        CECBlocks.RGB_COPPER_CASING)


				.addStoryBoard("createextracasing", CECKineticsScenes::shaftsCanBeEncased)
				.addStoryBoard("createextracogcasing", CECKineticsScenes::cogAsRelay)
		        .addStoryBoard("encasing", CECKineticsScenes::beltsCanBeEncased);
				//.addStoryBoard("createextracogcasing", CECKineticsScenes::largeCogAsRelay);
	}


}
