package atmmachine.src;

public class MainATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
        MainATMRoom atmRoom = new MainATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getCurrentState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentState().authenticatePin(atmRoom.atm, atmRoom.user.card, 123456);
        atmRoom.atm.getCurrentState().selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, 2700);
        atmRoom.atm.printCurrentATMStatus();

        atmRoom.atm.getCurrentState().insertCard(atmRoom.atm, atmRoom.user.card);
        atmRoom.atm.getCurrentState().authenticatePin(atmRoom.atm, atmRoom.user.card, 123456);
        atmRoom.atm.getCurrentState().selectOperation(atmRoom.atm, atmRoom.user.card, TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentState().cashWithdrawal(atmRoom.atm, atmRoom.user.card, 5000);
        atmRoom.atm.printCurrentATMStatus();

    }

    private void initialize() {

        // Create an ATM
        atm = ATM.getATMObject();
        atm.setAtmBalance(10000, 5, 6, 20);

        // Create User
        this.user = createUser();
    }

    private User createUser(){
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount() {
        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.balance = 15000;

        return bankAccount;
    }

}
