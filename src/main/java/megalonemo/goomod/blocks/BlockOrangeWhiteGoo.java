package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockOrangeWhiteGoo extends Block {
    public BlockOrangeWhiteGoo(Properties properties) {
        super(properties);
        //properties.lightValue(15);
        //properties.hardnessAndResistance(.000f,1f);
    }
    @Override public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) { return true; }
    @OnlyIn(Dist.CLIENT)
    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
    }
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        grow(pos,worldIn);

        Block.spawnAsEntity(worldIn,pos,new ItemStack(this));

        super.onBlockClicked(state,worldIn,pos,player);
    }

    @Override
    public ActionResultType func_225533_a_(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        grow(p_225533_3_,p_225533_2_);
        return ActionResultType.SUCCESS;
    }

    @Override
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        grow(pos,worldIn);
        super.onBlockAdded(state, worldIn, pos, oldState, isMoving);
    }


    private void grow(BlockPos pos,World world) {
        ///boolean negx = false;
        //boolean posx = false;
        //boolean negz = false;
        //boolean posz = false;
        //boolean up = false;
        //boolean down = false;

        if (world.getBlockState(pos.add(1, 0, 0)) == ModBlocks.green_goo.getDefaultState()) {
            //Console.print("leftx");
            //posx = true;
            for (int i = 0; i < 500; i++) {
                if(world.getBlockState(pos.add(-i, 0, 0)) == ModBlocks.green_goo.getDefaultState()) {
                    break;
                }else {
                    if (world.getBlockState(pos.add(-i, 0, 0))!=ModBlocks.orange_white_goo.getDefaultState()) {
                        world.setBlockState(pos.add(-i, 0, 0),ModBlocks.orange_white_goo.getDefaultState());
                    }

                }
            }
        }
        if (world.getBlockState(pos.add(0, 0, 1)) == ModBlocks.green_goo.getDefaultState()) {
            //posz = true;
            //Console.print("rightz");

            for (int i = 0; i < 500; i++) {
                if(world.getBlockState(pos.add(0, 0, -i)) == ModBlocks.green_goo.getDefaultState()) {
                    break;
                }else {

                    if (world.getBlockState(pos.add(0, 0, -i))!= ModBlocks.orange_white_goo.getDefaultState()) {
                        world.setBlockState(pos.add(0, 0, -i),ModBlocks.orange_white_goo.getDefaultState());
                    }

                }
            }

        }

        if (world.getBlockState(pos.add(-1, 0, 0)) == ModBlocks.green_goo.getDefaultState()) {
            //negx = true;
            //Console.print("rightx");
            for (int i = 0; i < 500; i++) {
                if(world.getBlockState(pos.add(i, 0, 0)) == ModBlocks.green_goo.getDefaultState()) {
                    break;
                }else {
                    if (world.getBlockState(pos.add(i, 0, 0))!=ModBlocks.orange_white_goo.getDefaultState()) {
                        world.setBlockState(pos.add(i, 0, 0),ModBlocks.orange_white_goo.getDefaultState());
                    }
                }

            }
        }
        if (world.getBlockState(pos.add(0, 0, -1)) == ModBlocks.green_goo.getDefaultState()) {
            for (int i = 0; i < 500; i++) {
                if(world.getBlockState(pos.add(0, 0, i)) == ModBlocks.green_goo.getDefaultState()) {
                    break;
                }else {
                    if (world.getBlockState(pos.add(0, 0, i))!=ModBlocks.orange_white_goo.getDefaultState()) {
                        world.setBlockState(pos.add(0, 0, i),ModBlocks.orange_white_goo.getDefaultState());
                    }

                }
            }
        }
        if (world.getBlockState(pos.add(0, -1, 0)) == ModBlocks.green_goo.getDefaultState()) {


            for (int i = 0; i < -(pos.getY()-255); i++) {
                //Console.print(world.getBlockState(pos.add(0, i, 0)));
                if(world.getBlockState(pos.add(0, i, 0)) == ModBlocks.green_goo.getDefaultState()) {
                    break;
                }else {
                    if (world.getBlockState(pos.add(0, i, 0))!=ModBlocks.orange_white_goo.getDefaultState()) {
                        world.setBlockState(pos.add(0, i, 0),ModBlocks.orange_white_goo.getDefaultState());
                    }

                }
            }


            //Console.print("down");
        }
        if (world.getBlockState(pos.add(0, 1, 0)) == ModBlocks.green_goo.getDefaultState()) {
            //up = true;
            //Console.print("up");
            for (int i = 0; i < pos.getY()+1; i++) {
                //Console.print(world.getBlockState(pos.add(0, -i, 0)));
                if(world.getBlockState(pos.add(0, -i, 0)) == ModBlocks.green_goo.getDefaultState()) {
                    break;
                }else {

                    if (world.getBlockState(pos.add(0, -i, 0))!=ModBlocks.orange_white_goo.getDefaultState()) {
                        world.setBlockState(pos.add(0, -i, 0),ModBlocks.orange_white_goo.getDefaultState());
                    }
                }
            }

        }
    }
}
