package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8, V_9, V_10, V_J, V_L, V_K, V_A
}

public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
     //   ArrayList<Card> rsl = Stream.of(Suit.values()).map(Stream.of(Value.values()).)
    }
}