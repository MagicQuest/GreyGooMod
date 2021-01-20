package megalonemo.goomod.blocks;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModItems;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class BlockPlagueGoo extends Block {
    public BlockPlagueGoo(Properties properties) {
        super(properties);
        //properties.lightValue(1);
       // properties.hardnessAndResistance(.000f,1f);
    }

    @Override
    public ActionResultType func_225533_a_(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntityTypes.plague_goo.get().create();
    }

    @Override
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {

            Block.spawnAsEntity(worldIn,pos,new ItemStack(this));

    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        grow(pos,worldIn,entityIn);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        grow(pos,worldIn,entityIn);
    }

    public void grow(BlockPos pos, World worldIn, Entity entityIn) {
        if(worldIn.getBlockState(pos.add(1, 0, 0)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(1, 0, 0), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(0, 1, 0), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(0, 0, 1), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(0, 0, -1), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(-1, 0, 0), ModBlocks.plague_goo.getDefaultState());
        }

        if(worldIn.getBlockState(pos.add(1, 0, 1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(1, 0, 1), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(1, 0, -1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(1, 0, -1), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(-1, 0, -1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(-1, 0, -1), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(-1, 0, 1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(-1, 0, 1), ModBlocks.plague_goo.getDefaultState());
        }


        if(worldIn.getBlockState(pos.add(1, 1, 0)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(1, 1, 0), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(0, 1, 1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(0, 1, 1), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(0, 1, -1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(0, 1, -1), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(-1, 1, 0)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(-1, 1, 0), ModBlocks.plague_goo.getDefaultState());
        }

        if(worldIn.getBlockState(pos.add(1, 1, 1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(1, 1, 1), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(1, 1, -1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(1, 1, -1), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(-1, 1, -1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(-1, 1, -1), ModBlocks.plague_goo.getDefaultState());
        }
        if(worldIn.getBlockState(pos.add(-1, 1, 1)) != Blocks.AIR.getDefaultState()) {
            worldIn.setBlockState(pos.add(-1, 1, 1), ModBlocks.plague_goo.getDefaultState());
        }
        try {
            PlayerEntity plr = (PlayerEntity) entityIn;
            plr.addPotionEffect(new EffectInstance(Effect.get(4),100,1));
            plr.addPotionEffect(new EffectInstance(Effect.get(19),100,1));
            plr.addPotionEffect(new EffectInstance(Effect.get(20),100,1));
            //plr.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("poison"),100,1));
            //plr.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("wither"),100,1));
            //plr.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("mining_fatigue"),100,1));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    //@OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double d0 = pos.getX() + rand.nextFloat();
        double d1 = pos.getY() + 1;
        double d2 = pos.getZ() + rand.nextFloat();
        worldIn.addParticle(ParticleTypes.PORTAL, d0, d1, d2, 0.0D, -0.5D, 0.0D);
        //worldIn.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}
