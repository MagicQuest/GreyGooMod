package megalonemo.goomod.init;

import megalonemo.goomod.Mod;
import megalonemo.goomod.dimension.GooOverworldModDimension;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModDimensions {
    public static final DeferredRegister<net.minecraftforge.common.ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Mod.MOD_ID);

    public static final RegistryObject<ModDimension> GOO_OVERWORLD = MOD_DIMENSIONS.register("goo_overworld",()->new GooOverworldModDimension())    ;
}
