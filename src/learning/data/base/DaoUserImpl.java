package learning.data.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DaoUserImpl implements Dao {
    Connection conn;

    public DaoUserImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public User create(User user) {

        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO user (login,password) VALUES(?,?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return read(user.getLogin(), user.getPassword());
    }

    @Override
    public User read(String name, String pass) {
        String rsName = "";
        String rsPass = "";
        int id = 0;
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM user");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                rsName = resultSet.getString("login");
                rsPass = resultSet.getString("password");
                id = resultSet.getInt("id");
                if (name.equals(rsName) & pass.equals(rsPass)) {
                    System.out.println("----------------------------");
                    System.out.println(name);
                    System.out.println(pass);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new User(rsName, rsPass, id);
    }

    @Override
    public User update(String name, User upUser) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE users SET login=?,password=? WHERE id=?");
            statement.setString(1, name);
            statement.setString(2, upUser.getPassword());
            statement.setInt(3, upUser.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new User(name, upUser.getPassword(), upUser.getId());
    }

    @Override
    public boolean delete(String name, String password) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM user WHERE login=? AND password=?");
            statement.setString(1, name);
            statement.setString(2, password);
            statement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<User> readAll() {
        List<User> userList = new LinkedList<User>();
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM user");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getString("login"), resultSet.getString("password"), resultSet.getInt("id"));
                userList.add(user.clone());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
