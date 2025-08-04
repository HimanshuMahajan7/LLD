package vendingmachine.src;

import vendingmachine.src.state.State;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        try {
            System.out.println("|");
            System.out.println("Filling up the inventory");
            System.out.println("|");

            fillInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("Pressing InsertCoinButton");
            System.out.println("|");

            State vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.pressInsertCoinButton(vendingMachine);

             vendingMachineState = vendingMachine.getVendingMachineState();
             vendingMachineState.insertCoin(vendingMachine, Coin.FIVE);
             vendingMachineState.insertCoin(vendingMachine, Coin.TWENTY);
             vendingMachineState.insertCoin(vendingMachine, Coin.ONE);

            System.out.println("|");
            System.out.println("Press SelectProductButton");
            System.out.println("|");

            vendingMachineState.pressProductSelectionButton(vendingMachine);
            vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        } catch (Exception e) {
            displayInventory(vendingMachine);
        }
    }

    private static void fillInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if (i >= 0 && i < 3) {
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(20);
            } else if (i >= 3 && i < 5) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(50);
            } else if (i >= 5 && i < 7) {
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(40);
            } else if (i >= 7 && i < 10) {
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (ItemShelf slot : slots) {
            System.out.println("CodeNumber: " + slot.getCode() +
                    " Item: " + slot.getItem().getType().name() +
                    " Price: " + slot.getItem().getPrice() +
                    " isAvailable: " + !slot.isSoldOut());
        }
    }
}
