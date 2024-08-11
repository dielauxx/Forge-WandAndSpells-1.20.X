package net.dielauxx.wandandspellsmod.item;

import net.dielauxx.wandandspellsmod.WandAndSpellsMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WandAndSpellsMod.MOD_ID);

    public static final RegistryObject<Item> SPARK_BOLT = ITEMS.register("spark_bolt",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WAND = ITEMS.register("wand",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
