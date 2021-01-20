package megalonemo.goomod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Stream;

public class Console {
	/**
	 * lmao
	 */

	//so this console thing is just like a library i made and stuff just for random crap like:
	//logging
	//random function
	//spawning items
	//getting the blockpos' of all the megalonemo.furniture.blocks in a box that is specified
	//get the megalonemo.furniture.blocks that are touching a blockpos includes air
	//get a potion by name

	public static void log(Object msg) {
		//Logger logger;
		//logger.
		//Logger LOGGER = LogManager.getLogger(megalonemo.furniture.Mod.MOD_ID);
		Logger LOGGER = LogManager.getLogger(Mod.MOD_ID);
		//LOGGER.info(stuff.toString());
		LOGGER.info(msg.toString());
		//System.out.println(stuff);
	}

	public static int getRandom(int number,World world) {
		int randomNum = Console.random(0,number);
		//Console.log(world.getGameRules().get(Mod.GOO_SPEED).get());
		randomNum-=world.getGameRules().get(Mod.GOO_SPEED).get();
		if(randomNum < 1) {
			randomNum = 1;
		}
		if(!world.getGameRules().getBoolean(Mod.GOO_ENABLED)) {
			return -1;
		}
		return randomNum;
	}

	/**
	 *epic random function that i stole (inclusive)
	 * @param min
	 * @param max
	 * @return int
	 * @since ur mom lmao
	 */
	public static int random(int min, int max){   //defining method for a random number generator

		int range = (max - min) + 1;
		return (int)(Math.random() * range) + min;
	}

	/**
	 *
	 * @param world
	 * @param pos
	 * @param item
	 * @since 3:52PM MAY21
	 */
	public static void spawnItem(World world, BlockPos pos, Item item) {
		Block.spawnAsEntity(world,pos,new ItemStack(item));
	}

	/**
	 *
	 * @param world
	 * @param pos
	 * @param item
	 * @param count
	 * @since 11:34PM JUNE7
	 */
	public static void spawnItem(World world, BlockPos pos, Item item,int count) {
		Block.spawnAsEntity(world,pos,new ItemStack(item,count));
	}
	/**
	 * @param start
	 * @param end
	 * @since 3:54PM MAY23
	 * @return
	 */
	public static Stream<BlockPos> checkBox(BlockPos start, BlockPos end) {
		//BlockPos[] positions;
		return BlockPos.getAllInBox(start,end);
	}


	/**
	 *
	 * @param start
	 * @param end
	 * @param block
	 * @param world
	 * @since 12:30PM JUNE8
	 */
	public static void fill(BlockPos start, BlockPos end, BlockState block,World world) {
		Stream<BlockPos> positions = checkBox(start,end);
		positions.forEach(position -> {
			world.setBlockState(position,block);
		});
	}

	/**
	 * @since 12:59PM JUNE8
	 * @param start
	 * @param end
	 * @param block
	 * @param holeBlock
	 * @param world
	 * @param holeRarity
	 */
	public static void fillWithHoles(BlockPos start, BlockPos end, BlockState block,BlockState holeBlock,World world,int holeRarity) {
		Stream<BlockPos> positions = checkBox(start,end);
		positions.forEach(position -> {
			if(Console.random(0,holeRarity)==0) {
				world.setBlockState(position,holeBlock);
			}else {
				world.setBlockState(position,block);
			}

		});
	}

	/**
	 * @since 3:51PM JUNE8
	 * @param pos
	 * @param block
	 * @param blockToReplace
	 * @param world
	 */
	public static void replaceWith(BlockPos pos,BlockState block,BlockState blockToReplace,World world) {
		if(world.getBlockState(pos) == blockToReplace) {
			world.setBlockState(pos,block);
		}
	}

	/**
	 * @since 11:49AM JUNE9
	 * @param pos
	 * @param world
	 * @param entity
	 */
	public static void spawn(BlockPos pos, World world, EntityType entity) {
		entity.create(world,null,null,null,pos, SpawnReason.NATURAL,true,false);
	}

	public static BlockPos[] getTouching(BlockPos pos) {
		BlockPos[] positions = new BlockPos[6];
		positions[0] = pos.add(1,0,0);
		positions[1] = pos.add(0,1,0);
		positions[2] = pos.add(0,0,1);
		positions[3] = pos.add(0,0,-1);
		positions[4] = pos.add(0,-1,0);
		positions[5] = pos.add(-1,0,0);
		return positions;
	}
	/**
	 * @deprecated im pretty sure you can just do Effects.POTION_NAME :pensive:
	 */
	@Deprecated
	public static int potionIdByName(String name) {
		int id = 0;
		id++;
		if(name=="speed") {
			return id;
		}
		id++;
		if(name=="slowness") {
			return id;
		}
		id++;
		if(name=="haste") {
			return id;
		}
		id++;
		if(name=="mining_fatigue") {
			return id;
		}
		id++;
		if(name=="strength") {
			return id;
		}id++;
		if(name=="instant_health") {
			return id;
		}id++;
		if(name=="instant_damage") {
			return id;
		}id++;
		if(name=="jump_boost") {
			return id;
		}id++;
		if(name=="nausea") {
			return id;
		}id++;
		if(name=="regeneration") {
			return id;
		}
		id++;
		if(name=="resistance") {
			return id;
		}
		id++;
		if(name=="fire_resistance") {
			return id;
		}
		id++;
		if(name=="water_breathing") {
			return id;
		}
		id++;
		if(name=="invisibility") {
			return id;
		}
		id++;
		if(name=="blindness") {
			return id;
		}
		id++;
		if(name=="night_vision") {
			return id;
		}
		id++;
		if(name=="night_vision") {
			return id;
		}
		id++;
		if(name=="weakness") {
			return id;
		}
		id++;
		if(name=="poison") {
			return id;
		}
		id++;
		if(name=="wither") {
			return id;
		}
		id++;
		if(name=="health_boost") {
			return id;
		}
		id++;
		if(name=="absorption") {
			return id;
		}
		id++;
		if(name=="saturation") {
			return id;
		}
		id++;
		if(name=="glowing") {
			return id;
		}
		id++;
		if(name=="levitation") {
			return id;
		}
		id++;
		if(name=="luck") {
			return id;
		}
		id++;
		if(name=="unluck") {
			return id;
		}
		id++;
		if(name=="slow_falling") {
			return id;
		}
		id++;
		if(name=="conduit_power") {
			return id;
		}
		id++;
		if(name=="dolphins_grace") {
			return id;
		}
		id++;
		if(name=="bad_omen") {
			return id;
		}
		id++;
		if(name=="hero_of_the_village") {
			return id;
		}
		return 1337;
	}

	/**
	 * @since sometime from 11:00 to 12:00PM JUNE8
	 * @param n
	 * @return
	 */
	// Find the last digit
	public static int lastDigit(int n)
	{
		// return the last digit
		return (n % 10);
	}
}
