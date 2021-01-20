package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
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
import net.minecraft.world.dimension.Dimension;

import javax.annotation.Nullable;

public class BlockRainbowGoo extends Block {
    public static Dimension nether;
    public static Dimension overworld;
    public static int life = 0;
    static boolean sleep;

    public BlockRainbowGoo(Properties properties) {
        super(properties);
       // properties.lightValue(1);
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
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        Block.spawnAsEntity(worldIn,pos,new ItemStack(this));
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        life = 0;
        if(!worldIn.isRemote) {

            if(sleep == true) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                return;
            }

            //Thread newThread = new Thread(() -> {
              //  try {
             //       Console.log("sleeping");
             //       sleep = true;
                    //Thread.sleep(20000);
              //      sleep = false;
             //       Console.log("woke up");
             //       life = 100000;
            //    } catch (InterruptedException e) {
            //        e.printStackTrace();
          //      }
          // });
           // newThread.start();
        }

    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.rainbow_goo.get().create();
    }
}
