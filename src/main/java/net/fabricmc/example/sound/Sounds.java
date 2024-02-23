package net.fabricmc.example.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Sounds{
    public static final Identifier MY_SOUND_ID = new Identifier("modid:music_disc.cxk_music");
    public static SoundEvent CXK_MUSIC = SoundEvent.of(MY_SOUND_ID);
}
