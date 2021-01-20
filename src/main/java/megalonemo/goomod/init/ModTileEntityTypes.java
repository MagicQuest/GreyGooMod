package megalonemo.goomod.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import megalonemo.goomod.tileentity.*;

public class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, "goo");

    public static final RegistryObject<TileEntityType<TileEntityGreyGoo>> grey_goo = TILE_ENTITY_TYPES.register("grey_goo",()->TileEntityType.Builder.create(TileEntityGreyGoo::new,ModBlocks.grey_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityRedGoo>> red_goo = TILE_ENTITY_TYPES.register("red_goo",()->TileEntityType.Builder.create(TileEntityRedGoo::new,ModBlocks.red_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityBlueGoo>> blue_goo = TILE_ENTITY_TYPES.register("blue_goo",()->TileEntityType.Builder.create(TileEntityBlueGoo::new,ModBlocks.blue_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityPlagueGoo>> plague_goo = TILE_ENTITY_TYPES.register("plague_goo",()->TileEntityType.Builder.create(TileEntityPlagueGoo::new,ModBlocks.plague_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityWhiteGoo>> white_goo = TILE_ENTITY_TYPES.register("white_goo",()->TileEntityType.Builder.create(TileEntityWhiteGoo::new,ModBlocks.white_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityPurpleGoo>> purple_goo = TILE_ENTITY_TYPES.register("purple_goo",()->TileEntityType.Builder.create(TileEntityPurpleGoo::new,ModBlocks.purple_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityYellowGoo>> yellow_goo = TILE_ENTITY_TYPES.register("yellow_goo",()->TileEntityType.Builder.create(TileEntityYellowGoo::new,ModBlocks.yellow_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityRainbowGoo>> rainbow_goo = TILE_ENTITY_TYPES.register("rainbow_goo",()->TileEntityType.Builder.create(TileEntityRainbowGoo::new,ModBlocks.rainbow_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityPurpleRedGoo>> purple_red_goo = TILE_ENTITY_TYPES.register("purple_red_goo",()->TileEntityType.Builder.create(TileEntityPurpleRedGoo::new,ModBlocks.purple_red_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityBrownGoo>> brown_goo = TILE_ENTITY_TYPES.register("brown_goo",()->TileEntityType.Builder.create(TileEntityBrownGoo::new,ModBlocks.brown_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityBrownRedGoo>> brown_red_goo = TILE_ENTITY_TYPES.register("brown_red_goo",()->TileEntityType.Builder.create(TileEntityBrownRedGoo::new,ModBlocks.brown_red_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityTumorGoo>> tumor_goo = TILE_ENTITY_TYPES.register("tumor_goo",()->TileEntityType.Builder.create(TileEntityTumorGoo::new,ModBlocks.tumor_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityDarknessGoo>> darkness_goo = TILE_ENTITY_TYPES.register("darkness_goo",()->TileEntityType.Builder.create(TileEntityDarknessGoo::new,ModBlocks.darkness_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityBlueRedGoo>> blue_red_goo = TILE_ENTITY_TYPES.register("blue_red_goo",()->TileEntityType.Builder.create(TileEntityBlueRedGoo::new,ModBlocks.blue_red_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityWhiteGreenGoo>> white_green_goo = TILE_ENTITY_TYPES.register("white_green_goo",()->TileEntityType.Builder.create(TileEntityWhiteGreenGoo::new,ModBlocks.white_green_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityTGD>> tgd = TILE_ENTITY_TYPES.register("tgd",()->TileEntityType.Builder.create(TileEntityTGD::new,ModBlocks.tgd).build(null));
    public static final RegistryObject<TileEntityType<TileEntityOrangePurpleGoo>> orange_purple_goo = TILE_ENTITY_TYPES.register("orange_purple_goo",()->TileEntityType.Builder.create(TileEntityOrangePurpleGoo::new,ModBlocks.orange_purple_goo).build(null));
    public static final RegistryObject<TileEntityType<TileEntityGreenRedGoo>> green_red_goo = TILE_ENTITY_TYPES.register("green_red_goo",()->TileEntityType.Builder.create(TileEntityGreenRedGoo::new,ModBlocks.green_red_goo).build(null));

}