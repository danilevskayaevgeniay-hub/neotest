package com.example.examplemod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import com.example.examplemod.ExampleMod;

public class SeaMagicWandItem extends Item {

    public SeaMagicWandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(
            Level level,
            Player player,
            InteractionHand hand
    ) {

        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {

            player.addEffect(
                    new MobEffectInstance(
                            MobEffects.WATER_BREATHING,
                            6000,
                            0
                    )
            );

            if (stack.getDamageValue() + 1 >= stack.getMaxDamage()) {
                player.setItemInHand(hand, new ItemStack(ExampleMod.MAGIC_WAND.get()));
            }
            else{
                stack.setDamageValue(stack.getDamageValue() + 1);
            }

            player.getCooldowns().addCooldown(this, 20);
        }

        return InteractionResultHolder.sidedSuccess(
                stack,
                level.isClientSide()
        );
    }
}

