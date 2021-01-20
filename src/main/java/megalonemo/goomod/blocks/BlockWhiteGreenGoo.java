package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

public class BlockWhiteGreenGoo extends Block {
    public static boolean stop = false;
    public static boolean sleeping = false;
    public static int life = 0;
    public BlockWhiteGreenGoo(Properties properties) {
        super(properties);
        //properties.lightValue(1);
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
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.white_green_goo.get().create();
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if(!worldIn.isRemote) {
            stop = false;
            life = 0;
        }
        /*if(!worldIn.isRemote) {
            if (!sleeping) {
                stop = false;
                Thread thread = new Thread(() -> {
                    try {
                        sleeping = true;
                        Thread.sleep(7000);
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
        }*/
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {

            Block.spawnAsEntity(worldIn,pos,new ItemStack(this));

    }
}
