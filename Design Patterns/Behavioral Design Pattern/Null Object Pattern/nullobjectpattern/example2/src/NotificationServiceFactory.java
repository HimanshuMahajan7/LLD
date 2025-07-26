package nullobjectpattern.example2.src;

public class NotificationServiceFactory {
    public static NotificationService getNotificationService(User user, String serviceType) {
        if (user == null) {
            return new NullNotification();
        }
        return switch (serviceType) {
            case "Email" -> new EmailNotification();
            case "Message" -> new MessageNotification();
            default -> new NullNotification();
        };
    }
}
