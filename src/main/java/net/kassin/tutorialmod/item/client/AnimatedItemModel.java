package net.kassin.tutorialmod.item.client;

import net.kassin.tutorialmod.TutorialMod;
import net.kassin.tutorialmod.item.custom.AnimatedItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedItemModel extends GeoModel<AnimatedItem> {

    public AnimatedItemModel() {
        System.out.println("AnimatedItemModel.class");
    }

    @Override
    public ResourceLocation getModelResource(AnimatedItem animatedItem) {
        System.out.println("COLOCANDO MODELO NO JOGO");
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/item/water_gun.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedItem animatedItem) {
        System.out.println("COLOCANDO TEXTURA NO JOGO");
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/item/water_gun.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedItem animatedItem) {
        return null;
    }

}
