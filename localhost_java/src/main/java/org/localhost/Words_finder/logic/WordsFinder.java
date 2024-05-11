package org.localhost.Words_finder.logic;

//Map<String, Integer> wordsFinder(String text)

import java.util.*;
import java.util.stream.Stream;

public class WordsFinder {
    private static final int INIT_COUNTER = 0;
    private int amountOfOccurencesCounter = INIT_COUNTER;


    public Map<String, Integer> sortAndCountWords(String inputText) {
        Map<String, Integer> wordsInfo = new HashMap();

        String[] inputArray = inputText.split(" ");
        List<String> sortedStringList = new ArrayList<String>(Arrays.asList(inputArray))
                .stream().sorted().toList();;//


        System.out.println(sortedStringList);


        return wordsInfo;
    }
}
