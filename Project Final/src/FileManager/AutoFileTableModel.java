package FileManager;

import javax.swing.table.DefaultTableModel;
import java.io.File;

//ตารางเซฟข้อมูลลงเอง
public abstract class AutoFileTableModel extends DefaultTableModel { //extends DefaultTableModel = ตารางที่ยัดลงใส่หน้าJTableได้่้
    protected File file;
    private boolean isInitializing = true; //ตัวแปรไว้กันไฟล์เซฟอัตโนมัติ
    //สมมติไฟลืการบ้านมี100ข้อ กรณีนี้ไม่มี เชียนช้อนึงเซฟรอบนึง แล้วก็๋จะวนไปครบร้อยรอบ
    //ใส่กันไว้ก็จะเขียนครบร้อยข้อก่อนแล้วค่อยเซฟ

    public AutoFileTableModel(String filePath, String[] columnNames) {
        super(null, columnNames);
        this.file = new File(filePath);
        readFromFile();
        isInitializing = false;
    }

    protected abstract void readFromFile();
    protected abstract void writeToFile();

    @Override //ตอนกดปุ่มเพิ่ม ตารางก็จะงอกออกมาอีกแถว
    public void addRow(Object[] rowData) { //ใช้Objectเพราะสามารถรับข้อมูบได้ทุกประเภท
        super.addRow(rowData);
        if (!isInitializing) writeToFile(); //ถ้าไม่ได้อ่านไฟลือยุ่ให้เซฟ
    }

    @Override //ไว้แก้ข้อมูล
    public void setValueAt(Object aValue, int row, int column) { //rowแถวแนวนอน columnแถวแนวตั้ง
        super.setValueAt(aValue, row, column); //เปลี่ยนค่าที่แถวและหลักนั้น
        if (!isInitializing) writeToFile();
    }

    @Override //ลบข้อมูล เวลาลบข้อมุลก็จะลบตารางไปด้วย
    public void removeRow(int row) {
        super.removeRow(row); //ลบแถวนั้น
        if (!isInitializing) writeToFile();
    }

    @Override //ไม่ให้ไปมือบอนเขียนตารางเล่นก็ไม่ต้องให้ตารางเขียนทับเล่นได้
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}