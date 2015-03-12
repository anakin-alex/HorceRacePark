package ua.anakin.commands.utils;

import ua.anakin.Game;
import ua.anakin.context.GameContext;
import ua.anakin.model.Bill;

import java.util.*;

public class Dispenser {

    //Dispense bills and print out dispensing
    public void dispenseBills(GameContext context, int bet){

        //storage for bills to dispense
        NavigableMap<Bill, Integer> dispensingBills = new TreeMap<Bill, Integer>();
        //storage for bills in inventory
        NavigableMap<Bill, Integer> inventoryBills = context.getInventoryBills();

        int payout = bet * context.getHorses().get(context.getHorseWinnerNumber()).getOdds();

        //How many cash in ATM
        int inventorySum = 0;
        for(Map.Entry<Bill, Integer> e : inventoryBills.entrySet()) {
            inventorySum += e.getKey().getDenomination() * e.getValue();
        }

        if (payout < inventorySum) { //check that is enough cash in ATM to make payout

            //Select bills in descending order - from largest to smallest
            //and use iterator that can start from given position
            int position = 0;
            ListIterator<Bill> iterator = (new LinkedList<Bill>(inventoryBills.descendingKeySet())).listIterator(position);

            //List for storing all versions of dispensing
            List<NavigableMap<Bill, Integer>> dispensingBillsList = new ArrayList<NavigableMap<Bill, java.lang.Integer>>();

            //Fill list with bills to dispense
            while (iterator.hasNext()) {
                dispensingBillsList.add(calculateDispensingBills(iterator, inventoryBills, payout));
                iterator = (new LinkedList<Bill>(inventoryBills.descendingKeySet())).listIterator(++position);
            }

            //The first version by order is the best version because it has largest denomination
            for (int i = 0; i < dispensingBillsList.size(); i++) {
                if (!dispensingBillsList.get(i).isEmpty()) {
                    dispensingBills = dispensingBillsList.get(i);
                    break;
                }
            }

            //Check if there is bills to dispense
            if (!dispensingBills.isEmpty()) {

                for(Map.Entry<Bill, Integer> e : inventoryBills.entrySet()) {
                    if (dispensingBills.containsKey(e.getKey())) {
                        //Remove dispensed bills from ATM
                        inventoryBills.put(e.getKey(), inventoryBills.get(e.getKey()) - dispensingBills.get(e.getKey()));
                    }
                }
                System.out.println("Payout: " +
                        context.getHorses().get(context.getHorseWinnerNumber()).getName() + "," + payout);
                System.out.println("Dispensing: ");
                print(dispensingBills);
            }
            else {
                System.out.println("Insufficient Funds: " + payout);
            }
        }
        else {
            System.out.println("Insufficient Funds: " + payout);
        }
    }

    //Calculate bills for dispense
    public NavigableMap<Bill, Integer> calculateDispensingBills(
            Iterator<Bill> iterator, NavigableMap<Bill, Integer> inventoryBills, int payout){

        //storage for bills to dispense
        NavigableMap<Bill, Integer> dispensingBills = new TreeMap<Bill, Integer>();

        //Iterate all denominations
        while (iterator.hasNext()) {

            Bill current = iterator.next();
            //How many bills we can use from current denomination
            int amount = payout / current.getDenomination();

            if (inventoryBills.get(current) - amount >= 0) {
                //Calculate if bills of current denomination are enough in ATM
                payout -= amount * current.getDenomination();
                dispensingBills.put(current, amount);
            }
            else { //Calculate if bills of current denomination are not enough in ATM
                amount = inventoryBills.get(current);
                payout -= amount * current.getDenomination();
                dispensingBills.put(current, amount);
            }
        }

        //Clear storage fo dispense If bills are not enough to make the complete payout
        if (payout > 0) dispensingBills.clear();

        return dispensingBills;
    }

    public void print(Map<?, ?> map) {
        for(Map.Entry<?, ?> e : map.entrySet()) {
            System.out.println(e.getKey() + "," + e.getValue());
        }
    }
}
