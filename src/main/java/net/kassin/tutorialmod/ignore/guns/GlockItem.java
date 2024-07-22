package net.kassin.tutorialmod.ignore.guns;

import net.kassin.tutorialmod.item.utils.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GlockItem extends Item {

    public GlockItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        ItemStack itemStack = ModItems.KEY_CHEST.get().getDefaultInstance();
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!pLevel.isClientSide) {
            DiceProjectileEntity dice = new DiceProjectileEntity(pLevel, pPlayer);
            dice.setItem(itemStack);
            dice.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 3f, 0.0F);
            pLevel.addFreshEntity(dice);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));

        if (!pPlayer.getAbilities().instabuild) {
            item.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(item, pLevel.isClientSide());
    }
}
