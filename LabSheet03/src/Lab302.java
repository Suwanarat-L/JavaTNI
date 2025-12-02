import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.text.DecimalFormat;

public class Lab302 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat(".0");
        String name = JOptionPane.showInputDialog("Enter your name:");
        int height = Integer.parseInt(JOptionPane.showInputDialog("Enter your height (cm.):"));
        int gender = JOptionPane.showConfirmDialog(null,
                "Are your biological gender is Male?" ,
                "Gender",
                JOptionPane.INFORMATION_MESSAGE);
        if (gender == 0){
            JOptionPane.showMessageDialog(null,
                    "Hello, Mr." + name
            + "\nIf your height is " + df.format(height) + " cm." +
                    "\nYour weight should be " + df.format(height-100) +" kg.");
        }
        if (gender == 1){
            JOptionPane.showMessageDialog(null,
                    "Hello, Ms." + name +
                    "\nIf your height is " + df.format(height) + " cm." +
                    "\nYour weight should be " + df.format(height-110) + " kg.");
        }
        JOptionPane.showMessageDialog(null,"You can use BMI to measure your weight and height.");

    }
}
