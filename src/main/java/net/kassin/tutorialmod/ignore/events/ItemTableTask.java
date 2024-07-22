package net.kassin.tutorialmod.ignore.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemTableTask {

    private static ItemEntity itemEntity;
    private final double speed;

    public ItemTableTask(ItemEntity itemEntity, double speed) {
        ItemTableTask.itemEntity = itemEntity;
        this.speed = speed;
    }

    @SubscribeEvent
    public static void onWorldTick(TickEvent.PlayerTickEvent event) {

        if (event.phase == TickEvent.Phase.END) {

            for (ItemEntity itemEntity : event.player.level().getEntitiesOfClass(ItemEntity.class, itemEntity.getBoundingBox())) {

                Vec3 motion = new Vec3(0, 0, 0.05);

                itemEntity.setDeltaMovement(motion);

                BlockPos pos = itemEntity.getOnPos();

                event.player.level().scheduleTick(pos,itemEntity.getBlockStateOn().getBlock(), 1);

            }
        }
    }
}


