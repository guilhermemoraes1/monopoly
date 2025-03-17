package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.Tax;
import com.example.monopoly.casas.abstract_factory.TaxFactory;

public class TaxFactoryConcreta implements TaxFactory {
    @Override
    public Tax createTax(int position, String name, boolean taxRiqueza) {
        return new Tax(position, name, taxRiqueza);
    }
}
