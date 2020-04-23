import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        String urlConnection = "jdbc:mysql://localhost/dio_jdbc";
        Connection con = null;

        try {
            con = DriverManager.getConnection(urlConnection, "root", "1234");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}
