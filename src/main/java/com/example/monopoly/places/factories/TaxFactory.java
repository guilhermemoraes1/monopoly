package com.example.monopoly.places.factories;

import com.example.monopoly.Board;
import com.example.monopoly.places.Tax;

public interface TaxFactory {
    Tax createTax(int position, String name, boolean luxuryTax, Board board);
}
