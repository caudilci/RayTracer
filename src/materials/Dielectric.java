package materials;

import java.util.Random;

import utils.Color;
import utils.Hit;
import utils.Ray;
import utils.Scatter;
import utils.Vector3D;

public class Dielectric extends Material {

    public double refIdx;
    private Random random;

    public Dielectric(double refIdx) {
        this.refIdx = refIdx;
        random = new Random();
    }

    private double schlick(double cosine, double refIdx){
        double r0 = (1-refIdx)/(1+refIdx);
        r0 *= r0;
        return r0 + (1-r0)*Math.pow(1-cosine, 5);
        
    }

    @Override
    public Scatter scatter(Ray in, Hit hit) {
        Color attenuation = new Color(1.0f, 1.0f, 1.0f);
        double etaiOetat = hit.isFrontFace ? (1.0 / refIdx) : refIdx;
        Vector3D unitDirection = in.direction;
        unitDirection.normalize();
        double cosTheta = Math.min(hit.normal.dot(new Vector3D(-unitDirection.x, -unitDirection.y, -unitDirection.z)),
                1.0);
        double sinTheta = Math.sqrt(1.0-cosTheta*cosTheta);
        if(etaiOetat*sinTheta> 1){
            Vector3D reflected = unitDirection.reflect(hit.normal);
            Ray out = new Ray(hit.point, reflected);
            return new Scatter(attenuation, out, true);
        }
        double reflectProb = schlick(cosTheta, etaiOetat);
        if(random.nextDouble()<reflectProb){
            Vector3D reflected = unitDirection.reflect(hit.normal);
            Ray out = new Ray(hit.point, reflected);
            return new Scatter(attenuation, out, true);
        }
        Vector3D refracted = unitDirection.refract(hit.normal, etaiOetat);
        Ray out = new Ray(hit.point, refracted);
        return new Scatter(attenuation, out, true);
    }

}