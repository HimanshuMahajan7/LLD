package atmmachine.src.state.impl;

import atmmachine.src.ATM;
import atmmachine.src.Card;
import atmmachine.src.state.State;
import atmmachine.src.withdrawal.CashWithdrawProcessor;
import atmmachine.src.withdrawal.FiveHundredWithdrawProcessor;
import atmmachine.src.withdrawal.OneHundredWithdrawProcessor;
import atmmachine.src.withdrawal.TwoThousandWithdrawProcessor;

public class CashWithdrawalState implements State {

    CashWithdrawProcessor withdrawProcessor =
            new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));


    public CashWithdrawalState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmountRequest) {
        if (atm.getAtmBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient funds in ATM Machine");
            exit(atm);
        } else if (card.getBankBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient funds in your Bank Account");
            exit(atm);
        } else {
            card.deductBankBalance(withdrawalAmountRequest);
            atm.deductATMBalance(withdrawalAmountRequest);

            withdrawProcessor.withdraw(atm, withdrawalAmountRequest);
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
