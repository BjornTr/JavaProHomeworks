package MethodsWithList;

import java.util.*;

public class ListMethods {

    public static int countOccurrence(List<String> stringList, String target) {
        int count = 0;
        for (String s : stringList) {
            if (s.equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    public static List<Integer> findUnique(List<Integer> list) {
        List<Integer> uniqueList = new ArrayList<>();
        for (int i : list) {
            if (!uniqueList.contains(i)) {
                uniqueList.add(i);
            }
        }
        return uniqueList;
    }

    public static void calcOccurrence(List<String> words) {

        Collections.sort(words);
        String currentWord = words.get(0);
        int count = 1;

        for (int i = 1; i < words.size(); i++) {
            String word = words.get(i);
            if (word.equals(currentWord)) {
                count++;
            } else {
                System.out.println(currentWord + ": " + count);
                count = 1;
                currentWord = word;
            }
        }
        System.out.println(currentWord + ": " + count);

    }

    public static List<Map.Entry<String, Integer>> findOccurrence(List<String> words) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : words) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> occurrences = new ArrayList<>(occurrenceMap.entrySet());
        occurrences.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return occurrences;
    }
}

