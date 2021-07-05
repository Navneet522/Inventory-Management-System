
package Server.GUI;
import Server.mySqlConnection;
import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class sortByQuantity {

    private PreparedStatement pst;
    private JTable quantityTable;

    public sortByQuantity(JButton sortByQuantityButton) {
        sortingUI obj = new sortingUI();
        quantityTable = obj.getQuantityTable();
        try {
            Connection con = mySqlConnection.getConnection();
            pst = con.prepareStatement("SELECT * from  brandinfo WHERE quantity >= 0 ORDER BY quantity");
            ResultSet rs = pst.executeQuery();
            
            java.sql.ResultSetMetaData rsd = rs.getMetaData();
            int col = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel) quantityTable.getModel();
           
            for (int i = quantityTable.getRowCount()-1; i >=0; i--) {
                d.removeRow(i);
            }
            
            while(rs.next()) {
                Vector vec = new Vector();
                for(int i=0; i<col; i++) {
                    vec.add(rs.getString("productName"));
                    vec.add(rs.getString("brandName"));
                    vec.add(rs.getString("price"));
                    vec.add(rs.getString("quantity"));
                }
                d.addRow(vec);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
    }
    
}
