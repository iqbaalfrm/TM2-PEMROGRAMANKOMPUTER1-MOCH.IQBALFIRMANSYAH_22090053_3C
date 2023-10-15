/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komputer;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 *
 * @author IQBAL
 */

public class DataKomputer implements AppInterface {
    private final komputer[] computers;

    public DataKomputer() {
        this.computers = new komputer[10001];
        komputer computer = new komputer();

        // Dummy data
        computer.setBrand("Apple");
        computer.setModel("M1");
        computer.setDiskType("SSD");
        computer.setDiskSize(256);
        computer.setRamSize(8);
        this.computers[0] = computer;
    }

    @Override
    public int menuOption() {
        String p = JOptionPane.showInputDialog(null, ""
            + "<html>"
            + "=====Menu=================================<br>"
            + "0 &rarr; Lihat Data Komputer<br>"
            + "1 &rarr; Tambah Data Komputer<br>"
            + "2 &rarr; Cari Berdasarkan Merk<br>"
            + "3 &rarr; Cari Berdasarkan Model<br>"
            + "4 &rarr; Keluar<br>"
            + "==============================================<br>"
            + "<b›Enter your choice by number from 1 to 4:</b>"
            + "</html>", JOptionPane.QUESTION_MESSAGE);
        int option = Integer.parseInt(p); // casting JOptionPane.QUESTION_MESSAGE);
        return option;
    }

    @Override
    public void add() {
        komputer computer = new komputer();
        String brand = JOptionPane.showInputDialog(null, "Masukan Merk:", "Merk",
                JOptionPane.QUESTION_MESSAGE);
        computer.setBrand(brand);
        String model = JOptionPane.showInputDialog(null, "Masukan model:", "Model",
                JOptionPane.QUESTION_MESSAGE);
        computer.setModel(model);
        String disk = JOptionPane.showInputDialog(null, "Masukan Tipe Penyimpanan (HDD/SSD):", "Penyimpanan",
                JOptionPane.QUESTION_MESSAGE);
        computer.setDiskType(disk);
        int diskSize = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Kapasitas Penyimpanan:",
                        "Kapasitas Penyimpanan", JOptionPane.QUESTION_MESSAGE));
        computer.setDiskSize(diskSize);
        int ramSize = Integer.parseInt(
                JOptionPane.showInputDialog(null, "Kapasitas RAM:",
                        "Kapasitas RAM", JOptionPane.QUESTION_MESSAGE));
        computer.setRamSize(ramSize);

        for (int i = 0; i < this.computers.length; i++) {
            if (computers[i] == null) {
                computers[i] = computer;
                break;
            }
        }

        this.viewData(computer);
    }

    @Override
    public String keyword(String type) {
        return JOptionPane.showInputDialog(null, "Enter Computer " + type, JOptionPane.QUESTION_MESSAGE);
    }

    @Override
    public komputer searchByBrand(String brand) {
        for (komputer computer : computers) {
            if ((computer != null) && computer.getBrand().matches("(?i:.*" + brand + ".*)")) {
                return computer;
            }
        }
        return null;
    }

    @Override
    public komputer searchByModel(String model) {
        for (komputer computer : computers) {
            if ((computer != null) && computer.getModel().matches("(?i:.*" + model + ".*)")) {
                return computer;
            }
        }
        return null;
    }

    @Override
    public void viewData(komputer computer) {
        if (computer == null) {
            JOptionPane.showMessageDialog(null, "Not found!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Brand\t\t: " + computer.getBrand() + "\nModel\t\t: " + computer.getModel() + "\nDisk Type\t: "
                            + computer.getDiskType() + "\nDisk Size\t: " + computer.getDiskSize() + "\nRAM Size\t: "
                            + computer.getRamSize(),
                    "Computer Data", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void viewTable() {
        if (this.computers.length == 0) {
            JOptionPane.showMessageDialog(null, "Not found!");
            return;
        }

        Object[] cols = { "Number", "Brand", "Model", "Disk Type", "Disk Size", "RAM Size" };
        Object[][] rows = new Object[this.computers.length][6];
        for (int i = 0; i < this.computers.length; i++) {
            komputer computer = computers[i];
            if (computer == null) {
                break;
            }
            rows[i][0] = i + 1;
            rows[i][1] = computer.getBrand();
            rows[i][2] = computer.getModel();
            rows[i][3] = computer.getDiskType();
            rows[i][4] = computer.getDiskSize();
            rows[i][5] = computer.getRamSize();
        }
        JTable table = new JTable(rows, cols);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
