package net.fabricmc.example.Item.weapons;

import net.fabricmc.example.ExampleMod;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class watch_sword implements ToolMaterial {    //手表剑基本设置
    public static final watch_sword INSTANCE = new watch_sword();
    @Override
    public int getDurability() {   //耐久度
        return 1145;
    }

    @Override
    public float getMiningSpeedMultiplier() {   //挖掘速度
        return 2.5f;
    }

    @Override
    public float getAttackDamage() {    //攻击基础伤害
        return 13;
    }

    @Override
    public int getMiningLevel() {    //挖掘等级
        return 1;
    }

    @Override
    public int getEnchantability() {     //附魔能力等级
        return 16;
    }

    @Override
    public Ingredient getRepairIngredient() {    //修补材料
        return Ingredient.ofItems(ExampleMod.WATCH_PIECE);  //(手表碎片）
    }
}
