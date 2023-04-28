package MethodsWithList;

import lombok.AllArgsConstructor;

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

    public static int calcOccurrence(List<String> words, String word) {
        int count = 0;
        for (String w : words) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static List<Occurrence> findOccurrence(List<String> words) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : words) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        List<Occurrence> occurrences = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            occurrences.add(new Occurrence(entry.getKey(), entry.getValue()));
        }
        occurrences.sort(Comparator.comparing(Occurrence::getCount).reversed());
        return occurrences;
    }
}

