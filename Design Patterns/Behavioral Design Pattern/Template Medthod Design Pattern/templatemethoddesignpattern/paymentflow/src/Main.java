package templatemethoddesignpattern.paymentflow.src;

public class Main {
    public static void main(String[] args) {
        System.out.println("Paying to Friend:");
        PayToFriendFlow payToFriendFlow = new PayToFriendFlow();
        payToFriendFlow.sendMoney();

        System.out.println("----");

        System.out.println("Paying to Merchant:");
        PayToMerchantFlow payToMerchantFlow = new PayToMerchantFlow();
        payToMerchantFlow.sendMoney();
    }
}
