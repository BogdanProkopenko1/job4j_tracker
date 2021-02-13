package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {

    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> {
            System.out.println("Comparing : " + left + " - " + right);
            return left.compareTo(right);
        };
    }
}