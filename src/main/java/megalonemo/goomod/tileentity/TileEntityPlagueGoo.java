package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class TileEntityPlagueGoo extends TileEntity implements ITickableTileEntity {
    private int life =0;
    public TileEntityPlagueGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public TileEntityPlagueGoo() {
        this(ModTileEntityTypes.plague_goo.get());
        this.life = 0;
    }

    @Override
    public void read(CompoundNBT nbt) {
        this.life = nbt.getInt("life");
        super.read(nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putInt("life",this.life);
        return super.write(nbt);
    }


    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos thisPos = this.pos;
        if(!world.isRemote) {
            this.life++;
            if(this.life >= 5000) {
                world.setBlockState(pos,ModBlocks.tgd.getDefaultState());
            }
            if(Console.getRandom(1000,world) == Console.getRandom(1000,world)) {
                if(Console.getRandom(1000,world) == Console.getRandom(1000,world)) {
                    EntityType.SKELETON.spawn(world,null,null,null,pos.add(0,1,0), SpawnReason.NATURAL,true,false);

                }
                if(world.getBlockState(pos.add(1, 0, 0)) != Blocks.AIR.getDefaultState() && world.getBlockState(pos.add(1,0,0)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(1, 0, 0), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(0, 1, 0)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(0,1,0)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(0, 1, 0), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(0, 0, 1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(0,0,1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(0, 0, 1), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(0, 0, -1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(0,0,-1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(0, 0, -1), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(-1, 0, 0)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(-1,0,0)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(-1, 0, 0), ModBlocks.plague_goo.getDefaultState());
                }

                if(world.getBlockState(pos.add(1, 0, 1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(1,0,1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(1, 0, 1), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(1, 0, -1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(1,0,-1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(1, 0, -1), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(-1, 0, -1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(-1,0,-1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(-1, 0, -1), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(-1, 0, 1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(-1,0,1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(-1, 0, 1), ModBlocks.plague_goo.getDefaultState());
                }


                if(world.getBlockState(pos.add(1, 1, 0)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(1,1,0)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(1, 1, 0), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(0, 1, 1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(0,1,1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(0, 1, 1), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(0, 1, -1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(0,1,-1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(0, 1, -1), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(-1, 1, 0)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(-1,1,0)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(-1, 1, 0), ModBlocks.plague_goo.getDefaultState());
                }

                if(world.getBlockState(pos.add(1, 1, 1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(1,1,1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(1, 1, 1), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(1, 1, -1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(1,1,-1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(1, 1, -1), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(-1, 1, -1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(-1,1,-1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(-1, 1, -1), ModBlocks.plague_goo.getDefaultState());
                }
                if(world.getBlockState(pos.add(-1, 1, 1)) != Blocks.AIR.getDefaultState()&&world.getBlockState(pos.add(-1,1,1)) != ModBlocks.tgd.getDefaultState()) {
                    world.setBlockState(pos.add(-1, 1, 1), ModBlocks.plague_goo.getDefaultState());
                }
            }

        }
    }
}
