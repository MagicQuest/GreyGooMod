package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.blocks.BlockBrownRedGoo;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityBrownRedGoo extends TileEntity implements ITickableTileEntity {
    public TileEntityBrownRedGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityBrownRedGoo() {
        this(ModTileEntityTypes.brown_red_goo.get());
    }

    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos thisPos = this.pos;

        if (!world.isRemote) {
            if(BlockBrownRedGoo.stop) {
                world.setBlockState(pos,Blocks.AIR.getDefaultState());
            }
            int randomNum = Console.random(0,10);
            //Console.log(world.getGameRules().get(Mod.GOO_SPEED).get());
            randomNum-=world.getGameRules().get(Mod.GOO_SPEED).get();
            if(randomNum < 1) {
                randomNum = 1;
            }
            if (randomNum == 1) {
                if (true) {
                    //if (world.getBlockState(pos.add(1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(1, 0, 0);
                        if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState() || world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState() || world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                                world.setBlockState(posi, world.getBlockState(pos));

                        }

                    //}
                }

                if (true) {
                   // if (world.getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, 1);
                    if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState() || world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState() || world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                        world.setBlockState(posi, world.getBlockState(pos));

                    }
                  //  }
                }
                if (true) {
                   // if (world.getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(-1, 0, 0);
                    if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState() || world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState() || world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                        world.setBlockState(posi, world.getBlockState(pos));

                    }
                  // }
                }
                if (true) {
                   // if (world.getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, -1);
                    if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState() || world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState() || world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                        world.setBlockState(posi, world.getBlockState(pos));

                    }
                   // }
                }
                if (true) {
                  //  if (world.getBlockState(pos.add(0, -1, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, -1, 0);
                    if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState() || world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState() || world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                        world.setBlockState(posi, world.getBlockState(pos));

                    }
                    //}
                }
                if (true) {
                   // if (world.getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.red_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 1, 0);
                    if(world.getBlockState(posi) == Blocks.SANDSTONE.getDefaultState() || world.getBlockState(posi) == Blocks.COBBLESTONE.getDefaultState() || world.getBlockState(posi) == Blocks.GRANITE.getDefaultState() || world.getBlockState(posi) == Blocks.ANDESITE.getDefaultState() || world.getBlockState(posi) == Blocks.DIORITE.getDefaultState() || world.getBlockState(posi) == Blocks.STONE.getDefaultState()) {

                        world.setBlockState(posi, world.getBlockState(pos));

                    }
                   // }
                }
                world.setBlockState(pos,Blocks.AIR.getDefaultState());
            }
        }
    }
}
