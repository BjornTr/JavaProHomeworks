package Homework8;

import java.util.Random;
import java.util.Scanner;

public class ArrayValueCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns: ");
        int columns = scanner.nextInt();

        String[][] array = new String[rows][columns];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) { // Changed from array.length to array[i].length

//                As an example without characters, but only integers

                array[i][j] = String.valueOf(random.nextInt(100) + 1);


//                As an example with characters and integers to test ArrayDataException

//                if (random.nextBoolean()) {
//                    array[i][j] = Integer.toString(random.nextInt(10));
//                } else {
//                    array[i][j] = Character.toString((char) (random.nextInt(10) + 'A'));
//                }
            }
        }

        try {
            int sum = doCalc(array);
            System.out.println("The sum is: " + sum);
        } catch (ArraySizeException | ArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        int sum = 0;
        int numRows = array.length;
        int numCols = array[0].length;
        if (numRows != 4 || numCols != 4) {
            throw new ArraySizeException("Invalid array size! Must be 4x4");
        }
        for (int i = 0; i < numRows; i++) {
            if (array[i].length != numCols) {
                throw new ArraySizeException("Invalid array size! All rows must have the same number of columns");
            }
            for (int j = 0; j < numCols; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new ArrayDataException("Invalid data in cell (" + i + "," + j + "): " + ex.getMessage());
                }
            }
        }
        return sum;
    }
}
