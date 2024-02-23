package net.fabricmc.example.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.SharedConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.CubeMapRenderer;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.LogoDrawer;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.realms.gui.screen.RealmsNotificationsScreen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mixin(TitleScreen.class)
public abstract class MainMenu {
    @Mutable
    @Shadow @Final public static Text COPYRIGHT;

    @Shadow @Final private static Identifier PANORAMA_OVERLAY;

    @Mutable
    @Shadow @Final private RotatingCubeMapRenderer backgroundRenderer;

    @Inject(method = "init", at = @At("HEAD"))
    public void init(CallbackInfo ci){
        COPYRIGHT = Text.literal("copyright Mojang AB. Do not distribute!(小迷你所以你在抄什么？)");
    }

    /**
     * @author Minecraft_Siha
     * @reason Change_Background Textures
     */
    @Overwrite
    public static CompletableFuture<Void> loadTexturesAsync(TextureManager textureManager, Executor executor) {
        return CompletableFuture.allOf(textureManager.loadTextureAsync(LogoDrawer.LOGO_TEXTURE, executor), textureManager.loadTextureAsync(LogoDrawer.EDITION_TEXTURE, executor), textureManager.loadTextureAsync(PANORAMA_OVERLAY, executor), new CubeMapRenderer(new Identifier("modid:textures/gui/title/background/panorama")).loadTexturesAsync(textureManager, executor));
    }

    @Inject(method = "render", at = @At(value = "HEAD"))
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        backgroundRenderer = new RotatingCubeMapRenderer(new CubeMapRenderer(new Identifier("modid:textures/gui/title/background/panorama")));
    }




}
