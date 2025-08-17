package singleton;

public enum EnumSingleton {
    INSTANCE;  // single instance

    public void showMessage() {
        System.out.println("Hello from Enum Singleton!");
    }
}
