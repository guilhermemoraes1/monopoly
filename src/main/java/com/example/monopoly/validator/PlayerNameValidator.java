package com.example.monopoly.validator;


public class PlayerNameValidator implements Validator {
    @Override
    public void validate(int numPlayers, String playerNames) {
        String[] words = playerNames.split(",");

        // posso refatorar ainda mais
        for (String word : words) {
            if (word.compareTo("bank") == 0) {
                throw new IllegalArgumentException("Invalid player name");
            }
        }

        if (WordUtils.hasDuplicateWords(words)) {
            throw new IllegalArgumentException("There mustn't be repeated player names");
        }

        if (numPlayers > words.length) {
            throw new IllegalArgumentException("Too few player names");
        } else if (numPlayers < words.length) {
            throw new IllegalArgumentException("Too many player names");
        }
    }
}