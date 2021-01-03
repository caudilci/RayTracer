package sampling;

import utils.Point2D;

import java.util.Random;

public class RegularSampler extends Sampler {
    private int worldWidth, worldHeight, sampleSize;

    public RegularSampler(int worldHeight, int worldWidth, int sampleSize){
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.sampleSize = sampleSize;
    }

    public Point2D sample(int row, int col, int x, int y) {
        return new Point2D(x - worldWidth / 2f + (col + 0.5) / sampleSize,
                y - worldHeight / 2f + (row + 0.5) / sampleSize);
    }
}
