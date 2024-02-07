package web.service;
import java.util.List;
import web.model.User;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(int id);

}
