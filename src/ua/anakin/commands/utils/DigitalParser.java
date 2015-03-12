package ua.anakin.commands.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitalParser {

    //number is an integer that should be equal or greater to 1
    static final String INTEGER_PATTERN = "[1-9][0-9]*";

    //number is a decimal value that should be equal or greater to 1
    static final String DOUBLE_PATTERN = "[1-9][0-9]*(\\.[0-9]+)?";

    public boolean isInteger(String string) {
        Pattern pattern = Pattern.compile(INTEGER_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public boolean isDouble(String string) {
        Pattern pattern = Pattern.compile(DOUBLE_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public int parse(String string) {
        return Integer.parseInt(string);
    }

    public boolean isBetValid(String string) {
        if (isInteger(string)) {
            return true;
        }
        else {
            System.out.println("Invalid Bet: " + string);
            return false;
        }
    }


}
