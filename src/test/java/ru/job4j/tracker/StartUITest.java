package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = tracker.add(new Item("Name"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New name", "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("New name"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item = tracker.add(new Item("Test"));
        Input input = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new ShowToIdAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find item by Id ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() + "Result = " + item.toString() + System.lineSeparator() +
                        "=============================" + System.lineSeparator() + System.lineSeparator() +
                        System.lineSeparator() + System.lineSeparator() + "Menu." + System.lineSeparator() +
                        "0. === Find item by Id ===" + System.lineSeparator() + "1. === Exit ===" + System.lineSeparator())
        );
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Output output = new StubOutput();
        Item item0 = tracker.add(new Item("Test"));
        Item item1 = tracker.add(new Item("Test"));
        Item item2 = tracker.add(new Item("Test 2"));
        Input input = new StubInput(
                new String[] {"0", "Test", "1"}
        );
        UserAction[] actions = {
                new ShowToNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find items by name ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() + "Result: " + System.lineSeparator() + item0.toString() + System.lineSeparator() +
                        item1.toString() + System.lineSeparator() +
                        "=============================" + System.lineSeparator() + System.lineSeparator() +
                        System.lineSeparator() + System.lineSeparator() + "Menu." + System.lineSeparator() +
                        "0. === Find items by name ===" + System.lineSeparator() + "1. === Exit ===" + System.lineSeparator())
        );
    }

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

        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === All items ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() + item0.toString() + System.lineSeparator() +
                        item1.toString() + System.lineSeparator() + "All items showed." + System.lineSeparator() +
                        "=============================" + System.lineSeparator() + System.lineSeparator() +
                        System.lineSeparator() + System.lineSeparator() + "Menu." + System.lineSeparator() +
                        "0. === All items ===" + System.lineSeparator() + "1. === Exit ===" + System.lineSeparator())
        );
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Exit ===" + System.lineSeparator()
        ));
    }
}