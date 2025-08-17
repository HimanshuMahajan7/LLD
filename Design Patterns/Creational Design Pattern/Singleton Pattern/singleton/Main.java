package singleton;

public class Main {
    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        LazySingleton lazySingleton = LazySingleton.getInstance();
        SynchronizedMethodSingleton synchronizedMethodSingleton = SynchronizedMethodSingleton.getInstance();
        DoubleCheckedLockingSingleton doubleCheckedLockingSingleton = DoubleCheckedLockingSingleton.getInstance();
        BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;

        eagerSingleton.showMessage();
        lazySingleton.showMessage();
        synchronizedMethodSingleton.showMessage();
        doubleCheckedLockingSingleton.showMessage();
        billPughSingleton.showMessage();
        enumSingleton.showMessage();
    }
}
