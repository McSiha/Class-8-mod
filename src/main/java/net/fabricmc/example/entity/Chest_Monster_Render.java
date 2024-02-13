package net.fabricmc.example.entity;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MagmaCubeEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.MagmaCubeEntityModel;
import net.minecraft.util.Identifier;

public class Chest_Monster_Render extends MobEntityRenderer<Chest_Monster, Chest_Monster_Model> {
    public Chest_Monster_Render(EntityRendererFactory.Context context) {
        super(context, new Chest_Monster_Model(context.getPart(EntityRunningClient.MODEL_CUBE_LAYER)), 0.5f);
    }
    @Override
    public Identifier getTexture(Chest_Monster entity) {
        return new Identifier("modid", "textures/entity/chest_monster/chest_monster.png");
    }
}
