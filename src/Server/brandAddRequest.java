
package Server;
import Server.GUI.brandSwingUI;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class brandAddRequest {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private String productName;
    private String brandName;
    
    public brandAddRequest() {
        brandSwingUI obj = new brandSwingUI();
        //since getProductName() is not static so we have to create the object
        this.productName = obj.getProductName(); 
        this.brandName = obj.getBrandName();
        
        System.out.println("Product Name = "+productName);
        System.out.println("Brand Name = "+brandName);
        try {
            Connection con = mySqlConnection.getConnection();
            
            String syntax = "SELECT * FROM brandinfo WHERE productName = ? and brandName = ?";
            pst = (PreparedStatement) con.prepareStatement(syntax);
            pst.setString(1, productName);
            pst.setString(2, brandName);
            rs = pst.executeQuery();
            
            if(rs.next()) {
                System.out.println("Product Name "+productName);
                System.out.println("Brand Name = "+brandName);
                String warning = "Already same product name and brand name exist so plz edit them";
                JOptionPane.showMessageDialog(null, warning, "Inane warning", JOptionPane.WARNING_MESSAGE);
            }
            else {
                new brandAdd();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(brandAddRequest.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
