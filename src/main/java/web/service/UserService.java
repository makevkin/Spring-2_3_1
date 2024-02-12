package web.service;
import java.util.List;
import web.model.User;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();

    void deleteUser(int id);

    User getUserId(int id);

}
