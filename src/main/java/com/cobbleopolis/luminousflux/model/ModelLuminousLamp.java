package com.cobbleopolis.luminousflux.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelLuminousLamp - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelLuminousLamp extends ModelBase {
    public ModelRenderer pillar4;
    public ModelRenderer pillar3;
    public ModelRenderer pillar2;
    public ModelRenderer bottom;
    public ModelRenderer pillar1;
    public ModelRenderer top;
    public ModelRenderer top_connector;

    public ModelLuminousLamp() {
        this.textureWidth = 64;
        this.textureHeight = 35;
        this.bottom = new ModelRenderer(this, 0, 0);
        this.bottom.setRotationPoint(-8.0F, 23.0F, -8.0F);
        this.bottom.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16, 0.0F);
        this.pillar2 = new ModelRenderer(this, 0, 0);
        this.pillar2.setRotationPoint(7.0F, 9.0F, -8.0F);
        this.pillar2.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.top_connector = new ModelRenderer(this, 0, 17);
        this.top_connector.setRotationPoint(-1.0F, -8.0F, -1.0F);
        this.top_connector.addBox(0.0F, 0.0F, 0.0F, 2, 16, 2, 0.0F);
        this.pillar3 = new ModelRenderer(this, 0, 0);
        this.pillar3.setRotationPoint(7.0F, 9.0F, 7.0F);
        this.pillar3.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.pillar4 = new ModelRenderer(this, 0, 0);
        this.pillar4.setRotationPoint(-8.0F, 9.0F, 7.0F);
        this.pillar4.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
        this.top = new ModelRenderer(this, 0, 0);
        this.top.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.top.addBox(0.0F, 0.0F, 0.0F, 16, 1, 16, 0.0F);
        this.pillar1 = new ModelRenderer(this, 0, 0);
        this.pillar1.setRotationPoint(-8.0F, 9.0F, -8.0F);
        this.pillar1.addBox(0.0F, 0.0F, 0.0F, 1, 14, 1, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.bottom.render(f5);
        this.pillar2.render(f5);
//        this.top_connector.render(f5);
        this.pillar3.render(f5);
        this.pillar4.render(f5);
        this.top.render(f5);
        this.pillar1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
