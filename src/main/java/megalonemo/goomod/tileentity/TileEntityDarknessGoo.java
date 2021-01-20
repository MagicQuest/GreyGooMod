package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class TileEntityDarknessGoo extends TileEntity implements ITickableTileEntity {
    private int life = 0;

    public TileEntityDarknessGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityDarknessGoo() {
        this(ModTileEntityTypes.darkness_goo.get());
        this.life = 0;
    }

    @Override
    public void read(CompoundNBT nbt) {
        this.life = nbt.getInt("life");
        //super.readFromNBT(nbt);
        super.read(nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putInt("life",this.life);
        return super.write(nbt);
    }

    private void grow(BlockPos pos,World world) {
        //IBlockState[] goos = new IBlockState[4];
        //goos[0] = ModBlocks.orange_goo.getDefaultState();
        //goos[1] = ModBlocks.green_goo.getDefaultState();
        //goos[2] = Blocks.AIR.getDefaultState();
        //goos[3] = ModBlocks.red_goo.getDefaultState();
        ///
        //for (int i = 0; i < goos.length; i++) {
        Stream<BlockPos> positions = Console.checkBox(pos.add(2,2,2),pos.add(-2,-2,-2));
        try {
            positions.forEach(position -> {

                if (Console.random(0, 50) == Console.random(0, 50)) {
                    if (world.getBlockState(position) != Blocks.AIR.getDefaultState() && world.getBlockState(position) != ModBlocks.darkness_goo.getDefaultState() && world.getBlockState(position) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(position) != ModBlocks.orange_goo.getDefaultState()) {
                        if(world.getBlockState(position) != ModBlocks.plague_goo.getDefaultState()) {
                            world.setBlockState(position, ModBlocks.darkness_goo.getDefaultState());
                            throw new RuntimeException();
                        }


                    }

                }

            });
        }catch(RuntimeException e) {

        }
        //}



    }

    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos thisPos = this.pos;


        if (!world.isRemote) {
            if(this.life>=20) {
                world.setBlockState(pos,ModBlocks.plague_goo.getDefaultState());
            }
            int randomNum = Console.random(0,300);
            //Console.log(world.getGameRules().get(Mod.GOO_SPEED).get());
            randomNum-=world.getGameRules().get(Mod.GOO_SPEED).get();
            if(randomNum < 1) {
                randomNum = 1;
            }
            if (randomNum == 1) {
                this.life++;
            }
            //if(this.life>=4000) {
            //if(this.life>=30) {
            //    world.setBlockState(pos, ModBlocks.tumor_goo.getDefaultState());
            //}
            //}
            //this.life++;
            for (PlayerEntity player : world.getPlayers()) {
                double dist = player.getDistanceSq(new Vec3d(pos.getX(),pos.getY(),pos.getZ()));
                //Console.log(dist);
                if(dist <=  25) {
                    player.addPotionEffect(new EffectInstance(Effect.get(Console.potionIdByName("blindness")),40,1));
                }
            }
            if (Console.random(0, 500) == 1) {
                //this.life++;
                grow(thisPos,world);
            }
        }
    }
}
