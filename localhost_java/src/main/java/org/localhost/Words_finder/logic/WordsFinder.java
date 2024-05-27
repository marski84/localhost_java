package org.localhost.Words_finder.logic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsFinder {

    public Map<String, Integer> sortAndCountWords(String inputText) {
        Map<String, Integer> wordsMap = new LinkedHashMap<>();

        String cleanText = inputText.replaceAll("[\\p{Punct}&&[^']]", "");
        String[] inputArray = cleanText.split(" ");

//        List<String> sortedStringList = new ArrayList<>(Arrays.asList(inputArray))
//                .stream()
//                .sorted()
//                .toList();
//
//        for (String word : sortedStringList) {
//            handleAddToMap(word, wordsMap);
//        }
        TreeMap<String, Integer> resultMap = new TreeMap<>(Arrays.stream(inputArray)
                .sorted()
                .collect(
                        Collectors.toMap(
                                word -> word,
                                count -> 1,
                                Integer::sum
                        ))
        );


        Map<String, Long> resultMapWithGrouping = new TreeMap<>(Stream.of(inputArray)
                .collect(Collectors.groupingBy(
                                word -> word,
                                Collectors.counting()
                        )
                )
        );

        System.out.println(resultMapWithGrouping);
        System.out.println(resultMap);


        return wordsMap;
    }

    private void handleAddToMap(String word, Map<String, Integer> wordsMap) {
        //groupingBy()
        //Collectors.toMap()


        if (!wordsMap.containsKey(word)) {
            wordsMap.put(word.toLowerCase(), 1);
        } else {
            wordsMap.put(word, wordsMap.get(word) + 1);
        }
    }
}
