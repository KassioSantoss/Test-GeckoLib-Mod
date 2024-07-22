package net.kassin.tutorialmod.item.custom;

import net.kassin.tutorialmod.item.client.AnimatedItemModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedItemRenderer extends GeoItemRenderer<AnimatedItem> {
    public AnimatedItemRenderer() {
        super(new AnimatedItemModel());
    }
}
