
package Server;

import Server.GUI.shoppingUI;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class shoppingAddRequest {
    private int quantity;
    private int selectedQuantity;
    boolean success = true;
    
    public shoppingAddRequest() {
        shoppingUI obj = new shoppingUI();
        quantity = Integer.parseInt(obj.getQuantity());
        selectedQuantity = Integer.parseInt(obj.getSelectedQuantity());
        
        if(selectedQuantity > quantity) {
            String warning = "Sorry we does not have this much amount of item in our inventory";
            success = false;
            JOptionPane.showMessageDialog(null, warning, "Inane warning", JOptionPane.WARNING_MESSAGE);
        }
        else {
            new shoppingAdd();
        }
    }

    public boolean getMessage() {
        return success;
    }
}
