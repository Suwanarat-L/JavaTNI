import javax.swing.*;

public class Lab402 {
    public static void main(String[] args) {
        String student_id = "";
        do {
            student_id = JOptionPane.showInputDialog(null, "Enter student-id:");
            if (student_id.length() == 10) break;
        } while (true);
        String code = student_id.substring(2, 5), major = " ";
        if (code.equals("131")) major = "Information Technology (IT)";
        else if (code.equals("132")) major = "Multimedia Technology (MT)";
        else if (code.equals("133")) major = "Digital Business Information Technology (BI)";
        else if (code.equals("134")) major = "Digital Technology in Mass Communication (DC)";
        else if (code.equals("135")) major = "Data Science and Data Analytics (DS)";
        else major = "Cannot found major";
        JOptionPane.showMessageDialog(null,"Student ID: " + student_id
        + "\nMajor: " +major);
    }
}
