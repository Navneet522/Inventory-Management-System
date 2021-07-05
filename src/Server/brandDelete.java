
package Server;
import Server.GUI.brandSwingUI;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class brandDelete {
    Connection con;
    PreparedStatement pst;
    DefaultTableModel model;
    private int id;
    
    public brandDelete() {
        brandSwingUI obj = new brandSwingUI();
        String message = "Do you really want to delete";
        int dialogResult = JOptionPane.showConfirmDialog(null, message, "WARNING", JOptionPane.YES_NO_OPTION);
        
        if(dialogResult==JOptionPane.YES_OPTION) {
            try {
                //since getConnection() is a static method so we can access that without 
                //creating the object of it
                Connection con = mySqlConnection.getConnection();
                
                model = (DefaultTableModel) obj.getBrandTable().getModel();

                int index = obj.getSelectedRowFromTable();
                System.out.println("index: "+index);
                id = Integer.parseInt((String) model.getValueAt(index, 0));
                System.out.println("id: "+id);

                String syntax = "DELETE FROM brandinfo WHERE brandId = ?";
                pst = (PreparedStatement) con.prepareStatement(syntax);
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Brand deleted");

            } catch (SQLException ex) {
                Logger.getLogger(brandDelete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
}
