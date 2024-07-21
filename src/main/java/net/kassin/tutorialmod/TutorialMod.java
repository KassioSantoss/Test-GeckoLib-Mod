package net.kassin.tutorialmod;

import com.mojang.logging.LogUtils;
import net.kassin.tutorialmod.block.ModBlocks;
import net.kassin.tutorialmod.entity.ModEntities;
import net.kassin.tutorialmod.events.ItemTableEvent;
import net.kassin.tutorialmod.item.utils.ModCreativeModTabs;
import net.kassin.tutorialmod.item.utils.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.cache.GeckoLibCache;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";

    public TutorialMod() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        System.out.println("CHAMOU GECKOLIBCACHE");
        GeckoLibCache.registerReloadListener();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new ItemTableEvent());
    }

}