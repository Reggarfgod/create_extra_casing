package com.reggarf.mods.create_extra_casing.custom_casing;


import com.reggarf.mods.create_extra_casing.registry.CECBlockEntityTypes;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;


/*
This class allow to use the constructore of EncasedShaftBlock from the create code
 */
public class CECEncasedShaftBlock extends com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock {

	public CECEncasedShaftBlock(Properties properties, Supplier<Block> casing) {
		super(properties, casing);
	}

	@Override
	public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
		return CECBlockEntityTypes.ENCASED_SHAFT.get();
	}
}