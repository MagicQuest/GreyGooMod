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

public class TileEntityBrownGoo extends TileEntity implements ITickableTileEntity {
    private int life = 0;
    public TileEntityBrownGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityBrownGoo() {
        this(ModTileEntityTypes.brown_goo.get());
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
            if(this.life >= 1000) {
                world.setBlockState(pos,Blocks.AIR.getDefaultState());
            }
            int randomNum = Console.random(0,150);
            //Console.log(world.getGameRules().get(Mod.GOO_SPEED).get());
            randomNum-=world.getGameRules().get(Mod.GOO_SPEED).get();
            if(randomNum < 1) {
                randomNum = 1;
            }
            if (randomNum == 1) {
                if (Console.random(0, 5) == 5) {
                    //if (world.getBlockState(pos.add(1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(1, 0, 0);
                        if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState()||world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState()||world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                                world.setBlockState(posi, world.getBlockState(pos));


                        }

                    //}
                }

                if (Console.random(0, 5) == 5) {
                   // if (world.getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, 1);
                    if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState()||world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState()||world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                        world.setBlockState(posi, world.getBlockState(pos));


                    }
                  //  }
                }
                if (Console.random(0, 5) == 5) {
                   // if (world.getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(-1, 0, 0);
                    if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState()||world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState()||world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                        world.setBlockState(posi, world.getBlockState(pos));


                    }
                  // }
                }
                if (Console.random(0, 5) == 5) {
                   // if (world.getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, -1);
                    if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState()||world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState()||world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                        world.setBlockState(posi, world.getBlockState(pos));


                    }
                   // }
                }
                if (Console.random(0, 5) == 5) {
                  //  if (world.getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, -1, 0);
                    if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState()||world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState()||world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                        world.setBlockState(posi, world.getBlockState(pos));


                    }
                    //}
                }
                if (Console.random(0, 5) == 5) {
                   // if (world.getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 1, 0);
                    if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState()||world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState()||world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                        world.setBlockState(posi, world.getBlockState(pos));


                    }
                   // }
                }
            }
        }
    }
}
