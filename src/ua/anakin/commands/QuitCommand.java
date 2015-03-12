package ua.anakin.commands;


import ua.anakin.context.GameContext;

public class QuitCommand extends CommandWithoutParameter {

    public QuitCommand() {
        this.setPattern("q");
    }

    @Override
    public void execute(GameContext context, String[] strings) {
        System.out.println("Quit program");
        context.setContinueGame(false);
    }

    @Override
    public boolean isMatch(String[] strings) {
        return super.isMatch(strings) && strings[firstString()].equals(getPattern());
    }

}
