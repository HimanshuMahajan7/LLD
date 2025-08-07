package atmmachine.src.withdrawal;

import atmmachine.src.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor {

    public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 100;
        int balance = remainingAmount % 100;

        if (requiredNotes <= atm.getNoOfOneHundredNotes()) {
            atm.deductFiveHundredNotes(requiredNotes);
        } else if (requiredNotes > atm.getNoOfOneHundredNotes()) {
            atm.deductFiveHundredNotes(atm.getNoOfOneHundredNotes());
            balance = balance + (requiredNotes - atm.getNoOfOneHundredNotes()) * 100;
        }

        if(balance != 0) {
            System.out.println("Something went wrong!!!");
        }
    }
}
