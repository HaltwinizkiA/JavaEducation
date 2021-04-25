package learning.data.base;

import java.util.List;

public interface Dao {
    User create(User user);
    User read(String name, String pass);
    User update(String name, User newUser);
    boolean delete(String name,String password);
    List<User> readAll();

}
