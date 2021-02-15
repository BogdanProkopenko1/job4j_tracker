package ru.job4j.lambda;

public class ScopeInside {

    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            total = add(total, num);
        }
        System.out.println(total);
    }

    private static Integer add(int calc, int value) {
        return calc + value;
    }
}