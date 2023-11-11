package ru.panas.testwork.countLetter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.panas.testwork.countLetter.services.WordService;
import ru.panas.testwork.countLetter.util.NotWordException;
import ru.panas.testwork.countLetter.util.WordErrorResponse;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public Map<String, Integer> getCountLetter(@RequestParam(required = false) String word) {
        return wordService.countLetter(word);
    }

    @ExceptionHandler
    private ResponseEntity<WordErrorResponse> handleException(NotWordException e) {
        WordErrorResponse response = new WordErrorResponse(
                "It was not word",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
