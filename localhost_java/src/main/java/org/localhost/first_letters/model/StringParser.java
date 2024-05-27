package org.localhost.first_letters.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {


    public String capitalizeFirstLetters(String input) {
        validateInput(input);

        String[] inputWords = input.split(" ");
        String[] resultWords = new String[inputWords.length];

        for (int i = 0; i < inputWords.length; i++) {
            String word = inputWords[i];
            if (Character.isLowerCase(word.charAt(0))) {
                word = capitalizeFirstLetter(word);
            }
            resultWords[i] = word;
        }

        String result = String.join(" ", resultWords);

        System.out.println(result);
        //Stream, List
        return result.trim();
    }

    public String capitalizeFirstLettersWithStream(String input) {
        validateInput(input);
        String[] inputWord = input.split(" ");
        String resultString = Stream.of(inputWord)
                .reduce("", (result, next) -> result + " " + capitalizeFirstLetter(next));
        return resultString.trim();
    }

    public String capitalizeFirstLettersUsingList(String input) {
        //        tutaj pytanie czy celem było przećwiczenie List i możliwych operacji- bo w docelowym rozwiązaniu
        //        zwróciłbym String z list
        String resultWord = "";

        String[] inputWords = input.split(" ");

        String processedWord = Arrays.stream(inputWords)
                .map(word -> capitalizeFirstLetter(word))
                .collect(Collectors.joining(" "));

        List<String> listWithMap = Stream.of(input.split(" "))
                .map(word -> capitalizeFirstLetter(word)).toList();


        System.out.println(
                listWithMap.stream().collect(Collectors.joining(" ")));


        return resultWord;
    }


    private String capitalizeFirstLetter(String word) {
        String firstLetter = word.substring(0, 1).toUpperCase();
        return firstLetter + word.substring(1);
    }

    private Exception validateInput(String input) {
        if(input.length() < 1) {
            throw new InputMismatchException("Provided string is too short!");
        }
        return null;
    }
}
