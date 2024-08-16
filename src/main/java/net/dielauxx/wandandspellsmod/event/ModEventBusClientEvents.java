package net.dielauxx.wandandspellsmod.event;

import net.dielauxx.wandandspellsmod.WandAndSpellsMod;
import net.dielauxx.wandandspellsmod.entity.client.ModModelLayers;
import net.dielauxx.wandandspellsmod.entity.client.SparkBoltBBModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WandAndSpellsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.SPARK_BOLT_LAYER, SparkBoltBBModel::createBodyLayer);
    }

}
