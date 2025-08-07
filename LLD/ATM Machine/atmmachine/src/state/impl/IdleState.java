package atmmachine.src.state.impl;

import atmmachine.src.ATM;
import atmmachine.src.Card;
import atmmachine.src.state.State;

public class IdleState implements State {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentState(new HasCardState());
    }
}
