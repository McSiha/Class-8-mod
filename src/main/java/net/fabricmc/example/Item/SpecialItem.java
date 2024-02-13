package net.fabricmc.example.Item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SpecialItem extends Item {
    public SpecialItem(Settings settings){
        super(settings);

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        SaySomeThings(user);

        user.getItemCooldownManager().set(this, 8);
        return super.use(world, user, hand);
    }
    private void SaySomeThings(PlayerEntity user){
        user.sendMessage(Text.literal("Whats Up"));
    }
}
