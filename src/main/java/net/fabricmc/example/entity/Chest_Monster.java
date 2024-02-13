package net.fabricmc.example.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class Chest_Monster extends HostileEntity {
    public Chest_Monster(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void setHealth(float health) {
        super.setHealth(24.0f);
    }
}
