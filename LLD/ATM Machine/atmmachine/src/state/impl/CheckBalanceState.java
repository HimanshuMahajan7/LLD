package atmmachine.src.state.impl;

import atmmachine.src.ATM;
import atmmachine.src.Card;
import atmmachine.src.state.State;

public class CheckBalanceState implements State {

    public CheckBalanceState() {
        System.out.println("Checking Balance");
    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your balance is: " + card.getBankBalance());
        exit(atm);
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
}
