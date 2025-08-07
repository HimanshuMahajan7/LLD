package atmmachine.src.withdrawal;

import atmmachine.src.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor {

    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 500;
        int balance = remainingAmount % 500;

        if (requiredNotes <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(requiredNotes);
        } else if (requiredNotes > atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + (requiredNotes - atm.getNoOfFiveHundredNotes()) * 500;
        }

        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
