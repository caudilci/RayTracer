package sampling;

import utils.Point2D;

public abstract class Sampler {

    private int worldWidth, woldHeight, sampleSize;

    public abstract Point2D sample(int row, int col, int x, int y);

}
