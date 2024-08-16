package net.dielauxx.wandandspellsmod.item.custom.spells;

import net.dielauxx.wandandspellsmod.entity.custom.AbstractSpell;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class SpellItem extends ArrowItem {
    public SpellItem(Properties pProperties) {
        //TODO modificar para hcaer que por ejemplo solo se pueda tener uno, etc...
        super(pProperties);
    }

    public abstract AbstractSpell createSpell(Level pLevel, ItemStack pStack, LivingEntity pShooter);
}
