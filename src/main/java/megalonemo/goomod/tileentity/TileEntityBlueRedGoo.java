package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.blocks.BlockBlueRedGoo;
import megalonemo.goomod.blocks.BlockBrownRedGoo;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.stream.Stream;

import static megalonemo.goomod.blocks.BlockBlueRedGoo.stop;

public class TileEntityBlueRedGoo extends TileEntity implements ITickableTileEntity {
    //public static boolean stop = false;

    private int life = 0;
    boolean dormant = false;

    public TileEntityBlueRedGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public TileEntityBlueRedGoo() {
        this(ModTileEntityTypes.blue_red_goo.get());
        this.life = 0;
        this.dormant = false;
    }


    @Override
    public void read(CompoundNBT nbt) {
        this.life = nbt.getInt("life");
        this.dormant = nbt.getBoolean("dormant");
        //super.readFromNBT(nbt);
        super.read(nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putInt("life",this.life);
        nbt.putBoolean("dormant",this.dormant);
        return super.write(nbt);
    }

    public void setDormant(boolean value) {
        this.dormant = value;
    }

    public boolean getDormant() {
        return this.dormant;
    }

    void setblocks(World world,BlockPos pos) {
        //Console.log(world.getBlockState(pos.add(0,-1,0)).getFluidState().getFluid().toString());

        if (!world.getBlockState(pos.add(1,0,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") || world.getBlockState(pos.add(1, 0, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.KELP_PLANT.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(1, 0, 0)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(1, 0, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (!world.getBlockState(pos.add(0,0,1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, 0, 1)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, 0, 1)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(0, 0, 1);
            world.setBlockState(posi, world.getBlockState(pos));
        }

        if (!world.getBlockState(pos.add(-1,0,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(-1, 0, 0)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(-1, 0, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (!world.getBlockState(pos.add(0,0,-1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, 0, -1)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, 0, -1)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(0, 0, -1);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (!world.getBlockState(pos.add(0,-1,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, -1, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, -1, 0)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(0, -1, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (!world.getBlockState(pos.add(0,1,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, 1, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, 1, 0)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(0, 1, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
    }

    public int getBlocks() {
        int count = 0;
        if(world.getBlockState(pos.add(0,1,0)) == ModBlocks.blue_red_goo.getDefaultState()) {
            count++;
        }
        if(world.getBlockState(pos.add(0,-1,0)) == ModBlocks.blue_red_goo.getDefaultState()) {
            ++count;
        }
        if(world.getBlockState(pos.add(1,0,0)) == ModBlocks.blue_red_goo.getDefaultState()) {
            count++;
        }
        if(world.getBlockState(pos.add(-1,0,0)) == ModBlocks.blue_red_goo.getDefaultState()) {
            ++count;
        }
        if(world.getBlockState(pos.add(0,0,1)) == ModBlocks.blue_red_goo.getDefaultState()) {
            count++;
        }
        if(world.getBlockState(pos.add(0,0,-1)) == ModBlocks.blue_red_goo.getDefaultState()) {
            ++count;
        }

        if(world.getBlockState(pos.add(1,0,1)) == ModBlocks.blue_red_goo.getDefaultState()) {
            count++;
        }
        if(world.getBlockState(pos.add(-1,0,1)) == ModBlocks.blue_red_goo.getDefaultState()) {
            ++count;
        }
        if(world.getBlockState(pos.add(1,0,-1)) == ModBlocks.blue_red_goo.getDefaultState()) {
            count++;
        }
        if(world.getBlockState(pos.add(-1,0,-1)) == ModBlocks.blue_red_goo.getDefaultState()) {
            ++count;
        }
        return count;
    }
    public int getWater() {
        int count = 0;
        if(!world.getBlockState(pos.add(0,1,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*")) {
            count++;
        }
        if(!world.getBlockState(pos.add(0,-1,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*")) {
            ++count;
        }
        if(!world.getBlockState(pos.add(1,0,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*")) {
            count++;
        }
        if(!world.getBlockState(pos.add(-1,0,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*")) {
            ++count;
        }
        if(!world.getBlockState(pos.add(0,0,1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*")) {
            count++;
        }
        if(!world.getBlockState(pos.add(0,0,-1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*")) {
            ++count;
        }

        if(!world.getBlockState(pos.add(1,0,1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*")) {
            count++;
        }
        if(!world.getBlockState(pos.add(1,0,-1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*")) {
            ++count;
        }
        if(!world.getBlockState(pos.add(-1,0,1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*")) {
            count++;
        }
        if(!world.getBlockState(pos.add(-1,0,-1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*")) {
            ++count;
        }
        return count;
    }

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        World world = this.getWorld();
        BlockPos thisPos = this.pos;
        if(!world.isRemote) {
            if(stop) {
                this.dormant = true;
                //world.setBlockState(pos,Blocks.AIR.getDefaultState());
            }
            if(this.dormant) {
                if(getWater() == 0) {
                    world.setBlockState(pos,Blocks.AIR.getDefaultState());
                }
                if(getBlocks() == 0) {
                    world.setBlockState(pos,Blocks.AIR.getDefaultState());
                }
            }else {
                //Console.log("Ticking nigga???");
                if(world.getBlockState(thisPos.add(0, -1, 0)) == Blocks.WATER.getDefaultState()) {
                    world.setBlockState(thisPos.add(0, -1, 0), world.getBlockState(thisPos));
                }
                //Console.log(randomNum);
                if(Console.getRandom(10,world) == 1) {
                    this.life++;
                    setblocks(world, thisPos);
                  // // if(world.getBlockState(pos.add(0,-1,0)) == ModBlocks.blue_red_goo.getDefaultState()) {
                   ////     TileEntityBlueRedGoo te = (TileEntityBlueRedGoo) world.getTileEntity(pos.add(0,-1,0));

                        //te.setDormant(true);
                  ///  }
                    //Stream<BlockPos> positions = Console.checkBox(pos.add(2,2,2),pos.add(-2,-2,-2));
                    //positions.forEach(position -> {
                   //     if(world.getBlockState(position) == ModBlocks.blue_red_goo.getDefaultState()) {
                    //        TileEntityBlueRedGoo te = (TileEntityBlueRedGoo) world.getTileEntity(position);
                    //        if(te.getDormant()) {
                     //           world.setBlockState(position,ModBlocks.blue_red_goo.getDefaultState());
                    //        }
                   //     }
                   // });
                }
            }
            //Console.log(world.getBlockState(thisPos.add(0, -1, 0)));

            //if(stop == true) {
            //    world.setBlockState(thisPos, Blocks.AIR.getDefaultState());
            //}
           //if(life >= 100) {
           //     world.setBlockState(thisPos, Blocks.AIR.getDefaultState());
            //}

            //if(bruh >= 2000) {
            //	world.setBlockState(thisPos, Blocks.CACTUS.getDefaultState());
            //}


        }

    }

}
