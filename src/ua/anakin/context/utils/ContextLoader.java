package ua.anakin.context.utils;


import ua.anakin.commands.*;
import ua.anakin.model.Bill;
import ua.anakin.model.Horse;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


public class ContextLoader {

    private int[] billDenominations = new int[] {1, 5, 10, 20, 100};
    private int[] billsAmount = new int[] {10, 10, 10, 10, 10};
    private String[] horseNames = new String[] {"That Darn Gray Cat", "Fort Utopia",
            "Count Sheep", "Ms Traitour", "Real Princess", "Pa Kettle", "Gin Stinger"};
    private int[] odds = new int[] {5, 10, 9, 4, 3, 5, 6};

    public TreeMap<Integer, Horse> loadHorses() {

        return new TreeMap<Integer, Horse>() {{

            for (int i = 0; i < horseNames.length; i++) {
                put(i + 1, new Horse(horseNames[i], odds[i]));
            }
        }};

    }

    public TreeMap<Bill, Integer> loadInventory() {

        return new TreeMap<Bill, Integer>() {{
            for (int i = 0; i < billDenominations.length; i++) {
                    put(new Bill(billDenominations[i]), billsAmount[i]);
            }
        }};
    }

    public List<AbstractCommand> loadCommands() {

        return new LinkedList<AbstractCommand>() {{
                add(new InvalidCommand()); //should be added primarily to locate in the tail of the list
                add(new QuitCommand());
                add(new RestockInventoryCommand());
                add(new SetWinnerCommand());
                add(new TakeBetCommand());
        }};
    }
}
