package ru.panas.testwork.countLetter.services;

import org.junit.jupiter.api.Test;
import ru.panas.testwork.countLetter.util.NotWordException;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordServiceTest {

    @Test()
    void countLetter() {

       String word = "word1";
       WordService wordService = new WordService();

       assertThrows(NotWordException.class, () -> {
           wordService.countLetter(word);
       });
    }

    @Test
    void wordToMap() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method methodWordToMap = WordService.class.getDeclaredMethod("wordToMap", String.class);
        methodWordToMap.setAccessible(true);

        Map<String, Integer> testWordToMap = (Map<String, Integer>) methodWordToMap.invoke(new WordService(), "word");

        Map<String, Integer> sampleMap = new HashMap<>();
        sampleMap.put("r", 1);
        sampleMap.put("d", 1);
        sampleMap.put("w", 1);
        sampleMap.put("o", 1);

        assertEquals(sampleMap, testWordToMap);
    }

    @Test
    void isWord() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method methodIsWord = WordService.class.getDeclaredMethod("isWord", String.class);
        methodIsWord.setAccessible(true);

        assertFalse((Boolean) methodIsWord.invoke(new WordService(), "word1"));
    }

    @Test
    void sortByValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method methodWordToMap = WordService.class.getDeclaredMethod("wordToMap", String.class);
        methodWordToMap.setAccessible(true);
        Map<String, Integer> testWordToMap = (Map<String, Integer>) methodWordToMap.invoke(new WordService(), "word");

        Method methodSortByValue = WordService.class.getDeclaredMethod("sortByValue", Map.class);
        methodSortByValue.setAccessible(true);
        Map<String, Integer> testMap = (Map<String, Integer>) methodSortByValue.invoke(new WordService(), testWordToMap);

        Map<String, Integer> sampleMap = new HashMap<>();
        sampleMap.put("r", 1);
        sampleMap.put("d", 1);
        sampleMap.put("w", 1);
        sampleMap.put("o", 1);

        assertEquals(sampleMap, testMap);

    }


}