package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModItems;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockBrownRedGoo extends Block {
    public static boolean stop = false;
    boolean sleeping = false;
    public BlockBrownRedGoo(Properties properties) {
        super(properties);
        //properties.lightValue(1);
        //properties.hardnessAndResistance(.000f,1f);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
    @Override
    public ActionResultType func_225533_a_(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        return ActionResultType.SUCCESS;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {

        if(!worldIn.isRemote) {
            if (!sleeping) {
                stop = false;
                Thread thread = new Thread(() -> {
                    try {
                        sleeping = true;
                        Thread.sleep(4000);
                        sleeping = false;
                        stop = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
            } else {
               // worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.brown_red_goo.get().create();
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        grow(pos,worldIn);


            Block.spawnAsEntity(worldIn,pos,new ItemStack(this));

    }

    private void grow(BlockPos pos, World world) {
        BlockState[] goos = new BlockState[6];
        goos[0] = Blocks.STONE.getDefaultState();
        goos[1] = Blocks.COBBLESTONE.getDefaultState();
        goos[2] = Blocks.ANDESITE.getDefaultState();
        goos[3] = Blocks.DIORITE.getDefaultState();
        goos[4] = Blocks.GRANITE.getDefaultState();
        goos[5] = Blocks.SANDSTONE.getDefaultState();
        if(!world.isRemote) {
            for (int i = 0; i < goos.length; i++) {
                if (world.getBlockState(pos.add(1, 0, 0)) == goos[i]) {
                    world.setBlockState(pos.add(1, 0, 0), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(0, 1, 0)) == goos[i]) {
                    world.setBlockState(pos.add(0, 1, 0), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(0, 0, 1)) == goos[i]) {
                    world.setBlockState(pos.add(0, 0, 1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(0, 0, -1)) == goos[i]) {
                    world.setBlockState(pos.add(0, 0, -1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(-1, 0, 0)) == goos[i]) {
                    world.setBlockState(pos.add(-1, 0, 0), ModBlocks.brown_red_goo.getDefaultState());
                }

                if (world.getBlockState(pos.add(1, 0, 1)) == goos[i]) {
                    world.setBlockState(pos.add(1, 0, 1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(1, 0, -1)) == goos[i]) {
                    world.setBlockState(pos.add(1, 0, -1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(-1, 0, -1)) == goos[i]) {
                    world.setBlockState(pos.add(-1, 0, -1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(-1, 0, 1)) == goos[i]) {
                    world.setBlockState(pos.add(-1, 0, 1), ModBlocks.brown_red_goo.getDefaultState());
                }


                if (world.getBlockState(pos.add(1, 1, 0)) == goos[i]) {
                    world.setBlockState(pos.add(1, 1, 0), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(0, 1, 1)) == goos[i]) {
                    world.setBlockState(pos.add(0, 1, 1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(0, 1, -1)) == goos[i]) {
                    world.setBlockState(pos.add(0, 1, -1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(-1, 1, 0)) == goos[i]) {
                    world.setBlockState(pos.add(-1, 1, 0), ModBlocks.brown_red_goo.getDefaultState());
                }

                if (world.getBlockState(pos.add(1, 1, 1)) == goos[i]) {
                    world.setBlockState(pos.add(1, 1, 1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(1, 1, -1)) == goos[i]) {
                    world.setBlockState(pos.add(1, 1, -1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(-1, 1, -1)) == goos[i]) {
                    world.setBlockState(pos.add(-1, 1, -1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(-1, 1, 1)) == goos[i]) {
                    world.setBlockState(pos.add(-1, 1, 1), ModBlocks.brown_red_goo.getDefaultState());
                }


                if (world.getBlockState(pos.add(1, -1, 0)) == goos[i]) {
                    world.setBlockState(pos.add(1, -1, 0), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(0, -1, 1)) == goos[i]) {
                    world.setBlockState(pos.add(0, -1, 1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(0, -1, -1)) == goos[i]) {
                    world.setBlockState(pos.add(0, -1, -1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(-1, -1, 0)) == goos[i]) {
                    world.setBlockState(pos.add(-1, -1, 0), ModBlocks.brown_red_goo.getDefaultState());
                }

                if (world.getBlockState(pos.add(1, -1, 1)) == goos[i]) {
                    world.setBlockState(pos.add(1, -1, 1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(1, -1, -1)) == goos[i]) {
                    world.setBlockState(pos.add(1, -1, -1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(-1, -1, -1)) == goos[i]) {
                    world.setBlockState(pos.add(-1, -1, -1), ModBlocks.brown_red_goo.getDefaultState());
                }
                if (world.getBlockState(pos.add(-1, -1, 1)) == goos[i]) {
                    world.setBlockState(pos.add(-1, -1, 1), ModBlocks.brown_red_goo.getDefaultState());
                }
            }
        }


    }
}
