package vendingmachine.src.state.impl;

import vendingmachine.src.Coin;
import vendingmachine.src.Item;
import vendingmachine.src.VendingMachine;
import vendingmachine.src.state.State;

import java.util.List;

public class HasMoneyState implements State {

    public HasMoneyState() {
        System.out.println("Currently Vending Machine is in HasMoneyState");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        vendingMachine.getCoins().add(coin);
        System.out.println("Accepted the coin: " + coin.value);
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception {
        throw new Exception("You need to press Select Product");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can not get change in has money state");
    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine, int productCode) throws Exception {
        throw new Exception("Product can not be dispensed in has money state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoins();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int productCode) throws Exception {
        throw new Exception("You can not update inventory in has money state");
    }
}
