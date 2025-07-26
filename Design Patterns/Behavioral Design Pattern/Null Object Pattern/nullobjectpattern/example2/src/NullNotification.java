package nullobjectpattern.example2.src;

public class NullNotification implements NotificationService{
    @Override
    public void send(String message) {
        // do nothing
        System.out.println("No notification sent");
    }
}
