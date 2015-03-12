package ua.anakin.commands;

import ua.anakin.context.GameContext;

public abstract class AbstractCommand {

    private int numberOfWordsInCommand;
    private String pattern;

    public abstract boolean isMatch(String[] words);

    public abstract void execute(GameContext context, String[] strings);

    public int getNumberOfWordsInCommand() {
        return numberOfWordsInCommand;
    }

    public void setNumberOfWordsInCommand(int numberOfWordsInCommand) {
        this.numberOfWordsInCommand = numberOfWordsInCommand;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int firstString() {
        return 0;
    }

    public int secondString() {
        return 1;
    }
}
