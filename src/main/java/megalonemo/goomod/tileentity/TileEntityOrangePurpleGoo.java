package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.util.BlockSnapshot;

public class TileEntityOrangePurpleGoo extends TileEntity implements ITickableTileEntity {
    int ticked = 0;
    int direction = 0;

    public TileEntityOrangePurpleGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityOrangePurpleGoo() {
        this(ModTileEntityTypes.orange_purple_goo.get());
        this.ticked = 0;
        this.direction = 0;
    }

    @Override
    public void read(CompoundNBT nbt) {
        this.ticked = nbt.getInt("life");
        this.direction = nbt.getInt("direction");
        //super.readFromNBT(nbt);
        super.read(nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putInt("life", this.ticked);
        nbt.putInt("direction", this.direction);
        return super.write(nbt);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public void tick() {
        if (!world.isRemote) {
            this.ticked++;

            if (world.getBlockState(pos.add(1, 0, 0)) == ModBlocks.green_goo.getDefaultState()) {
                //Console.print("leftx");
                //posx = true;
                if (this.ticked % 2 == 0) {

                    world.setBlockState(pos.add(-1, 0, 0), this.getBlockState());
                    TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(-1, 0, 0));
                    if (te != null) {
                        te.setDirection(1);
                    }else {
                        world.setBlockState(pos,Blocks.AIR.getDefaultState());
                    }
                }
            }
            if (world.getBlockState(pos.add(0, 0, 1)) == ModBlocks.green_goo.getDefaultState()) {
                //posz = true;
                //Console.print("rightz");
                if (this.ticked % 2 == 0) {
                    world.setBlockState(pos.add(0, 0, -1), this.getBlockState());
                    TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(0, 0, -1));
                    if (te != null) {
                        te.setDirection(3);
                    }else {
                        world.setBlockState(pos,Blocks.AIR.getDefaultState());
                    }
                }

            }

            if (world.getBlockState(pos.add(-1, 0, 0)) == ModBlocks.green_goo.getDefaultState()) {
                //negx = true;
                //Console.print("rightx");
                if (this.ticked % 2 == 0) {

                    world.setBlockState(pos.add(1, 0, 0), this.getBlockState());
                    TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(1, 0, 0));
                    if (te != null) {
                        te.setDirection(-1);
                    }else {
                        world.setBlockState(pos,Blocks.AIR.getDefaultState());
                    }
                }
            }
            if (world.getBlockState(pos.add(0, 0, -1)) == ModBlocks.green_goo.getDefaultState()) {
                if (this.ticked % 2 == 0) {
                    world.setBlockState(pos.add(0, 0, 1), this.getBlockState());
                    TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(0, 0, 1));
                    if (te != null) {
                        te.setDirection(-3);
                    }else {
                        world.setBlockState(pos,Blocks.AIR.getDefaultState());
                    }
                }
            }
            if (world.getBlockState(pos.add(0, -1, 0)) == ModBlocks.green_goo.getDefaultState()) {
                if (this.ticked % 2 == 0) {
                    world.setBlockState(pos.add(0, 1, 0), this.getBlockState());
                    TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(0, 1, 0));
                    if (te != null) {
                        te.setDirection(-2);
                    }else {
                        world.setBlockState(pos,Blocks.AIR.getDefaultState());
                    }
                }


