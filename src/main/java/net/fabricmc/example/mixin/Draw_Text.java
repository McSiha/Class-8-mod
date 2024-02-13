package net.fabricmc.example.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class Draw_Text {
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;enableBlend()V", ordinal = 3))
    private void render(MatrixStack matrices, float tickDelta, CallbackInfo ci){
        MinecraftClient.getInstance().textRenderer.draw(matrices, "手表虫且，归位！！！！各位八班佬们，给我离了！！！", 0, 0, 0xDC143C);
    }
}
