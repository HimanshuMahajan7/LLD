package vendingmachine.src.state.impl;

import vendingmachine.src.Coin;
import vendingmachine.src.Item;
import vendingmachine.src.VendingMachine;
import vendingmachine.src.state.State;

import java.util.List;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Currently Vending Machine is in Selection State");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You can not press InsertCoinButton in SelectionState");
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You can not insert coin in SelectionState");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception {
        //1. Get the item with productCode
        Item item = vendingMachine.getInventory().getItem(productCode);

        //2. Total amount paid by user
        int paidByUser = 0;
        for (Coin coin: vendingMachine.getCoins()) {
            paidByUser += coin.value;
        }

        //3. Compare product price and amount paid by user
        if (paidByUser < item.getPrice()) {
            System.out.println("Insufficient amount, Product you selected is for price: " + item.getPrice() + ", and you paid: " + paidByUser);
            refundFullMoney(vendingMachine);
            throw new Exception("Insufficient Amount");
        } else if (paidByUser >= item.getPrice()) {
            if (paidByUser > item.getPrice()) {
                getChange(paidByUser - item.getPrice());
            }
            vendingMachine.setVendingMachineState(new DispenceState(vendingMachine, productCode));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        //actual logic should be to return COINs in the dispense tray, but for simplicity i am just returning the amount to be refunded
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
        return returnChangeMoney;

    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine, int productCode) throws Exception {
        throw new Exception("Item can not be dispensed in Selection State");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount in coin dispense tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoins();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int productCode) throws Exception {
        throw new Exception("Inventory can not be updated in Selection State");
    }
}
