package ua.anakin.selectors;

import ua.anakin.commands.AbstractCommand;
import ua.anakin.context.GameContext;

import java.util.List;

public class CommandSelector extends AbstractCommandSelector {

    private AbstractCommand command;
    private List<AbstractCommand> commands;

    public CommandSelector(GameContext context) {
        this.commands = context.getCommands();
    }

    public AbstractCommand selectCommand(String[] strings) {
        for(AbstractCommand command : commands) {
            if (command.isMatch(strings)) {
                this.command = command;
            }
        }
        return command;
    }

}
