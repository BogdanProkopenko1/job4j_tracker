package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item successful created." + System.lineSeparator() + "============================="
                + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== All items ===");
        Item[] out = tracker.findAll();
        for (Item item : out) {
            System.out.println(item);
        }
        System.out.println("All items showed." + System.lineSeparator() + "============================="
                + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Edit item ===");
        int id = input.askInt("Item id: ");
        String newName = input.askStr("New item name: ");
        Item item = new Item(id, newName);
        if (tracker.replace(id, item)) {
            System.out.println("Item was successful edited.");
        } else {
            System.out.println("ERROR. Item not found.");
        }
        System.out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Delete item ===");
        int id = input.askInt("Item id: ");
        if (tracker.delete(id)) {
            System.out.println("Item was deleted!");
        } else {
            System.out.println("ERROR. Item not found.");
        }
        System.out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
    }

    public static void itemById(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Find item by Id ===");
        int id = input.askInt("Enter item id: ");
        Item rsl = tracker.findById(id);
        if (rsl != null) {
            System.out.println("Result = " + rsl.toString());
        } else {
            System.out.println("Item not found.");
        }
        System.out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
    }

    public static void itemsByName(Input input, Tracker tracker) {
        System.out.println(System.lineSeparator() + "=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length != 0) {
            System.out.println("Result: ");
            for (Item item : rsl) {
                System.out.println(item);
            }
        } else {
            System.out.println("Item(s) not found.");
        }
        System.out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.itemById(input, tracker);
            } else if (select == 5) {
               StartUI.itemsByName(input, tracker);
            } else if (select == 6) {
                System.out.println(System.lineSeparator() + "Program is closed.");
                run = false;
            } else {
                System.out.println(System.lineSeparator() + "Invalid request! Try again." + System.lineSeparator());
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
        System.out.print("Select: ");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(formatter));
    }
}