package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.stream.Stream;

public class TileEntityYellowGoo extends TileEntity implements ITickableTileEntity {
    public TileEntityYellowGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityYellowGoo() {
        this(ModTileEntityTypes.yellow_goo.get());
    }

    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos thisPos = this.pos;

        if (!world.isRemote) {
            //Console.log(world.getBlockState(pos.add(0,-1    ,0)));

            /*for (int y = 0; y < 3; y++) {
                for (int rows = 0; rows < 3; rows++) {
                    for (int cols = 0; cols < 3; cols++) {
                        BlockPos startingPos = thisPos;
                        if(world.getBlockState(startingPos.add(rows,-1-y,cols)) == Blocks.AIR.getDefaultState()) {
                            if (world.getBlockState(startingPos.add(rows,-y,cols)) != Blocks.AIR.getDefaultState()) {
                                world.setBlockState(startingPos.add(rows,-y,cols),ModBlocks.yellow_goo.getDefaultState());
                                for (int i = 0; i < 255; i++) {
                                    if(world.getBlockState(startingPos.add(rows,-y+i,cols)) == Blocks.AIR.getDefaultState()) {
                                        break;
                                    }
                                    world.setBlockState(startingPos.add(rows,-y+i,cols),Blocks.SAND.getDefaultState());
                                }
                            }

                        }
                    }
                }
            }*/

        }
    }
}
