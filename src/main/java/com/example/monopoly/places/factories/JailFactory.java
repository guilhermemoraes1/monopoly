package com.example.monopoly.places.factories;

import com.example.monopoly.Board;
import com.example.monopoly.places.Jail;

public interface JailFactory {
    Jail createJail(int position, String name, boolean visitingJail, Board board);
}
