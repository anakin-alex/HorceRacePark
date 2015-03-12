package ua.anakin.model;

public class Horse {

    private String name;
    private int odds;

    public Horse(String name, int odds) {
        this.name = name;
        this.odds = odds;
    }

    public String getName() {
        return name;
    }

    public int getOdds() {
        return odds;
    }

    @Override
    public String toString() {
        return name + "," + odds;
    }
}
