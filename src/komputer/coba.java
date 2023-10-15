/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;
import javax.swing.JOptionPane;

/**
 *
 * @author IQBAL
 */
public class coba {
   public static void main(String[] args) {
        DataKomputer computerData = new DataKomputer();
             
        do {            
            int selectedMenu = computerData.menuOption();
            switch (selectedMenu) {
                case AppInterface.VIEW_ALL_COMPUTERS -> {
                    computerData.viewTable();
                    break;
                }
                case AppInterface.ADD_DATA_COMPUTER -> {
                    computerData.add();
                    computerData.viewTable();
                    break;
                }
                case AppInterface.SEARCH_BY_BRAND -> {
                    String key = computerData.keyword("brand");
                    Komputer computer = computerData.searchByBrand(key);
                    computerData.viewData(computer);
                    break;
                }
                case AppInterface.SEARCH_BY_MODEL -> {
                    String key = computerData.keyword("model");
                    Komputer computer = computerData.searchByModel(key);
                    computerData.viewData(computer);
                    break;
                }
                case AppInterface.EXIT -> {
                    computerData.exit();
                    break;
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Wrong choice!");
                    break;
                }
            }
        } while (true);
        
        
         
    }
}