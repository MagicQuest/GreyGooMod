package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.blocks.BlockWhiteGreenGoo;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Arrays;

import static megalonemo.goomod.blocks.BlockWhiteGreenGoo.stop;

public class TileEntityWhiteGreenGoo extends TileEntity implements ITickableTileEntity {

    boolean dormant = false;

    public TileEntityWhiteGreenGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityWhiteGreenGoo() {
        this(ModTileEntityTypes.white_green_goo.get());
        this.dormant = false;
}

    @Override
    public void read(CompoundNBT nbt) {
        this.dormant = nbt.getBoolean("dormant");
        //super.readFromNBT(nbt);
        super.read(nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putBoolean("dormant",this.dormant);
        return super.write(nbt);
    }

    void setblocks(World world, BlockPos pos) {
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
            if(BlockWhiteGreenGoo.life >= 250000) {
                stop = true;
            }else if(!this.dormant){
                BlockWhiteGreenGoo.life++;
            }

            //Console.log(world.getLight(thisPos.add(0,1,0)));
            //Console.print(world.getBlockState(thisPos.add(0, -1, 0)));
            //if(stop == true) {
            //     world.setBlockState(thisPos, Blocks.AIR.getDefaultState());
            // }
            //abstract boolean int class void public static protected private return break continue true false if else this new super extends implements interface enum native () {

            // }
            if(stop) {
                this.dormant = true;
                //world.setBlockState(pos,Blocks.AIR.getDefaultState());
            }
            if(getLightAt(world,pos) >= 8) {

            }else {
                //Console.log(world.getLight(pos.add(0,1,0)));
                //Console.log(world.getLightValue(pos.add(0,1,0)));
                world.setBlockState(thisPos, Blocks.AIR.getDefaultState());
            }

            if(!this.dormant && Console.getRandom(50, world) == 1) {
                //Console.log(world.getLight(thisPos));

                setblocks(world, thisPos);
            }
            //if(bruh >= 2000) {
            //	world.setBlockState(thisPos, Blocks.CACTUS.getDefaultState());
            //}

        }
    }
}
