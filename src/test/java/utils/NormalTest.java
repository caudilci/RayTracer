package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class NormalTest {

    private Random random;
    private double x1, x2, y1, y2, z1, z2;
    private Normal norm1, norm2;

    @BeforeEach
    void init() {
        random = new Random();
        x1 = random.nextDouble();
        y1 = random.nextDouble();
        z1 = random.nextDouble();
        x2 = random.nextDouble();
        y2 = random.nextDouble();
        z2 = random.nextDouble();

        norm1 = new Normal(x1,y1,z1);
        norm2 = new Normal(x2,y2,z2);
    }

    @Test
    void dot() {
        double dot = x1*x2 + y1*y2 + z1*z2;

        try {
            assertEquals(dot, norm1.dot(norm2));
            assertEquals(dot, norm2.dot(norm1));
        } catch(Exception dotProductMathException) {
            System.out.println("x1: " + x1);
            System.out.println("y1: " + y1);
            System.out.println("z1: " + z1);
            System.out.println("x2: " + x2);
            System.out.println("y2: " + y2);
            System.out.println("z2: " + z2);
        }
    }

    @Test
    void normalize() {
    }
}