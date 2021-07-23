package dia22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    public Connection getConnection() throws SQLException {
        String urlPostgres = System.getenv("urlPostgres");
        String usuario = System.getenv("usuario");
        String senha = System.getenv("senha");

        return DriverManager.getConnection(urlPostgres, usuario, senha);
    }

}
