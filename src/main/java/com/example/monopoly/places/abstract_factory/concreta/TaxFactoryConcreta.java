package com.example.monopoly.places.abstract_factory.concreta;

import com.example.monopoly.places.Tax;
import com.example.monopoly.places.abstract_factory.TaxFactory;

public class TaxFactoryConcreta implements TaxFactory {
    @Override
    public Tax createTax(int position, String name, boolean luxuryTax) {
        return new Tax(position, name, luxuryTax);
    }
}