                //Console.print("down");
            }
            if (world.getBlockState(pos.add(0, 1, 0)) == ModBlocks.green_goo.getDefaultState()) {
                //up = true;
                //Console.print("up");
                if (this.ticked % 2 == 0) {
                    world.setBlockState(pos.add(0, -1, 0), this.getBlockState());
                    TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(0, -1, 0));
                    if (te != null) {
                        te.setDirection(2);
                    }else {
                        world.setBlockState(pos,Blocks.AIR.getDefaultState());
                    }
                }

            }
            if (this.direction == 1) {
                if (this.ticked % 2 == 0) {
                    if (world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.green_goo.getDefaultState()) {
                        world.setBlockState(pos.add(-1, 0, 0), this.getBlockState());
                        if (world.getBlockState(pos.add(2, 0, 0)) == this.getBlockState()) {
                            world.setBlockState(pos.add(2, 0, 0), Blocks.AIR.getDefaultState());
                        }
                        TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(-1, 0, 0));
                        if (te != null) {
                            te.setDirection(1);
                        }else {
                            world.setBlockState(pos,Blocks.AIR.getDefaultState());
                        }
                    }

                }
            }
            if (this.direction == 2) {
                if (this.ticked % 2 == 0) {
                    if (pos.getY() + 1 >= 255) {

                    } else {
                        if (world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.green_goo.getDefaultState()) {
                            world.setBlockState(pos.add(0, -1, 0), this.getBlockState());
                            if (world.getBlockState(pos.add(0, 2, 0)) == this.getBlockState()) {
                                world.setBlockState(pos.add(0, 2, 0), Blocks.AIR.getDefaultState());
                            }
                            TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(0, -1, 0));
                            if(pos.getY()-3 <= 0) {
                                world.setBlockState(pos,Blocks.AIR.getDefaultState());
                            }
                            if (te != null) {
                                te.setDirection(2);
                            }else {

                            }
                        }

                    }

                }
            }

            if (this.direction == 3) {
                if (this.ticked % 2 == 0) {
                    if (world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.green_goo.getDefaultState()) {
                        world.setBlockState(pos.add(0, 0, -1), this.getBlockState());
                        if (world.getBlockState(pos.add(0, 0, 2)) == this.getBlockState()) {
                            world.setBlockState(pos.add(0, 0, 2), Blocks.AIR.getDefaultState());
                        }
                        TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(0, 0, -1));
                        if (te != null) {
                            te.setDirection(3);
                        }else {
                            world.setBlockState(pos,Blocks.AIR.getDefaultState());
                        }
                    }
                }
            }
            if (this.direction == -1) {
                if (this.ticked % 2 == 0) {
                    if (world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.green_goo.getDefaultState()) {
                        world.setBlockState(pos.add(1, 0, 0), this.getBlockState());
                        if (world.getBlockState(pos.add(-2, 0, 0)) == this.getBlockState()) {
                            world.setBlockState(pos.add(-2, 0, 0), Blocks.AIR.getDefaultState());
                        }
                        TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(1, 0, 0));
                        if (te != null) {
                            te.setDirection(-1);
                        }else {
                            world.setBlockState(pos,Blocks.AIR.getDefaultState());
                        }
                    }
                }
            }
            if (this.direction == -2) {
                if (this.ticked % 2 == 0) {
                    if (pos.getY() - 1 <= 0) {

                    } else {
                        if (world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.green_goo.getDefaultState()) {
                            world.setBlockState(pos.add(0, 1, 0), this.getBlockState());
                            if (world.getBlockState(pos.add(0, -2, 0)) == this.getBlockState()) {
                                world.setBlockState(pos.add(0, -2, 0), Blocks.AIR.getDefaultState());
                            }
                            TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(0, 1, 0));
                            if(pos.getY()+3 >= 255) {
                                world.setBlockState(pos,Blocks.AIR.getDefaultState());
                            }
                            if (te != null) {
                                te.setDirection(-2);
                            }else {


                            }
                        }

                    }

                }
            }
            if (this.direction == -3) {
                if (this.ticked % 2 == 0) {
                    if (world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.green_goo.getDefaultState()) {
                        world.setBlockState(pos.add(0, 0, 1), this.getBlockState());
                        if (world.getBlockState(pos.add(0, 0, -2)) == this.getBlockState()) {
                            world.setBlockState(pos.add(0, 0, -2), Blocks.AIR.getDefaultState());
                        }
                        TileEntityOrangePurpleGoo te = (TileEntityOrangePurpleGoo) world.getTileEntity(pos.add(0, 0, 1));
                        if (te != null) {
                            te.setDirection(-3);
                        }else {
                            world.setBlockState(pos,Blocks.AIR.getDefaultState());
                        }
                    }
                }
            }
        }
    }
}
