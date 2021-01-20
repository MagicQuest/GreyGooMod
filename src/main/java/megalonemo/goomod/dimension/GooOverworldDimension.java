package megalonemo.goomod.dimension;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

import javax.annotation.Nullable;

public class GooOverworldDimension extends Dimension {
    public GooOverworldDimension(World world, DimensionType type) {
        super(world, type,0f);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return new OverworldChunkGenerator(world, new OverworldBiomeProvider(new OverworldBiomeProviderSettings(world.getWorldInfo())),new OverworldGenSettings());
        //return new ModChunkGenerator(world,new ModBiomeProvider(),new ModGenSettings());
    }

    @Override
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
        return null;
    }

    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return Vec3d.ZERO;
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public int getActualHeight() {
        return 256;
    }
}
