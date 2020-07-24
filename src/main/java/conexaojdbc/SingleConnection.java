package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
    private static String url = "jdbc:postgresql://localhost:5432/posjava";
    private static String user = "postgres";
    private static String password = "lililalalulu";
    private static Connection connection = null;

    private static void connectar() {
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
                System.out.println("***** conectamos *****");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    };

    static {
        connectar();
    }

    public SingleConnection() {
        connectar();
    }

    public static Connection getConnection() {
        return connection;
    }

//    public static void setConnection(Connection connection) {
//        SingleConnection.connection = connection;
//    }

}
