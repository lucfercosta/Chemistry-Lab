package core;
import ui.ChemTable;
/**
 *
 * @author Lucas Fernandes
 */
public class ChemLab {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            ChemTable chemTable = new ChemTable();
        chemTable.setVisible(true);
        chemTable.setLocationRelativeTo(null);
    });
        
        
    }
}
