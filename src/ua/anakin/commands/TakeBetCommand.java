package ua.anakin.commands;


import ua.anakin.commands.utils.Dispenser;
import ua.anakin.context.GameContext;

public class TakeBetCommand extends CommandWithParameter {

    Dispenser dispenser;

    public TakeBetCommand() {
        this.dispenser = new Dispenser();
    }

    @Override
    public void execute(GameContext context, String[] strings) {
        if (isHorseNumberCorrect(context) && parser.isBetValid(strings[secondString()])
                && context.getWorker().isUserGuess(getUserHorseNumber())) {
            dispenser.dispenseBills(context, parser.parse(strings[secondString()]));
        }
    }

    @Override
    public boolean isMatch(String[] strings) {
        if (super.isMatch(strings) && parser.isInteger(strings[firstString()])
                && parser.isDouble(strings[secondString()])) {
            setUserHorseNumber(parser.parse(strings[firstString()]));
            return true;
        }
        return false;
    }

}
