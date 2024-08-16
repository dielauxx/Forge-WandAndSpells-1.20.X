package net.dielauxx.wandandspellsmod.item.custom.spells;

import net.dielauxx.wandandspellsmod.entity.custom.AbstractSpell;
import net.dielauxx.wandandspellsmod.entity.custom.SparkBoltEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SparkBoltSpellItem extends SpellItem {
    public SparkBoltSpellItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public AbstractSpell createSpell(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        SparkBoltEntity sparkBolt = new SparkBoltEntity(pLevel, pShooter);
        //sparkBolt.setEffectsFromItem(pStack);
        return sparkBolt;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, Player player) {
        //int enchant = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, bow);
        //return enchant <= 0 ? false : this.getClass() == ArrowItem.class;
        return true;
    }
}
