package ua.anakin.context;

import ua.anakin.commands.AbstractCommand;
import ua.anakin.context.utils.ContextLoader;
import ua.anakin.context.utils.ContextWorker;
import ua.anakin.model.Bill;
import ua.anakin.model.Horse;

import java.util.*;

public class GameContext {

    private Map<Integer, Horse> horses;
    private NavigableMap<Bill, Integer> inventoryBills;
    private List<AbstractCommand> commands;
    private ContextLoader loader;
    private boolean continueGame = true;
    private int horseWinnerNumber = 1;
    private ContextWorker worker;

    public GameContext() {
        this.loader = new ContextLoader();
        this.horses = loader.loadHorses();
        this.inventoryBills = loader.loadInventory();
        this.commands = loader.loadCommands();
        this.worker = new ContextWorker(this);
    }

    public boolean isContinueGame() {
        return continueGame;
    }

    public void setContinueGame(boolean continueGame) {
        this.continueGame = continueGame;
    }

    public void setHorseWinnerNumber(int horseWinnerNumber) {
        this.horseWinnerNumber = horseWinnerNumber;
    }

    public void setInventoryBills(NavigableMap<Bill, Integer> inventoryBills) {
        this.inventoryBills = inventoryBills;
    }

    public ContextLoader getLoader() {
        return loader;
    }

    public List<AbstractCommand> getCommands() {
        return commands;
    }

    public NavigableMap<Bill, Integer> getInventoryBills() {
        return inventoryBills;
    }

    public Map<Integer, Horse> getHorses() {
        return horses;
    }

    public int getHorseWinnerNumber() {
        return horseWinnerNumber;
    }

    public ContextWorker getWorker() {
        return worker;
    }
}
