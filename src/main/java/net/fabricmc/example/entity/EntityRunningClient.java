package net.fabricmc.example.entity;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.example.ExampleMod;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class EntityRunningClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier("modid", "chest_monster"), "main");
    @Override
    public void onInitializeClient() {
        /*
         * 方块实体渲染器的注册，提供模型、阴影大小和纹理的渲染器。
         *
         * 实体渲染器也可以在实体基于上下文进行渲染前(EndermanEntityRenderer#render). 操作模型。
         */
        EntityRendererRegistry.register(ExampleMod.CHEST_MONSTER, (context) -> {
            return new Chest_Monster_Render(context);
        });
        EntityModelLayerRegistry.registerModelLayer(MODEL_CUBE_LAYER, Chest_Monster_Model::getTexturedModelData);
    }
}
