package com.firstname_lastname.java.lesson3;

/**
 * Sentences operation class
 *
 * @version 1.0
 * @author FIO
 */


import java.util.ArrayList;

public class SentenceOperation {
    public ArrayList<String> splitSentences(ArrayList<String> listString) {
        ArrayList<String> splitSentences = new ArrayList<>();
        String fullText = "";
//        fullText = listString.toString();
        for (String str: listString) {
            fullText += str + " ";
        }

        PropertiesFile prop = new PropertiesFile();
        String regexpReplaceSpace = prop.readProperties("regexpReplaceSpace");

        fullText = fullText.replaceAll(regexpReplaceSpace, " ");

        String regexpSplit = prop.readProperties("regexpSplitSentences");

        String[] list = fullText.split(regexpSplit);

        for (String str: list) {
            splitSentences.add(str.trim());
        }
        return splitSentences;
    }
}
