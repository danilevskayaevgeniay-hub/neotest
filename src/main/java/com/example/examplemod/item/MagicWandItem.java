package com.example.examplemod.item;

import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MagicWandItem extends Item{
  public MagicWandItem(Item.Properties properties) {
    super(properties);
  }
  @Override
  public InteractionResultHolder<ItemStack> use(
        Level level,
        Player player,
        InteractionHand hand
) {
ItemStack stack = player.getItemInHand(hand);
    if (!level.IsClientSide) {
      pllayer.sendSystemMessage(
        Component.literal("Magic Works")
      );
    }
return InteractionResultHolder.succes(stack);
}
}
