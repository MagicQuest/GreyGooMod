package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModItems;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockRedGoo extends Block {
    public BlockRedGoo(Properties properties) {
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
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.red_goo.get().create();
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        grow(pos,worldIn);

            Block.spawnAsEntity(worldIn,pos,new ItemStack(this));

    }

    private void grow(BlockPos pos, World world) {
        BlockState[] goos = new BlockState[10];
        goos[0] = ModBlocks.blue_goo.getDefaultState();
        //goos[1] = ModBlocks.green_goo.getDefaultState();
        goos[1] = ModBlocks.grey_goo.getDefaultState();
        goos[2] = ModBlocks.orange_goo.getDefaultState();
        goos[3] = ModBlocks.plague_goo.getDefaultState();
        goos[4] = ModBlocks.white_goo.getDefaultState();
        goos[5] = ModBlocks.purple_goo.getDefaultState();
        goos[6] = ModBlocks.rainbow_goo.getDefaultState();
        goos[7] = ModBlocks.brown_goo.getDefaultState();
        goos[8] = ModBlocks.tumor_goo.getDefaultState();
        goos[9]=ModBlocks.darkness_goo.getDefaultState();
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
        }



    }
}
