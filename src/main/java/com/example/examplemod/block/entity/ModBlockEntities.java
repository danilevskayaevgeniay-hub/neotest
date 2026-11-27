package com.example.examplemod.block.entity;

import com.example.examplemod.ExampleMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(
                    Registries.BLOCK_ENTITY_TYPE,
                    ExampleMod.MODID
            );

    public static final DeferredHolder<
            BlockEntityType<?>,
            BlockEntityType<AlchemyTableBlockEntity>
            > ALCHEMY_TABLE_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register(
                    "alchemy_table",
                    () -> BlockEntityType.Builder.of(
                            AlchemyTableBlockEntity::new,
                            ExampleMod.ALCHEMY_TABLE.get()
                    ).build(null)
            );

    private ModBlockEntities() {
    }
}
