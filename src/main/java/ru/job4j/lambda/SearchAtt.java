package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class SearchAtt {

    private static int filter(int to, BiFunction<Integer, Integer, Integer> func, Supplier<Integer> initValue) {
        int rsl = initValue.get();
        for (int index = 1; index <= to; index++) {
            rsl = func.apply(rsl, index);
        }
        return rsl;
    }

    public static int summation(int to) {
        BiFunction<Integer, Integer, Integer> func = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer left, Integer right) {
                return left + right;
            }
        };
        Supplier<Integer> initValue = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 0;
            }
        };
        return filter(to, func, initValue);
    }

    public static int multiplication(int to) {
        BiFunction<Integer, Integer, Integer> func = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer left, Integer right) {
                return left * right;
            }
        };
        Supplier<Integer> initValue = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1;
            }
        };
        return filter(to, func, initValue);
    }


/*
    public static List<Attachment> filterSize(List<Attachment> list, int size) {
        Function<Attachment, Attachment> function = new UnaryOperator<Attachment>() {
            @Override
            public Attachment apply(Attachment attachment) {
                if (attachment.getSize() > initSize.get()) {
                    return attachment;
                } else {
                    return null;
                }
            }
            Supplier<Integer> initSize = new Supplier<Integer>() {
                @Override
                public Integer get() {
                    return size;
                }
            };
        };
        return filter(list, initSize);
    }

    public static List<Attachment> filterName(List<Attachment> list, String name) {
        Function<Attachment, Attachment> function = new UnaryOperator<Attachment>() {
            @Override
            public Attachment apply(Attachment attachment) {
                if (attachment.getSize() > initSize.get()) {
                    return attachment;
                } else {
                    return null;
                }
            }
            Supplier<String> initName = new Supplier<String>() {
                @Override
                public String get() {
                    return name;
                }
            };
        };
        return filter(list, value);
    }

 */
}