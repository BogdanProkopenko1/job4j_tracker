package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Delayed;
import java.util.stream.Collectors;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) throws SQLException {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 - " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(tracker, input);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input validate = new ValidateInput(out, new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            List<UserAction> list = new ArrayList<>();
            list.add(new CreateAction(out));
            list.add(new ReplaceAction(out));
            list.add(new DeleteAction(out));
            list.add(new ShowAction(out));
            list.add(new ShowToNameAction(out));
            list.add(new ShowToIdAction(out));
            list.add(new ExitAction());
            new StartUI(out).init(validate, tracker, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}