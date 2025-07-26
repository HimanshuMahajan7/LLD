package nullobjectpattern.example2.src;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.name = "Himanshu";
        NotificationService notificationService = NotificationServiceFactory.getNotificationService(user, "Email");
        notificationService.send("Mail");

        User noUser = null;
        NotificationService noNotificationService = NotificationServiceFactory.getNotificationService(noUser, "Email");
        noNotificationService.send("Mail");
    }
}
