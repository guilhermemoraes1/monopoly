package com.example.monopoly.validator;

import java.util.HashSet;
import java.util.Set;

public class WordUtils  {

    public static boolean hasDuplicateWords(String[] data) {
        Set<String> uniqueWords = new HashSet<>();
        
        for (String word : data) {
            word = word.trim();
            if (!uniqueWords.add(word)) {
                return true;
            }
        }
        return false;
    }

    public static String hasCurlyBraces(String data) {
        if (data.charAt(0) == '{') {
            data = data.substring(1, data.length() - 1);
        }
        
        return data;
    }
}
