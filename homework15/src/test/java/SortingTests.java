import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortingTests {

    @Test
    public void testQuickSort() {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};

        QuickSort.quickSort(arr, 0, arr.length - 1);
        Assertions.assertArrayEquals(expected, arr);
    }

    @Test
    public void testShakerSort() {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};

        ShakerSort.shakerSort(arr);
        Assertions.assertArrayEquals(expected, arr);
    }
}
