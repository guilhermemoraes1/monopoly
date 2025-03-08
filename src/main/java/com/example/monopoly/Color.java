package com.example.monopoly;

import java.util.HashSet;
import java.util.Set;

public class Color {
    private Set<String> validColors;

    public Color() {
        validColors = new HashSet<>();
        validColors.add("black");
        validColors.add("white");
        validColors.add("red");
        validColors.add("green");
        validColors.add("blue");
        validColors.add("yellow");
        validColors.add("orange");
        validColors.add("pink");
        validColors.add("brown");
    }

    public boolean isValidColor(String color) {
        return validColors.contains(color);
    }
}

