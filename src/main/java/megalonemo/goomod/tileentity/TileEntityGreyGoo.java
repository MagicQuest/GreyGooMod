package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityGreyGoo extends TileEntity implements ITickableTileEntity {
    private int life = 0;

    public TileEntityGreyGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityGreyGoo() {
        this(ModTileEntityTypes.grey_goo.get());
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
        World world = this.getWorld();
        BlockPos thisPos = this.pos;


        if (!world.isRemote) {
           // if(this.life>=4000) {
            if(this.life>=30) {
                world.setBlockState(pos, ModBlocks.tumor_goo.getDefaultState());
            }
             //}
            //this.life++;

            if (Console.getRandom(300,world) == 1) {
                this.life++;
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(1, 0, 0);
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                        }

                    }
                }

                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, 1);
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                        }
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(-1, 0, 0);
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                        }
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, -1);
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                        }
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, -1, 0);
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                        }
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 1, 0);
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                        }
                    }
                }
            }
        }
    }
}
