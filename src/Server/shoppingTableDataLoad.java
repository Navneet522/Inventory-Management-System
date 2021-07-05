
package Server;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class shoppingTableDataLoad {
    DefaultTableModel defaultModel;
    
    public shoppingTableDataLoad(JTable shoppingTable, JTextField productNameText, 
                JTextField brandNameText, JTextField selectedQuantity) {
        
        defaultModel = (DefaultTableModel) shoppingTable.getModel();
        int selectedIndex = shoppingTable.getSelectedRow();
        
        productNameText.setText((String) defaultModel.getValueAt(selectedIndex, 0));
        brandNameText.setText((String) defaultModel.getValueAt(selectedIndex, 1));
        
        String quantity = (String) defaultModel.getValueAt(selectedIndex, 2);
        selectedQuantity.setText(quantity);
    }
}
