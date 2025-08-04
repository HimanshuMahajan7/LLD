package vendingmachine.src.state.impl;

import vendingmachine.src.Coin;
import vendingmachine.src.Item;
import vendingmachine.src.VendingMachine;
import vendingmachine.src.state.State;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Currently Vending Machine is in IdleState");
    }

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Currently Vending Machine is in IdleState");
        vendingMachine.setCoins(new ArrayList<>());
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("First you need to click on insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You can not insert Coin in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception {
        throw new Exception("You can not choose product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can not get change in idle state");
    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine, int productCode) throws Exception {
        throw new Exception("Product can not be dispensed in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        return List.of();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int productCode) throws Exception {
        vendingMachine.getInventory().addItem(item, productCode);
    }
}
