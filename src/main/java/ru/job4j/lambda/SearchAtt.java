package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class SearchAtt {

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> func) {
        List<Attachment> rsl = new ArrayList<>();
        for (int index = 0; index <= list.size(); index++) {
            if (func.test(list.get(index))) {
                rsl.add(list.get(index));
            }
        }
        return rsl;
    }

    public List<Attachment> FName(List<Attachment> list) {
        Predicate<Attachment> func = (value) -> value.getName().equals("bug");
        return filter(list, func);
    }

    public List<Attachment> FSize(List<Attachment> list) {
        Predicate<Attachment> func = (value) -> value.getSize() > 100;
        return filter(list, func);
    }
}