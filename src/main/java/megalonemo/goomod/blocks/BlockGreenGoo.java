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
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockGreenGoo extends Block {
    public BlockGreenGoo(Properties properties) {
        super(properties);
        //properties.lightValue(1);
        //properties.hardnessAndResistance(.000f,1f);
    }

    @Override
    public ActionResultType func_225533_a_(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult ray) {
        if(!world.isRemote) {
            player.sendMessage(new StringTextComponent("TGD Bloom status--"+(Mod.BLOOM>0)+"\nGlobal Goo Active status--"+world.getGameRules().getBoolean(Mod.GOO_ENABLED)+"\nEMP Array status--"+Mod.EMP_ARRAY_ACTIVE));
        }
        return ActionResultType.SUCCESS;
    }
    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {

        Block.spawnAsEntity(worldIn, pos, new ItemStack(this));

    }
}
