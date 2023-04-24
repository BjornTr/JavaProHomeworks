package org.hillel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTaskTest {

    @Test
    void testLastFour1() {
        int[] array1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] arrExp1 = {1, 7};
        assertArrayEquals(arrExp1, ArraysTask.newArrayAfterLastFour(array1));
    }

    @Test
    void testLastFour2() {
        int[] array2 = {4, 4, 4, 4};
        int[] arrExp2 = {};
        assertArrayEquals(arrExp2, ArraysTask.newArrayAfterLastFour(array2));
    }

    @Test
    void testLastFour3() {
        int[] array3 = {1, 2, 3};
        RuntimeException exception = assertThrows(RuntimeException.class, () -> ArraysTask.newArrayAfterLastFour(array3));
        assertEquals("Array doesn't contain 4", exception.getMessage());
    }


    @Test
    void testLastFour4() {

        int[] array4 = {1, 2, 4, 3, 4, 5};
        int[] arrExp4 = {5};
        assertArrayEquals(arrExp4, ArraysTask.newArrayAfterLastFour(array4));
    }

    @Test
    void testContainsOnesAndFours1() {
        int[] array1 = {1, 1, 1, 4, 4, 1, 4, 4};
        assertTrue(ArraysTask.containsOnesAndFours(array1));
    }

    @Test
    void testContainsOnesAndFours2() {

        int[] array2 = {1, 1, 1, 1, 1, 1};
        assertFalse(ArraysTask.containsOnesAndFours(array2));
    }

    @Test
    void testContainsOnesAndFours3() {

        int[] array3 = {4, 4, 4, 4};
        assertFalse(ArraysTask.containsOnesAndFours(array3));
    }

    @Test
    void testContainsOnesAndFours4() {

        int[] array4 = {1, 4, 4, 1, 1, 4, 3};
        assertFalse(ArraysTask.containsOnesAndFours(array4));
    }
}