package ua.anakin.context.utils;

import ua.anakin.context.GameContext;
import ua.anakin.model.Horse;

import java.util.Map;

public class ContextWorker {

    private GameContext context;

    public ContextWorker(GameContext context) {
        this.context = context;
    }

    public void displayContext(){
        System.out.println("Inventory:");
        for(Map.Entry<?, ?> entry : context.getInventoryBills().entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
        System.out.println("Horses:");
        for(Map.Entry<Integer, Horse> entry : context.getHorses().entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue() +
            "," + wonOrLost(entry.getKey()));
        }
    }

    public boolean isUserGuess(int number) {
        if (context.getHorseWinnerNumber() == number) {
            return true;
        }
        else {
            System.out.println("No Payout: " + context.getHorses().get(number).getName());
            return false;
        }
    }

    public String wonOrLost(int number) {
        return number == context.getHorseWinnerNumber() ? "won" : "lost";
    }

}
