package com.reggarf.mods.create_extra_casing.block;

import com.reggarf.mods.create_extra_casing.registry.CECBlockEntityTypes;
import com.simibubi.create.content.fluids.pipes.EncasedPipeBlock;
import com.simibubi.create.content.fluids.pipes.FluidPipeBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;


public class CECEncasedPipeBlock extends EncasedPipeBlock {


	public CECEncasedPipeBlock(Properties properties, Supplier<Block> casing) {
		super(properties,casing);
	}

	@Override
	public BlockEntityType<? extends FluidPipeBlockEntity> getBlockEntityType() {
		return CECBlockEntityTypes.ENCASED_FLUID_PIPE.get();
	}

}