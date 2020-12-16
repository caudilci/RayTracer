package materials;

import utils.Hit;
import utils.Ray;
import utils.Scatter;

public abstract class Material {

    private double schlick(double cosine, double refIdx){
        double r0 = (1-refIdx)/(1+refIdx);
        r0 *= r0;
        return r0 + (1-r0)*Math.pow(1-cosine, 5);
        
    }

    public abstract Scatter scatter(Ray in, Hit hit);
    
}