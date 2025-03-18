package com.example.monopoly.places.abstract_factory.concreta;

import com.example.monopoly.places.Jail;
import com.example.monopoly.places.abstract_factory.JailFactory;

public class JailFactoryConcreta implements JailFactory {
    @Override
    public Jail createJail(int position, String name, boolean visitingJail) {
        return new Jail(position, name, visitingJail);
    }
}
