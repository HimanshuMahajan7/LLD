package atmmachine.src.state.impl;

import atmmachine.src.ATM;
import atmmachine.src.Card;
import atmmachine.src.state.State;

public class HasCardState implements State {

    public HasCardState() {
        System.out.println("Enter your card PIN");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        boolean isCorrectPINEntered = card.isCorrectPINEntered(pin);

        if (isCorrectPINEntered) {
            atm.setCurrentState(new SelectOperationState());
        } else {
            System.out.println("Invalid PIN Entered");
            exit(atm);
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
}
