package com.cobbleopolis.luminousflux.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelLight - Cobbleopolis
 * Created using Tabula 4.1.1
 */
public class ModelLight extends ModelBase {
    public ModelRenderer fixture;
    public ModelRenderer light_bottom;
    public ModelRenderer light_top;

    public ModelLight() {
        this.textureWidth = 28;
        this.textureHeight = 8;
        this.light_bottom = new ModelRenderer(this, 12, 5);
        this.light_bottom.setRotationPoint(-1.0F, 22.0F, -1.0F);
        this.light_bottom.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.fixture = new ModelRenderer(this, 12, 0);
        this.fixture.setRotationPoint(-2.0F, 23.0F, -2.0F);
        this.fixture.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F);
        this.light_top = new ModelRenderer(this, 0, 0);
        this.light_top.setRotationPoint(-1.5F, 19.0F, -1.5F);
        this.light_top.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.light_bottom.render(f5);
        this.fixture.render(f5);
        this.light_top.render(f5);
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
