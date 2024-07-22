package net.kassin.tutorialmod.item.guns;


import net.kassin.tutorialmod.entity.ModEntities;
import net.kassin.tutorialmod.item.utils.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class DiceProjectileEntity extends ThrowableItemProjectile {

    public DiceProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public DiceProjectileEntity(Level level) {
        super(ModEntities.DICE_PROJECTILE.get(), level);
    }

    public DiceProjectileEntity(Level level, LivingEntity livingEntity) {
        super(ModEntities.DICE_PROJECTILE.get(), livingEntity, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.WATER_GUN.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (level().isClientSide) return;

        Entity entity = pResult.getEntity();

        if (!(this.getOwner() instanceof Player)) return;
        if (!(entity instanceof LivingEntity livingEntity)) return;

        Player player = (Player) getOwner();
        entity.hurt(this.damageSources().thrown(livingEntity, this.getOwner()), 10f);
        player.sendSystemMessage(Component.literal("§aVocê atingiu um(a): " + entity.getName().getString()));
        discard();
    }

}
