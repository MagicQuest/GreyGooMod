package megalonemo.goomod.tileentity;

import megalonemo.goomod.Console;
import megalonemo.goomod.Mod;
import megalonemo.goomod.blocks.BlockTumorGoo;
import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModTileEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.ForgeEventFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TileEntityTumorGoo extends TileEntity implements ITickableTileEntity {
    private int life = 0;
    private int direction = 1;
    private int lastTurn = 0;
    private String eData = "sp=0";
    public TileEntityTumorGoo(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityTumorGoo() {
        this(ModTileEntityTypes.tumor_goo.get());
        this.life = 0;
        this.direction = Console.random(1,4);
        this.lastTurn = this.direction;
        this.eData = "sp=0";
    }

    @Override
    public void read(CompoundNBT nbt) {
        this.life = nbt.getInt("life");
        this.direction = nbt.getInt("direction");
        this.lastTurn = nbt.getInt("lastTurn");
        this.eData = nbt.getString("eData");
        //super.readFromNBT(nbt);
        super.read(nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT nbt) {
        nbt.putInt("life",this.life);
        nbt.putInt("direction",this.direction);
        nbt.putInt("lastTurn",this.lastTurn);
        nbt.putString("eData",this.eData);
        return super.write(nbt);
    }

    /*static void clearLines(World world, BlockPos pos) {

        for (int up = 1; up < 4; up++) {
            toAir(world, pos.add(0,up,0));
            toAir(world,pos.add(0,-up,0));
           // if(world.getBlockState(pos.add(0,up,0)) != ModBlocks.tumor_goo.getDefaultState()) {
           //     world.setBlockState(pos.add(0,up,0),Blocks.AIR.getDefaultState());
           // }
           // if(world.getBlockState(pos.add(0,-up,0)) != ModBlocks.tumor_goo.getDefaultState()) {
           //     world.setBlockState(pos.add(0,-up,0),Blocks.AIR.getDefaultState());
           // }
        }
        for (int left = 1; left < 4; left++) {
            toAir(world,pos.add(left,0,0));
            //if(world.getBlockState(pos.add(left,0,0)) != ModBlocks.tumor_goo.getDefaultState()) {
           //     world.setBlockState(pos.add(left,0,0),Blocks.AIR.getDefaultState());
            //}
            toAir(world,pos.add(-left,0,0));
            //if(world.getBlockState(pos.add(-left,0,0)) != ModBlocks.tumor_goo.getDefaultState()) {
                //world.setBlockState(pos.add(-left,0,0),Blocks.AIR.getDefaultState());
           // }
        }
        for (int right = 1; right < 4; right++) {
            toAir(world,pos.add(0,0,right));
            //if(world.getBlockState(pos.add(0,0,right)) != ModBlocks.tumor_goo.getDefaultState()) {
            //    world.setBlockState(pos.add(0,0,right),Blocks.AIR.getDefaultState());
            //}
            toAir(world,pos.add(0,0,-right));
            //if(world.getBlockState(pos.add(0,0,-right)) != ModBlocks.tumor_goo.getDefaultState()) {
           //     world.setBlockState(pos.add(0,0,-right),Blocks.AIR.getDefaultState());
            //}
        }
    }*/
    static BlockPos[] getBox(World world,BlockPos pos) {
            BlockPos[] positions = new BlockPos[26];
            positions[0] = pos.add(1, 0, 0);
            positions[1] = pos.add(0, 1, 0);
            positions[2] = pos.add(0, 0, 1);
            positions[3] = pos.add(0, 0, -1);
            positions[4] = pos.add(-1, 0, 0);
            positions[5] = pos.add(1, 0, 1);
            positions[6] = pos.add(1, 0, -1);
            positions[7] = pos.add(-1, 0, -1);
            positions[8] = pos.add(-1, 0, 1);
            positions[9] =  pos.add(1, 1, 0);
            positions[10] =  pos.add(0, 1, 1);
            positions[11] =  pos.add(0, 1, -1);
            positions[12] =   pos.add(-1, 1, 0);
            positions[13] =   pos.add(1, 1, 1);
            positions[14] =   pos.add(1, 1, -1);
            positions[15] =   pos.add(-1, 1, -1);
            positions[16] =  pos.add(-1, 1, 1);

            positions[17] = pos.add(0, -1, 0);
            positions[18] =  pos.add(1, -1, 0);
            positions[19] =  pos.add(0, -1, 1);
            positions[20] =  pos.add(0, -1, -1);
            positions[21] =   pos.add(-1, -1, 0);
            positions[22] =   pos.add(1, -1, 1);
            positions[23] =   pos.add(1, -1, -1);
            positions[24] =   pos.add(-1, -1, -1);
            positions[25] =  pos.add(-1, -1, 1);
            return positions;
    }
    /*public static void clear(World world,BlockPos pos) {
        clearLines(world,pos);
        Stream<BlockPos> positions = Console.checkBox(pos.add(3,3,3),pos.add(-3,-3,-3));// getBox(world,pos);
        //Stream<BlockPos> positions = Console.checkBox(pos.add(1,1,1),pos.add(-1,-1,-1));
        //for
        //positions.forEach();
        positions.forEach(bruh -> {
            toAir(world,bruh);
        });
        //for (int bruh = 0; bruh < positions.count(); bruh++) {
            //BlockPos position = positions[bruh];
            //toAir(world,position);
        //}


    }

    static void toAir(World world,BlockPos pos) {
        if(world.getBlockState(pos) != ModBlocks.darkness_goo.getDefaultState()&&world.getBlockState(pos) != ModBlocks.grey_goo.getDefaultState() && world.getBlockState(pos) != ModBlocks.tumor_goo.getDefaultState() && world.getBlockState(pos) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos) != ModBlocks.orange_goo.getDefaultState()) {
            if(world.getBlockState(pos) == ModBlocks.plague_goo.getDefaultState()) {
                if(Console.random(0,600)==5) {
                    world.setBlockState(pos,Blocks.AIR.getDefaultState());
                }
            }else {
                world.setBlockState(pos,Blocks.AIR.getDefaultState());
            }

        }
    }*/

    boolean stuff(World world,BlockPos pos) {
        if(world.getBlockState(pos.add(0,1,0)) == ModBlocks.tumor_goo.getDefaultState()) {
            if(Console.random(0,1) == 0) {
                return false;
            }
            return true;
        }
        return false;
    }
    BlockPos getPosFromDirection(int direction) {
        if (direction == 1) {
            //north
            return pos.add(0, 0, -1);
        }
        if (direction == 2) {
            //east
            return pos.add(1, 0, 0);
        }
        if (direction == 3) {
            //south
            return pos.add(0, 0, 1);
        }
        if (direction == 4) {
            //west
            return pos.add(-1, 0, 0);
        }
        return pos;
    }
    String getShitFromDir(int direction) {
        if (direction == 1) {
            //north
            return "north";
        }
        if (direction == 2) {
            //east
            return "east";
        }
        if (direction == 3) {
            //south
            return "south";
        }
        if (direction == 4) {
            //west
            return "west";
        }
        return "getShitFromDir";
    }

    @Override
    public void tick() {
        World world = this.getWorld();
        BlockPos thisPos = this.pos;
        if (!world.isRemote) {
            //if(Console.random(0,100) == 1) {
            //    clear(world,pos);
            //}
            if(pos.getY() != 0) {
                if(world.getBlockState(pos.add(0,-1,0)) == Blocks.AIR.getDefaultState() || world.getBlockState(pos.add(0,-1,0)) == Blocks.CAVE_AIR.getDefaultState()) {
                    world.setBlockState(pos.add(0,-1,0), this.getBlockState());
                    ((BlockTumorGoo) world.getBlockState(pos.add(0,-1,0)).getBlock()).TumorTile.direction = this.direction;
                    ((BlockTumorGoo) world.getBlockState(pos.add(0,-1,0)).getBlock()).TumorTile.lastTurn = this.lastTurn;
                    ((BlockTumorGoo) world.getBlockState(pos.add(0,-1,0)).getBlock()).TumorTile.life = this.life;
                    this.direction = 0;
                }
            }

            if(this.life==10) {
                Console.log("hello??");
                this.eData = "sp=50";
                this.direction = 5;
                this.life++;
                //world.setBlockState(pos,ModBlocks.darkness_goo.getDefaultState());
            }
            if(Console.getRandom(50,world) == 1 && this.direction != 0) {

                if (this.direction == 1) {
                    //north
                    BlockPos forward = pos.add(0, 0, -1);
                    BlockPos forwardCheck = pos.add(0, 0, -2);
                    if (world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.red_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {
                        if (Console.random(0, 1) == 1) {
                            this.direction = 4;
                            this.lastTurn = 4;
                        } else {
                            this.direction = 2;
                            this.lastTurn = 2;
                        }

                    } else {
                        world.setBlockState(forward, this.getBlockState());
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.direction = 1;
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.lastTurn = this.lastTurn;
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.life = this.life;
                        this.direction = 0;
                    }

                }
                if (this.direction == 2) {
                    //east
                    BlockPos forward = pos.add(1, 0, 0);
                    BlockPos forwardCheck = pos.add(2, 0, 0);
                    if (world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.red_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {
                        if (this.lastTurn == 2) {
                            this.direction = 3;
                            this.lastTurn = 3;
                        } else {
                            this.direction = 1;
                            this.lastTurn = 1;
                        }

                    } else {
                        world.setBlockState(forward, this.getBlockState());
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.direction = 2;
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.lastTurn = this.lastTurn;
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.life = this.life;
                        this.direction = 0;
                    }
                }
                if (this.direction == 3) {
                    //south
                    BlockPos forward = pos.add(0, 0, 1);
                    BlockPos forwardCheck = pos.add(0, 0, 2);
                    if (world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.red_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {
                        if (this.lastTurn == 3) {
                            this.direction = 4;
                            this.lastTurn = 4;
                        } else {
                            this.direction = 2;
                            this.lastTurn = 2;
                        }

                    } else {
                        world.setBlockState(forward, this.getBlockState());
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.direction = 3;
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.lastTurn = this.lastTurn;
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.life = this.life;
                        this.direction = 0;
                    }
                }
                if (this.direction == 4) {
                    //west
                    BlockPos forward = pos.add(-1, 0, 0);
                    BlockPos forwardCheck = pos.add(-2, 0, 0);
                    if (world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.red_goo.getDefaultState()) {
                        if (this.lastTurn == 4) {
                            this.direction = 1;
                            this.lastTurn = 1;
                        } else {
                            this.direction = 3;
                            this.lastTurn = 3;
                        }

                    } else {
                        world.setBlockState(forward, this.getBlockState());
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.direction = 4;
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.lastTurn = this.lastTurn;
                        ((BlockTumorGoo) world.getBlockState(forward).getBlock()).TumorTile.life = this.life;
                        this.direction = 0;
                    }
                }
                if(this.direction == 5) {
                    if(pos.getY() <= 254) {
                        Console.log("the club goin' up, on a tusedattebayo");
                        if(world.getBlockState(pos.up()) != this.getBlockState()) {
                            world.setBlockState(pos.up(), this.getBlockState());
                        }
                        ((BlockTumorGoo) world.getBlockState(pos.up()).getBlock()).TumorTile.direction = 5;
                        ((BlockTumorGoo) world.getBlockState(pos.up()).getBlock()).TumorTile.lastTurn = this.lastTurn;
                        ((BlockTumorGoo) world.getBlockState(pos.up()).getBlock()).TumorTile.life = this.life;
                        this.eData = "sp=" + (Integer.parseInt(this.eData.substring(3)) - 1);
                        ((BlockTumorGoo) world.getBlockState(pos.up()).getBlock()).TumorTile.eData = this.eData;
                        this.direction = 0;
                    }else {
                        this.eData = "sp=" + (Integer.parseInt(this.eData.substring(3)) - 1);
                    }
                }
                Console.log(Integer.parseInt(this.eData.substring(3)));
                if(Integer.parseInt(this.eData.substring(3)) == -1) {
                    this.direction = 0;
                    Console.log("bababooey");
                    if(pos.getY() <= 254) {
                        float f = (float)Math.min(16, 2 + 1);
                        if(true) {
                            Stream<BlockPos> positions = Console.checkBox(pos.add(4, 4, 4), pos.add(-4, -4, -4));
                            positions.forEach(position -> {
                                if (position.withinDistance(pos, (double) f)) {
                                    world.setBlockState(position, ModBlocks.darkness_goo.getDefaultState());
                                }
                            });
                        }
                    }
                    if(true) {
                        Stream<BlockPos> positions = Console.checkBox(pos.add(0,0,0),pos.add(0,-50,0));
                        positions.forEach(position -> world.setBlockState(position, ModBlocks.darkness_goo.getDefaultState()));
                    }
                }
            }
            if(Console.getRandom(150,world) == 1 && this.direction != 0 && this.direction != 5) {
                if(this.life <= 9) {
                    this.life++;
                }

                //Console.log(this.life);
                if(Console.random(0,1) == 1) {
                    if(Console.random(0,2) == 1) {
                        if(world.getBlockState(getPosFromDirection(this.direction)) != Blocks.AIR.getDefaultState() && world.getBlockState(getPosFromDirection(this.direction)) != Blocks.CAVE_AIR.getDefaultState()) {
                            if(world.getBlockState(pos.up()) != this.getBlockState()) {
                                world.setBlockState(pos.up(),this.getBlockState());
                                ((BlockTumorGoo) world.getBlockState(pos.up()).getBlock()).TumorTile.direction = this.direction;
                                ((BlockTumorGoo) world.getBlockState(pos.up()).getBlock()).TumorTile.lastTurn = this.lastTurn;
                                ((BlockTumorGoo) world.getBlockState(pos.up()).getBlock()).TumorTile.life = this.life;
                                this.direction = 0;
                            }
                        }
                    }else {
                        if(world.getBlockState(pos.down()) != this.getBlockState()) {
                            world.setBlockState(pos.down(),this.getBlockState());
                            ((BlockTumorGoo) world.getBlockState(pos.down()).getBlock()).TumorTile.direction = this.direction;
                            ((BlockTumorGoo) world.getBlockState(pos.down()).getBlock()).TumorTile.lastTurn = this.lastTurn;
                            ((BlockTumorGoo) world.getBlockState(pos.down()).getBlock()).TumorTile.life = this.life;
                            this.direction = 0;
                        }

                    }

                }else {
                    boolean north = false,east = false,south = false,west = false;
                    if(true) {
                        BlockPos forwardCheck = pos.add(0, 0, -2);
                        if (world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {

                        }else {
                            north = true;
                        }
                    }
                    if(true) {
                        BlockPos forwardCheck = pos.add(2, 0, 0);
                        if (world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {

                        }else {
                            east = true;
                        }
                    }
                    if(true) {
                        BlockPos forwardCheck = pos.add(0, 0, 2);
                        if (world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {

                        }else {
                            south = true;
                        }
                    }
                    if(true) {
                        BlockPos forwardCheck = pos.add(-2, 0, 0);
                        if (world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {
                            west = true;
                        }
                    }

                    ArrayList<Integer> ints = new ArrayList<>();
                    if(north && world.getBlockState(pos.add(0, 0, -1)) != this.getBlockState()) {
                        ints.add(1);
                    }
                    if(east && world.getBlockState(pos.add(1, 0, 0)) != this.getBlockState()) {
                        ints.add(2);
                    }
                    if(south && world.getBlockState(pos.add(0, 0, 1)) != this.getBlockState()) {
                        ints.add(3);
                    }
                    if(west && world.getBlockState(pos.add(-1, 0, 0)) != this.getBlockState()) {
                        ints.add(4);
                    }
                    if(ints.size()-1 == 0 || ints.size() == 0) {
                        return;
                    }
                    int result = ints.get(Console.random(0,ints.size()-1));
                    //Console.log(this.direction+" and "+result);
                    this.direction = result;
                    //Console.log(this.direction);
                    this.lastTurn = result;
                }
            }
            if(Console.getRandom(300,world) == 1 && this.direction != 0) {

                if(pos.getY() <= 254 && this.direction != 5) {
                    world.setBlockState(pos.up(),this.getBlockState());
                    ((BlockTumorGoo) world.getBlockState(pos.up()).getBlock()).TumorTile.direction = 0;
                    ((BlockTumorGoo) world.getBlockState(pos.up()).getBlock()).TumorTile.lastTurn = 0;
                }


                if(pos.getY() != 0) {
                    world.setBlockState(pos.down(),this.getBlockState());
                    ((BlockTumorGoo) world.getBlockState(pos.down()).getBlock()).TumorTile.direction = 0;
                    ((BlockTumorGoo) world.getBlockState(pos.down()).getBlock()).TumorTile.lastTurn = 0;
                }

                if(getShitFromDir(this.direction) != "north") {
                    world.setBlockState(pos.north(),this.getBlockState());
                    ((BlockTumorGoo) world.getBlockState(pos.north()).getBlock()).TumorTile.direction = 0;
                    ((BlockTumorGoo) world.getBlockState(pos.north()).getBlock()).TumorTile.lastTurn = 0;
                }
                if(getShitFromDir(this.direction) != "south") {
                    world.setBlockState(pos.south(),this.getBlockState());
                    ((BlockTumorGoo) world.getBlockState(pos.south()).getBlock()).TumorTile.direction = 0;
                    ((BlockTumorGoo) world.getBlockState(pos.south()).getBlock()).TumorTile.lastTurn = 0;
                }
                if(getShitFromDir(this.direction) != "east") {
                    world.setBlockState(pos.east(),this.getBlockState());
                    ((BlockTumorGoo) world.getBlockState(pos.east()).getBlock()).TumorTile.direction = 0;
                    ((BlockTumorGoo) world.getBlockState(pos.east()).getBlock()).TumorTile.lastTurn = 0;
                }
                if(getShitFromDir(this.direction) != "west") {
                    world.setBlockState(pos.west(),this.getBlockState());
                    ((BlockTumorGoo) world.getBlockState(pos.west()).getBlock()).TumorTile.direction = 0;
                    ((BlockTumorGoo) world.getBlockState(pos.west()).getBlock()).TumorTile.lastTurn = 0;
                }
            }
                /*if(this.direction == 1) {
                    //north
                    BlockPos forwardCheck = pos.add(2,0,0);
                    BlockPos forward = pos.add(1,0,0);
                    if(world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {
                        if(Console.random(0,1) == 1) {
                            world.setBlockState(pos.add(0,0,-1),ModBlocks.tumor_goo.getDefaultState());
                        }else {
                            world.setBlockState(pos.add(0,0,1),ModBlocks.tumor_goo.getDefaultState());
                        }
                    }else {
                        world.setBlockState(forward,ModBlocks.tumor_goo.getDefaultState());

                    }
                    this.direction = 0;
                }else if(this.direction == 2) {
                    //south
                    BlockPos forwardCheck = pos.add(-2,0,0);
                    BlockPos forward = pos.add(-1,0,0);
                    if(world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {
                        if(Console.random(0,1) == 1) {
                            world.setBlockState(pos.add(0,0,-1),ModBlocks.tumor_goo.getDefaultState());
                        }else {
                            world.setBlockState(pos.add(0,0,1),ModBlocks.tumor_goo.getDefaultState());
                        }

                        //this.direction = Console.random(3,4);

                    }else {
                        world.setBlockState(forward,ModBlocks.tumor_goo.getDefaultState());
                    }
                    this.direction = 0;
                }else if(this.direction == 3) {
                    //east
                    BlockPos forwardCheck = pos.add(0,0,2);
                    BlockPos forward = pos.add(0,0,1);
                    Console.log(world.getBlockState(forwardCheck));
                    if(world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {
                        world.setBlockState(pos.add(-1,0,0),ModBlocks.tumor_goo.getDefaultState());
                    }else {
                        world.setBlockState(forward,ModBlocks.tumor_goo.getDefaultState());
                    }
                    this.direction = 0;
                }else if(this.direction == 4) {
                    //west
                    BlockPos forwardCheck = pos.add(0,0,-2);
                    BlockPos forward = pos.add(0,0,-1);
                    Console.log(world.getBlockState(forwardCheck));
                    if(world.getBlockState(forwardCheck) == ModBlocks.green_goo.getDefaultState() || world.getBlockState(forwardCheck) == ModBlocks.rainbow_goo.getDefaultState()) {
                        world.setBlockState(pos.add(-1,0,0),ModBlocks.tumor_goo.getDefaultState());
                    }else {
                        world.setBlockState(forward,ModBlocks.tumor_goo.getDefaultState());
                    }
                    this.direction = 0;
                }*/
            }
            /*if (Console.getRandom(300,world) == 1) {
                this.life++;
                if (Console.random(0, 10) == 5) {
                    if (world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(1, 0, 0);
                        if(stuff(world,posi)) {
                            return;
                        }
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState() && world.getBlockState(posi)!=ModBlocks.darkness_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                            clear(world,thisPos);
                        }

                    }
                }

                if (Console.random(0, 10) == 5) {
                    if (world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, 1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, 1);
                        if(stuff(world,posi)) {
                            return;
                        }
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState() && world.getBlockState(posi)!=ModBlocks.darkness_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                            clear(world,thisPos);
                        }
                    }
                }
                if (Console.random(0, 10) == 5) {
                    if (world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(-1, 0, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(-1, 0, 0);
                        if(stuff(world,posi)) {
                            return;
                        }
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState() && world.getBlockState(posi)!=ModBlocks.darkness_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                            clear(world,thisPos);
                        }
                    }
                }
                if (Console.random(0, 10) == 5) {
                    if (world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 0, -1)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 0, -1);
                        if(stuff(world,posi)) {
                            return;
                        }
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState() && world.getBlockState(posi)!=ModBlocks.darkness_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                            clear(world,thisPos);
                        }
                    }
                }
                if (Console.random(0, 7) == 5) {
                    if (world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, -1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, -1, 0);
                        if(stuff(world,posi)) {
                            return;
                        }
                        if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState() && world.getBlockState(posi)!=ModBlocks.darkness_goo.getDefaultState()) {
                            world.setBlockState(posi, world.getBlockState(pos));
                            clear(world,thisPos);
                        }
                    }
                }
                if (Console.random(0, 5) == 5) {
                    if (world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.green_goo.getDefaultState() && world.getBlockState(pos.add(0, 1, 0)) != ModBlocks.orange_goo.getDefaultState()) {
                        BlockPos posi = pos.add(0, 1, 0);
                        if(stuff(world,posi)) {
                            return;
                        }
                        if(Console.random(0,25)==Console.random(0,25)) {
                            if(world.getBlockState(posi)!=ModBlocks.tumor_goo.getDefaultState() && world.getBlockState(posi)!=ModBlocks.darkness_goo.getDefaultState()) {
                                world.setBlockState(posi, world.getBlockState(pos));
                                clear(world,thisPos);
                            }
                        }
                    }
                }

            }*/
       // }
    }
}
