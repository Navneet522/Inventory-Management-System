
package Server;
import Server.GUI.brandSwingUI;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class brandEdit {
    Connection con;
    PreparedStatement pst;
    private String productName;
    private String brandName;
    private int price;
    private int quantity;
    private JTable brandTable;
    private int id;
    
    public brandEdit() {
        brandSwingUI obj = new brandSwingUI();
        //since getBrandName() is not static so we have to create the object
        this.brandTable = obj.getBrandTable();
        
        try {
            Connection con = mySqlConnection.getConnection();
            
            DefaultTableModel model = (DefaultTableModel) brandTable.getModel();
            
            int index = obj.getSelectedRowFromTable();
            System.out.println("index "+index);
            id = Integer.parseInt((String) model.getValueAt(index, 0));
            System.out.println("Id : "+id);
            
            productName = obj.getProductName();
            brandName = obj.getBrandName();
            price = Integer.parseInt(obj.getPrice());
            quantity = Integer.parseInt(obj.getQuantity());
            
            String syntax = "UPDATE brandinfo SET productName = ?, brandName = ?, price = ?, quantity = ? WHERE brandId = ?";
            pst = (PreparedStatement) con.prepareStatement(syntax);
            //first arguments of this pst.setString() is based upon the '?' order
            pst.setString(1, productName);
            pst.setString(2, brandName);
            pst.setInt(3, price);
            pst.setInt(4, quantity);
            pst.setInt(5, id);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Selected Row updated");
            
        } catch (SQLException ex) {
            Logger.getLogger(brandEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
