package learning.data.base;

public class Builder {

    public void build() {
        try {
            Connection connection = new Connection("root", "root");
            Dao daoUser = new DaoUserImpl(connection.connect());
            daoUser.readAll();
            connection.closeConnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
