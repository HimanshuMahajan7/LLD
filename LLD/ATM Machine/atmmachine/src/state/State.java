package atmmachine.src.state;

import atmmachine.src.ATM;
import atmmachine.src.Card;
import atmmachine.src.TransactionType;

public interface State {

    default void insertCard(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    default void authenticatePin(ATM atm, Card card, int pin) {
        System.out.println("OOPS!! Something went wrong");
    }

    default void selectOperation(ATM atm, Card card, TransactionType txnType) {
        System.out.println("OOPS!! Something went wrong");
    }

    default void cashWithdrawal(ATM atm, Card card, int withdrawalAmount) {
        System.out.println("OOPS!! Something went wrong");
    }

    default void displayBalance(ATM atm, Card card) {
        System.out.println("OOPS!! Something went wrong");
    }

    default void returnCard() {
        System.out.println("OOPS!! Something went wrong");
    }

    default void exit(ATM atm) {
        System.out.println("OOPS!! Something went wrong");
    }
}
