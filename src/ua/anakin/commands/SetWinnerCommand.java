package ua.anakin.commands;


import ua.anakin.context.GameContext;

public class SetWinnerCommand extends CommandWithParameter {

    public SetWinnerCommand() {
        this.setPattern("w");
    }

    @Override
    public void execute(GameContext context, String[] strings) {
        if (isHorseNumberCorrect(context)) {
            context.setHorseWinnerNumber(getUserHorseNumber());
        }
    }

    @Override
    public boolean isMatch(String[] strings) {
        if (super.isMatch(strings)&& strings[firstString()].equals(getPattern())
                && parser.isInteger(strings[secondString()])) {
            setUserHorseNumber(parser.parse(strings[secondString()]));
            return true;
        }
        return false;
    }

}
