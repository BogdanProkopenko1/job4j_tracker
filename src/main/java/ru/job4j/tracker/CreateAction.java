package ru.job4j.tracker;

public class CreateAction implements UserAction {

    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create a new item ===";
    }

    @Override
    public boolean execute(Store store, Input input) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        store.add(item);
        out.println("Item successful created." + System.lineSeparator()
                + "============================="
                + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}