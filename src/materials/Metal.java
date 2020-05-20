package materials;

import java.util.Random;

import utils.Color;
import utils.Hit;
import utils.Ray;
import utils.Scatter;
import utils.Vector3D;

public class Metal extends Material {
    public double fuzz;
    public Color albedo;
    private Random random;
    
    public Metal(Color albedo, double f){
        this.albedo = albedo;
        fuzz = f < 1 ? f : 1;
        random = new Random();
    }

    @Override
    public Scatter scatter(Ray in, Hit hit) {
        Vector3D normalizedDirection = in.direction;
        normalizedDirection.normalize();
        Vector3D reflected = normalizedDirection.reflect(hit.normal);
        Ray out = new Ray(hit.point, reflected.add(new Vector3D(2*random.nextDouble()-1,2*random.nextDouble()-1,2*random.nextDouble()-1)));
        Color attenuation = albedo;
        boolean scattered = out.direction.dot(hit.normal)>0;
        return new Scatter(attenuation, out, scattered);
    }
    
}