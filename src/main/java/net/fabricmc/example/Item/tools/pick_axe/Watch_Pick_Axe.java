package net.fabricmc.example.Item.tools.pick_axe;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.world.World;

import java.util.ArrayList;

public class Watch_Pick_Axe extends PickaxeItem {

    public Watch_Pick_Axe(int attackDamage, float attackSpeed, Settings settings) {
        super(Watch_Pick_Axe_Material.INSTANCE, attackDamage, attackSpeed, settings);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        boolean silk_touch = false;
        ArrayList Ench = new ArrayList(stack.getEnchantments());
        System.out.println(Ench.toString());
        for(int i = 0;i < Ench.size();i++){
            //if (Ench.get(i) == )

        }

    }
}
