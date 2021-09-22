package corgiaoc.byg.common.world.feature.nether.quartzdesert;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.FeatureUtil;
import corgiaoc.byg.common.world.feature.config.QuartzSpikeConfig;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Random;

public class QuartzSpikeFeature extends Feature<QuartzSpikeConfig> {
    private static final BlockStatePredicate IS_QUARTZ_SAND = BlockStatePredicate.forBlock(BYGBlocks.QUARTZITE_SAND);
    private static final BlockStatePredicate IS_AIR = BlockStatePredicate.forBlock(Blocks.CAVE_AIR);


    public QuartzSpikeFeature(Codec<QuartzSpikeConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<QuartzSpikeConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random random, BlockPos pos, QuartzSpikeConfig config) {

        if (!IS_QUARTZ_SAND.test(world.getBlockState(pos.below()))){
            return false;
        }

        if (!world.getBlockState(pos.above(4)).canOcclude()){
            return false;
        }

        if (!FeatureUtil.isAir(world, pos.above(5))) {
            return false;
        }

        if (world.getBlockState(pos.below()) != config.getBlockProvider().getState(random, pos) || !world.getBlockState(pos.below()).canOcclude())
            return false;

        int type = random.nextInt(2);


            if (type == 1) {
                for (int y1 = 1; y1 <= 2; ++y1) {
                    world.setBlock(pos.offset(1, y1, -1), getQuartzType(random), 3);
                    world.setBlock(pos.offset(0, y1, -1), getQuartzType(random), 3);
                    world.setBlock(pos.offset(-1, y1, 0), getQuartzType(random), 3);
                    world.setBlock(pos.offset(0, y1, 2), getQuartzType(random), 3);
                }
                for (int y1 = 1; y1 <= 3; ++y1) {
                    world.setBlock(pos.offset(2, y1, 0), getQuartzType(random), 3);
                    world.setBlock(pos.offset(-1, y1, 1), getQuartzType(random), 3);
                    world.setBlock(pos.offset(1, y1, 1), getQuartzType(random), 3);
                    world.setBlock(pos.offset(2, y1, 1), getQuartzType(random), 3);
                }
                for (int y1 = 1; y1 <= 5; ++y1) {
                    world.setBlock(pos.offset(0, y1, 0), getQuartzType(random), 3);
                }
                for (int y1 = 1; y1 <= 6; ++y1) {
                    world.setBlock(pos.offset(1, y1, 0), getQuartzType(random), 3);
                }
                for (int y1 = 1; y1 <= 7; ++y1) {
                    world.setBlock(pos.offset(0, y1, 1), getQuartzType(random), 3);
                }
                for (int y1 = 1; y1 <= 9; ++y1) {
                    world.setBlock(pos.offset(1, y1, 1), getQuartzType(random), 3);
                }
            } else {
                for (int y1 = 1; y1 <= 2; ++y1) {
                    world.setBlock(pos.offset(-1, y1, 1), getQuartzType(random), 3);
                    world.setBlock(pos.offset(0, y1, -1), getQuartzType(random), 3);
                    world.setBlock(pos.offset(-1, y1, 0), getQuartzType(random), 3);
                    world.setBlock(pos.offset(2, y1, 0), getQuartzType(random), 3);
                }
                for (int y1 = 1; y1 <= 3; ++y1) {
                    world.setBlock(pos.offset(1, y1, 2), getQuartzType(random), 3);
                    world.setBlock(pos.offset(-1, y1, 0), getQuartzType(random), 3);
                }
                for (int y1 = 1; y1 <= 4; ++y1) {
                    world.setBlock(pos.offset(0, y1, 2), getQuartzType(random), 3);
                    world.setBlock(pos.offset(1, y1, 2), getQuartzType(random), 3);
                    world.setBlock(pos.offset(1, y1, 0), getQuartzType(random), 3);
                }
                for (int y1 = 1; y1 <= 6; ++y1) {
                    world.setBlock(pos.offset(0, y1, 0), getQuartzType(random), 3);
                }
                for (int y1 = 1; y1 <= 7; ++y1) {
                    world.setBlock(pos.offset(1, y1, 1), getQuartzType(random), 3);
                }
                for (int y1 = 1; y1 <= 9; ++y1) {
                    world.setBlock(pos.offset(0, y1, 1), getQuartzType(random), 3);
                }
            }

        return true;

    }

    public static BlockState getQuartzType(Random rand){
        int i = rand.nextInt(5);
        if (i <= 3){
            return Blocks.SMOOTH_QUARTZ.defaultBlockState();
        } else{
            return Blocks.QUARTZ_BLOCK.defaultBlockState();
        }
    }
}