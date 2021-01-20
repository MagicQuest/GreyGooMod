package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
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

public class BlockWhiteGoo extends Block {
    public BlockWhiteGoo(Properties properties) {
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
        return ModTileEntityTypes.white_goo.get().create();
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {

            Block.spawnAsEntity(worldIn,pos,new ItemStack(this));

    }
}
