package org.hillel.homework10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyMathLibTest {

    @Test
    public void testMyMathLib() {
        assertEquals(4.0, MyMathLib.add(2.0, 2.0), 0.001);
        assertEquals(0.0, MyMathLib.add(-2.0, 2.0), 0.001);
        assertEquals(-2.0, MyMathLib.add(-1.0, -1.0), 0.001);
    }
}