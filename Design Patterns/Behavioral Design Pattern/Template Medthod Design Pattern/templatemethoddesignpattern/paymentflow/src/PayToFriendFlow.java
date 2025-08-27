package templatemethoddesignpattern.paymentflow.src;

public class PayToFriendFlow extends PaymentFLow {
    @Override
    void validateRequest() {
        System.out.println("Validate logic of PayToFriend");
    }

    @Override
    void calculateFee() {
        System.out.println("0% Feed Charged");
    }

    @Override
    void debitAmount() {
        System.out.println("Debit the amount logic of PayToFriend");
    }

    @Override
    void creditAmount() {
        System.out.println("Credit the full amount");
    }
}
