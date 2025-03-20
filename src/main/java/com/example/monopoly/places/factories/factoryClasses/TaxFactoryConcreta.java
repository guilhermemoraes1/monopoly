package com.example.monopoly.places.factories.factoryClasses;

import com.example.monopoly.Board;
import com.example.monopoly.places.Tax;
import com.example.monopoly.places.factories.TaxFactory;

public class TaxFactoryConcreta implements TaxFactory {
    @Override
    public Tax createTax(int position, String name, boolean luxuryTax, Board board) {
        return new Tax(position, name, luxuryTax, board);
    }
}
