package net.fabricmc.example.sound;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class music_disc{
   // public static final Item MUSIC_DISC = Registry.register(Registries.ITEM, new Identifier("modid", "music_disc"), new MusicDiscItem(10, Sounds.CXK_MUSIC, new FabricItemSettings().maxCount(1), 144));
    public static final Item MUSIC_DISC_CXK = music_disc.register("music_disc_cxk", (Item)new MusicDiscItem(13, Sounds.CXK_MUSIC, new Item.Settings().maxCount(1).rarity(Rarity.RARE), 144));

    private static Item register(Block block) {
        return music_disc.register(new BlockItem(block, new Item.Settings()));
    }

    private static Item register(Block block, Block ... blocks) {
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        for (Block block2 : blocks) {
            Item.BLOCK_ITEMS.put(block2, blockItem);
        }
        return music_disc.register(blockItem);
    }

    private static Item register(BlockItem item) {
        return music_disc.register(item.getBlock(), (Item)item);
    }

    protected static Item register(Block block, Item item) {
        return music_disc.register(Registries.BLOCK.getId(block), item);
    }

    private static Item register(String id, Item item) {
        return music_disc.register(new Identifier("modid", id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registries.ITEM, id, item);
    }
    public static void regMusicDisc(){
        System.out.println("Reg Music Disc for modid");
    }
}
