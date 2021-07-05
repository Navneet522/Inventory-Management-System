
package Server;

import javax.swing.JTable;
import javax.swing.JTextField;


public class subTotal {
    private int totalSum = 0;
    public subTotal(JTable shoppingTable, JTextField subTotalText) {
        int row = shoppingTable.getRowCount();
        for(int i=0; i<row; i++) {
            totalSum += Integer.parseInt((String) shoppingTable.getValueAt(i, 3));
        }
        subTotalText.setText(String.valueOf(totalSum));
    }
}
