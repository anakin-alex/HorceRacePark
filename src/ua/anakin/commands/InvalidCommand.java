package ua.anakin.commands;

import ua.anakin.context.GameContext;

public class InvalidCommand extends AbstractCommand {

    @Override
    public void execute(GameContext context, String[] strings) {
        System.out.print("Invalid Command:");
        for (String string : strings) {
            System.out.print(" " + string);
        }
        System.out.println();
    }

    @Override
    public boolean isMatch(String[] words) {
        return true; //this command is used if other commands' patterns are not matched
    }

}
