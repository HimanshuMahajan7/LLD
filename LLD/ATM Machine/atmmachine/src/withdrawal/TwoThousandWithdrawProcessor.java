package atmmachine.src.withdrawal;

import atmmachine.src.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor {

    public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {
        int requiredNotes = remainingAmount / 2000;
        int balance = remainingAmount % 2000;

        if (requiredNotes <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(requiredNotes);
        } else if (requiredNotes > atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance + (requiredNotes - atm.getNoOfTwoThousandNotes()) * 2000;
        }

        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
