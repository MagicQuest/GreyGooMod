package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityRedGoo extends TileEntity implements ITickableTileEntity {
    public static boolean stop = false;

    private int life = 0;

    public TileEntityRedGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public TileEntityRedGoo() {
        this(ModTileEntityTypes.red_goo.get());
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


    @Override
    public void tick() {
        // TODO Auto-generated method stub
        World world = this.getWorld();
        BlockPos thisPos = this.pos;
        if(!world.isRemote) {
            this.life++;
            if(this.life >= 1000) {
                world.setBlockState(thisPos, Blocks.AIR.getDefaultState());
            }
            if(stop == true) {
                world.setBlockState(thisPos, Blocks.AIR.getDefaultState());
            }
            if(Console.getRandom(75,world) == 1) {

                BlockState[] goos = new BlockState[11];
                goos[0] = ModBlocks.blue_goo.getDefaultState();
               // goos[1] = ModBlocks.green_goo.getDefaultState();
                goos[1] = ModBlocks.grey_goo.getDefaultState();
                goos[2] = ModBlocks.orange_goo.getDefaultState();
                goos[3] = ModBlocks.plague_goo.getDefaultState();
                goos[4] = ModBlocks.white_goo.getDefaultState();
                goos[5] = ModBlocks.purple_goo.getDefaultState();
                goos[6] = ModBlocks.rainbow_goo.getDefaultState();
                goos[7] = ModBlocks.brown_goo.getDefaultState();
                goos[8] = ModBlocks.tumor_goo.getDefaultState();
                goos[9]=ModBlocks.darkness_goo.getDefaultState();
                goos[10] = ModBlocks.green_red_goo.getDefaultState();
                for (int i = 0; i < goos.length; i++) {
                    if(world.getBlockState(pos.add(1, 0, 0)) == goos[i]) {
                        world.setBlockState(pos.add(1, 0, 0), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0, 1, 0)) == goos[i]) {
                        world.setBlockState(pos.add(0, 1, 0), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0, 0, 1)) == goos[i]) {
                        world.setBlockState(pos.add(0, 0, 1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0, 0, -1)) == goos[i]) {
                        world.setBlockState(pos.add(0, 0, -1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(-1, 0, 0)) == goos[i]) {
                        world.setBlockState(pos.add(-1, 0, 0), ModBlocks.red_goo.getDefaultState());
                    }

                    if(world.getBlockState(pos.add(1, 0, 1)) == goos[i]) {
                        world.setBlockState(pos.add(1, 0, 1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(1, 0, -1)) == goos[i]) {
                        world.setBlockState(pos.add(1, 0, -1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(-1, 0, -1)) == goos[i]) {
                        world.setBlockState(pos.add(-1, 0, -1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(-1, 0, 1)) == goos[i]) {
                        world.setBlockState(pos.add(-1, 0, 1), ModBlocks.red_goo.getDefaultState());
                    }


                    if(world.getBlockState(pos.add(1, 1, 0)) == goos[i]) {
                        world.setBlockState(pos.add(1, 1, 0), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0, 1, 1)) == goos[i]) {
                        world.setBlockState(pos.add(0, 1, 1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0, 1, -1)) == goos[i]) {
                        world.setBlockState(pos.add(0, 1, -1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(-1, 1, 0)) == goos[i]) {
                        world.setBlockState(pos.add(-1, 1, 0), ModBlocks.red_goo.getDefaultState());
                    }

                    if(world.getBlockState(pos.add(1, 1, 1)) == goos[i]) {
                        world.setBlockState(pos.add(1, 1, 1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(1, 1, -1)) == goos[i]) {
                        world.setBlockState(pos.add(1, 1, -1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(-1, 1, -1)) == goos[i]) {
                        world.setBlockState(pos.add(-1, 1, -1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(-1, 1, 1)) == goos[i]) {
                        world.setBlockState(pos.add(-1, 1, 1), ModBlocks.red_goo.getDefaultState());
                    }


                    if(world.getBlockState(pos.add(1, -1, 0)) == goos[i]) {
                        world.setBlockState(pos.add(1, -1, 0), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0, -1, 1)) == goos[i]) {
                        world.setBlockState(pos.add(0, -1, 1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0, -1, -1)) == goos[i]) {
                        world.setBlockState(pos.add(0, -1, -1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(-1, -1, 0)) == goos[i]) {
                        world.setBlockState(pos.add(-1, -1, 0), ModBlocks.red_goo.getDefaultState());
                    }

                    if(world.getBlockState(pos.add(1, -1, 1)) == goos[i]) {
                        world.setBlockState(pos.add(1, -1, 1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(1, -1, -1)) == goos[i]) {
                        world.setBlockState(pos.add(1, -1, -1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(-1, -1, -1)) == goos[i]) {
                        world.setBlockState(pos.add(-1, -1, -1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(-1, -1, 1)) == goos[i]) {
                        world.setBlockState(pos.add(-1, -1, 1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(1,0,0)) == goos[i]) {
                        world.setBlockState(pos.add(1,0,0), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0,0,1)) == goos[i]) {
                        world.setBlockState(pos.add(0,0,1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(-1,0,0)) == goos[i]) {
                        world.setBlockState(pos.add(-1,0,0), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0,0,-1)) == goos[i]) {
                        world.setBlockState(pos.add(0,0,-1), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0,-1,0)) == goos[i]) {
                        world.setBlockState(pos.add(0,-1,0), ModBlocks.red_goo.getDefaultState());
                    }
                    if(world.getBlockState(pos.add(0,1,0)) == goos[i]) {
                        world.setBlockState(pos.add(0,1,0), ModBlocks.red_goo.getDefaultState());
                    }
                }
                world.setBlockState(thisPos, Blocks.AIR.getDefaultState());

            }
        }

    }

}
