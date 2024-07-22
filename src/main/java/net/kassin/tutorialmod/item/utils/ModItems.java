package net.kassin.tutorialmod.item.utils;

import net.kassin.tutorialmod.TutorialMod;
import net.kassin.tutorialmod.item.client.AnimatedItemModel;
import net.kassin.tutorialmod.item.custom.AnimatedItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> KEY_CHEST = ITEMS.register("keychest",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WATER_GUN = ITEMS.register("water_gun",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ANIMATED_ITEM = ITEMS.register("animated_item",
            () -> new AnimatedItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
