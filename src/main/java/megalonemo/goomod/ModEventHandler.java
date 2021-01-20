package megalonemo.goomod;


import megalonemo.goomod.init.ModDimensions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = megalonemo.goomod.Mod.MOD_ID,bus= Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventHandler {
    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if(DimensionType.byName(megalonemo.goomod.Mod.GOO_OVERWORLD_TYPE) == null) {
            DimensionManager.registerDimension(megalonemo.goomod.Mod.GOO_OVERWORLD_TYPE, ModDimensions.GOO_OVERWORLD.get(),null,true);
        }
        Console.log("Dimensions registered!");
    }
}
