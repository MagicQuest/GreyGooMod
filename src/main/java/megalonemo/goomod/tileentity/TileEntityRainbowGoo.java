package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.blocks.BlockRainbowGoo;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.MinecraftGame;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.OverworldDimension;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.FMLWorldPersistenceHook;

import static megalonemo.goomod.blocks.BlockRainbowGoo.*;

public class TileEntityRainbowGoo extends TileEntity implements ITickableTileEntity {
    public TileEntityRainbowGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    private int life = 0;
    private boolean active = false;
    //private Dimension nether;
    // private boolean bruh = false;
    public TileEntityRainbowGoo() {
        this(ModTileEntityTypes.rainbow_goo.get());
        this.life = 0;
        this.active = false;
    }

    public static boolean disabled = false;

    public void activate() {
        this.active = true;
    }

    @Override
    public void read(CompoundNBT nbt) {
        this.life = nbt.getInt("life");
        this.active = nbt.getBoolean("active");
        //super.readFromNBT(nbt);
        super.read(nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putInt("life",this.life);
        nbt.putBoolean("active",this.active);
        return super.write(nbt);
    }

    /*public void grow(BlockPos pos,World world,Dimension dim) {
        if(Console.random(0,1) == 1) {
            if(dim == nether) {
                if(true) {
                    BlockPos posi = pos.add(1, 0, 0);
                    if(overworld.getWorld().getBlockState(posi) != world.getBlockState(posi)) {
                        world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                        ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();)
                    }
                    //   }



                    //if (nether.getWorld().getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi2 = pos.add(0, 0, 1);
                    if(overworld.getWorld().getBlockState(posi2) != world.getBlockState(posi2)) {
                        world.setBlockState(posi2, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }


                    // if (nether.getWorld().getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi3 = pos.add(-1, 0, 0);
                    if(overworld.getWorld().getBlockState(posi3) != world.getBlockState(posi3)) {
                        world.setBlockState(posi3, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //}


                    // if (nether.getWorld().getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi4 = pos.add(0, 0, -1);
                    if(overworld.getWorld().getBlockState(posi4) != world.getBlockState(posi4)) {
                        world.setBlockState(posi4, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }
                    //if (nether.getWorld().getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi5 = pos.add(0, -1, 0);
                    if(overworld.getWorld().getBlockState(posi5) != world.getBlockState(posi5)) {
                        world.setBlockState(posi5, ModBlocks.rainbow_goo.getDefaultState());
                        // }
                    }


                    //if (nether.getWorld().getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi6 = pos.add(0, 1, 0);
                    if(overworld.getWorld().getBlockState(posi6) != world.getBlockState(posi6)) {
                        world.setBlockState(posi6, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi7 = pos.add(1, 0, 1);
                    if(overworld.getWorld().getBlockState(posi7) != world.getBlockState(posi7)) {
                        world.setBlockState(posi7, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi8 = pos.add(-1, 0, -1);
                    if(overworld.getWorld().getBlockState(posi8) != world.getBlockState(posi8)) {
                        world.setBlockState(posi8, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi9 = pos.add(1, 0, -1);
                    if(overworld.getWorld().getBlockState(posi9) != world.getBlockState(posi9)) {
                        world.setBlockState(posi9, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi19 = pos.add(-1, 0, 1);
                    if(overworld.getWorld().getBlockState(posi19) != world.getBlockState(posi19)) {
                        world.setBlockState(posi19, ModBlocks.rainbow_goo.getDefaultState());
                    }
                }
                if(true) {
                    BlockPos posi = pos.add(1, 1, 0);
                    if(overworld.getWorld().getBlockState(posi) != world.getBlockState(posi)) {
                        world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                        ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();)
                    }
                    //   }



                    //if (nether.getWorld().getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi2 = pos.add(0, 1, 1);
                    if(overworld.getWorld().getBlockState(posi2) != world.getBlockState(posi2)) {
                        world.setBlockState(posi2, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }


                    // if (nether.getWorld().getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi3 = pos.add(-1, 1, 0);
                    if(overworld.getWorld().getBlockState(posi3) != world.getBlockState(posi3)) {
                        world.setBlockState(posi3, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //}


                    // if (nether.getWorld().getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi4 = pos.add(0, 1, -1);
                    if(overworld.getWorld().getBlockState(posi4) != world.getBlockState(posi4)) {
                        world.setBlockState(posi4, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }
                    //if (nether.getWorld().getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState()) {


                    //if (nether.getWorld().getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi7 = pos.add(1, 1, 1);
                    if(overworld.getWorld().getBlockState(posi7) != world.getBlockState(posi7)) {
                        world.setBlockState(posi7, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi8 = pos.add(-1, 1, -1);
                    if(overworld.getWorld().getBlockState(posi8) != world.getBlockState(posi8)) {
                        world.setBlockState(posi8, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi9 = pos.add(1, 1, -1);
                    if(overworld.getWorld().getBlockState(posi9) != world.getBlockState(posi9)) {
                        world.setBlockState(posi9, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi19 = pos.add(-1, 1, 1);
                    if(overworld.getWorld().getBlockState(posi19) != world.getBlockState(posi19)) {
                        world.setBlockState(posi19, ModBlocks.rainbow_goo.getDefaultState());
                    }
                }
                if(true) {
                    BlockPos posi = pos.add(1, -1, 0);
                    if(overworld.getWorld().getBlockState(posi) != world.getBlockState(posi)) {
                        world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                        ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();)
                    }
                    //   }



                    //if (nether.getWorld().getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi2 = pos.add(0, -1, 1);
                    if(overworld.getWorld().getBlockState(posi2) != world.getBlockState(posi2)) {
                        world.setBlockState(posi2, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }


                    // if (nether.getWorld().getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi3 = pos.add(-1, -1, 0);
                    if(overworld.getWorld().getBlockState(posi3) != world.getBlockState(posi3)) {
                        world.setBlockState(posi3, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //}


                    // if (nether.getWorld().getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi4 = pos.add(0, -1, -1);
                    if(overworld.getWorld().getBlockState(posi4) != world.getBlockState(posi4)) {
                        world.setBlockState(posi4, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }
                    //if (nether.getWorld().getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState()) {


                    //if (nether.getWorld().getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi7 = pos.add(1, -1, 1);
                    if(overworld.getWorld().getBlockState(posi7) != world.getBlockState(posi7)) {
                        world.setBlockState(posi7, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi8 = pos.add(-1, -1, -1);
                    if(overworld.getWorld().getBlockState(posi8) != world.getBlockState(posi8)) {
                        world.setBlockState(posi8, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi9 = pos.add(1, -1, -1);
                    if(overworld.getWorld().getBlockState(posi9) != world.getBlockState(posi9)) {
                        world.setBlockState(posi9, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi19 = pos.add(-1, -1, 1);
                    if(overworld.getWorld().getBlockState(posi19) != world.getBlockState(posi19)) {
                        world.setBlockState(posi19, ModBlocks.rainbow_goo.getDefaultState());
                    }
                }
                world.setBlockState(pos,overworld.getWorld().getBlockState(pos));
            }else if(dim.getType() == DimensionType.OVERWORLD) {
                if(true) {
                    BlockPos posi = pos.add(1, 0, 0);
                    if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi)) {
                        world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                        ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();)
                    }
                    //   }



                    //if (nether.getWorld().getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi2 = pos.add(0, 0, 1);
                    if(nether.getWorld().getBlockState(posi2) != world.getBlockState(posi2)) {
                        world.setBlockState(posi2, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }


                    // if (nether.getWorld().getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi3 = pos.add(-1, 0, 0);
                    if(nether.getWorld().getBlockState(posi3) != world.getBlockState(posi3)) {
                        world.setBlockState(posi3, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //}


                    // if (nether.getWorld().getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi4 = pos.add(0, 0, -1);
                    if(nether.getWorld().getBlockState(posi4) != world.getBlockState(posi4)) {
                        world.setBlockState(posi4, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }
                    //if (nether.getWorld().getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi5 = pos.add(0, -1, 0);
                    if(nether.getWorld().getBlockState(posi5) != world.getBlockState(posi5)) {
                        world.setBlockState(posi5, ModBlocks.rainbow_goo.getDefaultState());
                        // }
                    }


                    //if (nether.getWorld().getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi6 = pos.add(0, 1, 0);
                    if(nether.getWorld().getBlockState(posi6) != world.getBlockState(posi6)) {
                        world.setBlockState(posi6, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi7 = pos.add(1, 0, 1);
                    if(nether.getWorld().getBlockState(posi7) != world.getBlockState(posi7)) {
                        world.setBlockState(posi7, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi8 = pos.add(-1, 0, -1);
                    if(nether.getWorld().getBlockState(posi8) != world.getBlockState(posi8)) {
                        world.setBlockState(posi8, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi9 = pos.add(1, 0, -1);
                    if(nether.getWorld().getBlockState(posi9) != world.getBlockState(posi9)) {
                        world.setBlockState(posi9, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi19 = pos.add(-1, 0, 1);
                    if(nether.getWorld().getBlockState(posi19) != world.getBlockState(posi19)) {
                        world.setBlockState(posi19, ModBlocks.rainbow_goo.getDefaultState());
                    }
                }
                if(true) {
                    BlockPos posi = pos.add(1, 1, 0);
                    if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi)) {
                        world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                        ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();)
                    }
                    //   }



                    //if (nether.getWorld().getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi2 = pos.add(0, 1, 1);
                    if(nether.getWorld().getBlockState(posi2) != world.getBlockState(posi2)) {
                        world.setBlockState(posi2, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }


                    // if (nether.getWorld().getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi3 = pos.add(-1, 1, 0);
                    if(nether.getWorld().getBlockState(posi3) != world.getBlockState(posi3)) {
                        world.setBlockState(posi3, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //}


                    // if (nether.getWorld().getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi4 = pos.add(0, 1, -1);
                    if(nether.getWorld().getBlockState(posi4) != world.getBlockState(posi4)) {
                        world.setBlockState(posi4, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }
                    //if (nether.getWorld().getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState()) {


                    //if (nether.getWorld().getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi7 = pos.add(1, 1, 1);
                    if(nether.getWorld().getBlockState(posi7) != world.getBlockState(posi7)) {
                        world.setBlockState(posi7, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi8 = pos.add(-1, 1, -1);
                    if(nether.getWorld().getBlockState(posi8) != world.getBlockState(posi8)) {
                        world.setBlockState(posi8, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi9 = pos.add(1, 1, -1);
                    if(nether.getWorld().getBlockState(posi9) != world.getBlockState(posi9)) {
                        world.setBlockState(posi9, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi19 = pos.add(-1, 1, 1);
                    if(nether.getWorld().getBlockState(posi19) != world.getBlockState(posi19)) {
                        world.setBlockState(posi19, ModBlocks.rainbow_goo.getDefaultState());
                    }
                }
                if(true) {
                    BlockPos posi = pos.add(1, -1, 0);
                    if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi)) {
                        world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                        ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();)
                    }
                    //   }



                    //if (nether.getWorld().getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi2 = pos.add(0, -1, 1);
                    if(nether.getWorld().getBlockState(posi2) != world.getBlockState(posi2)) {
                        world.setBlockState(posi2, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }


                    // if (nether.getWorld().getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi3 = pos.add(-1, -1, 0);
                    if(nether.getWorld().getBlockState(posi3) != world.getBlockState(posi3)) {
                        world.setBlockState(posi3, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //}


                    // if (nether.getWorld().getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi4 = pos.add(0, -1, -1);
                    if(nether.getWorld().getBlockState(posi4) != world.getBlockState(posi4)) {
                        world.setBlockState(posi4, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    //  }
                    //if (nether.getWorld().getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState()) {


                    //if (nether.getWorld().getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState()) {
                    BlockPos posi7 = pos.add(1, -1, 1);
                    if(nether.getWorld().getBlockState(posi7) != world.getBlockState(posi7)) {
                        world.setBlockState(posi7, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi8 = pos.add(-1, -1, -1);
                    if(nether.getWorld().getBlockState(posi8) != world.getBlockState(posi8)) {
                        world.setBlockState(posi8, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi9 = pos.add(1, -1, -1);
                    if(nether.getWorld().getBlockState(posi9) != world.getBlockState(posi9)) {
                        world.setBlockState(posi9, ModBlocks.rainbow_goo.getDefaultState());
                    }
                    BlockPos posi19 = pos.add(-1, -1, 1);
                    if(nether.getWorld().getBlockState(posi19) != world.getBlockState(posi19)) {
                        world.setBlockState(posi19, ModBlocks.rainbow_goo.getDefaultState());
                    }
                }
                world.setBlockState(pos,nether.getWorld().getBlockState(pos));
            }
        }
    }*/
    void grow(BlockPos pos,World world,Dimension dim) {
        if(dim == nether) {
            Console.checkBox(pos.add(1,1,1),pos.add(-1,-1,-1)).forEach((posi)->{
                if(overworld.getWorld().getBlockState(posi) != world.getBlockState(posi)) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            });
            /*if(true) {
                BlockPos posi = pos.add(1, 0, 0);
                if(overworld.getWorld().getBlockState(posi) != world.getBlockState(posi)) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }
            if(true) {
                BlockPos posi = pos.add(0, 0, 1);
                if(overworld.getWorld().getBlockState(posi) != world.getBlockState(posi)) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }
            if(true) {
                BlockPos posi = pos.add(-1, 0, 0);
                if(overworld.getWorld().getBlockState(posi) != world.getBlockState(posi)) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }
            if(true) {
                BlockPos posi = pos.add(0, 0, -1);
                if(overworld.getWorld().getBlockState(posi) != world.getBlockState(posi)) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }
            if(true) {
                BlockPos posi = pos.add(0, -1, 0);
                if(overworld.getWorld().getBlockState(posi) != world.getBlockState(posi)) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }
            if(true) {
                BlockPos posi = pos.add(0, 1, 0);
                if(overworld.getWorld().getBlockState(posi) != world.getBlockState(posi)) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }*/
            world.setBlockState(pos,overworld.getWorld().getBlockState(pos));
        }else {
            Console.checkBox(pos.add(1,1,1),pos.add(-1,-1,-1)).forEach((posi)->{
                if(posi != pos.add(0,-1,0) && posi != pos.add(0,1,0)) {
                    if(nether.getWorld().getBlockState(pos) == Blocks.GRASS.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.GRASS_PATH.getDefaultState()) {
                        nether.getWorld().setBlockState(pos,Blocks.AIR.getDefaultState());
                    }else
                    if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi) && world.getBlockState(posi) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.emp_array.getDefaultState() && world.getBlockState(posi) != ModBlocks.goo_portal.getDefaultState()) {
                        world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                        ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                    }
                }else {
                    if(nether.getWorld().getBlockState(pos) == Blocks.SAND.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.CAVE_AIR.getDefaultState()) {
                        nether.getWorld().setBlockState(pos,Blocks.CAVE_AIR.getDefaultState());
                    }else if(nether.getWorld().getBlockState(pos) == Blocks.GRAVEL.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.CAVE_AIR.getDefaultState()) {
                        nether.getWorld().setBlockState(pos,Blocks.CAVE_AIR.getDefaultState());
                    }else if(nether.getWorld().getBlockState(pos) == Blocks.SNOW.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.CAVE_AIR.getDefaultState()) {
                        nether.getWorld().setBlockState(pos,Blocks.CAVE_AIR.getDefaultState());
                    }else if(nether.getWorld().getBlockState(pos) == Blocks.GRASS.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.GRASS_PATH.getDefaultState()) {
                        nether.getWorld().setBlockState(pos,Blocks.AIR.getDefaultState());
                    }else if(nether.getWorld().getBlockState(pos) == Blocks.GRAVEL.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.WATER.getDefaultState()) {
                        nether.getWorld().setBlockState(pos,Blocks.WATER.getDefaultState());
                    }else if(nether.getWorld().getBlockState(pos) == Blocks.SAND.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.WATER.getDefaultState()) {
                        nether.getWorld().setBlockState(pos,Blocks.WATER.getDefaultState());
                    }else
                    if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi) && world.getBlockState(posi) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.emp_array.getDefaultState() && world.getBlockState(posi) != ModBlocks.goo_portal.getDefaultState()) {

                        world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                        ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                    }
                }
            });
            /*if(true) {
                BlockPos posi = pos.add(1, 0, 0);
                if(nether.getWorld().getBlockState(pos) == Blocks.GRASS.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.GRASS_PATH.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.AIR.getDefaultState());
                }else
                if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi) && world.getBlockState(posi) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.emp_array.getDefaultState() && world.getBlockState(posi) != ModBlocks.goo_portal.getDefaultState()) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }
            if(true) {
                BlockPos posi = pos.add(0, 0, 1);
                if(nether.getWorld().getBlockState(pos) == Blocks.GRASS.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.GRASS_PATH.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.AIR.getDefaultState());
                }else
                if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi) && world.getBlockState(posi) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.emp_array.getDefaultState() && world.getBlockState(posi) != ModBlocks.goo_portal.getDefaultState()) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }
            if(true) {
                BlockPos posi = pos.add(-1, 0, 0);
                if(nether.getWorld().getBlockState(pos) == Blocks.GRASS.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.GRASS_PATH.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.AIR.getDefaultState());
                }else
                if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi) && world.getBlockState(posi) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.emp_array.getDefaultState() && world.getBlockState(posi) != ModBlocks.goo_portal.getDefaultState()) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }
            if(true) {
                BlockPos posi = pos.add(0, 0, -1);
                if(nether.getWorld().getBlockState(pos) == Blocks.GRASS.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.GRASS_PATH.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.AIR.getDefaultState());
                }else
                if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi) && world.getBlockState(posi) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.emp_array.getDefaultState() && world.getBlockState(posi) != ModBlocks.goo_portal.getDefaultState()) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }
            if(true) {
                BlockPos posi = pos.add(0, -1, 0);
                if(nether.getWorld().getBlockState(pos) == Blocks.SAND.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.CAVE_AIR.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.CAVE_AIR.getDefaultState());
                }else if(nether.getWorld().getBlockState(pos) == Blocks.GRAVEL.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.CAVE_AIR.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.CAVE_AIR.getDefaultState());
                }else if(nether.getWorld().getBlockState(pos) == Blocks.SNOW.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.CAVE_AIR.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.CAVE_AIR.getDefaultState());
                }else if(nether.getWorld().getBlockState(pos) == Blocks.GRASS.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.GRASS_PATH.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.AIR.getDefaultState());
                }else
                if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi) && world.getBlockState(posi) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.emp_array.getDefaultState() && world.getBlockState(posi) != ModBlocks.goo_portal.getDefaultState()) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }
            if(true) {
                BlockPos posi = pos.add(0, 1, 0);
                if(nether.getWorld().getBlockState(pos) == Blocks.SAND.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.CAVE_AIR.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.CAVE_AIR.getDefaultState());
                }else if(nether.getWorld().getBlockState(pos) == Blocks.GRAVEL.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.CAVE_AIR.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.CAVE_AIR.getDefaultState());
                }else if(nether.getWorld().getBlockState(pos) == Blocks.SNOW.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.CAVE_AIR.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.CAVE_AIR.getDefaultState());
                }else if(nether.getWorld().getBlockState(pos) == Blocks.GRASS.getDefaultState() && nether.getWorld().getBlockState(posi) == Blocks.GRASS_PATH.getDefaultState()) {
                    nether.getWorld().setBlockState(pos,Blocks.AIR.getDefaultState());
                }else
                if(nether.getWorld().getBlockState(posi) != world.getBlockState(posi) && world.getBlockState(posi) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(posi) != ModBlocks.emp_array.getDefaultState() && world.getBlockState(posi) != ModBlocks.goo_portal.getDefaultState()) {

                    world.setBlockState(posi, ModBlocks.rainbow_goo.getDefaultState());
                    ((TileEntityRainbowGoo)world.getTileEntity(posi)).activate();
                }
            }*/
            world.setBlockState(pos,nether.getWorld().getBlockState(pos));
        }

    }

    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos thisPos = this.pos;

        if (!world.isRemote && !disabled) {
            if(this.active) {
                // if(nether == null) {
                // Console.log(BlockRainbowGoo.life);
                //    }
                Dimension dim =  world.getDimension();
                if(dim.isNether() || dim.getType() == DimensionType.THE_END) {
                    //BlockRainbowGoo.life++;
                    //Console.log("dawg help");
                    if(BlockRainbowGoo.life >= 300000) {
                        world.setBlockState(thisPos,nether.getWorld().getBlockState(thisPos));
                    }
                }

                //world.setBlockState(thisPos,Blocks.GRASS_BLOCK.getDefaultState());
                //this.life++;
                // if(/*BlockRainbowGoo.life >= 10000*/this.life >= 25) {
                //     world.setBlockState(thisPos,nether.getWorld().getBlockState(thisPos));
                //}
                //BlockRainbowGoo.life++;

                if(Console.getRandom(200,world)==1) {
                    //this.life++;
                    grow(thisPos,world,dim);
                }

            /*if(this.life >= 10) {
                grow(thisPos,world,dim);

                //world.setBlockState(thisPos,Blocks.AIR.getDefaultState());

                ///if(dim.isNether() == true) {
                   // nether = dim;
               //     nether = dim;
                if(dim == nether) {
                    world.setBlockState(thisPos,overworld.getWorld().getBlockState(thisPos));
                }else if(dim.getType() == DimensionType.OVERWORLD) {
                    world.setBlockState(thisPos,nether.getWorld().getBlockState(thisPos));
                }
               // }else {
               //     if(nether != null) {
               //         try {
                          //  DimensionManager.keepLoaded(DimensionType.THE_NETHER,true);
               //             //nether.
              //              world.setBlockState(thisPos,nether.getWorld().getBlockState(thisPos));
                //        }catch (Exception e) {
               //             //e.printStackTrace();
               //         }


                  //  }else {
                 //  //     world.setBlockState(thisPos,dim.getWorld().getBlockState(thisPos.add(0,-1,0)));
                  //  }

                   // bruh = true;


            }
            /*if (Console.random(0, 25) == 1) {
                    setblocks(world,thisPos);
                    /*if (world.getBlockState(pos.add(1, 0, 0)) == Blocks.AIR.getDefaultState()) {
                        BlockPos posi = pos.add(1, 0, 0);
                        world.setBlockState(pos, Blocks.GRASS_BLOCK.getDefaultState());
                    }



                    if (world.getBlockState(pos.add(0, 0, 1)) == Blocks.AIR.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, 1);
                        world.setBlockState(posi, Blocks.GRASS_BLOCK.getDefaultState());
                    }


                    if (world.getBlockState(pos.add(-1, 0, 0)) == Blocks.AIR.getDefaultState()) {
                        BlockPos posi = pos.add(-1, 0, 0);
                        world.setBlockState(posi, Blocks.GRASS_BLOCK.getDefaultState());
                    }


                    if (world.getBlockState(pos.add(0, 0, -1)) == Blocks.AIR.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, -1);
                        world.setBlockState(posi, Blocks.GRASS_BLOCK.getDefaultState());
                    }*/
                //}
            }else if(Mod.GOO_PORTAL_ACTIVE) {
                this.activate();
            }

        }
    }
}
