package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Arrays;

public class TileEntityWhiteGoo extends TileEntity implements ITickableTileEntity {
    public TileEntityWhiteGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityWhiteGoo() {
        this(ModTileEntityTypes.white_goo.get());
    }

    void setblocks(World world,BlockPos pos) {
       // if(Console.random(0, 2)==1) {
            if (world.getBlockState(pos.add(1, 0, 0)) == Blocks.AIR.getDefaultState()) {
                BlockPos posi = pos.add(1, 0, 0);
                if(getLightAt(world,posi) >= 8) {
                    world.setBlockState(posi, world.getBlockState(pos));
                }




            }
        //}
        //if(Console.random(0, 2)==1) {
            if (world.getBlockState(pos.add(0, 0, 1)) == Blocks.AIR.getDefaultState()) {
                BlockPos posi = pos.add(0, 0, 1);
                //world.setBlockState(posi, world.getBlockState(pos));
                if(getLightAt(world,posi) >= 8) {
                    world.setBlockState(posi, world.getBlockState(pos));
                }

            }
        //}
        //if(Console.random(0, 2)==1) {
            if (world.getBlockState(pos.add(-1, 0, 0)) ==Blocks.AIR.getDefaultState()) {
                BlockPos posi = pos.add(-1, 0, 0);
                //world.setBlockState(posi, world.getBlockState(pos));
                if(getLightAt(world,posi) >= 8) {
                    world.setBlockState(posi, world.getBlockState(pos));
                }
                //if(Console.random(0, 2) == 1) {
                //	world.setBlockState(pos, Blocks.AIR.getDefaultState());
                //}
                //setblocks(world, posi);

            }
        //}
        //if(Console.random(0, 2)==1) {
            if (world.getBlockState(pos.add(0, 0, -1)) == Blocks.AIR.getDefaultState()) {
                BlockPos posi = pos.add(0, 0, -1);
                //world.setBlockState(posi, world.getBlockState(pos));
                if(getLightAt(world,posi) >= 8) {
                    world.setBlockState(posi, world.getBlockState(pos));
                }
                //if(Console.random(0, 2) == 1) {
                //world.setBlockState(pos, Blocks.AIR.getDefaultState());
                //}

                //setblocks(world, posi);

            }
        //}
        //if(Console.random(0, 5)==1) {
            if (world.getBlockState(pos.add(0, -1, 0)) == Blocks.AIR.getDefaultState()) {
                BlockPos posi = pos.add(0, -1, 0);
                //world.setBlockState(posi, world.getBlockState(pos));
                if(getLightAt(world,posi) >= 8) {
                    world.setBlockState(posi, world.getBlockState(pos));
                }
                //if(Console.random(0, 2) == 1) {
                //world.setBlockState(pos, Blocks.AIR.getDefaultState());
                //}

                //setblocks(world, posi);

            }
        //}
        //if(Console.random(0, 2)==1) {
            if (world.getBlockState(pos.add(0, 1, 0)) == Blocks.AIR.getDefaultState()) {
                BlockPos posi = pos.add(0, 1, 0);
                //world.setBlockState(posi, world.getBlockState(pos));
                if(getLightAt(world,posi) >= 8) {
                    world.setBlockState(posi, world.getBlockState(pos));
                }
                //if(Console.random(0, 2) == 1) {

                //}

                //setblocks(world, posi);

            }
        //}
        world.setBlockState(pos, Blocks.AIR.getDefaultState());
    }

    private int getLightAt(World world,BlockPos pos) {
        int[] light=new int[6];
        light[0]=world.getLight(pos.add(1,0,0));
        light[1]=world.getLight(pos.add(0,1,0));
        light[2]=world.getLight(pos.add(0,0,1));
        light[3]=world.getLight(pos.add(0,0,-1));
        light[4]=world.getLight(pos.add(0,-1,0));
        light[5]=world.getLight(pos.add(-1,0,0));
        Arrays.sort(light,0,6);
        return light[5];
    }

    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos thisPos = this.pos;
        if(!world.isRemote) {
            //Console.log(world.getLight(thisPos.add(0,1,0)));
            //Console.print(world.getBlockState(thisPos.add(0, -1, 0)));
            //if(stop == true) {
           //     world.setBlockState(thisPos, Blocks.AIR.getDefaultState());
           // }
            if(getLightAt(world,pos) >= 8) {

            }else {
                //Console.log(world.getLight(pos.add(0,1,0)));
                //Console.log(world.getLightValue(pos.add(0,1,0)));
                world.setBlockState(thisPos, Blocks.AIR.getDefaultState());
            }
            if(Console.getRandom(250, world) == 1) {
                //Console.log(world.getLight(thisPos));

                setblocks(world, thisPos);
            }
            //if(bruh >= 2000) {
            //	world.setBlockState(thisPos, Blocks.CACTUS.getDefaultState());
            //}

        }
    }
}
