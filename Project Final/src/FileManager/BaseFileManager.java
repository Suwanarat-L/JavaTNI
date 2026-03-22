package FileManager;

import java.io.*;
import java.util.Scanner;

//ไม่ต้องมาเขียนtry-catchบ่อยๆ
public abstract class BaseFileManager {
    protected File file;

    public BaseFileManager(String filePath) {
        this.file = new File(filePath);
    }

    //นับจำนวนบรรทัดของไฟล์
    protected int getLineCount() {
        int count = 0;
        Scanner scanner = Reader();
        if (scanner != null) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                count++;
            }
            scanner.close();
        }
        return count;
    }

    //อ่านไฟล์
    public Scanner Reader() {
        try {
            if (file.exists()) return new Scanner(file); //ถ้ามีไฟล์ให้ส่งไฟล์
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return null;
    }

    //เขียนทับ
    public PrintWriter Overwrite() {
        try {
            return new PrintWriter(new FileWriter(file, false));
        } catch (IOException e) {
            return null;
        }
    }

    //เขียนต่อ
    public PrintWriter Writer() {
        try {
            return new PrintWriter(new FileWriter(file, true));
        } catch (IOException e) {
            return null;
        }
    }
}