package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModItems;
import megalonemo.goomod.init.ModTileEntityTypes;
import megalonemo.goomod.tileentity.TileEntityTumorGoo;
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

public class BlockTumorGoo extends Block {
    public TileEntityTumorGoo TumorTile;
    public BlockTumorGoo(Properties properties) {
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

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        //grow(pos,worldIn);

            Block.spawnAsEntity(worldIn,pos,new ItemStack(this));

    }

    private void grow(BlockPos pos,World world) {
        //IBlockState[] goos = new IBlockState[4];
        //goos[0] = ModBlocks.orange_goo.getDefaultState();
        //goos[1] = ModBlocks.green_goo.getDefaultState();
        //goos[2] = Blocks.AIR.getDefaultState();
        //goos[3] = ModBlocks.red_goo.getDefaultState();
        ///
        //for (int i = 0; i < goos.length; i++) {
        if (world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.green_goo.getDefaultState()&& world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
            BlockPos posi = pos.add(1, 0, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.green_goo.getDefaultState()&& world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.orange_goo.getDefaultState()) {
            BlockPos posi = pos.add(0, 0, 1);
            world.setBlockState(posi, world.getBlockState(pos));
        }

        if (world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.green_goo.getDefaultState()&& world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
            BlockPos posi = pos.add(-1, 0, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.green_goo.getDefaultState()&& world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.orange_goo.getDefaultState()) {
            BlockPos posi = pos.add(0, 0, -1);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.green_goo.getDefaultState()&& world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
            BlockPos posi = pos.add(0, -1, 0);
            world.setBlockState(posi, world.getBlockState(pos));
        }
        if (world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.green_goo.getDefaultState()&& world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
            BlockPos posi = pos.add(0, 1, 0);

                world.setBlockState(posi, world.getBlockState(pos));


        }
        //}



    }


    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        TumorTile = ModTileEntityTypes.tumor_goo.get().create();
        return TumorTile;
    }
}
