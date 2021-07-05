
package Server;

import Server.GUI.shoppingUI;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class shoppingAdd {
    
    public shoppingAdd() {
        shoppingUI obj = new shoppingUI();
        String productName = obj.getProductName();
        String brandName = obj.getBrandName();
        int price = Integer.parseInt(obj.getPrice());
        int selectedQuantity = Integer.parseInt(obj.getSelectedQuantity());
        int totalAmount = price*selectedQuantity;
        System.out.println("Selected Quantity in shoppingAdd: "+selectedQuantity);
        
        JTable table = obj.getTableModel();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[] {
                productName, 
                brandName, 
                String.valueOf(selectedQuantity),
                String.valueOf(totalAmount),
            }
        );
    }
}
