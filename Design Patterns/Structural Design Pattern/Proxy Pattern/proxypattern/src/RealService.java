package proxypattern.src;

public class RealService implements Service{
    @Override
    public void doWork() {
        System.out.println("RealService: Working...");
    }
}
