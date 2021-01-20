package megalonemo.goomod.init;

import megalonemo.goomod.Mod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemsNew {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,"goo");

   // public static final RegistryObject<Item> UR_MOM = ITEMS.register("ur_mom", () -> new Item(new Item.Properties().group(Mod.CBModItemGroup.instance)));
}
