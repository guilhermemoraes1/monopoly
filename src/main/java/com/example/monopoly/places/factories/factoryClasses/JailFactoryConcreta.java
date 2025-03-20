package com.example.monopoly.places.factories.factoryClasses;

import com.example.monopoly.Board;
import com.example.monopoly.places.Jail;
import com.example.monopoly.places.factories.JailFactory;

public class JailFactoryConcreta implements JailFactory {
    @Override
    public Jail createJail(int position, String name, boolean visitingJail, Board board) {
        return new Jail(position, name, visitingJail, board);
    }
}
