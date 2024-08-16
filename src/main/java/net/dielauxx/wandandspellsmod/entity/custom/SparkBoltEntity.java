package net.dielauxx.wandandspellsmod.entity.custom;

import com.google.common.collect.Sets;
import net.dielauxx.wandandspellsmod.entity.ModEntities;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;

//TODO todos los spell deberian mimic el comportamiento de Arrow.class, asi que capaz AbstractSpell deberia copiarse algo de Arrow.class...
public class SparkBoltEntity extends AbstractSpell {
    public SparkBoltEntity(EntityType<? extends AbstractSpell> pEntityType, Level pLevel) {
        super(ModEntities.SPARK_BOLT.get(), pLevel);
        this.setBaseDamage(5);
    }

    protected SparkBoltEntity(EntityType<? extends AbstractSpell> pEntityType, double pX, double pY, double pZ, Level pLevel) {
        super(ModEntities.SPARK_BOLT.get(), pX, pY, pZ, pLevel);
        this.setBaseDamage(5);
    }

    protected SparkBoltEntity(EntityType<? extends AbstractSpell> pEntityType, LivingEntity pShooter, Level pLevel) {
        super(ModEntities.SPARK_BOLT.get(), pShooter, pLevel);
        this.setBaseDamage(5);
    }

    public SparkBoltEntity(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntities.SPARK_BOLT.get(), pX, pY, pZ, pLevel);
    }

    public SparkBoltEntity(Level pLevel, LivingEntity pShooter) {
        super(ModEntities.SPARK_BOLT.get(), pShooter, pLevel);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    //TODO cambiar el sonido por uno de spark bolt... hacer tambien un sonido al disparar...
    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return super.getDefaultHitGroundSoundEvent();
    }
}
