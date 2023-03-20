package Homework8;

import java.util.Random;
import java.util.Scanner;

public class ArrayValueCalculator {



    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        if (array.length != 4 || array[0].length != 4) {
            throw new ArraySizeException("Invalid array size! Must be 4x4");
        } else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    try {
                        sum += Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException ex) {
                        throw new ArrayDataException("Invalid data in cell (" + i + "," + j + "): " + ex.getMessage());
                    }
                }
            }
        }
        return sum;
    }
}
