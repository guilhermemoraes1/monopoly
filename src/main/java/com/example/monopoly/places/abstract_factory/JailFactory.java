package com.example.monopoly.places.abstract_factory;

import com.example.monopoly.places.Jail;

public interface JailFactory {
    Jail createJail(int position, String name, boolean visitingJail);
}
