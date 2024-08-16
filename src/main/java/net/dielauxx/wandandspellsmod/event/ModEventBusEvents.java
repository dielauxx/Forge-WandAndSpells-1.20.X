package net.dielauxx.wandandspellsmod.event;

import net.dielauxx.wandandspellsmod.WandAndSpellsMod;
import net.dielauxx.wandandspellsmod.entity.ModEntities;
import net.dielauxx.wandandspellsmod.entity.custom.SparkBoltEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WandAndSpellsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
/* no se si tenga que usarlo a este...
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.SPARK_BOLT.get(), SparkBoltEntity.);
    }
    /*
 */
}
