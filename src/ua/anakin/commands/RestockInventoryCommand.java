package ua.anakin.commands;


import ua.anakin.context.GameContext;

public class RestockInventoryCommand extends CommandWithoutParameter {

    public RestockInventoryCommand() {
        this.setPattern("r");
    }

    @Override
    public void execute(GameContext context, String[] strings) {
        System.out.println("Restocking Inventory...");
        context.setInventoryBills(context.getLoader().loadInventory());
        System.out.println("Done.");
    }

    @Override
    public boolean isMatch(String[] strings) {
        return super.isMatch(strings) && strings[firstString()].equals(getPattern());
    }
}
