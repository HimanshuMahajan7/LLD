package singleton;

public class BillPughSingleton {
    private BillPughSingleton() {}

    private static class Helper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return Helper.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Hello from Bill Pugh Singleton!");
    }
}
