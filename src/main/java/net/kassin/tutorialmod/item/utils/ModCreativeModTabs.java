package net.kassin.tutorialmod.item.utils;

import net.kassin.tutorialmod.TutorialMod;
import net.kassin.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KEY_CHEST.get()))
                    .title(Component.literal("Mod Tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.KEY_CHEST.get());
                        output.accept(ModBlocks.CHEST_DEFAULT.get());
                        output.accept(ModBlocks.TESTE_BLOCK.get());
                        output.accept(ModItems.GLOCK_GUN.get());
                        output.accept(ModItems.HAMMER.get());
                        output.accept(ModItems.WATER_GUN.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
