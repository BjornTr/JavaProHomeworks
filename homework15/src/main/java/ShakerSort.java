import java.util.Arrays;

public class ShakerSort {
    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        shakerSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void shakerSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            boolean swapped = false;

            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }

            right--;

            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            }

            left++;

            if (!swapped)
                break;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
