package ua.anakin;

import ua.anakin.commands.AbstractCommand;
import ua.anakin.handler.InputHandler;
import ua.anakin.selectors.AbstractCommandSelector;
import ua.anakin.selectors.CommandSelector;
import ua.anakin.context.GameContext;

public class Game {

    private GameContext context;
    private AbstractCommandSelector selector;
    private InputHandler handler;

    public Game() {
        this.context = new GameContext();
        this.selector = new CommandSelector(context);
        this.handler = new InputHandler();
    }

    public void run() {
        AbstractCommand command;
        String[] strings;
        while (context.isContinueGame()) {
            context.getWorker().displayContext();
            strings = handler.getUserInput();
            command = selector.selectCommand(strings);
            command.execute(context, strings);
        }
    }
}

