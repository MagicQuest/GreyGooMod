package megalonemo.goomod;


import megalonemo.goomod.init.ModBlocks;
import megalonemo.goomod.init.ModDimensions;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ChunkManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = megalonemo.goomod.Mod.MOD_ID,bus= Mod.EventBusSubscriber.Bus.FORGE)
public class ModWorldEventHandler {
    //sand check
    @SubscribeEvent
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if(stack.getItem() == ModBlocks.green_goo.asItem()) {
            stack.grow(1);
        }
    }
    @SubscribeEvent
    public static void sandCheck(TickEvent.WorldTickEvent event) {
        World world = event.world;
        for(PlayerEntity plr:world.getPlayers()) {

            List<FallingBlockEntity> list = world.getEntitiesWithinAABB(FallingBlockEntity.class,new AxisAlignedBB(plr.getPosition().add(100,100,100),plr.getPosition().add(-100,-100,-100)));
            int fallingblocks = (int) list.stream().count();
            //Console.log(fallingblocks);

            if(fallingblocks != 0) {
                //plr.sendMessage(new StringTextComponent(""+fallingblocks));
            }
            if(fallingblocks > 1000) {
                if(fallingblocks >= 1500) {
                    list.forEach(Entity::remove);
                }
                fallingblocks = fallingblocks - 1000;
                for (int i = 0; i < fallingblocks; i++) {
                    list.get(i).remove();
                }
            }
        }

    }
    @SubscribeEvent
    public static void tick(TickEvent.WorldTickEvent event) {
        World world = event.world;
        for (int i = 0; i < world.getPlayers().size(); i++) {
            PlayerEntity playerIn = (PlayerEntity) world.getPlayers().toArray()[i];

            RayTraceResult ray = playerIn.func_213324_a(155.0d,1,false);//playerIn.rayTrace(155.0d, 1);
            if (ray == null)
            {

            }
            else if (ray.getType() != RayTraceResult.Type.BLOCK)
            {

            }else {

                BlockPos block = new BlockPos(ray.getHitVec());
                //Console.print(world.getBlockState(block));
                if(world.getBlockState(block) == ModBlocks.plague_goo.getDefaultState() || world.getBlockState(block.add(0,-1,0)) == ModBlocks.plague_goo.getDefaultState()) {
                    //Console.print("doign");
                        /*for (int y = 0; y < 2; y++) {
                            for (int j = 0; j < 8; j++) {
                                //rows
                                for (int b = 0; b < 8; b++) {
                                    //cols
                                    //Console.log(y);
                                    BlockPos startingPos = playerIn.getPosition().add(0, -1, 0);
                                    if (world.getBlockState(startingPos.add(j - 4, -y, b - 4)) != Blocks.AIR.getDefaultState() && world.getBlockState(startingPos.add(j - 6, -y+1, b - 6))==Blocks.AIR.getDefaultState()) {
                                        world.setBlockState(startingPos.add(j - 4, -y, b - 4), ModBlocks.plague_goo.getDefaultState());
                                    }

                                }
                            }
                        }*/
                    for (int j = 0; j < 12; j++) {
                        //rows
                        for (int b = 0; b < 12; b++) {
                            //cols
                            BlockPos startingPos = playerIn.getPosition().add(0, -1, 0);
                            if(world.getBlockState(startingPos.add(j-6,0,b-6)) != Blocks.AIR.getDefaultState()) {
                                world.setBlockState(startingPos.add(j-6,0,b-6),ModBlocks.plague_goo.getDefaultState());
                            }

                        }
                    }
                }
            }
        }
    }

}
