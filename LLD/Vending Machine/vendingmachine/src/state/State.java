package vendingmachine.src.state;

import vendingmachine.src.Coin;
import vendingmachine.src.Item;
import vendingmachine.src.VendingMachine;

import java.util.List;

public interface State {

    void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception;

    void pressProductSelectionButton(VendingMachine vendingMachine) throws Exception;

    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;

    void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception;

    int getChange(int returnChangeMoney) throws Exception;

    Item dispenseItem(VendingMachine vendingMachine, int productCode) throws Exception;

    List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;

    void updateInventory(VendingMachine vendingMachine, Item item, int productCode) throws Exception;
}
