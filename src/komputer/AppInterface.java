/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;

/**
 *
 * @author IQBAL
 */

public interface AppInterface {
    int VIEW_ALL_COMPUTERS = 0;
    int ADD_DATA_COMPUTER = 1;
    int SEARCH_BY_MODEL = 3;
    int SEARCH_BY_BRAND = 2;
    int EXIT = 4;

    int menuOption();
    void add();
    String keyword(String type);
    komputer searchByBrand(String brand);
    komputer searchByModel(String model);
    void viewData(komputer computer);
    void exit();
}
