package net.fabricmc.example.Item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class Item {
    //Food Items
    public static final FoodComponent WATCH = new  FoodComponent.Builder().hunger(9).saturationModifier(1.3f).build();
    public static final FoodComponent ENCH_GOLD_WATCH = new FoodComponent.Builder().hunger(9).saturationModifier(1.5f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 1), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 6000, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 0), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 3), 1.0f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,400,5),1.0f).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,100,255),1.0f).alwaysEdible().build();
    public static final FoodComponent SHOU_ZE = new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,200,3),0.99f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER,500,0),1.0f).alwaysEdible().build();

}
