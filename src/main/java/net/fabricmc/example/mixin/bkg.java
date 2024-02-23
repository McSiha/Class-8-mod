package net.fabricmc.example.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.CubeMapRenderer;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RotatingCubeMapRenderer.class)
public class bkg {   //(Background Mixin
    @Shadow @Final private MinecraftClient client;

    @Shadow private float pitch;

    @Shadow private float yaw;

    @Shadow @Final private CubeMapRenderer cubeMap;

    private static float wrap(float a, float b) {
        return a > b ? a - b : a;
    }
    //wrapOnce(this.pitch + f * 0.1f, 360.0f
    //this.yaw + f * 0.001f, (float)Math.PI * 2)
    /**
     * @author Minecraft_Siha
     * @reason Stop Rotate_Background
     */
    @Overwrite
    public void render(float delta, float alpha) {
        float f = (float)((double)delta * this.client.options.getPanoramaSpeed().getValue());
        this.pitch = 0.0f;
        this.yaw = 0.0f;
        this.cubeMap.draw(this.client, MathHelper.sin(this.yaw) * 5.0f + 25.0f, -this.pitch, alpha);
    }
}
