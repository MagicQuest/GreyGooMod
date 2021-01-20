package megalonemo.goomod.init;

import megalonemo.goomod.Mod;
import megalonemo.goomod.blocks.*;
import megalonemo.goomod.items.BlockItemInfo;
import megalonemo.goomod.items.BlockItemInfo2;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Mod.MOD_ID)
@net.minecraftforge.fml.common.Mod.EventBusSubscriber(modid = Mod.MOD_ID,bus= net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final Block grey_goo = null;
    public static final Block red_goo = null;

    public static final Block green_goo = null;
    public static final Block green_red_goo = null;

    public static final Block orange_goo = null;
    public static final Block blue_goo = null;
    public static final Block plague_goo = null;
    public static final Block white_goo = null;
    public static final Block purple_goo = null;
    public static final Block yellow_goo = null;
    public static final Block rainbow_goo = null;
    public static final Block purple_red_goo = null;
    public static final Block brown_goo = null;
    public static final Block brown_red_goo = null;
    public static final Block tumor_goo = null;
    public static final Block darkness_goo = null;
    public static final Block blue_red_goo = null;

    public static final Block white_green_goo = null;

    public static final Block tgd = null;
    public static final Block orange_white_goo = null;
    public static final Block orange_purple_goo = null;
    public static final Block emp_array = null;


    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        //Blocks.GRASS_BLOCK
       event.getRegistry().register(new BlockGreyGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1f).lightValue(5)).setRegistryName("grey_goo"));
       event.getRegistry().register(new BlockRedGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1f).lightValue(7)).setRegistryName("red_goo"));
       event.getRegistry().register(new BlockGreenGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,10f).lightValue(3)).setRegistryName("green_goo"));
       event.getRegistry().register(new BlockOrangeGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,10f).lightValue(3)).setRegistryName("orange_goo"));
       event.getRegistry().register(new BlockBlueGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1f).lightValue(3)).setRegistryName("blue_goo"));
       event.getRegistry().register(new BlockPlagueGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,30f).lightValue(1)).setRegistryName("plague_goo"));
       event.getRegistry().register(new BlockWhiteGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1f).lightValue(3)).setRegistryName("white_goo"));
       event.getRegistry().register(new BlockPurpleGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1f).lightValue(3)).setRegistryName("purple_goo"));
       event.getRegistry().register(new BlockYellowGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1f).lightValue(3)).setRegistryName("yellow_goo"));
       event.getRegistry().register(new BlockRainbowGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,20f).lightValue(7)).setRegistryName("rainbow_goo"));
       event.getRegistry().register(new BlockPurpleRedGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1f).lightValue(7)).setRegistryName("purple_red_goo"));
       event.getRegistry().register(new BlockBrownGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1f).lightValue(3)).setRegistryName("brown_goo"));
       event.getRegistry().register(new BlockBrownRedGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1f).lightValue(7)).setRegistryName("brown_red_goo"));
       event.getRegistry().register(new BlockTumorGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1,50).lightValue(7)).setRegistryName("tumor_goo"));
       event.getRegistry().register(new BlockDarknessGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1,50)).setRegistryName("darkness_goo"));
       event.getRegistry().register(new BlockBlueRedGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1).lightValue(5)).setRegistryName("blue_red_goo"));
        event.getRegistry().register(new BlockWhiteGreenGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(.000f,1).lightValue(3)).setRegistryName("white_green_goo"));
        event.getRegistry().register(new BlockTGD(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(10,100).lightValue(15)).setRegistryName("tgd"));
        event.getRegistry().register(new BlockOrangeWhiteGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(0,1).doesNotBlockMovement().lightValue(3)).setRegistryName("orange_white_goo"));
        event.getRegistry().register(new BlockOrangePurpleGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(0,1).lightValue(3)).setRegistryName("orange_purple_goo"));
        event.getRegistry().register(new BlockGreenRedGoo(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(0,1).lightValue(3)).setRegistryName("green_red_goo"));
        event.getRegistry().register(new BlockEmpArray(Block.Properties.from(Blocks.STONE)).setRegistryName("emp_array"));

    }

    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItemInfo2(grey_goo, new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A77"+"This goo will " + "\u00A74" + "eat everything" + "\u00A77" +" and can evolve")).setRegistryName("grey_goo"));
        event.getRegistry().register(new BlockItemInfo(red_goo, new Item.Properties().group(Mod.GooItemGroup.instance),"This goo will eat other goos").setRegistryName("red_goo"));
        event.getRegistry().register(new BlockItemInfo2(green_goo, new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A77"+"This goo is special because" + "\u00A72" +" it can't be destroyed by other goos (except rainbow)")).setRegistryName("green_goo"));
        event.getRegistry().register(new BlockItemInfo2(orange_goo, new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A77"+"This goo will grow away from green goo " + "\u00A72"+ "and also can't be eaten by other goos except red and rainbow")).setRegistryName("orange_goo"));
        event.getRegistry().register(new BlockItemInfo(blue_goo,new Item.Properties().group(Mod.GooItemGroup.instance),"This goo will eat \u00A79water").setRegistryName("blue_goo"));
        event.getRegistry().register(new BlockItemInfo2(plague_goo, new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A77"+"This goo will" + "\u00A74" +" spawn under you and slowly grow if you look at it")).setRegistryName("plague_goo"));
        event.getRegistry().register(new BlockItemInfo(white_goo,new Item.Properties().group(Mod.GooItemGroup.instance),"This goo is one of the only ones that will grow in the air but it needs light to grow").setRegistryName("white_goo"));
        event.getRegistry().register(new BlockItemInfo2(purple_goo,new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A77"+"This goo will " + "\u00A74" + "eat everything" + "\u00A77" +" and slowly decay")).setRegistryName("purple_goo"));
        event.getRegistry().register(new BlockItemInfo(yellow_goo,new Item.Properties().group(Mod.GooItemGroup.instance),"This goo will fall just like sand and will eat blocks that have nothing under them").setRegistryName("yellow_goo"));
        event.getRegistry().register(new BlockItemInfo2(rainbow_goo,new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A74"+"This goo will" + "\u00A71" +" actually restore" + "\u00A76" + " craters in your" + "\u00A7d" + " world and recreate" + "\u00A73" + " the ground")).setRegistryName("rainbow_goo"));
        event.getRegistry().register(new BlockItemInfo2(purple_red_goo,new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A77"+"This goo will just" + "\u00A74" + " eat everything very fast and leave huge craters")).setRegistryName("purple_red_goo"));
        event.getRegistry().register(new BlockItemInfo(brown_goo,new Item.Properties().group(Mod.GooItemGroup.instance),"This goo eats \u00A78stones").setRegistryName("brown_goo"));
        event.getRegistry().register(new BlockItemInfo(brown_red_goo,new Item.Properties().group(Mod.GooItemGroup.instance),"This goo eats \u00A78stones rapidly").setRegistryName("brown_red_goo"));
        event.getRegistry().register(new BlockItemInfo2(tumor_goo,new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A74This goo will grow in all 6 directions including up and down and will eat literally everything")).setRegistryName("tumor_goo"));
        event.getRegistry().register(new BlockItemInfo2(darkness_goo,new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A74This goo is a child of tumor and can grow far and wide and even cause blindness")).setRegistryName("darkness_goo"));
        event.getRegistry().register(new BlockItemInfo(blue_red_goo,new Item.Properties().group(Mod.GooItemGroup.instance),"This goo will eat \u00A79water rapidly").setRegistryName("blue_red_goo"));
        event.getRegistry().register(new BlockItemInfo(white_green_goo,new Item.Properties().group(Mod.GooItemGroup.instance),"This goo will eat air rapidly").setRegistryName("white_green_goo"));
        event.getRegistry().register(new BlockItemInfo2(tgd,new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A74"+"This goo will cause the end of the world")).setRegistryName("tgd"));
        event.getRegistry().register(new BlockItemInfo2(orange_white_goo,new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A77"+"This goo will act just like" + "\u00A7e" + " orange " + "\u00A77" + "except it is a ladder")).setRegistryName("orange_white_goo"));
        //event.getRegistry().register(new BlockItemInfo(orange_purple_goo,new Item.Properties().group(Mod.GooItemGroup.instance),"This goo will tunnel through *every* block").setRegistryName("orange_purple_goo"));
        event.getRegistry().register(new BlockItemInfo2(orange_purple_goo,new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A77"+"This goo will tunnel through " + "\u00A7e" +"*every*"+"\u00A77"+ " block")).setRegistryName("orange_purple_goo"));
        event.getRegistry().register(new BlockItemInfo2(green_red_goo, new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A77"+"this goo will grow extremely fast over other goos and freezes them")).setRegistryName("green_red_goo"));
        event.getRegistry().register(new BlockItemInfo2(emp_array,new Item.Properties().group(Mod.GooItemGroup.instance),new StringTextComponent("\u00A77This machine will \u00A76stop any goo\u00A77 that you put on it but you have to build it correctly")).setRegistryName("emp_array"));

    }
}
