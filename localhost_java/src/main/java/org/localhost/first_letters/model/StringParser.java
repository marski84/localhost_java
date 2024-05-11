package org.localhost.first_letters.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class StringParser {


    public String capitalizeFirstLetters(String input) {

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
        String[] inputWord = input.split(" ");
        String resultString = Stream.of(inputWord)
                .reduce("", (result, next) -> result + " " + capitalizeFirstLetter(next));
        return resultString.trim();
    }

    public String capitalizeFirstLettersUsingList(String input) {
        //        tutaj pytanie czy celem było przećwiczenie List i możliwych operacji- bo w docelowym rozwiązaniu
        //        zwróciłbym String z list
        List list = new ArrayList<String>();
        List resultList = new ArrayList<String>();
        String resultWord = "";

        String[] inputWords = input.split(" ");
        for (String word : inputWords) {
            list.add(word);
        }

        ListIterator<String> listIterator = list.listIterator();


        while (listIterator.hasNext()) {
            String capitalizedWord = capitalizeFirstLetters(listIterator.next());
            resultList.add(capitalizedWord);
        }
        resultWord = String.join(" ", resultList).trim();
        return resultWord;
    }


    private String capitalizeFirstLetter(String word) {
        String firstLetter = word.substring(0, 1).toUpperCase();
        return firstLetter + word.substring(1);
    }
}
