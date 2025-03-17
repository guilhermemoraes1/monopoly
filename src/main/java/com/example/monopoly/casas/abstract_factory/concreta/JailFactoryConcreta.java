package com.example.monopoly.casas.abstract_factory.concreta;

import com.example.monopoly.casas.Jail;
import com.example.monopoly.casas.abstract_factory.JailFactory;

public class JailFactoryConcreta implements JailFactory {
    @Override
    public Jail createJail(int position, String name, boolean visitingJail) {
        return new Jail(position, name, visitingJail);
    }
}
