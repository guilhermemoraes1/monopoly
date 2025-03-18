package com.example.monopoly.places.abstract_factory.concreta;

import com.example.monopoly.Board;
import com.example.monopoly.places.Tax;
import com.example.monopoly.places.abstract_factory.TaxFactory;

public class TaxFactoryConcreta implements TaxFactory {
    @Override
    public Tax createTax(int position, String name, boolean luxuryTax, Board board) {
        return new Tax(position, name, luxuryTax, board);
    }
}
