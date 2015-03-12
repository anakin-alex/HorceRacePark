package ua.anakin.selectors;

import ua.anakin.commands.AbstractCommand;

public abstract class AbstractCommandSelector {

    public abstract AbstractCommand selectCommand(String[] strings);

}
