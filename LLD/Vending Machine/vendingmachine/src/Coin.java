package vendingmachine.src;

public enum Coin {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);

    public int value;

    Coin(int value) {
        this.value = value;
    }
}
