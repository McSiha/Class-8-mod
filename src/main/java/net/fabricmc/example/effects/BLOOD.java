package net.fabricmc.example.effects;

import net.fabricmc.example.ExampleMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import org.apache.logging.slf4j.Log4jLogger;

import java.util.concurrent.TimeUnit;

import static org.joml.Math.floor;

public class BLOOD extends StatusEffect {
    public BLOOD() {
        super(
                StatusEffectCategory.HARMFUL, 0xDC143C); // 显示的颜色

    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        double hurt = amplifier / 8.5f;
        int count = amplifier * 2;
        entity.damage(entity.getDamageSources().magic(), (float) hurt);
        ExampleMod.LOGGER.info("Blood down");
    }
}
