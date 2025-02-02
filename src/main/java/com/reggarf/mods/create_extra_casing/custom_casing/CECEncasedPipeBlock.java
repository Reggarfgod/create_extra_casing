package com.reggarf.mods.create_extra_casing.custom_casing;

import com.reggarf.mods.create_extra_casing.registry.CECBlockEntityTypes;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;


/*
This class allow to use the constructore of EncasedPipeBlock from the create code
 */
public class CECEncasedPipeBlock extends com.simibubi.create.content.fluids.pipes.EncasedPipeBlock {


	public CECEncasedPipeBlock(Properties properties, Supplier<Block> casing) {
		super(properties,casing);
	}

	@Override
	public BlockEntityType<? extends FluidPipeBlockEntity> getBlockEntityType() {
		return CECBlockEntityTypes.ENCASED_FLUID_PIPE.get();
	}

}