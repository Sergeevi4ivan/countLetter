package ru.panas.testwork.countLetter.services;

import org.springframework.stereotype.Service;
import ru.panas.testwork.countLetter.util.NotWordException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WordService {

    public Map<String, Integer> countLetter(String word) {

        if (word == null || !isWord(word)) {
            throw new NotWordException();
        }

        return sortByValue(wordToMap(word));
    }

    private Map<String, Integer> wordToMap(String word) {

        String[] splittedString = word.split("");
        Map<String, Integer> counterMap = new HashMap<>();

        for (String letter :
                splittedString) {
            if (!letter.isEmpty()) {
                Integer count = counterMap.get(letter);
                if (count == null) {
                    count = 0;
                }
                counterMap.put(letter, ++count);
            }
            }
        return counterMap;
    }

    private boolean isWord(String str) {
        for (char c : str.toCharArray())
            if(!Character.isUpperCase(Character.toUpperCase(c)))
                return false;
        return true;
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortedMap) {
        Map<K, V> sortedMap = unsortedMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));

        return sortedMap;
    }
}
