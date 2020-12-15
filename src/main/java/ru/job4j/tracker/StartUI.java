package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select;
            select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                int id = 1;
                System.out.println(System.lineSeparator() + "=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(id, name);
                tracker.add(item);
                System.out.println("Item successful created." + System.lineSeparator() + "=============================" + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
                id += 1;
            } else if (select == 1) {
                System.out.println(System.lineSeparator() + "=== All items ===");
                System.out.println(Arrays.toString(tracker.findAll()));
                System.out.println("All items showed." + System.lineSeparator() + "=============================" + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
            } else if (select == 2) {
                System.out.println(System.lineSeparator() + "=== Edit item ===");
                System.out.print("Item id: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Item: " + tracker.findById(id).toString());
                System.out.print("New item name: ");
                String newName = scanner.nextLine();
                Item item = new Item(id, newName);
                tracker.replace(id, item);
                System.out.println("Item was successful edited." + System.lineSeparator() + "=============================" + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
            } else if (select == 3) {
                System.out.println(System.lineSeparator() + "=== Delete item ===");
                System.out.print("Item id: ");
                int id = Integer.valueOf(scanner.nextLine());
                tracker.delete(id);
                System.out.println("Item was deleted." + System.lineSeparator() + "=============================" + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
            } else if (select == 4) {
                System.out.println(System.lineSeparator() + "=== Find item by Id ===");
                System.out.print("Enter item id: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Result = " + tracker.findById(id).toString() + System.lineSeparator() + "=============================" + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
            } else if (select == 5) {
                System.out.println(System.lineSeparator() + "=== Find items by name ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Result = " + tracker.findByName(name).toString() + System.lineSeparator() + "=============================" + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(formatter));
    }
}