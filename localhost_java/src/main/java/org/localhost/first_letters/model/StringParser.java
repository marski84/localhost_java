package org.localhost.first_letters.model;

public class StringParser {


    public String parseString(String input) {
        String[] inputAsArray = input.split(" ");
        for (int i = 0; i < inputAsArray.length; i++) {
            String word = inputAsArray[i];
            char firstLetter = word.charAt(0);
            if (!isUppercase(firstLetter)) {
                word = transformWord(word, firstLetter);
            }
            inputAsArray[i] = word;
        }
        System.out.println(String.join(" ", inputAsArray));
        return String.join(" ", inputAsArray);
    }

    private boolean isUppercase(char letter) {
        return Character.isUpperCase(letter);
    }

    private String transformWord(String input, char firstLetter) {
        char firstLetterToUpperCase = Character.toUpperCase(firstLetter);
        String[] wordAsArray = input.split("");
        wordAsArray[0] = String.valueOf(firstLetterToUpperCase);
        input = String.join("", wordAsArray);
        return input;
    }
}
