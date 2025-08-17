package singleton;

public class DoubleCheckedLockingWithVolatileSingleton {
    private static volatile DoubleCheckedLockingWithVolatileSingleton instance;

    private DoubleCheckedLockingWithVolatileSingleton() {}

    public static DoubleCheckedLockingWithVolatileSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingWithVolatileSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingWithVolatileSingleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from DoubleCheckedLocking With Volatile Singleton!");
    }
}
