package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemSortTest {

    @Test
    public void sortItem() {

        List<Item> items = Arrays.asList(
                new Item("9"),
                new Item("5"),
                new Item("7"),
                new Item("3"),
                new Item("1123")
        );
        List<Item> check = Arrays.asList(
                items.get(4),
                items.get(3),
                items.get(1),
                items.get(2),
                items.get(0)
        );
        Collections.sort(items, new UpSortItem());

        assertThat(items, is(check));
    }

    @Test
    public void reverseSortItem() {

        List<Item> items = Arrays.asList(
                new Item("9"),
                new Item("5"),
                new Item("7"),
                new Item("3"),
                new Item("1123")
        );
        List<Item> check = Arrays.asList(
                items.get(0),
                items.get(2),
                items.get(1),
                items.get(3),
                items.get(4)
        );
        Collections.sort(items, new DownSortItem());

        assertThat(items, is(check));

    }
}