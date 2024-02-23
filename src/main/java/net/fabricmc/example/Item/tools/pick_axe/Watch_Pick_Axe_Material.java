package net.fabricmc.example.Item.tools.pick_axe;

import net.fabricmc.example.ExampleMod;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class Watch_Pick_Axe_Material implements ToolMaterial {
    public static final Watch_Pick_Axe_Material INSTANCE = new Watch_Pick_Axe_Material();
    @Override
    public int getDurability() {
        return 1145;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 14.0f;
    }

    @Override
    public float getAttackDamage() {
        return 2;
    }

    @Override
    public int getMiningLevel() {
        return 24;
    }

    @Override
    public int getEnchantability() {
        return 24;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ExampleMod.WATCH_PIECE);
    }
}
