package net.fabricmc.example.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class Sounds {
    public static final SoundEvent CXK_MUSIC = Registry.register(Registries.SOUND_EVENT, new Identifier("modid", "music_disc.cxk_music"), SoundEvent.of(new Identifier("modid", "cxk_music")));
}
