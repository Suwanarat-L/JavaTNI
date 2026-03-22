package FileManager;

import java.io.*;
import java.util.Scanner;

public class HomeworkTableModel extends AutoFileTableModel {

    public HomeworkTableModel() {
        super("src/homework.txt", new String[]{"Subject", "Detail", "Deadline", "Status"});
    }

    @Override
    protected void readFromFile() {
        try {
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String[] parts = scanner.nextLine().split(",");
                    if (parts.length >= 4) {
                        //เอาข้อมูลขึ้นจอ
                        super.addRow(new Object[]{parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()});
                    }
                }
                scanner.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    @Override
    protected void writeToFile() { //เขียนเซฟลงไฟล์
        try {
            //เขียนทับ
            PrintWriter writer = new PrintWriter(new FileWriter(file, false));
            for (int i = 0; i < getRowCount(); i++) {
                //ดึงข้อมูลแต่ละตัวออกมา
                String sub = getValueAt(i, 0).toString();
                String det = getValueAt(i, 1).toString();
                String dead = getValueAt(i, 2).toString();
                String stat = getValueAt(i, 3).toString();

                //เอามาต่อรวมกันแล้วเขียนลงไฟล์
                writer.println(sub + "," + det + "," + dead + "," + stat);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}