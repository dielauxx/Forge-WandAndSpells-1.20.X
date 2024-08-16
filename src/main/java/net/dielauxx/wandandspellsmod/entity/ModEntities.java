package net.dielauxx.wandandspellsmod.entity;

import net.dielauxx.wandandspellsmod.WandAndSpellsMod;
import net.dielauxx.wandandspellsmod.entity.custom.SparkBoltEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WandAndSpellsMod.MOD_ID);

    public static final RegistryObject<EntityType<SparkBoltEntity>> SPARK_BOLT = ENTITY_TYPES.register("spark_bolt",
            () -> EntityType.Builder.of((EntityType.EntityFactory<SparkBoltEntity>) SparkBoltEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).build("spark_bolt"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
