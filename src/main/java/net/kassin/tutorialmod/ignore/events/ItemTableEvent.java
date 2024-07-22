package net.kassin.tutorialmod.ignore.events;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ItemTableEvent {

    @SubscribeEvent
    public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {

        Item item = event.getItemStack().getItem();
        Player player = event.getEntity();

        if (item == Items.BREAD) {

            ItemEntity itemEntity = new ItemEntity(EntityType.ITEM,player.level());

            ItemStack apple = new ItemStack(Items.APPLE);

            itemEntity.setInvisible(true);
            itemEntity.setNoGravity(true);
            itemEntity.setCustomName(Component.literal("TESTE"));
            itemEntity.setCustomNameVisible(true);
            itemEntity.setPickUpDelay(Integer.MAX_VALUE);

            itemEntity.setItem(apple);

            itemEntity.setPosRaw(event.getPos().getX() + 0.5, event.getPos().getY() + 1.2, event.getPos().getZ() + 0.5);

            player.level().addFreshEntity(itemEntity);


        }

    }

}
