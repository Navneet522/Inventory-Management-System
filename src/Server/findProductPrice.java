
package Server;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class findProductPrice {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private int price = -1, quantity = -1;
    
    public findProductPrice(String product, String brand, String option) {
        String syntax;
        try {
            con = mySqlConnection.getConnection();
            if(option.equals("price")) {
                syntax = "SELECT price FROM brandinfo WHERE productName = ? AND brandName = ?";
            }
            else {
                //since option can have 2 values -> i)price, ii)quantity
                syntax = "SELECT quantity FROM brandinfo WHERE productName = ? AND brandName = ?";
            }
            pst = (PreparedStatement) con.prepareStatement(syntax);
            pst.setString(1, product);
            pst.setString(2, brand);  
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()) {
                if(option.equals("price")) {
                    price = rs.getInt("price");
                }
                else {
                    quantity = rs.getInt("quantity");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(findProductPrice.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
}
