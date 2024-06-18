
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {

    public Connection getConnectDB() {
      
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/uc11",
                    "root",
                    "Wanderfelipe135$"
            );
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao Conectar: " + e.getMessage());
            return null;
        }
    }
}

