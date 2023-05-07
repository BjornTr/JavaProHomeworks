import MethodsWithList.ListMethods;
import MethodsWithList.Occurrence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListMethodsTest {

    @Test
    public void testCountOccurrence() {
        List<String> stringList = Arrays.asList("apple", "banana", "orange", "banana", "grape", "banana", "banana", "apple", "orange", "pineapple");
        String target = "banana";
        int count = ListMethods.countOccurrence(stringList, target);
        Assertions.assertEquals(4, count, "Incorrect count for target string \"" + target + "\"");
        System.out.println("The target string \"" + target + "\" occurs " + count + " times in the list.");
    }

    @Test
    public void testToList() {
        int[] array = {1, 2, 3, 4, 5};
        List<Integer> list = ListMethods.toList(array);
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5);
        Assertions.assertEquals(expectedList, list, "Incorrect conversion from array to list");
        System.out.println("The list is: " + list);
    }

    @Test
    public void testUniqueList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 13, 3, 5, 1, 6, 15, 3, 5, 5, 7, 8, 9, 7, 8, 9, 10, 13, 11, 1, 12, 14);
        List<Integer> uniqueList = ListMethods.findUnique(list);
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 13, 5, 6, 15, 7, 8, 9, 10, 11, 12, 14);
        Assertions.assertEquals(expectedList, uniqueList, "Incorrect unique list");
        System.out.println("The unique numbers in the list are: " + uniqueList);
    }

    @Test
    public void testCalcOccurrence() {
        List<String> words = Arrays.asList("apple", "banana", "orange", "banana", "grape", "banana", "banana", "apple", "orange", "pineapple");
        int occurrences = ListMethods.calcOccurrence(words, "banana");
        assertEquals(4, occurrences);
        System.out.println("The word \"banana\" occurs " + occurrences + " times in the list.");
    }

    @Test
    public void testFindOccurrence() {
        List<String> words = Arrays.asList("apple", "banana", "orange", "banana", "grape", "banana", "banana", "apple", "orange", "pineapple");
        List<Occurrence> occurrences = ListMethods.findOccurrence(words);
        List<Occurrence> expected = Arrays.asList(
                new Occurrence("banana", 4),
                new Occurrence("orange", 2),
                new Occurrence("apple", 2),
                new Occurrence("pineapple", 1),
                new Occurrence("grape", 1)
        );
        List<Occurrence> actual = ListMethods.findOccurrence(words);
        assertEquals(expected, actual);
        System.out.println("The occurrences are: ");
        for (Occurrence occurrence : occurrences) {
            System.out.println(occurrence);
        }
    }
}
