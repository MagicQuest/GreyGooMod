package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class TileEntityGreenRedGoo extends TileEntity implements ITickableTileEntity {
    private int life = 0;
    public TileEntityGreenRedGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityGreenRedGoo() {
        this(ModTileEntityTypes.green_red_goo.get());
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

    @Override
    public void tick() {
        // TODO Auto-generated method stub
        World world = this.getWorld();
        BlockPos thisPos = this.pos;
        if (!world.isRemote) {
            if (Console.getRandom(8, world) == 1 && this.life <= 50) {
                this.life++;
                BlockState[] goos = new BlockState[21];
                goos[0] = ModBlocks.grey_goo.getDefaultState();
                //goos[1] = ModBlocks.green_goo.getDefaultState();
                goos[1] = ModBlocks.red_goo.getDefaultState();
                goos[2] = ModBlocks.orange_goo.getDefaultState();
                goos[3] = ModBlocks.blue_goo.getDefaultState();
                goos[4] = ModBlocks.plague_goo.getDefaultState();
                goos[5] = ModBlocks.white_goo.getDefaultState();
                goos[6] = ModBlocks.purple_goo.getDefaultState();
                goos[7] = ModBlocks.yellow_goo.getDefaultState();
                goos[8] = ModBlocks.rainbow_goo.getDefaultState();
                goos[9] = ModBlocks.purple_red_goo.getDefaultState();
                goos[10] = ModBlocks.brown_goo.getDefaultState();
                goos[11] = ModBlocks.brown_red_goo.getDefaultState();
                goos[12] = ModBlocks.tumor_goo.getDefaultState();
                goos[13] = ModBlocks.darkness_goo.getDefaultState();
                goos[14] = ModBlocks.blue_red_goo.getDefaultState();
                goos[15] = ModBlocks.white_green_goo.getDefaultState();
                goos[16] = ModBlocks.tgd.getDefaultState();
                goos[17] = ModBlocks.orange_white_goo.getDefaultState();
                goos[18] = ModBlocks.orange_purple_goo.getDefaultState();
                goos[19] = ModBlocks.white_green_goo.getDefaultState();


                for (int i = 0; i < goos.length; i++) {
                    int finalI = i;
                    Stream<BlockPos> positions = Console.checkBox(pos.add(1, 1, 1), pos.add(-1, -1, -1));
                    positions.forEach(position -> {
                        if (world.getBlockState(position) == goos[finalI]) {
                            world.setBlockState(position, ModBlocks.green_red_goo.getDefaultState());
                        }
                    });
                    //world.setBlockState(thisPos, Blocks.AIR.getDefaultState());

                }
            }

        }

    }
}
