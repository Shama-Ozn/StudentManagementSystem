package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            
            String url = "jdbc:mysql://localhost:3306/School";
            String username = "SYSDBA";
            String password = "sitd2023";//failed because of had sidi molay password li lmfrod s7i7 walk nsito

            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }
}

