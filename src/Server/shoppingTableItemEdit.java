
package Server;

import Server.GUI.shoppingUI;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class shoppingTableItemEdit {
    DefaultTableModel defaultModel;
    private int totalQuantity;
    private int price;
    
    public shoppingTableItemEdit(JTable shoppingTable) {
        shoppingUI obj = new shoppingUI();
        
        defaultModel = (DefaultTableModel) shoppingTable.getModel();
        int selectedRow = shoppingTable.getSelectedRow();
        
        //since we have passed the object of selectQuantityText(i.e. reference)
        //so value has been changed in memory 
        String editedQuantity = (String) obj.getSelectedQuantity();
        
        String productName = (String) defaultModel.getValueAt(selectedRow, 0);
        String brandName = (String) defaultModel.getValueAt(selectedRow, 1);
        
        findProductPrice find = new findProductPrice(productName, brandName, "price");
        price = find.getPrice();
        
        find = new findProductPrice(productName, brandName, "quantity");
        totalQuantity = find.getQuantity();
        
        if(Integer.parseInt(editedQuantity) > totalQuantity) {
            String warning = "Sorry we does not have this much amount of item in our inventory";
            JOptionPane.showMessageDialog(null, warning, "Inane warning", JOptionPane.WARNING_MESSAGE);
        }
        else {
            defaultModel.setValueAt(editedQuantity, selectedRow, 2);
            int editedPrice = price*Integer.parseInt(editedQuantity);
            //set it as string other it can create class cast exception
            defaultModel.setValueAt(String.valueOf(editedPrice), selectedRow, 3);
            
            String message = "Shopping Table row updated";
            JOptionPane.showMessageDialog(null, message);
        }
    }
}
