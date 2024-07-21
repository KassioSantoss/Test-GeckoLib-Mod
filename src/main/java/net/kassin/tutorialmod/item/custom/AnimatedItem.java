package net.kassin.tutorialmod.item.custom;

import net.kassin.tutorialmod.item.client.AnimatedItemModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtils;

import java.util.function.Consumer;

public class AnimatedItem extends Item implements GeoItem {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public AnimatedItem(Properties pProperties, AnimatedItemModelFactory animatedItemModelFactory) {
        super(pProperties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
        System.out.println("Item Criado");
        initializeClient(IClientItemExtensions::getCustomRenderer);

        AnimatedItemModel animatedItemModel = animatedItemModelFactory.create();

        animatedItemModel.getModelResource(this);
        animatedItemModel.getTextureResource(this);
        animatedItemModel.getAnimationResource(this);

    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public double getTick(Object o) {
        return RenderUtils.getCurrentTick();
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        System.out.println("INITIALIZECLIENT");

        consumer.accept(new IClientItemExtensions() {

            private AnimatedItemRenderer renderer;

            static {
                System.out.println("CLASSE ANONIMA");
            }

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {

                System.out.println("ENTROU NO GETCUSTOMRENDERER");

                if (this.renderer == null) {
                    this.renderer = new AnimatedItemRenderer();
                    System.out.println("CRIANDO NOVA INSTANCIA ANIMATEDITEMRENDERER");
                }
                System.out.println("RETORNANDO INSTANCIA EXISTENTE");
                return this.renderer;
            }
        });
        System.out.println("SAIU DO CONSUMER");
    }

}