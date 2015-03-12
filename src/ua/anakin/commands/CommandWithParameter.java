package ua.anakin.commands;

import ua.anakin.commands.utils.DigitalParser;
import ua.anakin.context.GameContext;

public abstract class CommandWithParameter extends AbstractCommand{

    DigitalParser parser;

    public CommandWithParameter() {
        setNumberOfWordsInCommand(2);
        this.parser = new DigitalParser();
    }

    private int userHorseNumber;

    @Override
    public boolean isMatch(String[] strings) {
        return strings.length == getNumberOfWordsInCommand();
    }

    public boolean isHorseNumberCorrect(GameContext context) {
        if (userHorseNumber <= context.getHorses().size()) {
            return true;
        }
        else {
            System.out.println("Invalid Horse Number: " + userHorseNumber);
            return false;
        }
    }

    public int getUserHorseNumber() {
        return userHorseNumber;
    }

    public void setUserHorseNumber(int userHorseNumber) {
        this.userHorseNumber = userHorseNumber;
    }
}
