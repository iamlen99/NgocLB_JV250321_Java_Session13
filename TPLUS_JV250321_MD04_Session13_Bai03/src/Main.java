import entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", "alice@example.com"),
                new User ("Bob", "bob@example.com"),
                new User("Charlie", "charlie@example.com")
        );

        Optional<User> userOptional = findUserByUsername (users, "bob");

        if (userOptional.isPresent()) {
            System.out.println("Nguoi dung tim thay: " + userOptional.get());
        } else {
            System.out.println("Khong tim thay nguoi dung");
        }

        User defaultUser = userOptional.orElse(new User("default", "default@example.com"));
        System.out.println("Nguoi dung mac dinh neu khong tim thay: " + defaultUser);

        userOptional.ifPresent(user -> System.out.println("Email cua nguoi dung: " + user.getEmail()));
    }

    public static Optional<User> findUserByUsername (List<User> users, String username) {
        for (User user : users) {
            if (user.getUsername().toLowerCase().contains(username.trim().toLowerCase())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
