package net.fabricmc.example.Item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchGoldenWatch extends Item {
    public EnchGoldenWatch(Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
