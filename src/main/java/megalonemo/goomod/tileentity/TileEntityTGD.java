package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class TileEntityTGD extends TileEntity implements ITickableTileEntity {
    public TileEntityTGD(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityTGD() {
        this(ModTileEntityTypes.tgd.get());
    }

    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos thisPos = this.pos;


        if (!world.isRemote) {

            if(Console.getRandom(50,world)==1) {
                ///if (world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                BlockPos posi = pos.add(0, 1, 0);

                // if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState() && world.getBlockState(posi)!=ModBlocks.darkness_goo.getDefaultState()) {
                world.setBlockState(posi, world.getBlockState(pos));
                //}
            }
            //}
            }
            if (Console.getRandom(100,world) == 1) {
                if(pos.getY() == 255) {
                    if(world.getBlockState(pos.add(1,0,0)) != this.getBlockState()) {
                        world.setBlockState(pos.add(1,0,0),this.getBlockState());
                    }
                    if(world.getBlockState(pos.add(0,0,1)) != this.getBlockState()) {
                        world.setBlockState(pos.add(0,0,1),this.getBlockState());
                    }
                    if(world.getBlockState(pos.add(0,0,-1)) != this.getBlockState()) {
                        world.setBlockState(pos.add(0,0,-1),this.getBlockState());
                    }
                    if(world.getBlockState(pos.add(-1,0,0)) != this.getBlockState()) {
                        world.setBlockState(pos.add(-1,0,0),this.getBlockState());
                    }
                }



            }
        }
}
