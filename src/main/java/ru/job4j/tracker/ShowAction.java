package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public class ShowAction implements UserAction {

    private final Output output;

    public ShowAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "=== All items ===";
    }

    @Override
    public boolean execute(Store store, Input input) throws SQLException {
        List<Item> rsl = store.findAll();
        for (Item item : rsl) {
            output.println(item);
        }
        output.println("All items showed." + System.lineSeparator()
                + "============================="
                + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}