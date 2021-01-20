package megalonemo.goomod.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocksNew {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,"goo");

    //public static final RegistryObject<Block> LMAO = BLOCKS.register("lmao", () -> new Block(Block.Properties.create(Material.ROCK)));

}
