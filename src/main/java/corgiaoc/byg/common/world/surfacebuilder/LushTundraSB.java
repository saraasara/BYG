package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import java.util.Random;

public class LushTundraSB extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public LushTundraSB(Codec<SurfaceBuilderBaseConfiguration> p_i51312_1_) {
        super(p_i51312_1_);
    }

    public void apply(Random random, ChunkAccess chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int minSurfaceLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        if (noise > 1.75D) {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, minSurfaceLevel, seed, SurfaceBuilder.CONFIG_GRASS);
        } else if (noise > -0.95D) {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, minSurfaceLevel, seed, SurfaceBuilder.CONFIG_STONE);
        } else if (noise > -0.85D) {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, minSurfaceLevel, seed, SurfaceBuilder.CONFIG_GRASS);
        } else {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, minSurfaceLevel, seed, SurfaceBuilder.CONFIG_GRASS);
        }

    }
}