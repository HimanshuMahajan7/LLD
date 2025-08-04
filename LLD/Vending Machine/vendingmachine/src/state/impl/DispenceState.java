package vendingmachine.src.state.impl;

import vendingmachine.src.Coin;
import vendingmachine.src.Item;
import vendingmachine.src.VendingMachine;
import vendingmachine.src.state.State;

import java.util.List;

public class DispenceState implements State {

    public DispenceState(VendingMachine vendingMachine, int productCode) throws Exception {
        System.out.println("Currently Vending Machine is DispenseState");
        dispenseItem(vendingMachine, productCode);
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("InsertCoinButton can not be clicked in DispenseState");
    }

    @Override
    public void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("ProductSelectButton can not clicked on DispenseState");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Coin can not be inserted in DispenseState");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception {
        throw new Exception("Product can not be chosen in DispenseState");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Change can not be returned in DispenseState");
    }

    @Override
    public Item dispenseItem(VendingMachine vendingMachine, int productCode) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = vendingMachine.getInventory().getItem(productCode);
        vendingMachine.getInventory().updateSoldOutItem(productCode);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Refund can not be happen in DispenseState");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int productCode) throws Exception {
        throw new Exception("Inventory can not be updated in DispenseState");
    }
}
