package FileManager;
import Data.Subject;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

//ตัวกลางไว้จัดการระหว่างSchudulePageกับSubject
//จัดการไฟล์ตารางเรียน+เช็คเวลาชน
public class SubjectManager extends BaseFileManager {

    public SubjectManager() {
        super("src/subjects.txt");
    }

    //อ่านข้อมูลทั้งหมดแล้วทำให้เป็นArray
    public Subject[] subjectAll() {
        int totalLines = getLineCount();//นับบรรทัดของไฟล์
        Subject[] subjects = new Subject[totalLines];//ถ้านับแล้วมี10 ตัวArrayก็จะมี10ตัว
        Scanner scanner = Reader(); //เปิดไฟล์อ่าน

        int i = 0;
        if (scanner != null) { //ถ้าเปิดไฟล์อ่านได่้ให้เข้าลูป
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length >= 4 && i < totalLines) {
                    try {
                        subjects[i] = new Subject(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim());
                        i++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            scanner.close();
        }
        return subjects;
    }

    //เอาวิชาที่เพิ่มไปเขียนต่อท้ายในไฟล์
    public void addSubject(Subject s) {
        PrintWriter pw = Writer();
        if (pw != null) {
            pw.println(s.commaValues());
            pw.close();
        }
    }

    //ลบวิชา
    public boolean deleteSubject(String code) {
        Subject[] all = subjectAll(); //อ่านไฟล์ทั้งหมด
        boolean found = false;

        //ไล่หา
        for (int i = 0; i < all.length; i++) {
            if (all[i] != null && all[i].getCode().toUpperCase().equalsIgnoreCase(code.toUpperCase().trim())) {
                //ถ้าเจอวิชานั้นแล้ว จะเปลี่ยนช่องวิชานั้นให้เป็นค่าว่าง
                all[i] = null;
                found = true;
            }
        }

        //เขียนไฟล์ใหม่อีกรอบ
        if (found) {
            PrintWriter pw = Overwrite();
            if (pw != null) {
                for (Subject s : all) {
                    //วิชาที่ไม่โดนลบจะเขียนใหม่ ส่วนที่โดนลบไปแล้วเป็นค่าว่างก็จะโดนข้ามไป
                    if (s != null) pw.println(s.commaValues());
                }
                pw.close();
            }
        }
        return found;
    }

    //เช็คว่าเวลาเรียนในวันนั้นชนกันไหม
    public String check(String day, LocalTime newStart, LocalTime newEnd) {
        //ดึงวิชาทั้งหมดออกมาเช็ค
        Subject[] allSubjects = subjectAll();
        for (Subject s : allSubjects) {
            if (s != null && s.getDay().equalsIgnoreCase(day)) {
                LocalTime existingStart = s.getStartTime();
                LocalTime existingEnd = s.getEndTime();
                //เวลาเริ่มใหม่ต้องมาก่อนเวลาจบเดิม เวลาจบใหม่ ้องมาหลังเวลาเริ่มเดิม
                //ถ้าเวลาชนกันให้returnวิชาที่วิชาชน
                if (newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart)) {
                    return s.getCode() + " (" + s.getStartTime() + "-" + s.getEndTime() + ")";
                }
            }
        }
        return "";
    }
}