package geometry;

import utils.Color;
import utils.Ray;

public abstract class GeometricObject{

    public Color color;
    
    public abstract double hit(Ray ray);


}