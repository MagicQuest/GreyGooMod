package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityBlueGoo extends TileEntity implements ITickableTileEntity {
    //public static boolean stop = false;

    private int life = 0;

    public TileEntityBlueGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public TileEntityBlueGoo() {
        this(ModTileEntityTypes.blue_goo.get());
        this.life = 0;
    }


    @Override
    public void read(CompoundNBT nbt) {
        this.life = nbt.getInt("life");
        //super.readFromNBT(nbt);
        super.read(nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putInt("life",this.life);
        return super.write(nbt);
    }

    void setblocks(World world,BlockPos pos) {
        Console.log(world.getBlockState(pos.add(0,-1,0)).getFluidState());
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

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        World world = this.getWorld();
        BlockPos thisPos = this.pos;
        if(!world.isRemote) {
            //Console.log(world.getBlockState(thisPos.add(0, -1, 0)));
            if(world.getBlockState(thisPos.add(0, -1, 0)) == Blocks.WATER.getDefaultState()) {
                world.setBlockState(thisPos.add(0, -1, 0), world.getBlockState(thisPos));
            }
            //if(stop == true) {
            //    world.setBlockState(thisPos, Blocks.AIR.getDefaultState());
            //}
            if(life >= 50) {
                world.setBlockState(thisPos, Blocks.AIR.getDefaultState());
            }
            int randomNum = Console.random(0,250);
            //Console.log(world.getGameRules().get(Mod.GOO_SPEED).get());
            randomNum-=world.getGameRules().get(Mod.GOO_SPEED).get();
            if(randomNum < 1) {
                randomNum = 1;
            }
            //Console.log(randomNum);
            if(randomNum == 1) {
                this.life++;
                setblocks(world, thisPos);
            }
            //if(bruh >= 2000) {
            //	world.setBlockState(thisPos, Blocks.CACTUS.getDefaultState());
            //}

        }

    }

}
