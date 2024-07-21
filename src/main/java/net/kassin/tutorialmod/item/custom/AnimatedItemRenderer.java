package net.kassin.tutorialmod.item.custom;

import net.kassin.tutorialmod.TutorialMod;
import net.kassin.tutorialmod.item.client.AnimatedItemModel;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedItemRenderer extends GeoItemRenderer<AnimatedItem> {
    public AnimatedItemRenderer() {
        super(new AnimatedItemModel());
        System.out.println("CRIOU O CONSTRUCTOR");
    }

}
