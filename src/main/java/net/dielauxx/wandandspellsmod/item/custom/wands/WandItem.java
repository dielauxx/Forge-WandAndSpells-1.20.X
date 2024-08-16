package net.dielauxx.wandandspellsmod.item.custom.wands;

import net.dielauxx.wandandspellsmod.entity.custom.AbstractSpell;
import net.dielauxx.wandandspellsmod.item.ModItems;
import net.dielauxx.wandandspellsmod.item.custom.spells.SparkBoltSpellItem;
import net.dielauxx.wandandspellsmod.item.custom.spells.SpellItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.function.Predicate;

public class WandItem extends ProjectileWeaponItem {
    public static final int MAX_DRAW_DURATION = 20;
    public static final int DEFAULT_RANGE = 15;

    public WandItem(Properties pProperties) {
        super(pProperties);
    }

    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            System.out.println("El objeto es: " + pStack.getItem().getName(pStack).getString());
            System.out.println(pStack.toString());
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, pStack) > 0;
            ItemStack itemstack = player.getProjectile(pStack);
            //int i = this.getUseDuration(pStack) - pTimeLeft;
            //i = ForgeEventFactory.onArrowLoose(pStack, pLevel, player, i, !itemstack.isEmpty() || flag);
            //if (i < 0) {
            //    return;
            //}

            if (!itemstack.isEmpty() || flag) {
                if (itemstack.isEmpty()) {
                    //TODO hmmm...
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = getPowerForTime();
                if (!((double)f < 0.1)) {
                    boolean flag1 = player.getAbilities().instabuild || itemstack.getItem() instanceof SpellItem && ((SpellItem)itemstack.getItem()).isInfinite(itemstack, pStack, player);
                    if (!pLevel.isClientSide) {
                        SpellItem spellItem = (SpellItem)(itemstack.getItem() instanceof SpellItem ? itemstack.getItem() : ModItems.SPARK_BOLT_SPELL.get());
                        AbstractSpell abstractSpell = spellItem.createSpell(pLevel, itemstack, player);
                        abstractSpell = this.customSpell(abstractSpell);
                        abstractSpell.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
                        if (f == 1.0F) {
                            abstractSpell.setCritArrow(true);
                        }
                        /*
                        int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, pStack);
                        if (j > 0) {
                            abstractSpell.setBaseDamage(abstractSpell.getBaseDamage() + (double)j * 0.5 + 0.5);
                        }

                        int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, pStack);
                        if (k > 0) {
                            abstractSpell.setKnockback(k);
                        }

                        if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, pStack) > 0) {
                            abstractSpell.setSecondsOnFire(100);
                        }
                        */
                        pStack.hurtAndBreak(1, player, (p_289501_) -> {
                            p_289501_.broadcastBreakEvent(player.getUsedItemHand());
                        });
                        //if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
                        //    abstractSpell.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        //}

                        pLevel.addFreshEntity(abstractSpell);
                    }

                    pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild) {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }

    }

    public static float getPowerForTime() {
        /*float f = (float)pCharge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        System.out.println("pCharge: " + pCharge);
        System.out.println("Poder: " + f);
        return f;
         */
        return 1.0f;
    }

    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.NONE;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        boolean flag = !pPlayer.getProjectile(itemstack).isEmpty();
        releaseUsing(itemstack, pLevel, pPlayer, 0);
        //System.out.println("Holdeando el arrow....");
        //InteractionResultHolder<ItemStack> ret = ForgeEventFactory.onArrowNock(itemstack, pLevel, pPlayer, pHand, flag);
        //System.out.println("LIBERADO");
        /*if (ret != null) {
            return ret;
        } else if (!pPlayer.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            pPlayer.startUsingItem(pHand);
            return InteractionResultHolder.success(itemstack);
        }

         */
       // return InteractionResultHolder.success(itemstack);
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        //return ARROW_ONLY;
        return new Predicate<ItemStack>() {
            @Override
            public boolean test(ItemStack itemStack) {
                return itemStack.getItem() instanceof SparkBoltSpellItem;
            }
        };
    }

    public AbstractSpell customSpell(AbstractSpell spell) {
        return spell;
    }

    public int getDefaultProjectileRange() {
        return 30;
    }


}
