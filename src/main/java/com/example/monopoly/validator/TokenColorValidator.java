package com.example.monopoly.validator;

import com.example.monopoly.Color;

public class TokenColorValidator implements Validator {

    private Color colorValidator;

    public TokenColorValidator(Color colorValidator) {
        this.colorValidator = colorValidator;
    }

    @Override
    public void validate(int numPlayers, String tokenColors) {
        String[] colors = tokenColors.split(",");
        
        // posso refatorar mais
        if (WordUtils.hasDuplicateWords(colors)) {
            throw new IllegalArgumentException("There mustn't be repeated token colors");
        }

        for (String color : colors) {
            color = color.trim();
            if (!colorValidator.isValidColor(color)) {
                throw new IllegalArgumentException("Invalid token color");
            }
        }
        
        if (numPlayers > colors.length) {
            throw new IllegalArgumentException("Too few token colors");
        } else if (numPlayers < colors.length) {
            throw new IllegalArgumentException("Too many token colors");
        }
    }
}
