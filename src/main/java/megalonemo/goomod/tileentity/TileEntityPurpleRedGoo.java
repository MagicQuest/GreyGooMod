package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.blocks.BlockPurpleRedGoo;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.concurrent.atomic.AtomicBoolean;

public class TileEntityPurpleRedGoo extends TileEntity implements ITickableTileEntity {
    private int life = 0;

    public TileEntityPurpleRedGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityPurpleRedGoo() {
        this(ModTileEntityTypes.purple_red_goo.get());
        this.life = 0;
    }

    @Override
    public void read(CompoundNBT nbt) {
        this.life = nbt.getInt("life");
        super.read(nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putInt("life",this.life);
        return super.write(nbt);
    }

    void setblocks(World world,BlockPos pos) {
        //Console.log(world.getBlockState(pos.add(0,-1,0)).getFluidState().getFluid().toString());

        //-//if (!world.getBlockState(pos.add(1,0,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") || world.getBlockState(pos.add(1, 0, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.KELP_PLANT.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(1, 0, 0)) == Blocks.WATER.getDefaultState()) {
        if(world.getBlockState(pos.add(1,0,0)) != Blocks.AIR.getDefaultState()) {
            BlockPos posi = pos.add(1, 0, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        //if (!world.getBlockState(pos.add(0,0,1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, 0, 1)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, 0, 1)) == Blocks.WATER.getDefaultState()) {
        if(world.getBlockState(pos.add(0,0,1)) != Blocks.AIR.getDefaultState()) {
            BlockPos posi = pos.add(0, 0, 1);
            world.setBlockState(posi, world.getBlockState(pos));
        }

        //if (!world.getBlockState(pos.add(-1,0,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(-1, 0, 0)) == Blocks.WATER.getDefaultState()) {
        if(world.getBlockState(pos.add(-1,0,0)) != Blocks.AIR.getDefaultState()) {
            BlockPos posi = pos.add(-1, 0, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        //if (!world.getBlockState(pos.add(0,0,-1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, 0, -1)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, 0, -1)) == Blocks.WATER.getDefaultState()) {
        if(world.getBlockState(pos.add(0,0,-1)) != Blocks.AIR.getDefaultState()) {
            BlockPos posi = pos.add(0, 0, -1);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        //if (!world.getBlockState(pos.add(0,-1,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, -1, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, -1, 0)) == Blocks.WATER.getDefaultState()) {
        if(world.getBlockState(pos.add(0,-1,0)) != Blocks.AIR.getDefaultState()) {
            BlockPos posi = pos.add(0, -1, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        //if (!world.getBlockState(pos.add(0,1,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, 1, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, 1, 0)) == Blocks.WATER.getDefaultState()) {
        if(world.getBlockState(pos.add(0,1,0)) != Blocks.AIR.getDefaultState()) {
            BlockPos posi = pos.add(0, 1, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
    }

    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos thisPos = this.pos;

        if (!world.isRemote) {
            this.life++;

            //if(BlockPurpleRedGoo.life >= 800000 || this.life >= 20) {
            //    world.setBlockState(thisPos,Blocks.AIR.getDefaultState());
            //}
            //boolean grew = false;
            int grew = 0;
            if (Console.getRandom(10,world) == 1) {
                if(BlockPurpleRedGoo.life >= 800000 || this.life >= 20) {
                    world.setBlockState(thisPos,Blocks.AIR.getDefaultState());
                }
            }
            if (Console.getRandom(100,world) == 1) {
                BlockPurpleRedGoo.life += 15;
                this.life++;
                if(BlockPurpleRedGoo.life >= 800000 || this.life >= 20) {
                    world.setBlockState(thisPos,Blocks.AIR.getDefaultState());
                }
                //AtomicBoolean moved = new AtomicBoolean(false);
                setblocks(world,pos);
                /*if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(1, 0, 0);
                        moved.set(true);
                        grew++;
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }

                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, 1);
                        moved.set(true);
                        grew++;
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(-1, 0, 0);
                        moved.set(true);
                        grew++;
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, -1);
                        moved.set(true);
                        grew++;
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, -1, 0);
                        moved.set(true);
                        grew++;
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 1, 0);
                        moved.set(true);
                        grew++;
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }
                if(grew >= 3) {
                    world.setBlockState(pos,Blocks.AIR.getDefaultState());
                }*/
                //use if want to make purple tumor
                //if(grew) {
                ///    world.setBlockState(pos,Blocks.AIR.getDefaultState());
                //}
                // if(moved.get()) {
                //    world.setBlockState(pos,Blocks.AIR.getDefaultState());
                //}

            }
        }
    }
}
