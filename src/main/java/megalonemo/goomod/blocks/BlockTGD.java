package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
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

public class BlockTGD extends Block {
    public BlockTGD(Properties properties) {
        super(properties);

       // properties.hardnessAndResistance(.000f,1f);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
    @Override
    public ActionResultType func_225533_a_(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        return ActionResultType.SUCCESS;
    }

    private void grow(BlockPos pos,World world) {
        //IBlockState[] goos = new IBlockState[4];
        //goos[0] = ModBlocks.orange_goo.getDefaultState();
        //goos[1] = ModBlocks.green_goo.getDefaultState();
        //goos[2] = Blocks.AIR.getDefaultState();
        //goos[3] = ModBlocks.red_goo.getDefaultState();
        ///
        //for (int i = 0; i < goos.length; i++) {
        ///if (world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.green_goo.getDefaultState()&& world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
            BlockPos posi = pos.add(0, 1, 0);

                world.setBlockState(posi, world.getBlockState(pos));


        //}
        //}



    }


    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.tgd.get().create();
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if(!world.isRemote) {
            Mod.BLOOM++;
        }
    }

    @Override
    public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
        if(!world.isRemote) {
            Mod.BLOOM--;
        }
        super.onReplaced(state, world, pos, newState, isMoving);
    }
}
