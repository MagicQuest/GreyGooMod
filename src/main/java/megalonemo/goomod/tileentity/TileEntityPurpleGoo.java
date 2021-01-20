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

public class TileEntityPurpleGoo extends TileEntity implements ITickableTileEntity {
    private int life = 0;

    public TileEntityPurpleGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityPurpleGoo() {
        this(ModTileEntityTypes.purple_goo.get());
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

    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos thisPos = this.pos;

        if (!world.isRemote) {
            this.life++;
            if(life >= 1000) {
                world.setBlockState(thisPos,Blocks.AIR.getDefaultState());
            }
            if (Console.getRandom(100,world) == 1) {

                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(1, 0, 0);
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }

                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, 1);
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(-1, 0, 0);
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, -1);
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, -1, 0);
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 1, 0);
                        world.setBlockState(posi, world.getBlockState(pos));
                    }
                }
            }
        }
    }
}
