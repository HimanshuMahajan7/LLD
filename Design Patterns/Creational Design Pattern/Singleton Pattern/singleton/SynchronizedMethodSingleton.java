package singleton;

public class SynchronizedMethodSingleton {
    private static volatile SynchronizedMethodSingleton instance;

    private SynchronizedMethodSingleton() {}

    public static SynchronizedMethodSingleton getInstance() {
        if (instance == null) {
            synchronized (SynchronizedMethodSingleton.class) {
                if (instance == null) {
                    instance = new SynchronizedMethodSingleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from SynchronizedMethod Singleton!");
    }
}
