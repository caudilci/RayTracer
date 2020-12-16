package projection;

import utils.Point2D;
import utils.Ray;

public abstract class Projection {

    public abstract Ray createRay(Point2D point);

}