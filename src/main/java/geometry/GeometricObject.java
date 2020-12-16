package geometry;

import materials.Material;
import utils.Color;
import utils.Hit;
import utils.Ray;

public abstract class GeometricObject{

    public Color color;
    public Material material;

    public abstract Hit getHit(Ray ray, double tMax, double tMin);


}