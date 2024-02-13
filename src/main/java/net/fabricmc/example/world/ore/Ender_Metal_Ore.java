package net.fabricmc.example.world.ore;

import net.minecraft.block.Blocks;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.Arrays;

public class Ender_Metal_Ore {
    public static ConfiguredFeature<?,?> ENDER_METAL_ORE = new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(
            new BlockMatchRuleTest(Blocks.END_STONE), Blocks.DIAMOND_BLOCK.getDefaultState(), 9
    ));
    public static PlacedFeature END_METAL_ORE_FEATURE = new PlacedFeature(
            RegistryEntry.of(ENDER_METAL_ORE),
            Arrays.asList(
                    CountPlacementModifier.of(8),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))));
}
