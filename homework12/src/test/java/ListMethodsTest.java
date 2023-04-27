import MethodsWithList.ListMethods;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ListMethodsTest {

    @Test
    public void testCountOccurrence() {
        List<String> stringList = Arrays.asList("apple", "banana", "orange", "banana", "grape", "banana", "banana", "apple", "orange", "pineapple");
        String target = "banana";
        int count = ListMethods.countOccurrence(stringList, target);
        System.out.println("The target string \"" + target + "\" occurs " + count + " times in the list.");
    }

    @Test
    public void testToList() {
        int[] array = {1, 2, 3, 4, 5};
        List<Integer> list = ListMethods.toList(array);
        System.out.println("The list is: " + list);
    }

    @Test
    public void testUniqueList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 13, 3, 5, 1, 6, 15, 3, 5, 5, 7, 8, 9, 7, 8, 9, 10, 13, 11, 1, 12, 14);
        List<Integer> uniqueList = ListMethods.findUnique(list);
        System.out.println("The unique numbers in the list are: " + uniqueList);
    }

    @Test
    public void testCalcOccurrence() {
        List<String> words = Arrays.asList("apple", "banana", "orange", "banana", "grape", "banana", "banana", "apple", "orange", "pineapple");
        ListMethods.calcOccurrence(words);
    }

    @Test
    public void testFindOccurrence() {
        List<String> words = Arrays.asList("apple", "banana", "orange", "banana", "grape", "banana", "banana", "apple", "orange", "pineapple");
        List<Map.Entry<String, Integer>> occurrences = ListMethods.findOccurrence(words);
        for (Map.Entry<String, Integer> entry : occurrences) {
            System.out.println("Word: " + entry.getKey() + ", Occurrence: " + entry.getValue());
        }
    }
}
