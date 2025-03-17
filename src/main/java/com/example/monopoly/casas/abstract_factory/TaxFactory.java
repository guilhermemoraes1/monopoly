package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.Tax;

public interface TaxFactory {
    Tax createTax(int position, String name, boolean taxRiqueza);
}
