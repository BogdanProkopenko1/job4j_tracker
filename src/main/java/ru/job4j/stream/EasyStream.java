package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class EasyStream {

    public static EasyStream of(List<Integer> source) {
        int rsl;
        for (int i = 0; i < source.size(); i++) {
            rsl = source.get(i);
        }
        throw new UnsupportedOperationException();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        throw new UnsupportedOperationException();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        throw new UnsupportedOperationException();
    }

    public List<Integer> collect() {
        throw new UnsupportedOperationException();
    }
}