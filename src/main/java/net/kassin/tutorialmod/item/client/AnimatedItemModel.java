package net.kassin.tutorialmod.item.client;

import net.kassin.tutorialmod.TutorialMod;
import net.kassin.tutorialmod.item.custom.AnimatedItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedItemModel extends GeoModel<AnimatedItem> {
    @Override
    public ResourceLocation getModelResource(AnimatedItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/water_gun.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/item/water_gun.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedItem animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/water_gun.animation.json");
    }
}
