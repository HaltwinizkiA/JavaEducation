package learning.data.base;

import java.sql.DriverManager;

public class Connection {
    private final String username;
    private final String password;
    private final String url;
    private java.sql.Connection conn;

    public Connection(String username, String password) {
        this.username = username;
        this.password = password;
        this.url = "jdbc:mysql://127.0.0.1:3306/app?characterEncoding=latin1&useConfigs=maxPerformance";
        conn = null;
    }

    java.sql.Connection connect() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connect successful");

            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }


    }

    void closeConnect() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
