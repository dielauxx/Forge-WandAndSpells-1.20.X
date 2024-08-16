package net.dielauxx.wandandspellsmod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

//INFO
/*
Todos los SPELL ENTITIES heredan de esta clase, copiar mas o menos el comportamiento de AbstractArrow
//TODO copiar el comportamiento de AbstractArrow.class, y capaz algo de Arrow.class...
 */
public class AbstractSpell extends AbstractArrow {

    protected AbstractSpell(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    protected AbstractSpell(EntityType<? extends AbstractArrow> pEntityType, double pX, double pY, double pZ, Level pLevel) {
        super(pEntityType, pX, pY, pZ, pLevel);
    }

    protected AbstractSpell(EntityType<? extends AbstractArrow> pEntityType, LivingEntity pShooter, Level pLevel) {
        super(pEntityType, pShooter, pLevel);
    }

    @Override
    protected ItemStack getPickupItem() {
        return null;
    }
}
