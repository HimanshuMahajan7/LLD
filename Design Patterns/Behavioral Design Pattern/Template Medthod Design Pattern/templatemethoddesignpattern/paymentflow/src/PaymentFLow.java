package templatemethoddesignpattern.paymentflow.src;

public abstract class PaymentFLow {
    abstract void validateRequest();
    abstract void calculateFee();
    abstract void debitAmount();
    abstract void creditAmount();

    public final void sendMoney() {
        // Step 1
        validateRequest();

        // Step 2
        calculateFee();

        // Step 3
        debitAmount();

        // Step 4
        creditAmount();
    }
}
