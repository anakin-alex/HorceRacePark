package ua.anakin.model;

public class Bill implements Comparable<Bill> {
    private int denomination;

    public Bill(int denomination) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }

    @Override
    public int compareTo(Bill bill) {
        return this.denomination - bill.denomination;
    }

    @Override
    public String toString() {
        return "$" + denomination;
    }
}
