package vendingmachine.src;

public class Inventory {

    ItemShelf[] inventory;

    Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initialEmptyInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    private void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < inventory.length; i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            inventory[i] = space;
            startCode++;
        }
    }

    public void addItem(Item item, int itemCode) throws Exception {
        for(ItemShelf itemShelf: inventory) {
            if (itemShelf.code == itemCode) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("Item already present, you can not add item here");
                }
            }
        }
    }

    public Item getItem(int itemCode) throws Exception {
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode() == itemCode) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("Item already sold out");
                } else {
                    return itemShelf.item;
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int itemCode) {
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode() == itemCode) {
                itemShelf.setSoldOut(true);
            }
        }
    }
}
