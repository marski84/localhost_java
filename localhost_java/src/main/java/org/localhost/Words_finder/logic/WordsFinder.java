package org.localhost.Words_finder.logic;
import java.util.*;

public class WordsFinder {

    public Map<String, Integer> sortAndCountWords(String inputText) {
        Map<String, Integer> wordsMap = new LinkedHashMap<>();

        String cleanText = inputText.replaceAll("[\\p{Punct}&&[^']]", "");
        String[] inputArray = cleanText.split(" ");

        List<String> sortedStringList = new ArrayList<String>(Arrays.asList(inputArray))
                .stream()
                .sorted()
                .toList();

        for (String word : sortedStringList) {
            handleAddToMap(word, wordsMap);
        }
        System.out.println(wordsMap);
        return wordsMap;
    }

    private void handleAddToMap(String word, Map<String, Integer> wordsMap) {
        if (!wordsMap.containsKey(word)) {
            wordsMap.put(word.toLowerCase(), 1);
        } else {
            wordsMap.put(word, wordsMap.get(word)+ 1);
        }
    }
}
