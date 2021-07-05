
package Server;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class shoppingTableItemDelete {
    DefaultTableModel model;
    public shoppingTableItemDelete(JTable shoppingTable) {
        model = (DefaultTableModel) shoppingTable.getModel();
        model.removeRow(shoppingTable.getSelectedRow());
    }
    
}
