package templatemethoddesignpattern.paymentflow.src;

public class PayToMerchantFlow extends PaymentFLow {
    @Override
    void validateRequest() {
        System.out.println("Validate logic of PayToMerchant");
    }

    @Override
    void calculateFee() {
        System.out.println("2% Feed Charged");
    }

    @Override
    void debitAmount() {
        System.out.println("Debit the amount logic of PayToMerchant");
    }

    @Override
    void creditAmount() {
        System.out.println("Credit the remaining amount");
    }
}
