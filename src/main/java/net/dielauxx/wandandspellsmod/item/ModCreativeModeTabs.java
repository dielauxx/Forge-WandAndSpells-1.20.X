package net.dielauxx.wandandspellsmod.item;

import net.dielauxx.wandandspellsmod.WandAndSpellsMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WandAndSpellsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WAND_AND_SPELLS_TAB = CREATIVE_MODE_TABS.register("wand_and_spells_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.SPARK_BOLT_SPELL.get()))
                    .title(Component.translatable("creativetab.wand_and_spells_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SPARK_BOLT_SPELL.get());
                        output.accept(ModItems.WAND.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
