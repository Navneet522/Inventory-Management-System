
package Server;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class mySqlConnection {
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String consyn = "jdbc:mysql://localhost/databaseinventory";
            Connection con = (Connection) DriverManager.getConnection(consyn, "root", "password");
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(mySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
