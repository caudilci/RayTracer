package sampling;

import utils.Point2D;

import java.util.Random;

public class JitteredSampler {

    private int worldWidth, worldHeight, sampleSize;
    private Random random;

    public JitteredSampler(int worldHeight, int worldWidth, int sampleSize){
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.sampleSize = sampleSize;
        random = new Random();
    }

    public Point2D sample(int row, int col, int x, int y) {
        Random random = new Random();
        return new Point2D(x - worldWidth / 2f + (col + random.nextFloat()) / sampleSize,
                y - worldHeight / 2f + (row + random.nextFloat()) / sampleSize);
    }
}
