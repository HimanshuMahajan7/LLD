package nullobjectpattern.example2.src;

public class MessageNotification implements NotificationService{
    @Override
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}
