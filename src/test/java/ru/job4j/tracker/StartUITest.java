package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.nio.channels.AsynchronousServerSocketChannel;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("New");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "Replaced"
        };
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("Replaced"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("New");
        tracker.add(item);
        String[] answers = { String.valueOf(item.getId()) };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item test = tracker.findById(item.getId());
        Assert.assertEquals(test, null);
    }
}