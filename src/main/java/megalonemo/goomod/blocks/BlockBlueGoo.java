package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModItems;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockBlueGoo extends Block {
    public BlockBlueGoo(Properties properties) {
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
        return ModTileEntityTypes.blue_goo.get().create();
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        grow(pos,worldIn);

            Block.spawnAsEntity(worldIn,pos,new ItemStack(this));




        super.onBlockClicked(state, worldIn, pos, player);
    }

    private void grow(BlockPos pos,World world) {

        if (!world.getBlockState(pos.add(1,0,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") || world.getBlockState(pos.add(1, 0, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.KELP_PLANT.getDefaultState() ||world.getBlockState(pos.add(1, 0, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(1, 0, 0)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(1, 0, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (!world.getBlockState(pos.add(0,0,1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, 0, 1)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, 0, 1)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, 0, 1)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(0, 0, 1);
            world.setBlockState(posi, world.getBlockState(pos));
        }

        if (!world.getBlockState(pos.add(-1,0,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(-1, 0, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(-1, 0, 0)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(-1, 0, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (!world.getBlockState(pos.add(0,0,-1)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, 0, -1)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, 0, -1)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, 0, -1)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(0, 0, -1);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (!world.getBlockState(pos.add(0,-1,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, -1, 0)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, -1, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, -1, 0)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(0, -1, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (!world.getBlockState(pos.add(0,1,0)).getFluidState().getFluid().toString().matches(".*EmptyFluid.*") ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.TALL_SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.SEAGRASS.getDefaultState() ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.KELP.getDefaultState() ||world.getBlockState(pos.add(0, 1, 0)) == Blocks.KELP_PLANT.getDefaultState()||world.getBlockState(pos.add(0, 1, 0)) == Blocks.LAVA.getDefaultState() || world.getBlockState(pos.add(0, 1, 0)) == Blocks.WATER.getDefaultState()) {
            BlockPos posi = pos.add(0, 1, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }


    }
}
