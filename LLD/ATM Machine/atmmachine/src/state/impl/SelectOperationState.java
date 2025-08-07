package atmmachine.src.state.impl;

import atmmachine.src.ATM;
import atmmachine.src.Card;
import atmmachine.src.TransactionType;
import atmmachine.src.state.State;

public class SelectOperationState implements State {

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        switch (txnType) {
            case CASH_WITHDRAWAL -> atm.setCurrentState(new CashWithdrawalState());
            case BALANCE_CHECK -> atm.setCurrentState(new CheckBalanceState());
            default -> {
                System.out.println("Invalid Option");
                exit(atm);
            }
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentState(new IdleState());
        System.out.println("Exit Happened");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

    private void showOperations() {
        System.out.println("Please select the Operations");
        TransactionType.showAllTransactionTypes();
    }
}
