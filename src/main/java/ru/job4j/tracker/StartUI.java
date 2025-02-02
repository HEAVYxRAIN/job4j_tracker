package ru.job4j.tracker;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size()));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        int index = 0;
        for (int i = 0; i < actions.size(); i++) {
            UserAction action = actions.get(i);
            out.println(index + ". " + action.name());
            index++;
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new CreateAction(output),
                new ShowAllAction(output), new EditAction(output),
                new DeleteAction(output), new FindIdAction(output),
                new FindNameAction(output), new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
    }
}