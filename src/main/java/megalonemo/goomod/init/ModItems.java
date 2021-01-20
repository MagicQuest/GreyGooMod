package megalonemo.goomod.init;

import megalonemo.goomod.Mod;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ObjectHolder;

@net.minecraftforge.fml.common.Mod.EventBusSubscriber(modid = Mod.MOD_ID,bus= net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Mod.MOD_ID)
public class ModItems {
   // @ObjectHolder(CBMod.MOD_ID + "unstable_item")

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
  //      event.getRegistry().register(new Item(new Item.Properties().group(Mod.CBModItemGroup.instance)).setRegistryName("unstable"));
    }
}
