
package Server;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class brandTableLoad {
    public brandTableLoad(JTable brandTable) {
        try {
            Connection con = mySqlConnection.getConnection();
            
            String syntax = "SELECT * FROM brandinfo";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(syntax);
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
            int column = rsd.getColumnCount();
            
            DefaultTableModel model = (DefaultTableModel) brandTable.getModel();
            model.setRowCount(0);
            
            while(rs.next()) {
                Vector vec = new Vector();
                for(int i=0; i<column; i++) {
                    String id = rs.getString("brandId");
                    String productName = rs.getString("productName");
                    String brandName = rs.getString("brandName");
                    String price = rs.getString("price");
                    String quantity = rs.getString("quantity");
                    
                    vec.add(id);
                    vec.add(productName);
                    vec.add(brandName);
                    vec.add(price);
                    vec.add(quantity);
                }
                //now put the data into the table
                model.addRow(vec);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(brandTableLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
