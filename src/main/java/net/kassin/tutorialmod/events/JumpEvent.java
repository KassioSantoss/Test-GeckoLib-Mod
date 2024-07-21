package net.kassin.tutorialmod.events;

import net.kassin.tutorialmod.item.utils.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JumpEvent {

    private final Map<UUID, Integer> playerMap = new HashMap<>();

    @SubscribeEvent
    public void onJump(PlayerInteractEvent.RightClickItem event) {
        Item item = event.getItemStack().getItem();
        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(item);
        Player player = event.getEntity();

        player.sendSystemMessage(Component.literal("§aKEY DO ITEM: " + itemId));

        if (itemId != null && itemId.toString().equals("tutorialmod:keychest")) {
            player.sendSystemMessage(Component.literal("§aVOCE USOU UMA KEY"));
            return;
        }

        player.sendSystemMessage(Component.literal("§4VOCE NÃO USOU UMA KEY"));

        if (event.getEntity() instanceof Player) {

            int valueJumps = playerMap.getOrDefault(player.getUUID(), 0);

            if (valueJumps >= 5) {

                ItemStack itemStack = new ItemStack(ModItems.GLOCK_GUN.get());
                player.getInventory().add(itemStack);
                playerMap.remove(player.getUUID());

                ItemEntity itemEntity = new ItemEntity(EntityType.ITEM,player.level());

                ItemStack apple = new ItemStack(Items.APPLE);

                itemEntity.setItem(apple);

                itemEntity.setPosRaw(event.getEntity().getX() + 0, event.getEntity().getY() + 3.0, event.getEntity().getZ() + 2);

                player.level().addFreshEntity(itemEntity);

                player.sendSystemMessage(Component.literal("Parabéns por completar a missão de saltos. Você recebeu uma glock!"));

                return;
            }

            player.sendSystemMessage(Component.literal("O jogador: " + player.getName() + " pulou!"));
            player.sendSystemMessage(Component.literal("Valor do map do jogador: " + player.getName() + "!"));
            player.sendSystemMessage(Component.literal("Quantidade de saltos: " + playerMap.get(player.getUUID()) + "!"));
            playerMap.put(player.getUUID(), valueJumps + 1);
        }

    }
}
