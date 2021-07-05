
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


public class sortByPrice {
    private PreparedStatement pst;
    private JTable priceTable;
    public sortByPrice(JButton sortByPriceButton) {
        sortingUI obj = new sortingUI();
        priceTable = obj.getPriceTable();
        try {
            Connection con = mySqlConnection.getConnection();
            pst = con.prepareStatement("SELECT * from  brandinfo WHERE price >= 0 ORDER BY price");
            ResultSet rs = pst.executeQuery();
            
            java.sql.ResultSetMetaData rsd = rs.getMetaData();
            int col = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel) priceTable.getModel();
           
            for (int i = priceTable.getRowCount()-1; i >=0; i--) {
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
