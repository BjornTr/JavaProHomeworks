package org.hillel;

public class ArraysTask {

    public static int[] newArrayAfterLastFour(int[] arr) {

        int lastFourIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                lastFourIndex = i;
            }
        }
        if (lastFourIndex == -1) {
            throw new RuntimeException("Array doesn't contain 4");
        }
        int[] result = new int[arr.length - lastFourIndex - 1];
        for (int i = lastFourIndex + 1; i < arr.length; i++) {
            result[i - lastFourIndex - 1] = arr[i];
        }
        return result;
    }

    public static boolean containsOnesAndFours(int[] arr) {
        boolean containsOne = false;
        boolean containsFour = false;
        for (int i : arr) {
            if (i == 1) {
                containsOne = true;
            } else if (i == 4) {
                containsFour = true;
            } else {
                return false;
            }
        }
        return containsOne && containsFour;
    }
}