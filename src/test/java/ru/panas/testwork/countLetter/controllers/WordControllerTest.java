package ru.panas.testwork.countLetter.controllers;

import org.junit.jupiter.api.Test;
import ru.panas.testwork.countLetter.services.WordService;
import ru.panas.testwork.countLetter.util.NotWordException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordControllerTest {

    @Test()
    void getCountLetter() {

        String word = "word1";
        WordService wordService = new WordService();

        assertThrows(NotWordException.class, () -> {
            wordService.countLetter(word);
        });
    }

    @Test
    void shouldReturnMapOfLetters() {
        WordController wordController = new WordController(new WordService());

        Map<String, Integer> testWordToMap = wordController.getCountLetter("wordd");

        Map<String, Integer> sampleMap = new HashMap<>();
        sampleMap.put("d", 2);
        sampleMap.put("r", 1);
        sampleMap.put("w", 1);
        sampleMap.put("o", 1);

        assertEquals(sampleMap, testWordToMap);
    }


}
