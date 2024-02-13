package net.fabricmc.example.world.dimension;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class WatchWorld {
    public static final RegistryKey<World> TUTORIAL_DIMENSION_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier("modid","watch_world"));
    public static final RegistryKey<DimensionType> TUTORIAL_DIMENSION_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier("modid","watch_world"));
}
