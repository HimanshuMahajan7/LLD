package atmmachine.src;

import atmmachine.src.state.State;
import atmmachine.src.state.impl.IdleState;

public class ATM {

    private static final ATM atm = new ATM();

    private State currentState;

    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    private ATM() { }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public static ATM getATMObject() {
        atm.setCurrentState(new IdleState());
        return atm;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductTwoThousandNotes(int noOfTwoThousandNotes) {
        this.noOfTwoThousandNotes = this.noOfTwoThousandNotes - noOfTwoThousandNotes;
    }

    public void deductFiveHundredNotes(int noOfFiveHundredNotes) {
        this.noOfFiveHundredNotes = this.noOfFiveHundredNotes - noOfFiveHundredNotes;
    }

    public void deductOneHundredNotes(int noOfOneHundredNotes) {
        this.noOfOneHundredNotes = this.noOfOneHundredNotes - noOfOneHundredNotes;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);
    }

}
