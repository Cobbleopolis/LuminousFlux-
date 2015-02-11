package com.cobbleopolis.luminousflux.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelLuminousLamp - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ModelLuminousLamp extends ModelBase {
    public ModelRenderer bottom;
    public ModelRenderer pillar1;
    public ModelRenderer pillar2;
    public ModelRenderer pillar3;
    public ModelRenderer pillar4;
    public ModelRenderer top;
    public ModelRenderer top2;
    public ModelRenderer top3;
    public ModelRenderer center;

    public ModelLuminousLamp() {
        this.textureWidth = 36;
        this.textureHeight = 32;
        this.top = new ModelRenderer(this, 0, 0);
        this.top.setRotationPoint(-4.0F, 12.0F, -4.0F);
        this.top.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F);
        this.top3 = new ModelRenderer(this, 0, 16);
        this.top3.setRotationPoint(-2.0F, 10.0F, -2.0F);
        this.top3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
        this.pillar4 = new ModelRenderer(this, 32, 0);
        this.pillar4.setRotationPoint(-4.0F, 13.0F, 3.0F);
        this.pillar4.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
        this.pillar3 = new ModelRenderer(this, 32, 0);
        this.pillar3.setRotationPoint(3.0F, 13.0F, 3.0F);
        this.pillar3.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
        this.pillar2 = new ModelRenderer(this, 32, 0);
        this.pillar2.setRotationPoint(-4.0F, 13.0F, -4.0F);
        this.pillar2.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
        this.center = new ModelRenderer(this, 10, 16);
        this.center.setRotationPoint(-3.0F, 13.0F, -3.0F);
        this.center.addBox(0.0F, 0.0F, 0.0F, 6, 10, 6, 0.0F);
        this.top2 = new ModelRenderer(this, 0, 9);
        this.top2.setRotationPoint(-3.0F, 11.0F, -3.0F);
        this.top2.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6, 0.0F);
        this.pillar1 = new ModelRenderer(this, 32, 0);
        this.pillar1.setRotationPoint(3.0F, 13.0F, -4.0F);
        this.pillar1.addBox(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
        this.bottom = new ModelRenderer(this, 0, 0);
        this.bottom.setRotationPoint(-4.0F, 23.0F, -4.0F);
        this.bottom.addBox(0.0F, 0.0F, 0.0F, 8, 1, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.top.render(f5);
        this.top3.render(f5);
        this.pillar4.render(f5);
        this.pillar3.render(f5);
        this.pillar2.render(f5);
        this.center.render(f5);
        this.top2.render(f5);
        this.pillar1.render(f5);
        this.bottom.render(f5);
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
