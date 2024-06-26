package org.localhost.first_letters.logic;

import org.localhost.first_letters.model.StringParser;

import java.util.InputMismatchException;

public class WordTransformer {
    public static void main(String[] args) {
        StringParser stringParser = new StringParser();

        String inputString = "lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type " +
                "specimen book. It has survived not only five centuries, but also the leap into " +
                "electronic typesetting, remaining essentially unchanged. It was popularised in the " +
                "1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                "and more recently with desktop publishing software like Aldus PageMaker " +
                "including versions of Lorem Ipsum.";

        try {
            stringParser.capitalizeFirstLettersUsingList(inputString);
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
//        stringParser.capitalizeFirstLettersWithStream(inputString);
//        System.out.println(        stringParser.capitalizeFirstLettersWithStream(inputString));
//        stringParser.capitalizeFirstLettersUsingList(inputString);
    }
}
