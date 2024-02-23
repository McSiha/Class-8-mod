package net.fabricmc.example.Enchant;

import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.effects.BLOOD;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class Bleeding_blade extends Enchantment {
    public Bleeding_blade() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

@Override
public int getMinPower(int level) {
    return 1;
}

@Override
public void onTargetDamaged(LivingEntity user, Entity target, int level) {
if(user instanceof PlayerEntity player && target instanceof LivingEntity entity){
if(!player.getWorld().isClient()) {
ServerWorld world = (ServerWorld) player.getWorld();
((LivingEntity) target).addStatusEffect(new StatusEffectInstance(ExampleMod.BLOOD, 45 * 2 * level, level  * 3));
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}
