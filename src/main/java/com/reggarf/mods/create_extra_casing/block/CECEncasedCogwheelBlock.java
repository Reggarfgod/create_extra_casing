package com.reggarf.mods.create_extra_casing.block;


import com.reggarf.mods.create_extra_casing.registry.CECBlockEntityTypes;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;


public class CECEncasedCogwheelBlock extends EncasedCogwheelBlock {

	public CECEncasedCogwheelBlock(Properties properties, boolean large, Supplier<Block> casing) {
		super(properties, large, casing);
	}

	@Override
	public BlockEntityType<? extends SimpleKineticBlockEntity> getBlockEntityType() {
		return this.isLargeCog() ? CECBlockEntityTypes.ENCASED_LARGE_COGWHEEL.get() : CECBlockEntityTypes.ENCASED_COGWHEEL.get();
	}

}