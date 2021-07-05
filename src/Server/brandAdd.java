
package Server;
import Server.GUI.brandSwingUI;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class brandAdd {
    PreparedStatement pst;
    ResultSet rs;
    private String productName;
    private String brandName;
    private int price;
    private int quantity;
    
    public brandAdd() {
        brandSwingUI obj = new brandSwingUI();
        productName = obj.getProductName();
        brandName = obj.getBrandName();
        price = Integer.parseInt(obj.getPrice());
        quantity = Integer.parseInt(obj.getQuantity());
        
        try {
            Connection con = mySqlConnection.getConnection();
            
            String syntax = "INSERT INTO brandinfo(productName, brandName, price, quantity) VALUES(?, ?, ?, ?)";
            pst = (PreparedStatement) con.prepareStatement(syntax);
            pst.setString(1, productName);
            pst.setString(2, brandName);
            pst.setInt(3, price);
            pst.setInt(4, quantity);
            
            System.out.println("Product Name "+ productName);
            System.out.println("Brand Name "+ brandName);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Succussfully added the product and brand");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
    }
}
