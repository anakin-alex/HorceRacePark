package ua.anakin.commands;

public abstract class CommandWithoutParameter extends AbstractCommand {

    public CommandWithoutParameter() {
        setNumberOfWordsInCommand(1);
    }

    @Override
    public boolean isMatch(String[] strings) {
        return strings.length == getNumberOfWordsInCommand();
    }

}
