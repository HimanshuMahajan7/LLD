package atmmachine.src;

public class Card {

    private static final int PIN_NUMBER = 123456;
    int cardNumber;
    int cvv;
    int expiryDate;
    int holderName;
    UserBankAccount bankAccount;

    public boolean isCorrectPINEntered(int pin) {
        return pin == PIN_NUMBER;
    }

    public int getBankBalance() {
        return bankAccount.balance;
    }

    public void deductBankBalance(int amount) {
        bankAccount.withdrawalBalance(amount);
    }

    public void setBankAccount(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
