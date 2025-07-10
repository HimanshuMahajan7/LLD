package proxypattern.src;

public class ProxyService implements Service {
    private final RealService realService = new RealService();

    public void doWork() {
        System.out.println("Proxy: Logging before");
        realService.doWork();
        System.out.println("Proxy: Logging after");
    }
}
