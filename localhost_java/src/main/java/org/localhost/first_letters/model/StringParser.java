package org.localhost.first_letters.model;

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
        return result;
    }



    private String capitalizeFirstLetter(String word) {
        String firstLetter = word.substring(0, 1).toUpperCase();
        return firstLetter + word.substring(1);
    }
}
