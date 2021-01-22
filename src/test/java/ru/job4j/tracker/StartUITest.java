package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

/*
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Name"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("New name"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Test"));
        Input input = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new ShowToIdAction(out),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item0 = tracker.add(new Item("Test"));
        Item item1 = tracker.add(new Item("Test"));
        Item item2 = tracker.add(new Item("Test 2"));
        Input input = new StubInput(
                new String[] {"0", "Test", "1"}
        );
        UserAction[] actions = {
                new ShowToNameAction(out),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        Item[] rsl = tracker.findByName("Test");
        Item[] added = {item0, item1};
        assertThat(rsl, is(added));
    }
 */
    @Test
    public void whenAllItems() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Item item0 = tracker.add(new Item("Test 0"));
        Item item1 = tracker.add(new Item("Test 1"));
        Input input = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAction(out),
                new ExitAction()
        };
        new StartUI(out).init(input, tracker, actions);
        Item[] items = {item0, item1};
        assertThat(out.toString(), is(items));
    }
}