package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import static megalonemo.goomod.Mod.SAND_ENABLED;

public class BlockYellowGoo extends FallingBlock {
    public BlockYellowGoo(Properties properties) {
        super(properties);
       // properties.lightValue(1);
      //  properties.hardnessAndResistance(.000f,1f);
    }

    //@Override
    //public boolean hasTileEntity(BlockState state) {
    //    return true;
    //}
    @Override
    public ActionResultType func_225533_a_(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        return ActionResultType.SUCCESS;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if(!world.isRemote && world.getGameRules().getBoolean(SAND_ENABLED)) {
            /*Stream<BlockPos> positions = Console.checkBox(pos.add(1, 1, 1), pos.add(-1, -1, -1));

            positions.forEach(posi -> {
                if (world.getBlockState(posi) != Blocks.AIR.getDefaultState() && world.getBlockState(posi) != Blocks.CAVE_AIR.getDefaultState()) {
                    if (world.getBlockState(posi.add(0, -1, 0)) == Blocks.AIR.getDefaultState() || world.getBlockState(posi.add(0, -1, 0)) == Blocks.CAVE_AIR.getDefaultState()) {
                        world.setBlockState(posi, ModBlocks.yellow_goo.getDefaultState());
                        //CompoundNBT nbt = new CompoundNBT();s

                        //EntityType.FALLING_BLOCK.spawn(world,);
                    }
                }
            });*/
            for (int i = 0; i < Console.getTouching(pos).length; i++) {
                BlockPos posi = Console.getTouching(pos)[i];
                if (world.getBlockState(posi) != Blocks.AIR.getDefaultState() && world.getBlockState(posi) != Blocks.CAVE_AIR.getDefaultState()) {
                    if (world.getBlockState(posi.add(0, -1, 0)) == Blocks.AIR.getDefaultState() || world.getBlockState(posi.add(0, -1, 0)) == Blocks.CAVE_AIR.getDefaultState() || world.getBlockState(posi.add(0, -2, 0)) == Blocks.CAVE_AIR.getDefaultState() || world.getBlockState(posi.add(0, -2, 0)) == Blocks.AIR.getDefaultState()) {
                        world.setBlockState(posi, ModBlocks.yellow_goo.getDefaultState());
                        //CompoundNBT nbt = new CompoundNBT();s
                        //EntityType.FALLING_BLOCK.spawn(world,);
                    }
                }
            }
        }
    }

    @Override
    protected void onStartFalling(FallingBlockEntity fallingEntity) {
        World world = fallingEntity.getWorldObj();
        BlockPos pos = fallingEntity.getPosition();
        if(!world.isRemote && world.getGameRules().getBoolean(SAND_ENABLED)) {
            /*Stream<BlockPos> positions = Console.checkBox(pos.add(1, 1, 1), pos.add(-1, -1, -1));

            positions.forEach(posi -> {
                if (world.getBlockState(posi) != Blocks.AIR.getDefaultState() && world.getBlockState(posi) != Blocks.CAVE_AIR.getDefaultState()) {
                    if (world.getBlockState(posi.add(0, -1, 0)) == Blocks.AIR.getDefaultState() || world.getBlockState(posi.add(0, -1, 0)) == Blocks.CAVE_AIR.getDefaultState()) {
                        world.setBlockState(posi, ModBlocks.yellow_goo.getDefaultState());
                        //CompoundNBT nbt = new CompoundNBT();s

                        //EntityType.FALLING_BLOCK.spawn(world,);
                    }
                }
            });*/
            for (int i = 0; i < Console.getTouching(pos).length; i++) {
                BlockPos posi = Console.getTouching(pos)[i];
                if (world.getBlockState(posi) != Blocks.AIR.getDefaultState() && world.getBlockState(posi) != Blocks.CAVE_AIR.getDefaultState()) {
                    if (world.getBlockState(posi.add(0, -1, 0)) == Blocks.AIR.getDefaultState() || world.getBlockState(posi.add(0, -1, 0)) == Blocks.CAVE_AIR.getDefaultState() || world.getBlockState(posi.add(0, -2, 0)) == Blocks.CAVE_AIR.getDefaultState() || world.getBlockState(posi.add(0, -2, 0)) == Blocks.AIR.getDefaultState()) {
                        world.setBlockState(posi, ModBlocks.yellow_goo.getDefaultState());
                        //CompoundNBT nbt = new CompoundNBT();s
                        //EntityType.FALLING_BLOCK.spawn(world,);
                    }
                }
            }
        }
    }

    @Override
    public void onEndFalling(World world, BlockPos pos, BlockState fallingState, BlockState hitState) {
        if(!world.isRemote && world.getGameRules().getBoolean(SAND_ENABLED)) {
            //Stream<BlockPos> positions = Console.checkBox(pos.add(1, 1, 1), pos.add(-1, -1, -1));
            //positions.forEach(posi -> {
            for (int i = 0; i < Console.getTouching(pos).length; i++) {
                BlockPos posi = Console.getTouching(pos)[i];
                if (world.getBlockState(posi) != Blocks.AIR.getDefaultState() && world.getBlockState(posi) != Blocks.CAVE_AIR.getDefaultState()) {
                    if (world.getBlockState(posi.add(0, -1, 0)) == Blocks.AIR.getDefaultState() || world.getBlockState(posi.add(0, -1, 0)) == Blocks.CAVE_AIR.getDefaultState() || world.getBlockState(posi.add(0, -2, 0)) == Blocks.CAVE_AIR.getDefaultState() || world.getBlockState(posi.add(0, -2, 0)) == Blocks.AIR.getDefaultState()) {
                        world.setBlockState(posi, ModBlocks.yellow_goo.getDefaultState());
                        //CompoundNBT nbt = new CompoundNBT();s
                        //EntityType.FALLING_BLOCK.spawn(world,);
                    }
                }
            }



            //});
        }
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {

            Block.spawnAsEntity(worldIn,pos,new ItemStack(this));

    }
    //@Override
    //public TileEntity createTileEntity(BlockState state, IBlockReader world) {
   //     return ModTileEntityTypes.yellow_goo.get().create();
   // }

    @Override
    public int getDustColor(BlockState state) {
        return 14406560;
    }
}
