package splitwise.src.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserController {
    List<User> users;

    public UserController() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String userId) {
        Optional<User> user = users.stream().filter(usr -> usr.getUserId().equals(userId)).findFirst();
        return user.orElse(null);
    }

    public List<User> getUsers() {
        return users;
    }
}
