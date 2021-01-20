package megalonemo.goomod;

import megalonemo.goomod.init.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameRules;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

import static megalonemo.goomod.blocks.BlockRainbowGoo.nether;
import static megalonemo.goomod.blocks.BlockRainbowGoo.overworld;


@net.minecraftforge.fml.common.Mod("goo")
public class Mod {

    public static final String MOD_ID = "goo";

    //if you are reading this then i'd really like to know why you are looking around in my mod lmao :joy:
    //is it because i haven't updated like stevenrs11 if so please email me at explodingfartinggoat@gmail.com (my actual email)

    public static final ResourceLocation GOO_OVERWORLD_TYPE = new ResourceLocation(MOD_ID,"goo_overworld");

    public static Mod instance;

    public final IEventBus modEventBus;
    public static final GameRules.RuleKey<GameRules.IntegerValue> GOO_SPEED = GameRules.register("gooSpeed", GameRules.IntegerValue.create(0));
    public static final GameRules.RuleKey<GameRules.BooleanValue> GOO_ENABLED = GameRules.register("gooEnabled", GameRules.BooleanValue.create(true));
    public static boolean EMP_ARRAY_ACTIVE = false;
    public static int BLOOM = 0;

    public Mod() {
        modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        instance = this;

        ModItemsNew.ITEMS.register(modEventBus);
        ModBlocksNew.BLOCKS.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);

        ModDimensions.MOD_DIMENSIONS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        //FMLJavaModLoadingContext.get().getModEventBus().register(new ClientEventBus());
        //MinecraftForge.EVENT_BUS.register(new ClientEventBus());
        Console.log("lmao");
        //ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        //Console.log(ModEntityTypes.HAMSTER.get());



    }
    //void reg() {
     //   ModEntityTypes.ENTITY_TYPES.register(modEventBus);
    //}

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();
        ModBlocksNew.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties props = new Item.Properties().group(GooItemGroup.instance);
            final BlockItem blockItem = new BlockItem(block,props);
            Console.log(block.getRegistryName());
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        Console.log("Registered BlockItems");
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        //Console.log(ModEntityTypes.HAMSTER.get());

        //reg();

        //RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HAMSTER.get(), EntityHamsterRender::new);
        Console.log("HELLO FROM PREINIT");
        Console.log("DIRT BLOCK >> " + Blocks.DIRT.getRegistryName());

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client

    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        Console.log("HELLO from server starting");

        DimensionManager.keepLoaded(DimensionType.byName(GOO_OVERWORLD_TYPE),true);
        
        nether = DimensionManager.initWorld(event.getServer(),DimensionType.byName(GOO_OVERWORLD_TYPE)).getWorld().dimension;
        overworld = event.getServer().getWorld(DimensionType.OVERWORLD).getWorld().dimension;

    }

    //better rename this creative tab because its wrong
    public static class GooItemGroup extends ItemGroup {
        public static final GooItemGroup instance = new GooItemGroup(ItemGroup.GROUPS.length,"gootab");

        private GooItemGroup(int index,String label) {
            super(index,label);
            this.setBackgroundImageName("item_search.png");
        }

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.grey_goo);
        }


        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @Override
        public boolean hasScrollbar() {
            return true;
        }
    }
}