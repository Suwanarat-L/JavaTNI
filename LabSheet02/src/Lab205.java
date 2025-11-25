import javax.swing.*;
public class Lab205 {
    public static void main(String[] args) {
        int input_Minutes = Integer.parseInt(JOptionPane.showInputDialog("Input minutes:"));
        int hour = input_Minutes / 60;
        int minute = input_Minutes % 60;
        JOptionPane.showMessageDialog(null,input_Minutes + " minutes is " + hour + " hour " + minute + " minute ");
    }
}
