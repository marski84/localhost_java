package org.localhost.Words_finder.logic;

//Map<String, Integer> wordsFinder(String text)

import java.util.*;
import java.util.stream.Stream;

public class WordsFinder {
    private static final int INIT_COUNTER = 0;
    private int amountOfOccurencesCounter = INIT_COUNTER;


    public Map<String, Integer> sortAndCountWords(String inputText) {
        Map<String, Integer> wordsMap = new HashMap();

        String[] inputArray = inputText.split(" ");

        List<String> sortedStringList = new ArrayList<String>(Arrays.asList(inputArray))
                .stream().sorted()
                .toList();

        for (String word : sortedStringList) {
            if (!wordsMap.containsKey(word)) {
                wordsMap.put(word, 1);
            } else {
                wordsMap.put(word, wordsMap.get(word)+ 1);
            }
        }
        System.out.println(wordsMap);




//        System.out.println(sortedStringList);
//        wordsMap.put("okok", 1);
//        if (wordsMap.containsKey("okok")){
//            Integer word = wordsMap.get("okok");
//            word++;
//            System.out.println("jest");
//            System.out.println(word);
//            wordsMap.put("okok", word++);
//        }
//        System.out.println(wordsMap);



        return wordsMap;
    }
}
