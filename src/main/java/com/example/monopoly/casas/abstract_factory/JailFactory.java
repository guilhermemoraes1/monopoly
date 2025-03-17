package com.example.monopoly.casas.abstract_factory;

import com.example.monopoly.casas.Jail;

public interface JailFactory {
    Jail createJail(int position, String name, boolean visitingJail);
}
