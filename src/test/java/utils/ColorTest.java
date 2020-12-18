package utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {
    private Random random;
    private float r1, r2, g1, g2, b1, b2;
    private Color color1, color2;

    @BeforeEach
    void init() {
        random = new Random();
        r1 = random.nextFloat();
        g1 = random.nextFloat();
        b1 = random.nextFloat();
        r2 = random.nextFloat();
        g2 = random.nextFloat();
        b2 = random.nextFloat();

        color1 = new Color(r1, g1, b1);
        color2 = new Color(r2, g2, b2);
    }

    @Test
    void add() {
        color1.add(color2);

        assertEquals(r1+r2, color1.r);
        assertEquals(g1+g2, color1.g);
        assertEquals(b1+b2, color1.b);
    }

    @Test
    void divide() {
        int scalar = random.nextInt();
        color1.divide(scalar);

        assertEquals(r1/scalar, color1.r);
        assertEquals(g1/scalar, color1.g);
        assertEquals(b1/scalar, color1.b);
    }

    @Test
    void multiply() {
        double val = random.nextDouble();
        color1.multiply(val);

        assertEquals((float) (r1*val), color1.r);
        assertEquals((float) (g1*val), color1.g);
        assertEquals((float) (b1*val), color1.b);
    }

    @Test
    void multiplyColor() {
        Color result = color1.multiplyColor(color2);

        assertEquals(r1*r2, result.r);
        assertEquals(g1*g2, result.g);
        assertEquals(b1*b2, result.b);
    }

    @Test
    void clamp() {
        Color greater = new Color(1f, 1f, 1f);
        greater.clamp();
        assertEquals(0.999f, greater.r);
        assertEquals(0.999f, greater.g);
        assertEquals(0.999f, greater.b);
        Color lessThan = new Color(-1f, -1f, -1f);
        lessThan.clamp();
        assertEquals(0f, lessThan.r);
        assertEquals(0f, lessThan.g);
        assertEquals(0f, lessThan.b);
    }

    @Test
    void toInteger() {
    }
}